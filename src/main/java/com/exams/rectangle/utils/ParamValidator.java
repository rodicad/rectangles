package com.exams.rectangle.utils;

/**
 * Created by rodicad on 15/09/2017.
 */
public class ParamValidator {
    private static final int MAX_RECTANGLES = 50;
    private static final int MIN_RECTANGLES = 5;

    public static int validateNumberOfRectanglesParam( String number_rectangles ) {
        int number = Integer.valueOf( number_rectangles );

        if  ( number >= MIN_RECTANGLES && number <= MAX_RECTANGLES ) {
            return number;
        }
            else throw new IndexOutOfBoundsException();
        }


}
