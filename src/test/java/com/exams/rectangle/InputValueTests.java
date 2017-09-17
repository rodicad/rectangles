package com.exams.rectangle;

import com.exams.rectangle.config.Constants;
import com.exams.rectangle.model.HorizontalRectangleGenerator;
import com.exams.rectangle.service.RectanglesService;
import com.exams.rectangle.utils.ParamValidator;
import com.exams.rectangle.utils.RectanglesDrawer;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class InputValueTests {
     private final String[] outOfBoundsValues={"-1","4","21","33"};
     private final String[] nonNumericValues= {"1f","","  6"};

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUserInputData() {
        for (int i=0; i< outOfBoundsValues.length; i++) {
            System.setProperty(Constants.NUMBER_OF_RECTANGLES_PROP,outOfBoundsValues[i]);
            RectanglesService app = new RectanglesService();
        }
    }

    @Test
    public void testUserIvalidDataFormat() {
        for (int i=0; i< nonNumericValues.length; i++) {
            System.setProperty(Constants.NUMBER_OF_RECTANGLES_PROP,outOfBoundsValues[i]);
            ParamValidator.getNumberOfRectangles();
        }
    }

    @Test
    public void testCorrectUserInput() {

    }

    @Test
    public void newRectangle_instantiatesCorrectly() {
        Rectangle testRectangle = new Rectangle(0,0,50,100);
        Rectangle testRectangle2 = new Rectangle(50,0,40,80);
        Rectangle testRectangle3 = new Rectangle(90,0,70,60);
        Rectangle testRectangle4 = new Rectangle(160,0,30,110);
        Rectangle testRectangle5 = new Rectangle(190,0,20,50);

        Map<Integer,Rectangle> input = new LinkedHashMap<>(  );
        input.put( 0, testRectangle );
        input.put( 1, testRectangle2 );
        input.put( 2, testRectangle3 );
        input.put( 3, testRectangle4 );
        input.put( 4, testRectangle5 );
        RectanglesDrawer draw = new RectanglesDrawer();
        draw.drawRectangles( input );

        HorizontalRectangleGenerator horizontalRectangleGenerator = new HorizontalRectangleGenerator();
        horizontalRectangleGenerator.generateOutputRectangles(input);
    }


    //check rectangles are adjacent

    //test cases where minimum horizantal rectangles are generated
    @Test
    @Ignore
    public void sameHeightInputRectangles() {
        //if all have same height => 1 horizontal
//        Rectangle testRectangle = new Rectangle(0,0,50,10);
//        Rectangle testRectangle2 = new Rectangle(50,0,40,10);
//        Rectangle testRectangle3 = new Rectangle(90,0,70,10);
//        Rectangle testRectangle4 = new Rectangle(160,0,30,10);
//        Rectangle testRectangle5 = new Rectangle(190,0,20,10);
//
//        Map<Integer,Rectangle> input = new LinkedHashMap<>(  );
//        input.put( 0, testRectangle );
//        input.put( 1, testRectangle2 );
//        input.put( 2, testRectangle3 );
//        input.put( 3, testRectangle4 );
//        input.put( 4, testRectangle5 );
//
//
        HorizontalRectangleGenerator horizontalRectangleGenerator = new HorizontalRectangleGenerator();
//        Map<Integer, Rectangle> results = horizontalRectangleGenerator.generateOutputRectangles(input);
//        Assert.assertEquals(1, results.size());


        //if all but 1 have same height => 2 horizontal
//        Map<Integer,Rectangle> input2 = new LinkedHashMap<>(  );
//        input2.put( 0,  new Rectangle(0,0,50,20) );
//        input2.put( 1, new Rectangle(50,0,40,10) );
//        input2.put( 2, new Rectangle(90,0,70,10) );
//        input2.put( 3, new Rectangle(160,0,30,10) );
//        input2.put( 4, new Rectangle(190,0,30,10) );
//
//        Assert.assertEquals(2, horizontalRectangleGenerator.generateOutputRectangles(input2).size());

        //if all but 1 have same height => 2 horizontal
        Map<Integer,Rectangle> input3 = new LinkedHashMap<>(  );
        input3.put( 0,  new Rectangle(0,0,50,10) );
        input3.put( 1, new Rectangle(50,0,40,10) );
        input3.put( 2, new Rectangle(90,0,70,30) );
        input3.put( 3, new Rectangle(160,0,30,10) );
        input3.put( 4, new Rectangle(190,0,30,10) );

        Assert.assertEquals(2, horizontalRectangleGenerator.generateOutputRectangles(input3).size());

    }
}
