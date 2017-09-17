package com.exams.rectangle.service;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.Constants;
import com.exams.rectangle.json.RectanglesJSONFormatter;
import com.exams.rectangle.model.HorizontalRectangleGenerator;
import com.exams.rectangle.model.InputRectanglesCreator;
import com.exams.rectangle.utils.ParamValidator;
import com.exams.rectangle.utils.RectanglesUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesService {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );

    private  final int numberOfRectangles;
    private final InputRectanglesCreator inputRectanglesCreator;
    private final HorizontalRectangleGenerator outputRectanglesGenerator;
    private Map<Integer, Rectangle> sourceRectangles;
    private Map<Integer, Rectangle> outputRectangles;
    private RectanglesJSONFormatter rectanglesJSONFormatter;



    public RectanglesService() {
        numberOfRectangles = ParamValidator.getNumberOfRectangles();
        this.inputRectanglesCreator = new InputRectanglesCreator();
        outputRectanglesGenerator = new HorizontalRectangleGenerator();
        this.rectanglesJSONFormatter = new RectanglesJSONFormatter();
    }

    public void runApplication() {
        try {
            //RectanglesDrawer draw = new RectanglesDrawer();
            sourceRectangles = inputRectanglesCreator.generateSourceRectangles( numberOfRectangles );
          //  draw.drawRectangles(sourceRectangles);
            outputRectangles = outputRectanglesGenerator.generateOutputRectangles (sourceRectangles);
            String json = rectanglesJSONFormatter.convertToJSON(numberOfRectangles,sourceRectangles,outputRectangles);
            RectanglesUtilities.writeToFile(json);
           // draw.drawRectangles(outputRectangles);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }






}
