/**
 * this class encapsulates all members and methods for the Square class which implements shape
 */
public class Square implements Shape {
    private int ID;
    private int side;
    private String color;
    private double area;
    private double perimeter;

    public Square(){
        ID = -999;
        side = 0;
        color = "Black";
    }

    public Square(int id, int s,String col){
        ID = id;
        side = s;
        color = col;
        area = s*s;
        perimeter = s*4;
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
                "Side: " + this.side + "\n" +
                "Area: " + this.area + "\n" +
                "Perimeter: " + this.perimeter;

    }
    //implements the getID function from Shape to return the shapes ID#
    @Override
    public int getID() {
        return ID;
    }
}
