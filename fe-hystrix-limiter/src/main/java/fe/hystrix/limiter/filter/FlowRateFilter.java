package fe.hystrix.limiter.filter;

import fe.hystrix.limiter.core.FlowRateManager;
import fe.hystrix.limiter.exception.LimiterException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fe on 2017/1/18.
 * 应用限流filter
 */
public class FlowRateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        try {
            FlowRateManager.flowRate(null,()->{

            },null);
        } catch (LimiterException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void destroy() {

    }
}
