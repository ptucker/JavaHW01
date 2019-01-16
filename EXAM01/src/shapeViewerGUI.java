import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * class encapsulates all gui components necessary to display shapes
 */
public class shapeViewerGUI implements ListSelectionListener {
    private JFrame frame;
    private JPanel backgroundPanel;
    private JPanel detailsPanel;
    private JPanel shapeSelectionPanel;
    private JPanel picturePanel;
    private JTextPane shapeDetailsTextPane;
    private JLabel shapePictureLabel;
    private JList shapesList;
    private DefaultListModel listModel;
    private JScrollPane listScroller;
    private CSVReader shapeData = new CSVReader();
    private ImageIcon squareIcon;
    private ImageIcon circleIcon;
    private ImageIcon rectangleIcon;
    private ImageIcon triangleIcon;

    // no-arg constructor that initializes the GUIa
    public shapeViewerGUI(){
        Init();
    }

    // initializes the GUI
    private void Init() {
        //create new frame
        frame = new JFrame();
        frame.setSize(800,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a new list with values taken from shapes toString function
        listModel = new DefaultListModel();
        for (int i =0; i< shapeData.getShapeArraySize();i++){
           listModel.addElement(shapeData.getShape(i).toString());
        }
        shapesList = new JList(listModel);

        // setup newly populated textPane with desired properties
        shapesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        shapesList.setLayoutOrientation(JList.VERTICAL);
        shapesList.setVisibleRowCount(25);
        shapeDetailsTextPane.setSize(new Dimension(200,400));
        shapeDetailsTextPane.setFont(new Font("Segoe UI", 0, 18));
        shapesList.setSelectedIndex(0);


        // add a scrollbar to the list
        listScroller = new JScrollPane(shapesList);
        shapeSelectionPanel.add(listScroller);

        //adds a listener to the list
        shapesList.addListSelectionListener(this);

        // set up the different shape icons
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //String currentDir = System.getProperty("user.dir");
        //System.out.println("Current dir using System:" +currentDir);

        URL squareURL = null;
        try {
            squareURL = new URL("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiMscOVhvPfAhXmilQKHbPaAB8QjRx6BAgBEAU&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FFile%3ASki_trail_rating_symbol-blue_square.svg&psig=AOvVaw3Z4zbwdyFEQsTYNP7ptoUJ&ust=1547753749122489");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image squareImg = toolkit.getImage(squareURL);
       squareIcon = new ImageIcon(squareImg);


        //URL circleURL = getClass().getResource("resources/circle.png");

        URL circleURL = null;
        try {
            circleURL = new URL("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwibqP_ZhvPfAhWT11QKHf22A4sQjRx6BAgBEAU&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FCircle_packing_in_a_circle&psig=AOvVaw1XGhbEDVg-bT1_84CnbSYN&ust=1547753891438758");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image circleImg;
        circleImg = toolkit.getImage(circleURL);
        circleIcon = new ImageIcon(circleImg);



        URL rectangleURL = null;
        try {
            rectangleURL = new URL("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjXkd-Rh_PfAhVDwcQHHYJ8CJMQjRx6BAgBEAU&url=https%3A%2F%2Fwww.khanacademy.org%2Fmath%2Fbasic-geo%2Fbasic-geo-area-and-perimeter%2Farea-formula-intuition%2Fa%2Farea-rectangles-review&psig=AOvVaw0BiMMXE4l1_LX-aBWXKr2f&ust=1547754008784669");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //URL rectangleURL = getClass().getResource("resources/rectangle.png");
        Image rectangleImg = toolkit.getImage(rectangleURL);
        rectangleIcon = new ImageIcon(rectangleImg);


        URL triangleURL = null;
        try {
            triangleURL = new URL("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjs2bLBh_PfAhVJy1QKHf6oD_EQjRx6BAgBEAU&url=https%3A%2F%2Fen.wiktionary.org%2Fwiki%2Fpink_triangle&psig=AOvVaw2ymk5qov6_KQU8-4a7gGSX&ust=1547754095550641");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //URL triangleURL = getClass().getResource("resources/triangle.png");
        Image triangleImg = toolkit.getImage(triangleURL);
        triangleIcon = new ImageIcon(triangleImg);



        shapePictureLabel.setIcon(circleIcon);

        updateShapeInfo(0);
        //img = img.getScaledInstance(100,100,Image.SCALE_SMOOTH)


        //shapePictureLabel.setIcon();





        // adding the main panel to the frame and setting frame to visible
        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

    /* doesn't work because url is not defined :(
    public ImageIcon URLtoIconImage(URL url){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage(url);
        img = img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);
        return icon;
    }
    */

    // defined a main in order to create a new GUI object and test it
    public static void main(String[] args){
        shapeViewerGUI test = new shapeViewerGUI();
    }


    // overloads valueChanged so when a new selection is made it updates shape information
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            updateShapeInfo(shapesList.getSelectedIndex());
        }


    }


     // this function takes in the index of selected item on the list and uses that index to
     // lookup the corresponding shape in the shapes array. I was able to do this because the way I added the shapes
     // to the array was in the same order that the items are displayed in the list
     // along with changing the shape details text, this function also updates the shape's image
    public void updateShapeInfo(int index){
        // used to test shape selection
        // System.out.println(index);


        // couldnt get picture to show up properly
        JLabel picture = new JLabel();
        shapeDetailsTextPane.setText(shapeData.getShape(index).getDetailString());
        Shape selectedShape = shapeData.getShape(index);
        if (selectedShape instanceof Circle)
            picture.setIcon(circleIcon);
        else if (selectedShape instanceof Square)
            picture.setIcon(squareIcon);
        else if (selectedShape instanceof Triangle)
            picture.setIcon(triangleIcon);
        else if (selectedShape instanceof Rectangle)
            picture.setIcon(rectangleIcon);
        picture.setText(" ");
        shapePictureLabel.revalidate();
        shapePictureLabel.repaint();

        picturePanel.add(picture);
    }
}
