package com.exams.rectangle.service;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.Constants;
import com.exams.rectangle.json.RectanglesJSONFormatter;
import com.exams.rectangle.model.JsonReport;
import com.exams.rectangle.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesService {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );

    private final InputRectanglesCreator inputRectanglesCreator;
    private final HorizontalRectangleGenerator outputRectanglesGenerator;
    private Map<Integer, Rectangle> sourceRectangles;
    private Map<Integer, Rectangle> outputRectangles;
    private RectanglesJSONFormatter rectanglesJSONFormatter;



    public RectanglesService() {
        this.inputRectanglesCreator = new InputRectanglesCreator();
        outputRectanglesGenerator = new HorizontalRectangleGenerator();
        this.rectanglesJSONFormatter = new RectanglesJSONFormatter();
    }

    public void runApplication(int numberOfRectangles) {
        try {
            sourceRectangles = inputRectanglesCreator.generateSourceRectangles( numberOfRectangles );
            List<Rectangle> sourceRectanglesList = rectanglesJSONFormatter.convertMapToList( sourceRectangles );

            outputRectangles = outputRectanglesGenerator.generateOutputRectangles (sourceRectangles);
            List<Rectangle> outputRectanglesList = rectanglesJSONFormatter.convertMapToList( outputRectangles );

            JsonReport jsonReport = new JsonReport( numberOfRectangles, sourceRectanglesList,outputRectanglesList  );

            String json = rectanglesJSONFormatter.convertToJSON(jsonReport);
            FileUtils.writeToFile(json, Constants.JSON_FILE_NAME );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }






}
