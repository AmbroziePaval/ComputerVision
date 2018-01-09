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
    LAB2_OUTPUT(OUTPUT_FILE.path + "\\lab2.png"),
    LAB3_BINARY_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_binary_rectangle.png"),
    LAB3_BINARY_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_binary_building.png"),
    LAB3_R1_DILATE_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_R1_dilate_rectangle.png"),
    LAB3_R1_DILATE_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_R1_dilate_building.png"),
    LAB3_R1_ERODE_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_R1_erode_rectangle.png"),
    LAB3_R1_ERODE_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_R1_erode_building.png"),
    LAB3_R2_DILATE_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_R2_dilate_rectangle.png"),
    LAB3_R2_DILATE_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_R2_dilate_building.png"),
    LAB3_R2_ERODE_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_R2_erode_rectangle.png"),
    LAB3_R2_ERODE_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_R2_erode_building.png"),
    LAB3_R_RECT(OUTPUT_FILE.path + "\\lab3\\lab3_R_rectangle.png"),
    LAB3_R_BUILDING(OUTPUT_FILE.path + "\\lab3\\lab3_R_building.png"),
    LAB4_CORREL_ROOT(OUTPUT_FILE.path + "\\lab4\\correl\\"),
    LAB4_CHISQR_ROOT(OUTPUT_FILE.path + "\\lab4\\chisqr\\"),
    LAB4_INTERSECT_ROOT(OUTPUT_FILE.path + "\\lab4\\intersect\\"),
    LAB4_BHATTACHARYYA_ROOT(OUTPUT_FILE.path + "\\lab4\\bhattacharyya\\"),
    LAB5_LINE(OUTPUT_FILE.path + "\\lab5\\lines.png"),
    LAB5_CIRCLE(OUTPUT_FILE.path + "\\lab5\\circles.png");

    public String path;

    OutputPaths(String path) {
        this.path = path;
    }
}
