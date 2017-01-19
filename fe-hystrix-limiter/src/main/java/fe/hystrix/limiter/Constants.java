package fe.hystrix.limiter;

import java.util.ResourceBundle;

/**
 * Created by fe on 2017/1/18.
 */
public class Constants {

    public static final ResourceBundle bundle = ResourceBundle.getBundle("fe_hystrix_config");

    public static final String APP_NAME = bundle.getString("app.name");

    public static final String beanParsePath = bundle.getString("bean.parse.path");

    public static final String urlParsePath = bundle.getString("url.parse.path");


    public static final int DB_DATA_LOAD_DELAY = Integer.parseInt(bundle.getString("db.data.load.delay"));


}
