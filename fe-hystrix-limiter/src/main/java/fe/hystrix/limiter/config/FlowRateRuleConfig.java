package fe.hystrix.limiter.config;

import com.google.common.util.concurrent.RateLimiter;
import fe.hystrix.limiter.enums.LimiterKeyTypeEnums;

import java.util.concurrent.Semaphore;

/**
 * Created by fe on 2017/1/18.
 */
public class FlowRateRuleConfig {

    /**
     * 流量控制总开关
     */
    private boolean flowRateSwitch = false;
    /**
     * 并发数量子开关
     */
    private boolean cctSwitch = false;
    /**
     * 最大并发数量
     */
    private int maxConcurrentNum;

    /**
     * qps数量子开关
     */
    private boolean qpsSwitch;
    /**
     * 最大qps数量
     */
    private int maxPermitsPerSecond;

    /**
     * 并发控制
     */
    private Semaphore semaphore = new Semaphore(maxConcurrentNum,false);

    /**
     * 每秒流量控制
     */
    private RateLimiter rateLimiter = RateLimiter.create(maxPermitsPerSecond);

    /**
     * 控制服务key :
     * url:/user/queryAllUser
     * method:com.entity.user.UserService.queryAllUser()
     * app:user
     */
    private String key;

    /**
     * 控制服务key类型
     */
    private LimiterKeyTypeEnums limiterKeyTypeEnums;

    /**
     * key 描述
     */
    private String description;


    public FlowRateRuleConfig(String key, LimiterKeyTypeEnums limiterKeyTypeEnums, String description) {
        this.key = key;
        this.limiterKeyTypeEnums = limiterKeyTypeEnums;
        this.description = description;
    }

    public boolean isFlowRateSwitch() {
        return flowRateSwitch;
    }

    public void setFlowRateSwitch(boolean flowRateSwitch) {
        this.flowRateSwitch = flowRateSwitch;
    }

    public boolean isCctSwitch() {
        return cctSwitch;
    }

    public void setCctSwitch(boolean cctSwitch) {
        this.cctSwitch = cctSwitch;
    }

    public int getMaxConcurrentNum() {
        return maxConcurrentNum;
    }

    public void setMaxConcurrentNum(int maxConcurrentNum) {
        this.maxConcurrentNum = maxConcurrentNum;
    }

    public boolean isQpsSwitch() {
        return qpsSwitch;
    }

    public void setQpsSwitch(boolean qpsSwitch) {
        this.qpsSwitch = qpsSwitch;
    }

    public int getMaxPermitsPerSecond() {
        return maxPermitsPerSecond;
    }

    public void setMaxPermitsPerSecond(int maxPermitsPerSecond) {
        this.maxPermitsPerSecond = maxPermitsPerSecond;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public RateLimiter getRateLimiter() {
        return rateLimiter;
    }

    public void setRateLimiter(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LimiterKeyTypeEnums getLimiterKeyTypeEnums() {
        return limiterKeyTypeEnums;
    }

    public void setLimiterKeyTypeEnums(LimiterKeyTypeEnums limiterKeyTypeEnums) {
        this.limiterKeyTypeEnums = limiterKeyTypeEnums;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


