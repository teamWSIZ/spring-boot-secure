package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.getProperty;

/**
 * Prosty obiekt do transportu danych o hoście na którym działa aplikacja
 */

@Data
@AllArgsConstructor
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
}
