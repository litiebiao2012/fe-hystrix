package fe.hystrix.limiter.enums;

/**
 * Created by fe on 2017/1/18.
 */
public enum LimiterKeyTypeEnums {

    /**
     * app
     */
    APP("app","应用层面"),
    /**
     * cct
     */
    METHOD("cct","method层面"),

    /**
     * url
     */
    URL("url","url层面");

    LimiterKeyTypeEnums(String val, String message) {
        this.val = val;
        this.description = message;
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
