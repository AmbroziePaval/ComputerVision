import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.ImagePaths;
import utils.OutputPaths;

/**
 * Laboratory 5.
 * <p>
 * Creator: Ambrozie
 * Info: Lab5.class
 * Date: 01/09/2018 17:21
 */
public class Lab5 {
    public static void run() {
        System.out.println("Lab5");
        Mat source = Imgcodecs.imread(ImagePaths.LAB5_SOURCE.path, Imgcodecs.IMREAD_GRAYSCALE);

        Mat linesMat = getHoughLines(source);
        System.out.println(String.format("Saving Mat to png: %s", OutputPaths.LAB5_LINE.path));
        Imgcodecs.imwrite(OutputPaths.LAB5_LINE.path, linesMat);

        Mat circlesMat = getHoughCircles(source);
        System.out.println(String.format("Saving Mat to png: %s", OutputPaths.LAB5_CIRCLE.path));
        Imgcodecs.imwrite(OutputPaths.LAB5_CIRCLE.path, circlesMat);
    }

    private static Mat getHoughLines(Mat image) {
        Mat edgeMat = new Mat();
        Imgproc.Canny(image, edgeMat, 50, 200, 3, false);

        Mat resultMat = new Mat();
        Imgproc.cvtColor(edgeMat, resultMat, Imgproc.COLOR_GRAY2BGR);

        Mat lines = new Mat();
        Imgproc.HoughLinesP(edgeMat, lines, 1, Math.PI / 180, 50, 50, 10);

        for (int x = 0; x < lines.rows(); x++) {
            double[] line = lines.get(x, 0);
            Point point1 = new Point(line[0], line[1]);
            Point point2 = new Point(line[2], line[3]);
            Imgproc.line(resultMat, point1, point2, new Scalar(0, 0, 255), 1, Imgproc.LINE_AA, 0);
        }
        return resultMat;
    }

    private static Mat getHoughCircles(Mat image) {
        Mat resultMat = image.clone();
        Imgproc.cvtColor(resultMat, resultMat, Imgproc.COLOR_GRAY2BGR);

        Imgproc.medianBlur(image, image, 5);
        Mat circles = new Mat();
        int minRadious = 1;
        int maxRadious = 30;
        Imgproc.HoughCircles(image, circles, Imgproc.CV_HOUGH_GRADIENT, 1.0,
                image.rows() / 16,
                100.0, 30.0,
                minRadious, maxRadious);


        for (int i = 0; i < circles.cols(); i++) {
            double[] circle = circles.get(0, i);
            double x = circle[0];
            double y = circle[1];
            int radius = (int) Math.round(circle[2]);

            Point center = new Point(x, y);
            Imgproc.circle(resultMat, center, 1, new Scalar(0, 100, 100), 2, 8, 0);
            Imgproc.circle(resultMat, center, (new Double(radius)).intValue(), new Scalar(0, 0, 255), 2, 8, 0);
        }
        return resultMat;
    }
}
