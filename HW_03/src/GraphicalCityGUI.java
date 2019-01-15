import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import static javax.swing.JOptionPane.*;


/**
 * Class that holds all members and methods of a GUI for a city containing a city hall and a school
 */
public class GraphicalCityGUI implements ActionListener, MouseMotionListener, MouseInputListener {
    JFrame frame;
    Point diffDrag;
    private ArrayList<JLabel> GUIlabels = new ArrayList<JLabel>();
    private JLabel[] labels;
    private JPanel createTeacherPanel;
    private JPanel backgroundPanel;
    private JLabel createTeacherLabel;
    private JTextField teacherNameTextField;
    private JTextField teacherAgeTextField;
    private JTextField gradeTextField;
    private JComboBox certificationOptionsComboBox;
    private JButton createTeacherButton;
    private JPanel createPolicePanel;
    private JLabel createPoliceLabel;
    private JPanel createKidPanel;
    private JLabel createKidLabel;
    private JPanel personGeneratorPanel;
    private JTextField kidNameTextField;
    private JTextField kidAgeTextField;
    private JTextField kidCandyTextField;
    private JButton createKidButton;
    private JTextField policeNameTextField;
    private JTextField policeAgeTextField;
    private JLabel certificationLabel;
    private JLabel policeRoleLabel;
    private JComboBox policeRoleComboBox;
    private JButton createPoliceButton;
    private JPanel MainWindowPanel;
    private JPanel cityHallPanel;
    private JPanel schoolPanel;
    private JPanel mainCityPanel;
    private JPanel buttonsPanel;
    private JButton autoGeneratePeopleButton;
    private JButton cityHallStatsButton;
    private JButton schoolStatsButton;
    private JButton lastPersonStatsButton;
    private JLabel cityHallIcon = new JLabel();
    private JLabel schoolIcon = new JLabel();
    private Person lastPerson;
    private JLayeredPane CityLayeredPane;

    private City Spokane = new City();

    /**
     * makes a city GUI object to display the program
     */
    public GraphicalCityGUI(){
        Initialize();

    }

    /**
     * initializes the frame with all of its components necessary to run the GUI
     */
    private void Initialize(){
        frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CityLayeredPane = new JLayeredPane();
        CityLayeredPane.setVisible(true);
        CityLayeredPane.setPreferredSize(new Dimension(1000,680));
        CityLayeredPane.addMouseMotionListener(this);
        CityLayeredPane.addMouseListener(this);

        //CityLayeredPane.setSize(new Dimension(mainCityPanel.getWidth(),mainCityPanel.getHeight()));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // sets the background city image
        //JLabel CityBackground = new JLabel();
        URL CityURL= getClass().getResource("resources/cityBackground.jpg");
        Image city = toolkit.getImage(CityURL);
        city = city.getScaledInstance(900,680,Image.SCALE_SMOOTH);
        ImageIcon cityIcon = new ImageIcon(city);
        JLabel CityBackground = new JLabel(cityIcon);
        CityBackground.setBounds(150,0,900,680);
        CityLayeredPane.add(CityBackground, new Integer(-9999));

        // gets image for city hall

        URL cityHallURL = getClass().getResource("/resources/CityHall.jpg");
        Image img1 = toolkit.getImage(cityHallURL);
        img1 = img1.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon icon1 = new ImageIcon(img1);
        this.cityHallIcon.setIcon(icon1);
        this.cityHallIcon.setBounds(850,300,icon1.getIconWidth(),icon1.getIconHeight());
        CityLayeredPane.add(this.cityHallIcon, new Integer(0));

        // gets image for school
        URL SchoolURL = getClass().getResource("/resources/School.jpg");
        Image img2 = toolkit.getImage(SchoolURL);
        img2 = img2.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(img2);
        this.schoolIcon.setIcon(icon2);
        this.schoolIcon.setBounds(180,300,icon2.getIconWidth(),icon2.getIconHeight());
        CityLayeredPane.add(this.schoolIcon,new Integer(0));


        mainCityPanel.add(CityLayeredPane);
        frame.add(backgroundPanel);
        frame.setVisible(true);


        // overloads focus adapter to select all text when user clicks on text box
       FocusAdapter focus = new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                if (e.getSource() == teacherNameTextField)
                    teacherNameTextField.selectAll();
                else if (e.getSource() == teacherAgeTextField)
                    teacherAgeTextField.selectAll();
                else if (e.getSource() == gradeTextField)
                    gradeTextField.selectAll();
                else if (e.getSource() == policeNameTextField)
                    policeNameTextField.selectAll();
                else if (e.getSource() == policeAgeTextField)
                    policeAgeTextField.selectAll();
                else if (e.getSource() == kidNameTextField)
                    kidNameTextField.selectAll();
                else if (e.getSource() == kidAgeTextField)
                    kidAgeTextField.selectAll();
                else if (e.getSource() ==  kidCandyTextField)
                    kidCandyTextField.selectAll();
            }
        };

        // adds focus listeners for all text fields
        teacherNameTextField.addFocusListener(focus);
        teacherAgeTextField.addFocusListener(focus);
        gradeTextField.addFocusListener(focus);
        policeNameTextField.addFocusListener(focus);
        policeAgeTextField.addFocusListener(focus);
        kidNameTextField.addFocusListener(focus);
        kidAgeTextField.addFocusListener(focus);
        kidCandyTextField.addFocusListener(focus);



        // adds listeners for all buttons
        createKidButton.addActionListener(this);
        createPoliceButton.addActionListener(this);
        createTeacherButton.addActionListener(this);
        cityHallStatsButton.addActionListener(this);
        lastPersonStatsButton.addActionListener(this);
        schoolStatsButton.addActionListener(this);
    }


    // main to create a new GUI and run program
    public static void main(String[] args){
        GraphicalCityGUI g = new GraphicalCityGUI();
    }

    /**
     * this is used to perform actions when buttons are clicked
     * @param e is an event, in this case the press of a button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createKidButton) {
            try {
                Kid k = new Kid(kidNameTextField.getText(), Integer.parseInt(kidAgeTextField.getText()), kidCandyTextField.getText());
                System.out.println("New kid with name " + k.toString());
                createPersonAction(k);
            }
            catch (Exception ex) {
                System.out.println("Invalid entry. Try Again.");
            }
        }
        else if(e.getSource() == createTeacherButton){
            try{
                Teacher t = new Teacher(Integer.parseInt(gradeTextField.getText()),certificationOptionsComboBox.getSelectedItem().toString(),teacherNameTextField.getText(), Integer.parseInt(teacherAgeTextField.getText()));
                System.out.println("New teacher with name " + t.toString() );
                createPersonAction(t);
        }
            catch (Exception ex) {
                 System.out.println("Invalid entry. Try Again.");
        }
        }

        else if(e.getSource() == createPoliceButton){
            try {
                Police p = new Police(Police.policeRole.valueOf(policeRoleComboBox.getSelectedItem().toString()),policeNameTextField.getText(), Integer.parseInt(policeAgeTextField.getText()));
                System.out.println("New police with name " + p.toString());
                createPersonAction(p);
            }
            catch (Exception ex) {
                System.out.println("Invalid entry. Try Again.");
            }
        }
        else if(e.getSource() == schoolStatsButton){
            showMessageDialog(null, Spokane.getBuilding(1).getName() + "\n" + Spokane.getBuilding(1).getAddress() + "\n Everybody in the school: \n" + Spokane.getBuilding(1).getOccupants() );
        }
        else if (e.getSource() == cityHallStatsButton) {
            showMessageDialog(null, Spokane.getBuilding(0).getName() + "\n" + Spokane.getBuilding(0).getAddress() + "\n Everybody in the city hall: \n" + Spokane.getBuilding(0).getOccupants());
        }
        // Unfixed bug where person must move into or out of a building in order to become the last person selected
        else if (e.getSource() == lastPersonStatsButton){
            try {
                if (lastPerson instanceof Police) {
                    Police p = (Police)lastPerson;
                    showMessageDialog(null, lastPerson.getName() + "\nAge: " + this.lastPerson.getAge() + "\nPhone number: " + this.lastPerson.getPhoneNumber() + "\nRole: " + p.getRole().toString());
                }
                else if (lastPerson instanceof Teacher){
                    Teacher t = (Teacher)lastPerson;
                    showMessageDialog(null, lastPerson.getName() + "\nAge: " + this.lastPerson.getAge() + "\nPhone number: " + this.lastPerson.getPhoneNumber()  + "\nGrade level taught: " + t.getGradeLevel() + "\nCertification: " + t.getCertification());
                }
                else if (lastPerson instanceof Kid) {
                    Kid k = (Kid)lastPerson;
                    showMessageDialog(null, lastPerson.getName() + "\nAge: " + this.lastPerson.getAge() + "\nPhone number: " + this.lastPerson.getPhoneNumber()  + "\nFavorite candy: " + k.getFavoriteCandy());
                }
                }
            catch (Exception ex){
                System.out.println("You have not selected anyone");
            }
            }
        // Ran out of time to include the generate random people button


    }

    /**
     * This is used to be able to click and drag labels or people around the city
     * @param e is a mouse event or in this case, the mouse being dragged
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("dragging");
        JLabel label = null;
        for (int i=0; i<GUIlabels.size(); i++) {
            if (GUIlabels.get(i).getBounds().contains(e.getPoint())) {
                label = GUIlabels.get(i);
            }

        }
        if (label != null) {
            if (diffDrag == null)
                diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
            label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
            System.out.printf("moved person to <%d, %d>", e.getX() - diffDrag.x, e.getY()-diffDrag.y);
        }

    }

    /**
     * this function detects when the mouse is moved and is utilized in the mouse dragged function
     * @param e a mouse event where the mouse is moved
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        diffDrag = null;
    }

    /**
     * this function is called whenever the button is pressed to create a person
     * it gives the label an icon accordingly as well as adds them to city
     * @param p is the person that is being created
     */
    public void createPersonAction(Person p){
        Spokane.addPersonToCity(p);
        Spokane.getBuilding(2).addPersonToBuilding(p);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon PersonIcon = new ImageIcon();

        URL kidURL = getClass().getResource("/resources/child.png");
        Image kid = toolkit.getImage(kidURL);
        kid = kid.getScaledInstance(30,40,Image.SCALE_SMOOTH);

        URL policeURL = getClass().getResource("/resources/police.png");
        Image police = toolkit.getImage(policeURL);
        police = police.getScaledInstance(30,40,Image.SCALE_SMOOTH);

        URL teacherURL = getClass().getResource("/resources/teacher.png");
        Image teacher = toolkit.getImage(teacherURL);
        teacher = teacher.getScaledInstance(30,40,Image.SCALE_SMOOTH);


        if (p instanceof Kid){
            PersonIcon.setImage(kid);
        }
        else if (p instanceof Police){
            PersonIcon.setImage(police);
        }
        else if (p instanceof  Teacher){
            PersonIcon.setImage(teacher);
        }

        JLabel PersonLabel = new JLabel();
        PersonLabel.setName(p.getName());
        PersonLabel.setBackground(Color.white);
        PersonLabel.setForeground(Color.black);
        PersonLabel.setFont(new Font(PersonLabel.getName(), Font.BOLD, 12));
        PersonLabel.setIcon(PersonIcon);
        //PersonLabel.addMouseListener(this);
        GUIlabels.add(PersonLabel);
        // tried to mess with bounds so text would show persons name but failed to get it working
        PersonLabel.setBounds(500,300,60,50);
        CityLayeredPane.add(PersonLabel,new Integer(200));

        CityLayeredPane.revalidate();
        CityLayeredPane.repaint();

    }

    /**
     * This function is called whenever the mouse is released and checks to see if a person label is in a new building and updates their location accordingly
     */
    public void checkCollision(){
        Person p;
        for (int i = 0; i<GUIlabels.size(); i++){
            p = Spokane.getCitizen(GUIlabels.get(i).getName());

            // if the person is already in the city hall and they move to the school remove them from city hall and add to school, if they were in the city hall but now arent, remove them
            if (Spokane.getBuilding(0).containsPerson(p)){
                if (schoolIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())){
                    Spokane.getBuilding(1).addPersonToBuilding(p);
                    Spokane.getBuilding(0).removePersonFromBuilding(p);
                    lastPerson = p;
                }

                else if (!cityHallIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())) {
                    Spokane.getBuilding(0).removePersonFromBuilding(p);
                    Spokane.getBuilding(2).addPersonToBuilding(p);
                    lastPerson = p;
                }
            }

            // if the person is already in school but leaves to the city hall remove from school and add to city hall, if they were in school and now are not, remove them to school and add to city
            else if (Spokane.getBuilding(1).containsPerson(p)){
                if (cityHallIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())){
                    if (p instanceof Police || p instanceof Teacher) {
                        Spokane.getBuilding(0).addPersonToBuilding(p);
                        Spokane.getBuilding(1).removePersonFromBuilding(p);
                        lastPerson = p;
                    }
                    else{
                        System.out.println("You have to be a tax-payer to get into city hall!");
                        GUIlabels.get(i).setLocation(450,300);
                        lastPerson = p;
                    }
                }
                else if (!schoolIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())) {
                    Spokane.getBuilding(1).removePersonFromBuilding(p);
                    Spokane.getBuilding(2).addPersonToBuilding(p);
                    lastPerson = p;
                }
            }

            // if the person was in the city but now is not, check if they are now in the school or the city hall and update accordingly
            else if (Spokane.getBuilding(2).containsPerson(p)){
                if (cityHallIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())){
                    if (p instanceof Police || p instanceof Teacher) {
                        Spokane.getBuilding(0).addPersonToBuilding(p);
                        Spokane.getBuilding(2).removePersonFromBuilding(p);
                        lastPerson = p;
                    }
                    else{
                        System.out.println("You have to be a tax-payer to get into city hall!");
                        GUIlabels.get(i).setLocation(450,300);
                        lastPerson = p;
                    }
                }
                else if (schoolIcon.getBounds().contains(GUIlabels.get(i).getX(),GUIlabels.get(i).getY())) {
                    Spokane.getBuilding(2).removePersonFromBuilding(p);
                    Spokane.getBuilding(1).addPersonToBuilding(p);
                    lastPerson = p;
                }
            }
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * This function checks when the mouse is releases and checks for collision each time
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        checkCollision();

        /*
        for (int i=0;i <GUIlabels.size();i++){
            if (GUIlabels.get(i).getBounds().contains(MouseInfo.getPointerInfo().getLocation().getX(),MouseInfo.getPointerInfo().getLocation().getY())){
                lastPerson = Spokane.getCitizen(GUIlabels.get(i).getName());
            }
        }
        */
       // lastPerson = p;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
