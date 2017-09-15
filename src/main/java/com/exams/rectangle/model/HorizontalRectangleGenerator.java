package com.exams.rectangle.model;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rodicad on 14/09/2017.
 */
public class HorizontalRectangleGenerator {

    public Map<Integer, Rectangle> generateOutputRectangles( Map<Integer, Rectangle> inputRectangles ) {
        Map<Integer, Rectangle> outputRectangles = new LinkedHashMap<>();
        Map<Integer, Rectangle> interm = new LinkedHashMap<>( inputRectangles );
        int minHeight = 0;
        Iterator<Integer> it = interm.keySet().iterator();

        while ( it.hasNext()) {
            int key = it.next();
            System.out.println("Testing rectangle with indexKey: "+key);


            Rectangle current = interm.get( key );
            minHeight = getMinHeight( interm );
            Rectangle newHor = new Rectangle();
            newHor.x = current.x;
            newHor.y = current.y;
            newHor.height = minHeight;
            newHor.width = calculateWidth( minHeight, interm );
            printRectInfo(newHor);
            outputRectangles.put( key, newHor );
            interm = updateRectangles( minHeight,key, interm );




            minHeight = getMinHeight( interm );
        }
        return outputRectangles;
    }

    private Map<Integer, Rectangle> updateRectangles( int minHeight,int previousKey, Map<Integer, Rectangle> interm ) {
        for ( Rectangle r : interm.values() ) {
            if ( r.height == minHeight ) {
                interm.remove( r );
            } else if ( r.height > minHeight && getKey( r, interm ) - previousKey == 1 ) {
                r.y = minHeight;
                r.height = r.height - minHeight;
            }
        }
        return interm;
    }

    private void printRectInfo(Rectangle r) {
        System.out.println("The following horizontal rectangle was generated: ");
        System.out.println("(X="+r.x+", y="+r.y+",W="+r.width+", H="+r.height+")");
    }

    private Integer getKey( Rectangle r, Map<Integer, Rectangle> list ) {
        for ( Integer key : list.keySet() ) {
            if ( r.equals( list.get( key ) ) ) {
                return key;
            }
        }
        return null;
    }

    private int calculateWidth( int minHeight, Map<Integer, Rectangle> list ) {
        int width = 0;
        for ( Rectangle r : list.values() ) {
            if ( r.height >= minHeight ) {
                width += r.width;
            }
        }
        return width;
    }

    private int getMinHeight( Map<Integer, Rectangle> list ) {
        int min = list.values().iterator().next().height;

        for ( Rectangle r : list.values() ) {
            if ( r.height < min ) {
                min = r.height;
            }
        }
        return min;
    }

}
