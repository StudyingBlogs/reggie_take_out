package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Participate
 * @date 2022/10/25 15:45
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //进行路径比较，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1、获取本次请求地URL
        String requestURI = request.getRequestURI();
        //2、判断本次请求是否需要处理
        //定义不需要处理地请求
        log.info("拦截到请求：{}",requestURI);
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };
        boolean check = check(urls, requestURI);
        //3、如果不需要处理，则直接放行
        if (check) {
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }
        //4-1、判断登录状态，如果已登录，则直接放行
       if(request.getSession().getAttribute("employee") != null) {
           Long empId = (Long)request.getSession().getAttribute("employee");
           log.info("用户已登录，用户ID为{}",empId);
           BaseContext.setCurrentId(empId);
           filterChain.doFilter(request,response);
           return;
       }
        //4-2、判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("user") != null) {
            Long userId = (Long)request.getSession().getAttribute("user");
            log.info("用户已登录，用户ID为{}",userId);
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request,response);
            return;
        }
       log.info("用户未登录");
        //5、如果未登录则返回未登录结果，通过输出流地方式向客户端返回数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
//        log.info("拦截到请求：{}",request.getRequestURI());
        //filterChain.doFilter(request,response);
        return;
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    /**
     * 路径匹配，检查本次请求是否需要方行
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
