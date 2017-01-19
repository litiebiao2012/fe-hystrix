package fe.hystrix.limiter.core;

import com.google.common.util.concurrent.RateLimiter;
import fe.common.Assert;
import fe.hystrix.limiter.callback.Executor;
import fe.hystrix.limiter.callback.RejectedExecutionHandler;
import fe.hystrix.limiter.config.FlowRateRuleConfig;
import fe.hystrix.limiter.exception.LimiterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * Created by fe on 2017/1/18.
 */
public class FlowRateManager {

    public static final Logger logger = LoggerFactory.getLogger(FlowRateManager.class);

    public static void flowRate(FlowRateRuleConfig flowRateRuleConfig, Executor executor, RejectedExecutionHandler rejectedExecutionHandler) throws LimiterException, InterruptedException {
        Assert.assertNotNull(flowRateRuleConfig);
        /** 总流量开关入口控制 **/
        if (!flowRateRuleConfig.isFlowRateSwitch()) executor.executor();

        Semaphore semaphore = flowRateRuleConfig.getSemaphore();
        /** 并发开关**/
        if (flowRateRuleConfig.isCctSwitch()) {
            boolean flag = false;
            try {
                flag = semaphore.tryAcquire();
                logger.debug("now concurrent num : {}", flowRateRuleConfig.getMaxConcurrentNum() - semaphore.availablePermits());
                if (flag) {
                    executor.executor();
                } else {
                    //TODO 报警
                }
            } finally {
                if (flag) semaphore.release();
            }

        } else {
            limiterQps(flowRateRuleConfig,executor);
        }
    }

    public static void limiterQps(FlowRateRuleConfig flowRateRuleConfig, Executor executor) {
        if (flowRateRuleConfig.isQpsSwitch()) {
            RateLimiter rateLimiter = flowRateRuleConfig.getRateLimiter();
            if (rateLimiter.tryAcquire()) {
                executor.executor();
            } else {
                //TODO 报警
            }
        } else {
            executor.executor();
        }
    }
}
