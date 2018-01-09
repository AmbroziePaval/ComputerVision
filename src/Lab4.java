import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.ImagePaths;
import utils.OutputPaths;

import java.util.Collections;
import java.util.List;

/**
 * Laboratory 4.
 * <p>
 * Creator: Ambrozie
 * Info: Lab4.class
 * Date: 01/09/2018 13:45
 */
public class Lab4 {

    public static final String IMAGE_FORMAT = ".jpg";
    private static MatOfFloat ranges;
    private static MatOfInt histSize;
    private static MatOfInt channels;

    public static void run() {
        System.out.println("Lab4");
        Integer imageNumber = 59;
        Mat sourceImage = Imgcodecs.imread(ImagePaths.LAB4_ROOT.path + imageNumber + IMAGE_FORMAT);

        channels = new MatOfInt(0, 1, 2);
        histSize = new MatOfInt(256, 256, 256);
        ranges = new MatOfFloat(0.0f, 255.0f, 0.0f, 255.0f, 0.0f, 255.0f);


        Imgproc.cvtColor(sourceImage, sourceImage, Imgproc.COLOR_BGR2HSV);
        Mat sourceHist = new Mat();
        List<Mat> images = Collections.singletonList(sourceImage);
        Imgproc.calcHist(images, channels, new Mat(), sourceHist, histSize, ranges);
        Core.normalize(sourceHist, sourceHist);


        compareHistCorrel(sourceHist);
        compareHistChisqr(sourceHist);
        compareHistIntersection(sourceHist);
        compareHistBhattacharyya(sourceHist);
    }

    private static void compareHistCorrel(Mat sourceHist) {
        System.out.println("Compare with CV_COMP_CORREL");
        for (int i = 1; i <= 96; i++) {
            Mat compareToMat = Imgcodecs.imread(ImagePaths.LAB4_ROOT.path + i + IMAGE_FORMAT);
            Mat copyMat = compareToMat.clone();
            Imgproc.cvtColor(compareToMat, compareToMat, Imgproc.COLOR_BGR2HSV);
            Mat compareMatHist = new Mat();
            List<Mat> images = Collections.singletonList(compareToMat);

            Imgproc.calcHist(images, channels, new Mat(), compareMatHist, histSize, ranges);
            Core.normalize(compareMatHist, compareMatHist);

            double value = Imgproc.compareHist(sourceHist, compareMatHist, Imgproc.CV_COMP_CORREL);
            if (value > 0.9) {
                String path = OutputPaths.LAB4_CORREL_ROOT.path + i + IMAGE_FORMAT;
                System.out.println(String.format("Saving Mat to png: %s", path));
                Imgcodecs.imwrite(path, copyMat);
            }
        }
    }


    private static void compareHistChisqr(Mat sourceHist) {
        System.out.println("Compare with CV_COMP_CHISQR");
        for (int i = 1; i <= 96; i++) {
            Mat compareToMat = Imgcodecs.imread(ImagePaths.LAB4_ROOT.path + i + IMAGE_FORMAT);
            Mat copyMat = compareToMat.clone();
            Imgproc.cvtColor(compareToMat, compareToMat, Imgproc.COLOR_BGR2HSV);
            Mat compareMatHist = new Mat();
            List<Mat> images = Collections.singletonList(compareToMat);

            Imgproc.calcHist(images, channels, new Mat(), compareMatHist, histSize, ranges);
            Core.normalize(compareMatHist, compareMatHist);

            double value = Imgproc.compareHist(sourceHist, compareMatHist, Imgproc.CV_COMP_CHISQR);
            if (new Double(value).intValue() == 0) {
                String path = OutputPaths.LAB4_CHISQR_ROOT.path + i + IMAGE_FORMAT;
                System.out.println(String.format("Saving Mat to png: %s", path));
                Imgcodecs.imwrite(path, copyMat);
            }
        }
    }

    private static void compareHistIntersection(Mat sourceHist) {
        System.out.println("Compare with CV_COMP_INTERSECT");
        for (int i = 1; i <= 96; i++) {
            Mat compareToMat = Imgcodecs.imread(ImagePaths.LAB4_ROOT.path + i + IMAGE_FORMAT);
            Mat copyMat = compareToMat.clone();
            Imgproc.cvtColor(compareToMat, compareToMat, Imgproc.COLOR_BGR2HSV);
            Mat compareMatHist = new Mat();
            List<Mat> images = Collections.singletonList(compareToMat);

            Imgproc.calcHist(images, channels, new Mat(), compareMatHist, histSize, ranges);
            Core.normalize(compareMatHist, compareMatHist);

            double value = Imgproc.compareHist(sourceHist, compareMatHist, Imgproc.CV_COMP_INTERSECT);
            if (new Double(value).intValue() == 1) {
                String path = OutputPaths.LAB4_INTERSECT_ROOT.path + i + IMAGE_FORMAT;
                System.out.println(String.format("Saving Mat to png: %s", path));
                Imgcodecs.imwrite(path, copyMat);
            }
        }
    }

    private static void compareHistBhattacharyya(Mat sourceHist) {
        System.out.println("Compare with CV_COMP_BHATTACHARYYA");
        for (int i = 1; i <= 96; i++) {
            Mat compareToMat = Imgcodecs.imread(ImagePaths.LAB4_ROOT.path + i + IMAGE_FORMAT);
            Mat copyMat = compareToMat.clone();
            Imgproc.cvtColor(compareToMat, compareToMat, Imgproc.COLOR_BGR2HSV);
            Mat compareMatHist = new Mat();
            List<Mat> images = Collections.singletonList(compareToMat);

            Imgproc.calcHist(images, channels, new Mat(), compareMatHist, histSize, ranges);
            Core.normalize(compareMatHist, compareMatHist);

            double value = Imgproc.compareHist(sourceHist, compareMatHist, Imgproc.CV_COMP_BHATTACHARYYA);
            if (value < 0.6) {
                String path = OutputPaths.LAB4_BHATTACHARYYA_ROOT.path + i + IMAGE_FORMAT;
                System.out.println(String.format("Saving Mat to png: %s", path));
                Imgcodecs.imwrite(path, copyMat);
            }


        }
    }
}
