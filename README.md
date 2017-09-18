# rectangles problem:
Given n rectangles (where n >= 5), generate adjacent vertical rectangles of random width and
height. The collection of rectangles should form an overall ‘skyline’ shape as indicated below.
Please make sure to use a top-left origin coordinate system
The solution must then run an algorithm on the generated shape and regenerate the exact outline
shape using the minimum number of horizontal rectangles (example diagram on next page). The
output of the program should be a JSON file that adheres to the following structure:
```
{
"numRects" : 5,
"sourceRectangles":[
{ "x": 0, "y": 150, "width" : 50, "height": 100},
{ "x": 50, "y": 150, "width" : 40, "height": 87},
{ "x": 90, "y": 150, "width" : 70, "height": 66},
{ "x": 160, "y": 150, "width" : 45, "height": 146},
{ "x": 205, "y": 150, "width" : 30, "height": 54}
],
"rectangles" : [
{ "x": 0, "y": 150, "width" : 235, "height": 54},
{ "x": 0, "y": 96, "width" : 205, "height": 12},
{ "x": 0, "y": 84, "width" : 90, "height": 21},
{ "x": 0, "y": 63, "width" : 50, "height": 13},
{ "x": 160, "y": 84, "width" : 45, "height": 80}
]
}
```
Instructions to run:

 Parameters:
 -number of rectangles desired, should be an integer between 5 and 20: -DnumRects
 
 Main class:
 RectanglesApp.java 
 
 JSON OUtput file:
 output\rectangles.json
 
 
