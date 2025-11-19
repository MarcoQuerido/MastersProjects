package app;

public class Config {

    /* Configuration variables for test classes
       static final to make them accessible without needing to create
       an instance of Config and to ensure they cannot be modified.
    */

    public static final int NUM_TESTS = 10;
    public static final int NUM_THREADS = 17;
    public static final String[] TEST_IMAGES_PATHS = {
            "src\\main\\resources\\turtle.jpg",
            "src\\test\\java\\utils\\ferris-wheel.jpg",
            "src\\test\\java\\utils\\neon_mountain.jpeg"
    };
    public static final String[] TEST_IMAGES_SIZES = {"696x522px", "1600x1067px", "2776x1504px"};
    public static final String TABLE_HEADER = "| Image Size | \tFilter Type | \tNumber of Threads | \nTests | \tTime";
    public static final String TABLE_HEADER_NOTHREADS = "| Image Size | \tFilter Type | \nTests | \tTime";
    public static final String RESULTS_PATH = "src\\test\\java\\results\\";
    public static final String OUTPUT_PATH_MULTITHREADED = RESULTS_PATH + "multithreaded_test_execution_times.txt";
    public static final String OUTPUT_PATH_SEQUENTIAL = RESULTS_PATH + "sequential_test_execution_times.txt";
    public static final String OUTPUT_PATH_CACHEDTHREADPOOL = RESULTS_PATH + "cachedThreadPool_test_execution_times.txt";
    public static final String OUTPUT_PATH_COMPLETABLEFUTURES = RESULTS_PATH + "completable_futures_test_execution_times.txt";
    public static final String OUTPUT_PATH_FIXEDTHREADPOOL = RESULTS_PATH + "fixedThreadPool_test_execution_times.txt";
    public static final String OUTPUT_PATH_FORKJOINPOOL = RESULTS_PATH + "forkJoinPool_test_execution_times.txt";
    public static final String OUTPUT_PATH_SINGLETHREADPOOL = RESULTS_PATH + "singleThread_test_execution_times.txt";

    // Private constructor to prevent instantiation of Config objects
    private Config() {
        // Private constructor to prevent instantiation
    }
}
