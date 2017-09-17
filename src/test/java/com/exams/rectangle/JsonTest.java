package com.exams.rectangle;

import com.exams.rectangle.json.RectanglesJSONFormatter;
import com.exams.rectangle.model.HorizontalRectangleGenerator;
import com.exams.rectangle.utils.RectanglesDrawer;
import com.exams.rectangle.utils.RectanglesUtilities;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by Rodicad on 17/09/2017.
 */
public class JsonTest {




    @Test
    public  void tesjson() throws IOException, InterruptedException {

        Map<Integer,Rectangle> input2 = new LinkedHashMap<>(  );
        input2.put( 0,  new Rectangle(0,0,50,20) );
        input2.put( 1, new Rectangle(50,0,40,10) );
        input2.put( 2, new Rectangle(90,0,70,10) );
        input2.put( 3, new Rectangle(160,0,30,10) );
        input2.put( 4, new Rectangle(190,0,30,10) );

        HorizontalRectangleGenerator horizontalRectangleGenerator = new HorizontalRectangleGenerator();

        Map<Integer, Rectangle> results = horizontalRectangleGenerator.generateOutputRectangles(input2);
        RectanglesDrawer draw = new RectanglesDrawer();
        draw.drawRectangles(input2);

        draw.drawRectangles(results);
        Thread.sleep(60000);



        RectanglesJSONFormatter formatter = new RectanglesJSONFormatter();
      String json = formatter.convertToJSON(5, input2, results);

        RectanglesUtilities.writeToFile(json);







    }


//    private void testOrder() {
//        JSONArray params = new JSONArray();
//        int paramIndex = 0;
//
//        for (String currParam : mParams)
//        {
//            JSONObject paramObject = new JSONObject();
//            paramObject.put("index", paramIndex);
//            paramObject.put("value", currParam);
//
//            params.put(paramObject);
//            ++paramIndex;
//        }
//
//        json.put("orderedArray", params);
//    }


}
