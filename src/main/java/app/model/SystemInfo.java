package app.model;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.getProperty;

/**
 * Prosty obiekt do transportu danych o hoście na którym działa aplikacja
 */

public class SystemInfo {
    String osName;
    String osVersion;
    Integer cores;
    Long presumableFreeMemoryMb;
    Long definitelyFreeMemoryMb;
    Long maxMemory;

    public SystemInfo() {
        osName = getProperty("os.name");
        osVersion = getProperty("os.version");

        cores = getRuntime().availableProcessors();

        //https://stackoverflow.com/questions/12807797/java-get-available-memory/18366283#18366283
        long allocatedMemory      = (getRuntime().totalMemory()- getRuntime().freeMemory());
        presumableFreeMemoryMb = getRuntime().maxMemory() - allocatedMemory; //-Xmx - allocated
        definitelyFreeMemoryMb = getRuntime().freeMemory();
        presumableFreeMemoryMb /= (1024 * 1024);
        definitelyFreeMemoryMb /= (1024 * 1024);
    }

    //generated

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Long getPresumableFreeMemoryMb() {
        return presumableFreeMemoryMb;
    }

    public void setPresumableFreeMemoryMb(Long presumableFreeMemoryMb) {
        this.presumableFreeMemoryMb = presumableFreeMemoryMb;
    }

    public Long getDefinitelyFreeMemoryMb() {
        return definitelyFreeMemoryMb;
    }

    public void setDefinitelyFreeMemoryMb(Long definitelyFreeMemoryMb) {
        this.definitelyFreeMemoryMb = definitelyFreeMemoryMb;
    }

    public Long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Long maxMemory) {
        this.maxMemory = maxMemory;
    }
}
