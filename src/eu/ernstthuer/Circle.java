package eu.ernstthuer;


/**
 * Created by ethur on 1/25/17.
 */
public class Circle {
    private double x_val;
    private double y_val;
    private double radius;
    private double intensity;
    private double row;
    private double column;


    public Circle(double x_val, double y_val, double radius, double intensity) {
        this.x_val = x_val;
        this.y_val = y_val;
        this.radius = radius;
        this.intensity = intensity;
    }

    public double getX_val() {
        return x_val;
    }

    public double getY_val() {
        return y_val;
    }

    public double getRadius() {
        return radius;
    }

    public double getIntensity() {
        return intensity;
    }

    public double getRow() {
        return row;
    }

    public double getColumn() {
        return column;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public void setColumn(double column) {
        this.column = column;
    }
}
