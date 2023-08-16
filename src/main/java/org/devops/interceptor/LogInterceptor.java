package org.devops.interceptor;

import org.devops.utils.LogUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            request.setCharacterEncoding("UTF-8");
            //统计一些时间打点
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LogUtils.logInfo(getClass(), String.format("api:%s, method:%s, params:%s, body:%s", request.getRequestURI(), request.getMethod(), request.getQueryString(), ""));
    }
}
