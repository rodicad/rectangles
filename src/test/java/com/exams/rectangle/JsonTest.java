package com.exams.rectangle;

import com.exams.rectangle.config.Constants;
import com.exams.rectangle.json.RectanglesJSONFormatter;
import com.exams.rectangle.model.JsonReport;
import com.exams.rectangle.service.HorizontalRectangleGenerator;
import com.exams.rectangle.service.RectanglesService;
import com.exams.rectangle.utils.FileUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class JsonTest {
    private  HorizontalRectangleGenerator horizontalRectangleGenerator;

    private Map<Integer,Rectangle> sameHeightRectangles;
    private Map<Integer, Rectangle> actualHorizontalsSameHeight;
    private Map<Integer, Rectangle> expectedRectanglesSameHeight;
    private static final String ACTUAL_JSON_1 = "\\outputTests//actual1.json";
    private static final String EXPECTED_JSON_1 = "\\outputTests//expectedJSON1.json";

    private Map<Integer,Rectangle> differentHeightRectangles;
    private Map<Integer, Rectangle> actualHorizontalsDiffHeight;
    private Map<Integer, Rectangle> expectedRectanglesDiffHeight;
    private static final String ACTUAL_JSON_2 = "\\outputTests//actual2.json";
    private static final String EXPECTED_JSON_2 = "\\outputTests//expectedJSON2.json";


    @Test
    //test the json contains required properties
    public void testJSONFormat() throws IOException {
        RectanglesService rectanglesService = new RectanglesService();
        rectanglesService.runApplication(  6 );

        String actualJson = FileUtils.readFile( Constants.JSON_FILE_NAME );
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse( actualJson ).getAsJsonObject();

        Assert.assertTrue( jsonObject.isJsonObject() );
        Assert.assertEquals( 3, jsonObject.keySet().size() );
        Assert.assertTrue( jsonObject.keySet().contains( Constants.NUMBER_OF_RECTANGLES_PROP ) );
        Assert.assertTrue( jsonObject.keySet().contains( Constants.INPUT_RECTANGLES_PROP ) );
        Assert.assertTrue( jsonObject.keySet().contains( Constants.OUTPUT_RECTANGLES_PROP ) );
    }

    @Test
    //Test generated json against expected json
    public void testJsonContent() throws IOException, InterruptedException {
        String expectedJson = FileUtils.readFile( EXPECTED_JSON_1 );
        String actualJson = FileUtils.readFile( ACTUAL_JSON_1 );
        Assert.assertEquals( expectedJson, actualJson );

        expectedJson = FileUtils.readFile( EXPECTED_JSON_2 );
        actualJson = FileUtils.readFile( ACTUAL_JSON_2 );
        Assert.assertEquals( expectedJson, actualJson );

        //TODO : Need to create more test data to

    }


    @Before
    public void buildTestData() throws IOException {
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

        RectanglesJSONFormatter formatter = new RectanglesJSONFormatter();
        JsonReport actualReport1 = new JsonReport(sameHeightRectangles.size(),formatter.convertMapToList(sameHeightRectangles),formatter.convertMapToList( actualHorizontalsSameHeight ) );
        JsonReport expectedReport1 = new JsonReport(sameHeightRectangles.size(),formatter.convertMapToList(sameHeightRectangles),formatter.convertMapToList( expectedRectanglesSameHeight ) );

        FileUtils.writeToFile( formatter.convertToJSON( actualReport1 ), ACTUAL_JSON_1 );
        FileUtils.writeToFile( formatter.convertToJSON( expectedReport1 ), EXPECTED_JSON_1 );


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

        JsonReport actualReport2 = new JsonReport(differentHeightRectangles.size(),formatter.convertMapToList(differentHeightRectangles),formatter.convertMapToList( actualHorizontalsDiffHeight ) );
        JsonReport expectedReport2 = new JsonReport(differentHeightRectangles.size(),formatter.convertMapToList(differentHeightRectangles),formatter.convertMapToList( expectedRectanglesDiffHeight ) );

        FileUtils.writeToFile(  formatter.convertToJSON( actualReport2), ACTUAL_JSON_2 );
        FileUtils.writeToFile(  formatter.convertToJSON( expectedReport2), EXPECTED_JSON_2 );



        //TODO : add more source data

    }

}
