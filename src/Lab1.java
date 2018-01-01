import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import utils.ImagePaths;
import utils.OutputPaths;

/**
 * Laboratory 1.
 * <p>
 * Creator: Ambrozie
 * Info: Lab1.class
 * Date: 01/01/2018 20:30
 */
public class Lab1 {
    public static void run() {
        System.out.println("Lab1");
        Mat souceImage = Imgcodecs.imread(ImagePaths.LAB1_SOURCE.path);

        // save file because there is no display window
        System.out.println(String.format("Saving Mat to png: %s", OutputPaths.LAB1_OUTPUT.path));
        Imgcodecs.imwrite(OutputPaths.LAB1_OUTPUT.path, souceImage);
    }
}
