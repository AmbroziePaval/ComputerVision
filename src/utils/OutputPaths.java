package utils;

/**
 * Output enum class helper.
 * <p>
 * Creator: Ambrozie
 * Info: OutputPaths.class
 * Date: 01/01/2018 21:44
 */
public enum OutputPaths {
    OUTPUT_FILE("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\output"),
    LAB1_OUTPUT(OUTPUT_FILE.path + "\\lab1.png"),
    LAB2_OUTPUT(OUTPUT_FILE.path + "\\lab2.png");

    public String path;

    OutputPaths(String path) {
        this.path = path;
    }
}
