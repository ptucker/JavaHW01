import org.w3c.dom.css.Rect;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {
    private ArrayList<Shape> shapes;
    private ArrayList shapeDetails = new ArrayList();

    public CSVReader() {
        shapes = new ArrayList<Shape>();

        String curdir = System.getProperty("user.dir");
        File csvFile = new File(curdir + "\\Resources\\ShapesCSV.csv");

        try (FileInputStream is = new FileInputStream(csvFile)) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                for(String p: parts){
                    // gets rid of quotes before shape kind
                    if(p.length() > 0 && p.charAt(0)== '"')
                        shapeDetails.add(p.substring(1,p.length()-1));
                    //gets rid of spaces before shape detail integers
                    else if (p.length() > 0 && p.charAt(0)== ' ')
                        shapeDetails.add(p.substring(1,p.length()));
                    // gets rid of spaces and quotes before colors
                    else if (p.length() > 0 && p.charAt(1)== '"')
                        shapeDetails.add(p.substring(2,p.length()-1));
                    else if (p.length() > 0)
                        shapeDetails.add(p);
                }

                line = rdr.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

            this.fillShapes();



    }

    public void fillShapes()  {
        Shape shape;
        for (int i = 0; i < shapeDetails.size(); i++) {
            if (shapeDetails.get(i).equals("circle")) {
                shape = new Circle(Integer.parseInt(shapeDetails.get(i + 1).toString()), Integer.parseInt(shapeDetails.get(i + 2).toString()), shapeDetails.get(i + 3).toString());
                shapes.add(shape);
            } else if (shapeDetails.get(i).toString().equals("square")) {
                shape = new Square(Integer.parseInt(shapeDetails.get(i + 1).toString()), Integer.parseInt(shapeDetails.get(i + 2).toString()), shapeDetails.get(i + 3).toString());
                shapes.add(shape);
            } else if (shapeDetails.get(i).toString().equals("triangle")) {
                shape = new Triangle(Integer.parseInt(shapeDetails.get(i + 1).toString()), Integer.parseInt(shapeDetails.get(i + 2).toString()), Integer.parseInt(shapeDetails.get(i + 3).toString()), Integer.parseInt(shapeDetails.get(i + 4).toString()), shapeDetails.get(i + 5).toString());
                shapes.add(shape);
            } else if (shapeDetails.get(i).toString().equals("rectangle")) {
                shape = new Rectangle(Integer.parseInt(shapeDetails.get(i + 1).toString()), Integer.parseInt(shapeDetails.get(i + 2).toString()), Integer.parseInt(shapeDetails.get(i + 3).toString()), shapeDetails.get(i + 4).toString());
                shapes.add(shape);
            }

        }
    }

    public static void main(String[] args) {
        CSVReader shapeData = new CSVReader();
        shapeData.displayShapes();
    }

    public void displayShapes() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).getDetailString());
        }

    }

    public int getShapeArraySize(){
        return shapes.size();
    }

    public Shape getShape(int i){
        return shapes.get(i);
    }
}



