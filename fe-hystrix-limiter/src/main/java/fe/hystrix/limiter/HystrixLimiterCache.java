package fe.hystrix.limiter;

import com.google.common.collect.Maps;
import fe.common.thread.NamedThreadFactory;
import fe.hystrix.limiter.config.FlowRateRuleConfig;
import fe.hystrix.limiter.domain.AppConfig;
import fe.hystrix.limiter.domain.FlowRateConfig;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * Created by fe on 2017/1/18.
 *
 */
public class HystrixLimiterCache {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1,new NamedThreadFactory("fe-hystrix-limiter",true));

    private static ConcurrentMap<String,FlowRateConfig> flowRateRuleConfigConcurrentMap = Maps.newConcurrentMap();
    private static AppConfig appConfig = new AppConfig();

    private int initialDelay = 0;
    private int delay = Constants.DB_DATA_LOAD_DELAY;

    @PostConstruct
    public void init() {
        scheduledExecutorService.scheduleWithFixedDelay(()->{
            reload();
        },initialDelay,delay, TimeUnit.SECONDS);
    }

    private void reload() {

    }

    private FlowRateConfig getAppFlowRateConfig() {
        FlowRateConfig flowRateConfig = flowRateRuleConfigConcurrentMap.get(Constants.APP_NAME);
        if (flowRateConfig == null) throw new RuntimeException("无法找到flowRateConfig配置!, key : " + Constants.APP_NAME);
        return flowRateConfig;
    }



}
