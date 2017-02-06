package eu.ernstthuer;


import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.JavaCV;

import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import static org.bytedeco.javacpp.opencv_imgproc.*;


public class Main {

    public static void main(String[] args) {

        IplImage src = cvLoadImage("/home/ethur/LNCrna_Local_processes/playWithCV/CpLNCRNA3-37C_25microg_pro_ml_CalcofluorWhite_day2.jpg");
        IplImage grey = cvCreateImage(cvGetSize(src),8,1);

        cvCvtColor(src, grey, CV_BGR2GRAY);
        CvMemStorage mem = CvMemStorage.create();
        CvSeq circles = cvHoughCircles(grey,mem,CV_HOUGH_GRADIENT,4,90,90,95,0,70);

        System.out.println(circles.total());
        CircleSorter circleSorter = new CircleSorter();


        for(int i = 0; i < circles.total(); i++){

            CvPoint3D32f circle = new CvPoint3D32f(cvGetSeqElem(circles, i));
            CvPoint center = cvPointFrom32f(new CvPoint2D32f(circle.x(), circle.y()));
            int radius = Math.round(circle.z());
            CircleDetector circleDetector = new CircleDetector(src,Math.round(center.x()),Math.round(center.y()),radius);
            circleSorter.addCircle(circleDetector.getCircle());
            System.out.println(i + " : " + radius + "   average intensity "  + circleDetector.averageIntensity +  " Position : x " + circle.x() + " y " + circle.y());

            cvCircle(src, center, radius, CvScalar.GREEN, 6, CV_AA, 0);
            CvScalar s =cvGet2D(src,Math.round(circle.x()),Math.round(circle.y()));
            //System.out.println("COlor in center : " + s);
        }


        circleSorter.organizeCircles();



        cvShowImage("Result",src);
        cvSaveImage("test_2.jpg",src);
    }
}
