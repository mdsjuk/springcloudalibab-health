package restsparketl.health.DynamicDataSource;



/**
 * @author:wxb
 * @description:
 * @date:21:302019/12/3
 */
public class DataSourceType {

    public static final String DEFAULT_DS = "db2";
    // 使用ThreadLocal保证线程安全
    private static final ThreadLocal<String> TYPE = new ThreadLocal<String>();

    // 往当前线程里设置数据源类型
    public static void setString(String String) {
        if (String == null) {
            throw new NullPointerException();
        }
        System.out.println("[set data source]：" + String);
        TYPE.set(String);
    }

    // 获取数据源类型
    public static String getString() {
        String String =  TYPE.get();
        System.out.println("[获取当前数据源]：" + String);
        return String;
    }

    // 清空数据类型
    public static void clearString() {
        TYPE.remove();
    }

}