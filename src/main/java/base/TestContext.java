package base;

public class TestContext {
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();
    private static ThreadLocal<String> port = new ThreadLocal<>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<>();

    public static void set(String d, String u, String p, String s) {
        deviceName.set(d);
        udid.set(u);
        port.set(p);
        systemPort.set(s);
    }

    public static String getDeviceName() {
        return deviceName.get();
    }

    public static String getUdid() {
        return udid.get();
    }

    public static String getPort() {
        return port.get();
    }

    public static String getSystemPort() {
        return systemPort.get();
    }

    public static void clear() {
        deviceName.remove();
        udid.remove();
        port.remove();
        systemPort.remove();
    }
}
