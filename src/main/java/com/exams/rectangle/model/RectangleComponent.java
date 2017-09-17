package com.exams.rectangle.model;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/*
   A component that draws two rectangles.
*/
public class RectangleComponent extends JComponent
{
    private Map<Integer,Rectangle> rectangles;

    public RectangleComponent(Map<Integer,Rectangle> rectangles){
        this.rectangles = rectangles;

    }


//    private void generatehorizontals( List<Rectangle> rects) {
//        horizontals = new ArrayList<>(  );
//        List<Rectangle> remainingRectangles = new ArrayList<>( rects );
//        //function to etract max height : expectedHeight = max height
//        Rectangle hor1 = new Rectangle(  rects.get( 0 ).x,  rects.get( 0 ).y, getMaxX(rects)+ rects.get( 4 ).width, getMinHeight( rects ) );
//        printRectInfo(hor1);
//        Rectangle prevHor = hor1;
//        int currHeight = hor1.height;
//       // remainingRectangles.remove(  com.exams.rectangle with minum height)
//        while (remainingRectangles.size() > 0) {
//            Rectangle box = remainingRectangles.get( 0 );
//
//            System.out.println("Testing com.exams.rectangle with width: "+box.width+" and height="+box.height);
//            if (currHeight < getMaxHeight( rects )  && box.height > currHeight ) {
//                Rectangle hor = new Rectangle(  );
//                //establish x
//                hor.x = prevHor.x;
//
//                //establish y
//                hor.y = prevHor.y + prevHor.height;
//
//                //establish width
//                hor.width = buildWidth( currHeight, remainingRectangles );
//
//                //establish height
//                hor.height = box.height - currHeight;
//                horizontals.add( hor );
//
//                printRectInfo (hor);
//
//                ////
//
//                currHeight = currHeight +hor.height;
//
//            }
//            remainingRectangles.remove( box );
//         //   should remove box with min height?
//
//
//        }
//    }
//
//    private void printRectInfo(Rectangle r) {
//        System.out.println("The following com.exams.rectangle was generated: ");
//        System.out.println("(X="+r.x+", y="+r.y+",W="+r.width+", H="+r.height+")");
//    }
//
//
//    private int buildWidth(int currHeight, List<Rectangle> rects) {
//        int width=0;
//
//        for ( Rectangle rect: rects) {
//            if (rect.height > currHeight ) {
//                width = width+rect.width;
//            } else {
//                break;
//            }
//        }
//        return width;
//    }
//
//    private int getMinX(List<Rectangle> rects) {
//        int min = rects.get( 0 ).x;
//        for (Rectangle rect: rects) {
//            if (rect.x < min) {
//                min = rect.x;
//            }
//        }
//        return min;
//    }
//
//    private int getMinHeight(List<Rectangle> rects) {
//        int min = rects.get( 0 ).height;
//        for (Rectangle rect: rects) {
//            if (rect.height < min) {
//                min = rect.height;
//            }
//        }
//        return min;
//    }
//
//    private int getMaxHeight(List<Rectangle> rects) {
//        int max = rects.get( 0 ).height;
//        for (Rectangle rect: rects) {
//            if (rect.height > max) {
//                max = rect.height;
//            }
//        }
//        return max;
//    }
//
//    private int getMinWidth(List<Rectangle> rects) {
//        int min = rects.get( 0 ).width;
//        for (Rectangle rect: rects) {
//            if (rect.width < min) {
//                min = rect.width;
//            }
//        }
//        return min;
//    }
//
//    private int getMaxWidth(List<Rectangle> rects) {
//        int max = rects.get( 0 ).width;
//        for (Rectangle rect: rects) {
//            if (rect.width > max) {
//                max = rect.width;
//            }
//        }
//        return max;
//    }
//
//    private int getMaxX(List<Rectangle> rects) {
//        int max = rects.get( 0 ).x;
//        for (Rectangle rect: rects) {
//            if (rect.x > max) {
//                max = rect.x;
//            }
//        }
//        return max;
//    }
//
//




    public void paintComponent(Graphics g)
    {

        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        // Construct a com.exams.rectangle and draw it

//        List<Rectangle> rects = new ArrayList<>(  );
//        Rectangle box = new Rectangle(0, 150, 50, 100);
//
//        Rectangle box2=new Rectangle(50,150,40, 87);
//
//        Rectangle box3=new Rectangle(90,150,70, 66);
//
//        Rectangle box4=new Rectangle(160,150,45, 146);
//
//        Rectangle box5=new Rectangle(205,150,30, 54);
//        rects.add( box );
//        rects.add( box2 );
//
//        rects.add( box3 );
//
//        rects.add( box4 );
//
//        rects.add( box5 );
//
//
//        generatehorizontals(rects);

        for (Rectangle rectangle: rectangles.values()) {
            g2.draw( rectangle );
        }


//
//        Rectangle hor1=new Rectangle(0,150,235, 54);
//        Rectangle hor2=new Rectangle(0,204,160, 12);
//        Rectangle hor3=new Rectangle(0,216,90, 21);
//        Rectangle hor4=new Rectangle(0,237,50, 13);
//        Rectangle hor5=new Rectangle(160,84,45, 80);








//
//        g2.draw(box);
//        g2.draw(box2);
//        g2.draw(box3);
//
//        g2.draw(box4);
//
//        g2.draw(box5);

//        g2.draw(hor1);
//        g2.draw(hor2);
//        g2.draw(hor3);
//        g2.draw(hor4);
//        g2.draw(hor5);





    }
}