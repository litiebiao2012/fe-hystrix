package fe.hystrix.limiter.domain;

import fe.hystrix.limiter.Constants;

import java.util.Date;

/**
 * Created by fe on 2017/1/19.
 */
public class AppConfig {
    /**
     * app名称
     */
    private String appName = Constants.APP_NAME;
    /**
     * appCode
     */
    private String appCode;
    /**
     * app创建时间
     */
    private Date createTime;
    /**
     * app更新时间
     */
    private Date updateTime;
    /**
     * app描述
     */
    private String appDescription;
    /**
     * 应用限流总开关
     */
    private boolean flowRateSwitch = false;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public boolean isFlowRateSwitch() {
        return flowRateSwitch;
    }

    public void setFlowRateSwitch(boolean flowRateSwitch) {
        this.flowRateSwitch = flowRateSwitch;
    }
}
