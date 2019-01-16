/**
 * this class encapsulates all members and methods for the triangle class which implements shape
 */
public class Triangle implements Shape {
   private int ID;
   private int side1;
   private int side2;
   private int side3;
   private String color;
   private double s;
   private double area;
   private double perimeter;

   // default no arg constructor
    public Triangle(){
        ID = -999;
        side1 = 0;
        side2 = 0;
        side3 = 0;
        color = "Black";
    }

    // constructor that passes in shape details
    public Triangle(int id, int s1, int s2, int s3,String col) {
            ID = id;
            side1 = s1;
            side2 = s2;
            side3 = s3;
            color = col;
            // used herons formula to calculate area, which yields 0 sometimes?
            s = (s1 + s2 + s3) / 2;
            area = Math.sqrt((s * (s - s1) * (s - s2) * (s - s3)));
            perimeter = s1 + s2 + s3;
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
    // this also has a check to make sure that the triangle is not impossible
    @Override
    public String getDetailString() {
        // bug where area can equal 0 even if triangle is valid
        // TODO fix area
        String Area;
        if (area >= 0){
            // if triangle is valid make area only record first two decimals
            Area = String.format("%.2f", area);
        }
        else
            Area = "Illegal Triangle";
        return  this.toString() + "\n" +
                "Color: " + this.color + "\n" +
                "Side 1: " + this.side1 + "\n" +
                "Side 2: " + this.side2 + "\n" +
                "Side 3: " + this.side3 + "\n" +
                "Area: " + Area + "\n" +
                "Perimeter: " + this.perimeter;
    }

    //implements the getID function from Shape to return the shapes ID#
    @Override
    public int getID() {
        return ID;
    }
}
