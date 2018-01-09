package utils;

/**
 * Image paths help enum.
 * <p>
 * Creator: Ambrozie
 * Info: utils.ImagePaths.class
 * Date: 01/01/2018 20:34
 */
public enum ImagePaths {
    LAB1_SOURCE("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\resources\\lab1\\source.jpg"),
    LAB2_SCENE("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\resources\\lab2\\scene.jpg"),
    LAB2_LOGO("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\resources\\lab2\\logo.png"),
    LAB3_RECTANGLE("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\resources\\lab3\\square-rectangle.png"),
    LAB3_BUILDING("C:\\Users\\Ambrozie\\IdeaProjects\\ComputerVision\\resources\\lab3\\MorpologicalCornerDetection.png");

    public String path;

    ImagePaths(String path) {
        this.path = path;
    }
}
