package eu.ernstthuer;

import org.bytedeco.javacpp.opencv_core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.bytedeco.javacpp.opencv_core.cvGet2D;

/**
 * Created by ethur on 1/25/17.
 */
public class CircleDetector {

    private opencv_core.IplImage source;
    private int x_axis;
    private int y_axis;
    private int radius;
    public double averageIntensity;
    private List<Pixel> pixelList = new ArrayList();

    public CircleDetector(opencv_core.IplImage source, int x_axis, int y_axis, int radius) {
        this.source = source;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.radius = radius;

        for (int i = 0; i < 100; i++) {
            pixelList.add(getPixel());
        }

        this.averageIntensity = getAverageIntensity();

    }


    private Pixel getPixel() {

        int x_min = this.x_axis - (this.radius - 1);
        int x_max = this.x_axis + (this.radius - 1);

        int y_min = this.y_axis - (this.radius - 1);
        int y_max = this.y_axis + (this.radius - 1);

        Random random = new Random();
        int random_x = random.nextInt(x_max - x_min) + x_min;
        int random_y = random.nextInt(y_max - y_min) + y_min;


        double intensity = getIntensity(random_x, random_y);
        Pixel pxl = new Pixel(random_x, random_y, intensity);
        return pxl;
    }

    private double getIntensity(int x_point, int y_point) {
        try {
            opencv_core.CvScalar scalar = cvGet2D(source, Math.round(x_point), Math.round(y_point));
            double total = (double) scalar.get(0) + (double) scalar.get(1) + (double) scalar.get(2);
            //System.out.println(scalar.get(0));
            return total;
        } catch (RuntimeException e) {
            //System.out.println("failed loaction : x = " +  x_point + " y = " +  y_point + " src width = " +source.width() +"src height = "+source.height());
            //e.printStackTrace();
            //System.out.println( " here  " );
            return 0;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return 0;
        }
    }

    public Circle getCircle() {
        Circle circle = new Circle(this.x_axis, this.y_axis, this.radius, this.averageIntensity);
        return circle;
    }

    private double getAverageIntensity() {
        double total = 0;

        for (Pixel pxl : pixelList
                ) {
            total += pxl.getIntensity();
        }

        if (total > 0) {
            return (total / pixelList.size());
        } else {
            return 0;
        }


    }
}

