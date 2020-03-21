package gcTest;
public class MonitorInfo {
    /** jvm可使用内存. */
    private long totalMemory;
    
    /** jvm剩余内存. */
    private long freeMemory;
    
    /** jvm最大可使用内存. */
    private long maxMemory;
    
    /** 操作系统. */
    private String osName;
    
    /** 总的物理内存. */
    private long totalMemorySize;
    
    /** 剩余的物理内存. */
    private long freeMemorySize;
    
    /** 已使用的物理内存. */
    private long usedMemorySize;
    
    /** 核心数. */
    private int processors;

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public long getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(long totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public long getFreeMemorySize() {
        return freeMemorySize;
    }

    public void setFreeMemorySize(long freeMemorySize) {
        this.freeMemorySize = freeMemorySize;
    }

    public long getUsedMemorySize() {
        return usedMemorySize;
    }

    public void setUsedMemorySize(long usedMemorySize) {
        this.usedMemorySize = usedMemorySize;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }
}