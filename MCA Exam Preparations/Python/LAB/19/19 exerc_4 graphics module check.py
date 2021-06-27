import graphics
from graphics import circle,rectangle
from graphics.tdgraphics import cuboid,sphere
from graphics.circle import *

print("Area of a circle with radius 10 is : ",circle.area_circle(10))
print("Permeter of a circle with radius 10 is ",circle.perimeter_circle(10))

print("Area of a circle with radius 10 is : ",area_circle(10))

print("Area of a Rectangle with length and width 10 is : ",rectangle.area_rec(10,10))
print("Permeter of a Rectangle with length and width 10 is : ",rectangle.perimeter_rec(10,10))

print("Area of a  cuboid with length,width,height 10 is : ",cuboid.area_cuboid(10,10,10))
print("Permeter of a cuboid with length,width,height 10 is : ",cuboid.perimeter_cuboid(10,10,10))

print("Area of a spere with radius 10 is : ",sphere.area_sphere(10))
print("Permeter of a spere with radius 10 is ",sphere.perimeter_sphere(10))

