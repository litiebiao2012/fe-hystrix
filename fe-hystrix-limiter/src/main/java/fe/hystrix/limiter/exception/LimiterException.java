package fe.hystrix.limiter.exception;

/**
 * Created by fe on 2017/1/18.
 */
public class LimiterException extends Exception {
    protected String exceptionCode;
    /**
     *
     */
    private static final long serialVersionUID = -2357521295745486102L;

    public LimiterException() {
        super();
    }

    public LimiterException(String code,String message) {
        super(message);
        this.exceptionCode = code;
    }

    public LimiterException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    public LimiterException(String msg,Throwable throwable,String code) {
        super(msg, throwable);
        this.exceptionCode = code;
    }

    public LimiterException(String msg) {
        super(msg);
    }

    public LimiterException(Throwable arg0) {
        super(arg0);
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
