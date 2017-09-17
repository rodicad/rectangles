package com.exams.rectangle.utils;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rodicad on 15/09/2017.
 */
public class ParamValidator {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );

    private static int validateNumberOfRectanglesParam( String number_rectangles ) {
        int number = Integer.valueOf( number_rectangles );

        if  ( number >= Constants.MIN_RECTANGLES && number <= Constants.MAX_RECTANGLES ) {
            return number;
        }
            else throw new IndexOutOfBoundsException();
        }

    public static int getNumberOfRectangles() {
        String numberOfRectangles = System.getProperty( Constants.NUMBER_OF_RECTANGLES_PROP);
        try {
            return validateNumberOfRectanglesParam(numberOfRectangles);
        }
        catch ( NumberFormatException e ) {
            LOG.error( "Wrong format -- {}", e.getMessage() );
        } catch (IndexOutOfBoundsException e) {
            LOG.error( "Number of rectangles [{}] not in range:  [{} - {}]",numberOfRectangles, Constants.MIN_RECTANGLES,Constants.MAX_RECTANGLES);
        }
        return -1;
    }


}
