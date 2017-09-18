package com.exams.rectangle;

import com.exams.rectangle.config.Constants;
import com.exams.rectangle.service.InputRectanglesCreator;
import com.exams.rectangle.utils.ParamValidator;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class InputValueTests {
    private final String[] outOfBoundsValues = { "-1", "4", "21", "33" };
    private final String[] nonNumericValues = { "1f", "", "  6", null, "?£$%$%%" };
    private final String[] validInputValues = { "5", "20", "7" };

    private final int[] expectedInputIntegers = { 5, 20, 7 };

    @Test( expected = IndexOutOfBoundsException.class )
    public void testUserInputData() {
        for ( int i = 0; i < outOfBoundsValues.length; i++ ) {
            System.setProperty( Constants.NUMBER_OF_RECTANGLES_PROP, outOfBoundsValues[i] );
            String param = System.getProperty( Constants.NUMBER_OF_RECTANGLES_PROP );
            ParamValidator.parseParameters( param );
        }
    }

    @Test( expected = IllegalArgumentException.class )
    public void testUserIvalidDataFormat() {
        for ( int i = 0; i < nonNumericValues.length; i++ ) {
            System.setProperty( Constants.NUMBER_OF_RECTANGLES_PROP, nonNumericValues[i] );
            String param = System.getProperty( Constants.NUMBER_OF_RECTANGLES_PROP );
            ParamValidator.parseParameters( param );
        }
    }

    @Test
    public void testCorrectUserInput() {
        for ( int i = 0; i < validInputValues.length; i++ ) {
            System.setProperty( Constants.NUMBER_OF_RECTANGLES_PROP, validInputValues[i] );
            Assert.assertEquals( expectedInputIntegers[i], ParamValidator.parseParameters( System.getProperty( Constants.NUMBER_OF_RECTANGLES_PROP ) ) );
        }
    }

    @Test
    //check that correct number of input rectangles ar generated
    public void testRectanglesInstantiatesCorrectly() {
        for ( int i = 0; i < expectedInputIntegers.length; i++ ) {
            InputRectanglesCreator inputRectanglesCreator = new InputRectanglesCreator();
            Map<Integer, Rectangle> inputRectangles = inputRectanglesCreator.generateSourceRectangles( expectedInputIntegers[i] );
            Assert.assertEquals( expectedInputIntegers[i], inputRectangles.size() );
        }
    }

    @Test
    public void testRectanglesAgjacency() {
        //TODO: test input rectangles are adjacent (I didn't have the time)
    }

}
