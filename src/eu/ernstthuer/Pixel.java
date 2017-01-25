package eu.ernstthuer;

/**
 * Created by ethur on 1/25/17.
 */
public class Pixel {
    private int x_val;
    private int y_val;
    private double intensity = 0;


    public Pixel(int x_val, int y_val, double intensity) {
        this.x_val = x_val;
        this.y_val = y_val;
        this.intensity = intensity;
    }

    public double getIntensity() {
        return intensity;
    }
}
