package fe.hystrix.limiter.callback;

/**
 * Created by fe on 2017/1/18.
 */
@FunctionalInterface
public interface Executor {

    void executor();
}
