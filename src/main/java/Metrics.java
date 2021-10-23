public class Metrics {
    private static final long MEGABYTE = 1024L * 1024L;
    private static long start;
    private static long end;
    private static long memory;


    public static void start() {
        start = System.currentTimeMillis();

    }

    public static void stop() {
        end = System.currentTimeMillis();
    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void print() {
        System.out.println("Time work:");
        System.out.println((end - start));
        memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Used memory:" + bytesToMegabytes(memory));
    }
}