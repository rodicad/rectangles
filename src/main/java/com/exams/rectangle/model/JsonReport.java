package com.exams.rectangle.model;

import java.awt.*;
import java.util.List;

/**
 * Created by rodicad on 18/09/2017.
 */
public class JsonReport {

    private int numRects;
    private List<Rectangle> sourceRectangles;
    private List<Rectangle> rectangles;

    public JsonReport(int numRects, List<Rectangle> sourceRectangles, List<Rectangle> rectangles ) {
        this.sourceRectangles = sourceRectangles;
        this.numRects = numRects;
        this.rectangles = rectangles;
    }

    public int getNumRects() {
        return numRects;
    }

    public List<Rectangle> getSourceRectangles() {
        return sourceRectangles;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setNumRects( int numRects ) {
        this.numRects = numRects;
    }

    public void setSourceRectangles( List<Rectangle> sourceRectangles ) {
        this.sourceRectangles = sourceRectangles;
    }

    public void setRectangles( List<Rectangle> rectangles ) {
        this.rectangles = rectangles;
    }
}
