package com.exams.rectangle.model;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesGenerator {

    private static final int MIN_X_POINT = 0;
    private static final int MIN_Y_POINT = 0;

    private static final int MAX_X_POINT = 300;
    private static final int MAX_Y_POINT = 300;

    private static final int MIN_WIDTH = 1;
    private static final int MAX_WIDTH = 300;

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 300;

    private Point startPoint;

    public RectanglesGenerator() {

    }

    /**
     * This method will generate n adjacent rectangles within min and max point and dimensions limits
     * @param number_rectangles
     * @return
     * A map with created rectangles
     */
    public  Map<Integer, Rectangle> generateSourceRectangles(int number_rectangles ) {
        Map<Integer, Rectangle> sourceRectangles = new LinkedHashMap<>(  );
        this.startPoint = new Point (10,10);

        for (int i = 0; i < number_rectangles; i++) {
           int x = startPoint.x;
           int y = startPoint.y;
           int width = (int) ( Math.random() * ( ( MAX_WIDTH - MIN_WIDTH ) + 1 ) ) + MIN_WIDTH;
           int height = (int) ( Math.random() * ( ( MAX_HEIGHT - MIN_HEIGHT ) + 1 ) ) + MIN_HEIGHT;
           sourceRectangles.put( i,new Rectangle( x,y,width,height ) );
            printRectInfo(sourceRectangles.get( i ));
           updateStartPoint(startPoint, width);
       }
       return sourceRectangles;
    }

//    private Point generateStartPoint() {
//        int x = (int) ( Math.random() * ( ( MAX_X_POINT - MIN_X_POINT ) + 1 ) ) + MIN_X_POINT;
//        int y = (int) ( Math.random() * ( ( MAX_Y_POINT - MIN_Y_POINT ) + 1 ) ) + MIN_Y_POINT;
//        return new Point(x,y  );
//
//    }

        private void printRectInfo(Rectangle r) {
            System.out.println("The following input rectangle was generated: ");
            System.out.println("(X="+r.x+", y="+r.y+",W="+r.width+", H="+r.height+")");
        }

    /**
     * This method is used to generate the startin=g point of a rectangle to make it adjacent to previous one,
     * by adding the width of previously generated rectangle
     * @param point
     * The starting point of previous rectangle
     * @param width
     * The value to add to x coordinate
     * @return
     */
    private Point updateStartPoint(Point point, int width){
        point.x = point.x+width;
        return point;


    }


}
