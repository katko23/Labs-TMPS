package Prototype;

abstract class Shape{
    int x ;
    int y ;
    String color;

    Shape(){};

    Shape(Shape tempShape){
        this();
        this.x = tempShape.x;
        this.y = tempShape.y;
        this.color = tempShape.color;
    }



    public abstract Shape clone();
}

class Rectangle extends Shape{
    int width;
    int length;

    Rectangle(Rectangle rtemp){
        width = rtemp.length;
        length = rtemp.width;
    }

    public Rectangle(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }



    public Shape clone(){
        return new Rectangle(this);
    }
}

class Circle extends Shape{
    int radius;

    public Circle(Circle ctemp){
        super(ctemp);
        this.radius = ctemp.radius;
    }

    public Circle(int x,int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public Shape clone(){
        return new Circle(this);
    }
}
