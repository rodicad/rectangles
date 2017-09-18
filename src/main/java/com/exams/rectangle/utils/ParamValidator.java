package com.exams.rectangle.utils;

import com.exams.rectangle.config.Constants;

/**
 * Created by rodicad on 15/09/2017.
 */
public class ParamValidator {

    public static int parseParameters( String parameter ) {
        if ( parameter == null  ) {
            throw new IllegalArgumentException();
        }
        int numberRectangles = Integer.valueOf( parameter );
        if ( !( numberRectangles >= Constants.MIN_RECTANGLES && numberRectangles <= Constants.MAX_RECTANGLES ) ) {
            throw new IndexOutOfBoundsException();
        }
        return numberRectangles;
    }

}
