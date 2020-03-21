package gcTest;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.Vector;

import com.sun.management.OperatingSystemMXBean;

/**
 * @author lyy
 */
public class MonitorService {
    public MonitorInfo getMonitorInfoBean() throws Exception {
        double mb = 1024 * 1024 * 1.0;
        double gb = 1024 * 1024 * 1024 * 1.0;

        Vector vector=new Vector();
        vector.add(1,"");
        // jvm
        double totalMemory = Runtime.getRuntime().totalMemory() / mb;
        double freeMemory = Runtime.getRuntime().freeMemory() / mb;
        double maxMemory = Runtime.getRuntime().maxMemory() / mb;
        // os
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        String osName = System.getProperty("os.name");
        double totalMemorySize = osmxb.getTotalPhysicalMemorySize() / gb;
        double freeMemorySize = osmxb.getFreePhysicalMemorySize() / gb;
        double usedMemorySize = (osmxb.getTotalPhysicalMemorySize() - osmxb
                .getFreePhysicalMemorySize()) / gb;
        // MonitorInfo
        MonitorInfo infoBean = new MonitorInfo();
        infoBean.setTotalMemory(getIntValue(totalMemory));
        infoBean.setFreeMemory(getIntValue(freeMemory));
        infoBean.setMaxMemory(getIntValue(maxMemory));
        infoBean.setOsName(osName);
        infoBean.setTotalMemorySize(getIntValue(totalMemorySize));
        infoBean.setFreeMemorySize(getIntValue(freeMemorySize));
        infoBean.setUsedMemorySize(getIntValue(usedMemorySize));
        infoBean.setProcessors(Runtime.getRuntime().availableProcessors());
        return infoBean;
    }

    /**
     * 四舍五入取整
     * 
     * @param d
     * @return
     */
    private static int getIntValue(double d) {
        return new BigDecimal(d).setScale(0, BigDecimal.ROUND_HALF_UP)
                .intValue();
    }

    public static void main(String[] args) throws Exception {
        MonitorService service = new MonitorService();
        MonitorInfo monitorInfo = service.getMonitorInfoBean();
        // System.out.println("JVM可使用内存=" + monitorInfo.getTotalMemory() +
        // "MB");
        // System.out.println("JVM剩余内存=" + monitorInfo.getFreeMemory() + "MB");
        // System.out.println("JVM最大可使用内存=" + monitorInfo.getMaxMemory() +
        // "MB");

        System.out.println("操作系统=" + monitorInfo.getOsName());
        System.out.println("核心数=" + monitorInfo.getProcessors());
        System.out.println("总的物理内存=" + monitorInfo.getTotalMemorySize() + "GB");
        System.out.println("剩余的物理内存=" + monitorInfo.getFreeMemorySize() + "GB");
        System.out
                .println("已使用的物理内存=" + monitorInfo.getUsedMemorySize() + "GB");
    }
}