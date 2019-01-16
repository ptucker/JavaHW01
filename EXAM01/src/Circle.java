
/**
 * this class encapsulates all members and methods for the Circle class which implements shape
 */
public class Circle implements Shape {
    private int ID;
    private int radius;
    private String color;
    private double area;
    private double perimeter;
    private static final double pi = 3.14;

    public Circle(){
        ID = -999;
        radius = 0;
        color = "Black";
    }

    public Circle(int id,int rad,String col){
        ID = id;
        radius = rad;
        color = col;
        area = pi*(rad*rad);
        perimeter = 2*pi*rad;
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
        // set perimeter to only take two decimals
        String Perimeter;
        Perimeter = String.format("%.2f",perimeter);
        return  this.toString() + "\n" +
                "Color: " + this.color + "\n" +
                "Radius: " + this.radius + "\n" +
                "Area: " + this.area + "\n" +
                "Perimeter: " + Perimeter;
    }
    //implements the getID function from Shape to return the shapes ID#
    @Override
    public int getID() {
        return ID;
    }
}
