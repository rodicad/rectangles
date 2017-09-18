package com.exams.rectangle.json;

import com.exams.rectangle.model.JsonReport;
import com.google.gson.Gson;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rodicad on 15/09/2017.
 */
public class RectanglesJSONFormatter {

    public String convertToJSON(JsonReport object) {
        Gson g = new Gson();
        return g.toJson(object, object.getClass());
    }

    public List<Rectangle> convertMapToList(Map<Integer, Rectangle> rectanglesList) {
        List<Rectangle> list = new ArrayList<>(  );
        for ( Rectangle r: rectanglesList.values()) {
            Rectangle rectangle = cloneRectangle( r );
            list.add( rectangle  );
        }
        return list;
    }

    private Rectangle cloneRectangle (Rectangle rectangle) {
        return new Rectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height  );
    }




}
