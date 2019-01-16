/**
 * this class encapsulates all members and methods for the rectangle class which implements shape
 */

public class Rectangle implements Shape {
    private int ID;
    private int length;
    private int width;
    private String color;
    private double area;
    private double perimeter;

    public Rectangle(){
        ID = -999;
        length = 0;
        width = 0;
        color = "Black";
    }

    public Rectangle(int id, int l, int w, String col){
        ID = id;
        length = l;
        width = w;
        color = col;
        area = l*w;
        perimeter = (2*l)+(2*w);
    }
    // overloads the toString function to get the shapes kind and ID
    public String toString(){
        return this.getKind() + "(ID# " + this.getID() + ")";
    }

    // implements the getKind function from shape interface which retrieves the class name
    // and returns the string of the name without the word "class" first
    @Override
    public String getKind() {
        String classKind = this.getClass().toString();
        return classKind.substring(6,classKind.length());
    }
    // implements the getDetailString from the shape interface
    // this returns a nicely formatted string with all the shapes details
    @Override
    public String getDetailString() {
        return  this.toString() + "\n" +
                "Color: " + this.color + "\n" +
                "Length: " + this.length + "\n" +
                "Width: " + this.width + "\n" +
                "Area: " + this.area + "\n" +
                "Perimeter: " + this.perimeter;

    }
    //implements the getID function from Shape to return the shapes ID#
    @Override
    public int getID() {
        return ID;
    }
}
