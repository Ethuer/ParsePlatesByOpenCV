package eu.ernstthuer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        ArrayList<Circle> negatives = new ArrayList<>();

        Circle min_x =  circles.stream().min((first, second) -> Double.compare(first.getX_val(), second.getX_val())).get();
        scoring.remove(min_x);
        double min_x_test = min_x.getX_val() + min_x.getRadius();

        System.out.println("before " + scoring.size());

        Set<Circle> firslevels =  scoring.stream().filter(x -> x.getX_val()<min_x_test);


      /*  for (Circle circle: circles
             ) {
            if(circle.getX_val() < min_x_test){
                scoring.remove(circle);
            }
        }*/
        //System.out.println("After " +scoring.size());
        Circle min_y =  circles.stream().min((first, second) -> Double.compare(first.getY_val(), second.getY_val())).get();
        System.out.println("circles at the end :  lowest X :" + min_x.getRadius() + " lowest Y " + min_y.getRadius()  );
    }
}
