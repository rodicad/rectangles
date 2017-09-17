package com.exams.rectangle.config;

import java.awt.*;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class Constants {

    public static final int MAX_RECTANGLES = 20;
    public static final int MIN_RECTANGLES = 5;

    public static final int MIN_X_POINT = 0;
    public static final int MIN_Y_POINT = 0;

    public static final int MAX_X_POINT = 300;
    public static final int MAX_Y_POINT = 300;

    public static final Point STARTPOINT = new Point(Constants.MIN_X_POINT,Constants.MIN_Y_POINT);

    public static final int MIN_WIDTH = 1;
    public static final int MAX_WIDTH = 300;

    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 300;

    public static final String jsonFileName= System.getProperty("user.dir")+"\\output//test2.json";
    public static final String NUMBER_OF_RECTANGLES_PROP = "numRects";
    public static final String INPUT_RECTANGLES_PROP = "sourceRectangles";
    public static final String OUTPUT_RECTANGLES_PROP = "rectangles";


}
