package com.exams.rectangle;

import com.exams.rectangle.utils.RectanglesDrawer;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class InputValueTests {
    // private static final  [-1,4];

    @Test
    @Ignore
    public void newRectangle_instantiatesCorrectly() {
        Rectangle testRectangle = new Rectangle(0,0,50,100);
        Rectangle testRectangle2 = new Rectangle(50,0,40,87);
        Rectangle testRectangle3 = new Rectangle(90,0,70,66);
        Rectangle testRectangle4 = new Rectangle(160,0,45,146);
        Rectangle testRectangle5 = new Rectangle(205,0,30,54);

        Map<Integer,Rectangle> input = new LinkedHashMap<>(  );
        input.put( 0, testRectangle );
        input.put( 1, testRectangle2 );
        input.put( 2, testRectangle3 );
        input.put( 3, testRectangle4 );
        input.put( 4, testRectangle5 );
        RectanglesDrawer draw = new RectanglesDrawer();
        draw.drawRectangles( input );
    }


    //check rectangles are adjacent
}
