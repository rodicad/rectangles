package com.exams.rectangle.utils;

import com.exams.rectangle.model.RectangleComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesDrawer {

    public void drawRectangles(Map<Integer,Rectangle> rectangles) {
        JFrame frame = new JFrame();

        frame.setSize(800, 800);
        frame.setTitle("Two rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RectangleComponent component = new RectangleComponent(rectangles);
        frame.add(component);

        frame.setVisible(true);
    }

}
