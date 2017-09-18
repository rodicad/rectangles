package com.exams.rectangle;

import com.exams.rectangle.config.Constants;
import com.exams.rectangle.service.RectanglesService;
import com.exams.rectangle.utils.ParamValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class RectanglesApp extends JPanel {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );

    public static void main(String[] args) {
        String inputParam = null;
        try {
            inputParam = System.getProperty( Constants.NUMBER_OF_RECTANGLES_PROP );
            int numberRectangles = ParamValidator.parseParameters( inputParam );
            RectanglesService rectanglesService = new RectanglesService();
            rectanglesService.runApplication(numberRectangles);

        } catch ( IllegalArgumentException e ) {
            LOG.error( "Wrong format -- {}", e.getMessage() );
            System.exit( -1 );
        } catch ( IndexOutOfBoundsException e ) {
            LOG.error( "Number of rectangles [{}] not in range:  [{} - {}]", inputParam, Constants.MIN_RECTANGLES, Constants.MAX_RECTANGLES );
            System.exit( -1 );
        }
    }

}
