package com.exams.rectangle;

import com.exams.rectangle.service.RectanglesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class RectanglesApp extends JPanel {

    public static void main(String[] args)
    {
        RectanglesService rectanglesService = new RectanglesService();
        rectanglesService.runApplication();
    }



}
