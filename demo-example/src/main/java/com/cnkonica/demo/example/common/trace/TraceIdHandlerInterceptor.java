package com.cnkonica.demo.example.common.trace;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class TraceIdHandlerInterceptor implements HandlerInterceptor {
    static final String REQUEST_ID_QUERY_KEY = "traceId";

    public TraceIdHandlerInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = request.getParameter("traceId");
        if (StringUtils.isEmpty(requestId)) {
            requestId = UUID.randomUUID().toString().replace("-", "");
        }

        TraceIdContext.set(requestId);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TraceIdContext.remove();
    }
}
