package fe.hystrix.limiter.enums;

/**
 * Created by fe on 2017/1/18.
 */
public enum FlowRateTypeEnums {
    /**
     * 流速控制
     */
    QPS("qps","rate limiter"),
    /**
     * 并发数量控制
     */
    CCT("cct","concurrent number");

    FlowRateTypeEnums(String val, String description) {
        this.val = val;
        this.description = description;
    }

    private String val;
    private String description;


    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
