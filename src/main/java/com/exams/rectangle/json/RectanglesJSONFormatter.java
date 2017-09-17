package com.exams.rectangle.json;

import com.exams.rectangle.config.Constants;
import com.google.gson.Gson;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesJSONFormatter {

    public String convertToJSON(int number, Map<Integer, Rectangle> inputRectangle, Map<Integer, Rectangle> outputRectangle) {
        Map<String, Object> obj = formatRectanglesforJson(number, inputRectangle, outputRectangle);
        Gson g = new Gson();
        return g.toJson(obj, obj.getClass());
    }

    private Map<String, Object> formatRectanglesforJson(int number, Map<Integer, Rectangle> inputRectangles, Map<Integer, Rectangle> outputRectangles) {
        Map<String, Object> obj = new LinkedHashMap();
        obj.put(Constants.NUMBER_OF_RECTANGLES_PROP, number);
        obj.put(Constants.INPUT_RECTANGLES_PROP, convertMapToList(inputRectangles));
        obj.put(Constants.OUTPUT_RECTANGLES_PROP, convertMapToList(outputRectangles));
        return obj;
    }

    private List<Map<String, Object>> convertMapToList(Map<Integer, Rectangle> rectanglesList) {
        List<Map<String, Object>> expectedList = new ArrayList<>();
        for (Rectangle rectangle : rectanglesList.values()) {
            Map<String, Object> values = new LinkedHashMap<>();
            values.put("x", rectangle.x);
            values.put("y", rectangle.y);
            values.put("width", rectangle.width);
            values.put("height", rectangle.height);
            expectedList.add(values);
        }
        return expectedList;
    }




}
