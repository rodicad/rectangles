package com.exams.rectangle.service;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.StartupParameters;
import com.exams.rectangle.model.HorizontalRectangleGenerator;
import com.exams.rectangle.model.RectanglesGenerator;
import com.exams.rectangle.utils.ParamValidator;
import com.exams.rectangle.utils.RectanglesDrawer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesService {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );

    private final RectanglesGenerator sourceRectanglesGenerator;
    private final StartupParameters startupParameters;
    private final HorizontalRectangleGenerator outputRectanglesGenerator;
    private Map<Integer, Rectangle> sourceRectangles;
    private Map<Integer, Rectangle> outputRectangles;



    public RectanglesService() {
        this.sourceRectanglesGenerator = new RectanglesGenerator();
        outputRectanglesGenerator = new HorizontalRectangleGenerator();
        this.startupParameters = new StartupParameters();

    }

    public void runApplication() {
        try {
            RectanglesDrawer draw = new RectanglesDrawer();

            int number_rectangles = ParamValidator.validateNumberOfRectanglesParam( startupParameters.getNumber_rectangles());
            sourceRectangles = sourceRectanglesGenerator.generateSourceRectangles( number_rectangles );
            draw.drawRectangles(sourceRectangles);
            outputRectangles = outputRectanglesGenerator.generateOutputRectangles (sourceRectangles);


           // draw.drawRectangles(outputRectangles);




        } catch ( NumberFormatException e ) {
            LOG.error( "Wrong format -- {}", e.getMessage() );
        }
    }




}
