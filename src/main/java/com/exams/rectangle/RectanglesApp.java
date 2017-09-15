package com.exams.rectangle;

import com.exams.rectangle.service.RectanglesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class RectanglesApp extends JPanel {

    private static final Logger LOG = LoggerFactory.getLogger( RectanglesApp.class );



//    public static void main(String[] args) {
//
//        2. ask for number of rectangles
//        3. generate n random widtgh/height rectangles
//        4. run algorith to generate horizontal rectangles
//        5. generate json file in requested format
//
//
//
//
//        Rectangle rect1= new Rectangle( 0,150,50,100 );
//        Rectangle rect2= new Rectangle( 50,150,40,87 );
//        rect1.
//
//        // write your code here
//    }


    public static void main(String[] args)
    {
        RectanglesService rectanglesService = new RectanglesService();
        rectanglesService.runApplication();



//        Scanner sc = new Scanner(System.in);
//        int number;
//        do {
//            System.out.println("Please enter a positive number!");
//            while (!sc.hasNextInt()) {
//                System.out.println("That's not a number!");
//                sc.next(); // this is important!
//            }
//            number = sc.nextInt();
//        } while (number <= 0);
//        System.out.println("Thank you! Got " + number);
//        JFrame frame = new JFrame();
//
//        frame.setSize(300, 400);
//        frame.setTitle("Two rectangles");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        RectangleComponent component = new RectangleComponent();
//        frame.add(component);
//
//        frame.setVisible(true);
    }



}
