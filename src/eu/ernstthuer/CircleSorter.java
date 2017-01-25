package eu.ernstthuer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethur on 1/25/17.
 */
public class CircleSorter {

    public ArrayList<Circle> circles = new ArrayList();
    private Grid grid = new Grid();

    public void addCircle(Circle circle){
        circles.add(circle);
    }

    public void organizeCircles(){
        //double min_x = 1000;
        //double min_y = 1000;

        ArrayList<Circle> scoring = circles;

        Circle min_x =  circles.stream().min((first, second) -> Double.compare(first.getX_val(), second.getX_val())).get();
        double min_x_test = min_x.getX_val() + min_x.getRadius();

        while(circles.size() > 0){



        }


        Circle min_y =  circles.stream().min((first, second) -> Double.compare(first.getY_val(), second.getY_val())).get();
        System.out.println("circles at the end :  lowest X :" + min_x.getRadius() + " lowest Y " + min_y.getRadius()  );
    }
}
