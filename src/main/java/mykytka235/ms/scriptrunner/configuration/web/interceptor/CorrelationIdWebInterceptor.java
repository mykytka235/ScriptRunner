package mykytka235.ms.scriptrunner.configuration.web.interceptor;

import mykytka235.ms.scriptrunner.util.CorrelationIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorrelationIdWebInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String correlationId = request.getHeader(CorrelationIdUtil.CORRELATION_ID_HEADER);

        if (!StringUtils.isBlank(correlationId)) {
            CorrelationIdUtil.setId(correlationId);
        } else {
            CorrelationIdUtil.generateId();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        response.setHeader(CorrelationIdUtil.CORRELATION_ID_HEADER, CorrelationIdUtil.getId());
    }

}
