package com.exams.rectangle.utils;

import com.exams.rectangle.RectanglesApp;
import com.exams.rectangle.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class RectanglesUtilities {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );


    public static void writeToFile(String data) throws IOException {
        try (java.io.FileWriter file = new java.io.FileWriter(Constants.jsonFileName)) {

            file.write(data);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
