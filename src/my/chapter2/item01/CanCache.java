package my.chapter2.item01;

/**
 * advantage 2: can cache obj
 * @author yangWu
 * @date 2021/6/28 9:38 上午
 * @version 1.0
 */
public class CanCache {
    private Object value;
    private CanCache(Object val) { value = val; }

    // 只在第一次调用时实例化
    public static CanCache dbConnectCache = new CanCache("database connections");
    public static CanCache webCookieCache = new CanCache("web cookies");

    public static CanCache getDbConnectCache() { return dbConnectCache; }
    public static CanCache getWebCookieCache() { return webCookieCache; }

    public String toString() { return value.toString(); }

    public static void main(String[] args) {
        CanCache dbCache = getDbConnectCache();
        CanCache webCache = getWebCookieCache();

        System.out.println(dbCache);
        System.out.println(webCache);
    }
}
