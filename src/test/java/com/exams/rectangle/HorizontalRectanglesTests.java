package com.exams.rectangle;

import com.exams.rectangle.service.HorizontalRectangleGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class HorizontalRectanglesTests {
    private Map<Integer,Rectangle> sameHeightRectangles;
    private Map<Integer, Rectangle> actualHorizontalsSameHeight;
    private Map<Integer, Rectangle> expectedRectanglesSameHeight;

    private Map<Integer,Rectangle> differentHeightRectangles;
    private Map<Integer, Rectangle> actualHorizontalsDiffHeight;
    private Map<Integer, Rectangle> expectedRectanglesDiffHeight;

    private  HorizontalRectangleGenerator horizontalRectangleGenerator;

    @Test
    public void sameHeightInputRectangles() {

        Assert.assertEquals( expectedRectanglesSameHeight.size(), actualHorizontalsSameHeight.size() );
        Assert.assertEquals( expectedRectanglesSameHeight, actualHorizontalsSameHeight);
    }


    @Test
    public void testDifferentHeightInputRectangles() {

        Assert.assertEquals( expectedRectanglesDiffHeight.size(), actualHorizontalsDiffHeight.size() );
        Assert.assertEquals( expectedRectanglesDiffHeight, actualHorizontalsDiffHeight);

    }

    @Before
    public void buildTestData() {
        horizontalRectangleGenerator = new HorizontalRectangleGenerator();

        sameHeightRectangles = new LinkedHashMap<>();
        sameHeightRectangles.put( 0, new Rectangle( 0, 0, 50, 10 ) );
        sameHeightRectangles.put( 1, new Rectangle( 50, 0, 40, 10 ) );
        sameHeightRectangles.put( 2, new Rectangle( 90, 0, 70, 10 ) );
        sameHeightRectangles.put( 3, new Rectangle( 160, 0, 30, 10 ) );
        sameHeightRectangles.put( 4, new Rectangle( 190, 0, 30, 10 ) );

        actualHorizontalsSameHeight= horizontalRectangleGenerator.generateOutputRectangles( sameHeightRectangles );
        expectedRectanglesSameHeight =  new LinkedHashMap<>();
        expectedRectanglesSameHeight.put( 0, new Rectangle( 0,0,220,10 ) );

        differentHeightRectangles = new LinkedHashMap<>();
        differentHeightRectangles.put( 0, new Rectangle( 0, 0, 50, 10 ) );
        differentHeightRectangles.put( 1, new Rectangle( 50, 0, 40, 50 ) );
        differentHeightRectangles.put( 2, new Rectangle( 90, 0, 70, 10 ) );
        differentHeightRectangles.put( 3, new Rectangle( 160, 0, 30, 10 ) );
        differentHeightRectangles.put( 4, new Rectangle( 190, 0, 30, 10 ) );

        actualHorizontalsDiffHeight= horizontalRectangleGenerator.generateOutputRectangles( differentHeightRectangles );
        expectedRectanglesDiffHeight = new LinkedHashMap<>();
        expectedRectanglesDiffHeight.put( 0, new Rectangle( 0,0,220,10 ) );
        expectedRectanglesDiffHeight.put( 1, new Rectangle( 50,10,40,40 ) );

        //TODO : add more source data

    }

    @Test
    public void testRectanglesAgjacency() {
        //TODO: test input rectangles are adjacent (I didn't have the time)
    }
    
}
