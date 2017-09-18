package com.exams.rectangle.utils;

import com.exams.rectangle.RectanglesApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class FileUtils {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );


    public static void writeToFile(String data, String fileName) throws IOException {
        fileName = System.getProperty("user.dir")+fileName;
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(data);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String path)
            throws IOException
    {
        path = System.getProperty("user.dir")+path;

        byte[] encoded = Files.readAllBytes( Paths.get(path));
        return new String(encoded);
    }


}
