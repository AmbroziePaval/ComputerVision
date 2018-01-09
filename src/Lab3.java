import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.ImagePaths;
import utils.OutputPaths;

/**
 * TLaboratory 3.
 * <p>
 * Creator: Ambrozie
 * Info: Lab3.class
 * Date: 01/09/2018 10:48
 */
public class Lab3 {
    private static Mat rectangleImage;
    private static Mat buildingImage;

    public static void run() {
        System.out.println("Lab3");
        rectangleImage = Imgcodecs.imread(ImagePaths.LAB3_RECTANGLE.path);
        buildingImage = Imgcodecs.imread(ImagePaths.LAB3_BUILDING.path);
        rectangleImage = getBinaryMat(rectangleImage);
        buildingImage = getBinaryMat(buildingImage);
        saveImage(rectangleImage, OutputPaths.LAB3_BINARY_RECT);
        saveImage(buildingImage, OutputPaths.LAB3_BINARY_BUILDING);

        // R1
        Mat R1_dilate_rect = dilateCross(rectangleImage.clone());
        Mat R1_dilate_building = dilateCross(buildingImage.clone());
        saveImage(R1_dilate_rect, OutputPaths.LAB3_R1_DILATE_RECT);
        saveImage(R1_dilate_building, OutputPaths.LAB3_R1_DILATE_BUILDING);

        Mat R1_erode_rect = erodeDiamond(R1_dilate_rect.clone());
        Mat R1_erode_building = erodeDiamond(R1_dilate_building.clone());
        saveImage(R1_erode_rect, OutputPaths.LAB3_R1_ERODE_RECT);
        saveImage(R1_erode_building, OutputPaths.LAB3_R1_ERODE_BUILDING);

        // R2
        Mat R2_dilate_rect = dilateX(rectangleImage.clone());
        Mat R2_dilate_building = dilateX(buildingImage.clone());
        saveImage(R2_dilate_rect, OutputPaths.LAB3_R2_DILATE_RECT);
        saveImage(R2_dilate_building, OutputPaths.LAB3_R2_DILATE_BUILDING);

        Mat R2_erode_rect = erodeSquare(R2_dilate_rect.clone());
        Mat R2_erode_building = erodeSquare(R2_dilate_building.clone());
        saveImage(R2_erode_rect, OutputPaths.LAB3_R2_ERODE_RECT);
        saveImage(R2_erode_building, OutputPaths.LAB3_R2_ERODE_BUILDING);

        // absdiff
        Mat R_rectangle = new Mat();
        Core.absdiff(R2_erode_rect, R1_erode_rect, R_rectangle);
        saveImage(R_rectangle, OutputPaths.LAB3_R_RECT);
        Mat R_building = new Mat();
        Core.absdiff(R2_erode_building, R1_erode_building, R_building);
        saveImage(R_building, OutputPaths.LAB3_R_BUILDING);

    }

    private static Mat dilateCross(Mat sourceImage) {
        // cross kernel
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3));
//        Imgproc.dilate(sourceImage, sourceImage, kernel, new Point(-1, -1), 1, Core.BORDER_CONSTANT, new Scalar(1));
        Imgproc.dilate(sourceImage, sourceImage, kernel, new Point(-1, -1), 1);

        return sourceImage;
    }

    private static Mat erodeDiamond(Mat sourceImage) {
        // diamond kernel
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
        kernel.put(0, 1, 1);
        kernel.put(1, 0, 1);
        kernel.put(1, 2, 1);
        kernel.put(2, 1, 1);

//        Imgproc.erode(sourceImage, sourceImage, kernel, new Point(-1, -1), 1, Core.BORDER_CONSTANT, new Scalar(1));
        Imgproc.erode(sourceImage, sourceImage, kernel, new Point(-1, -1), 1);
        return sourceImage;
    }

    private static Mat dilateX(Mat sourceImage) {
        // Xshape kernel
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
        kernel.put(0, 0, 1);
        kernel.put(0, 2, 1);
        kernel.put(2, 0, 1);
        kernel.put(2, 2, 1);

//        Imgproc.dilate(sourceImage, sourceImage, kernel, new Point(-1, -1), 1, Core.BORDER_CONSTANT, new Scalar(1));
        Imgproc.dilate(sourceImage, sourceImage, kernel, new Point(-1, -1), 1);
        return sourceImage;
    }

    private static Mat erodeSquare(Mat sourceImage) {
        // square kernel
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));

//        Imgproc.erode(sourceImage, sourceImage, kernel, new Point(-1, -1), 1, Core.BORDER_CONSTANT, new Scalar(1));
        Imgproc.erode(sourceImage, sourceImage, kernel, new Point(-1, -1), 1);
        return sourceImage;
    }

    private static void saveImage(Mat rectangleMat, OutputPaths outputPath) {
        System.out.println(String.format("Saving Mat to png: %s", outputPath.path));
        Imgcodecs.imwrite(outputPath.path, rectangleMat);
    }

    private static Mat getBinaryMat(Mat staveMat) {
        if (staveMat.channels() == 3) {
            Imgproc.cvtColor(staveMat, staveMat, Imgproc.COLOR_BGR2GRAY);
        }

        Mat binaryStaveMat = new Mat();
        Imgproc.threshold(staveMat, binaryStaveMat, 155, 255, Imgproc.THRESH_BINARY);
        return binaryStaveMat;
    }
}
