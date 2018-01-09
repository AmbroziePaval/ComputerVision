import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import utils.ImagePaths;
import utils.OutputPaths;

/**
 * Laboratory 2.
 * <p>
 * Creator: Ambrozie
 * Info: Lab2.class
 * Date: 01/06/2018 13:34
 */
public class Lab2 {
    public static void run() {
        placeLogo();
    }

    private static void placeLogo() {
        System.out.println("Lab2");
        Mat sceneImage = Imgcodecs.imread(ImagePaths.LAB2_SCENE.path);
        Mat logoImage = Imgcodecs.imread(ImagePaths.LAB2_LOGO.path, Imgcodecs.IMREAD_UNCHANGED);


        for (int row = 0; row < logoImage.rows(); row++) {
            for (int col = 0; col < logoImage.cols(); col++) {
                double[] logoValue = logoImage.get(row, col);
                if (logoValue[3] > 0) {
                    double[] newValue = new double[]{logoValue[0], logoValue[1], logoValue[2]};
                    sceneImage.put(row, col, newValue);
                }
            }
        }

        System.out.println(String.format("Saving Mat to png: %s", OutputPaths.LAB2_OUTPUT.path));
        Imgcodecs.imwrite(OutputPaths.LAB2_OUTPUT.path, sceneImage);
    }
}
