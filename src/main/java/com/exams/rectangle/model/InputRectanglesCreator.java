package com.exams.rectangle.model;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class InputRectanglesCreator {

    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );
    private Point startPoint;

    /**
     * This method will generate n adjacent rectangles within min and max point and dimensions limits
     * @param number_rectangles
     * @return
     * A map with created rectangles
     */
    public  Map<Integer, Rectangle> generateSourceRectangles(int number_rectangles ) {
        Map<Integer, Rectangle> sourceRectangles = new LinkedHashMap<>(  );
        this.startPoint = Constants.STARTPOINT;

        for (int i = 0; i < number_rectangles; i++) {
           int x = startPoint.x;
           int y = startPoint.y;
           int width = (int) ( Math.random() * ( (Constants.MAX_WIDTH - Constants.MIN_WIDTH ) + 1 ) ) + Constants.MIN_WIDTH;
           int height = (int) ( Math.random() * ( ( Constants.MAX_HEIGHT - Constants.MIN_HEIGHT ) + 1 ) ) + Constants.MIN_HEIGHT;
           sourceRectangles.put( i,new Rectangle( x,y,width,height ) );
            LOG.info("Input rectangle generated: key: {},x: {},y: {},width: {},height: {}"
                    ,i,x,y,width,height);
           updateStartPoint(startPoint, width);
       }
       return sourceRectangles;
    }


    /**
     * This method is used to generate the starting point of a rectangle to make it adjacent to previous one,
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
