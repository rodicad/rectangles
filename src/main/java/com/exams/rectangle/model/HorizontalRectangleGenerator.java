package com.exams.rectangle.model;

import com.exams.rectangle.RectanglesApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 14/09/2017.
 */
public class HorizontalRectangleGenerator {
    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );


    /**
     * Given n adjacent  input rectangles (considered vertical) which form a skyline shape, this function generates the "horizontal" rectangles
     * required to form the same skyline shape.
     * Solution involves iterating through each input rectangle and create horizontal rectangles of maximum possible width.
     * The height of each new horizontal rectangle will be the minimum height convertToJSON remaining input list.
     *
     * @param inputRectangles which form a skyline shape
     * @return Returns a Map object containing the horizontal rectangles that form same skyline shape as inputRectangles
     */
    public Map<Integer, Rectangle> generateOutputRectangles(Map<Integer, Rectangle> inputRectangles) {
       //the horizontal rectangles Map to rerieve
        Map<Integer, Rectangle> outputRectangles = new LinkedHashMap<>();

        //the intermediary rectangles will adjust their height and start point based on generated horizontal rectangles
        Map<Integer, Rectangle> interm = new LinkedHashMap<>(inputRectangles);

        //because map cannot be modified inside a loop, I am iterating through the initial input rectangles map
        Iterator<Integer> it = inputRectangles.keySet().iterator();

        while (it.hasNext()) {
            int currentKey = it.next();
            int outputKey = 0;

            while (interm.containsKey(currentKey)) {
                Rectangle current = interm.get(currentKey);
                int minHeight = getMinHeight(interm);

                if (current.height >= minHeight) {
                    Rectangle newHorizontal = new Rectangle();
                    newHorizontal.x = current.x;
                    newHorizontal.y = current.y;
                    newHorizontal.height = minHeight;
                    newHorizontal.width = calculateWidth(minHeight, currentKey, interm);
                    outputRectangles.put(outputKey, newHorizontal);
                    LOG.info("Horizontal rectangle generated: key: {},x: {},y: {},width: {},height: {}"
                            ,outputKey,newHorizontal.x,newHorizontal.y,newHorizontal.width,newHorizontal.height);
                    outputKey += 1;
                    interm = updateRectangles(minHeight, currentKey, interm);
                } else {
                    it.remove();

                }
            }
        }

        return outputRectangles;
    }

    /**
     * This method updates the start point and height of input rectangles
     *
     * @param minHeight
     * @param previousKey
     * @param interm
     * @return
     */
    private Map<Integer, Rectangle> updateRectangles(int minHeight, int previousKey, Map<Integer, Rectangle> interm) {
        //because I a map cannot be changed inside a loop, I am using a new one to update
        Map<Integer, Rectangle> temp = new LinkedHashMap<>(interm);
        for (Rectangle r : interm.values()) {
            if (r.height == minHeight) {
                temp.values().remove(r);
                previousKey = getKey(r, interm);
            } else if (r.height > minHeight) {
                r.y = r.y + minHeight;
                r.height = r.height - minHeight;
                temp.put(getKey(r, interm), r);

                if ((getKey(r, interm) - previousKey == 1)) {
                    previousKey = getKey(r, interm);
                }
            } else {
                break;
            }
        }
        return temp;
    }

    private Integer getKey(Rectangle r, Map<Integer, Rectangle> list) {
        for (Integer key : list.keySet()) {
            if (r.equals(list.get(key))) {
                return key;
            }
        }
        return null;
    }

    private int calculateWidth(int minHeight, int previousKey, Map<Integer, Rectangle> list) {
        int width = 0;
        for (Rectangle r : list.values()) {
            if (r.height >= minHeight) {
                if ((getKey(r, list) - previousKey <= 1)) {
                    width += r.width;
                    previousKey = getKey(r, list);
                } else {
                    break;
                }
            }
        }
        return width;
    }

    private int getMinHeight(Map<Integer, Rectangle> list) {
        int min = list.values().iterator().next().height;

        for (Rectangle r : list.values()) {
            if (r.height < min) {
                min = r.height;
            }
        }
        return min;
    }

}
