import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 * this class includes everything needed for the GUI to show all 5 die rolling
 */
public class YahtzeeGUI implements ActionListener {
    private JPanel backgroundPanel;
    private JPanel dicePanel;
    private JLabel dice1Label;
    private JLabel dice2Label;
    private JLabel dice3Label;
    private JLabel dice4Label;
    private JLabel dice5Label;
    private JButton rollButton;
    private JLabel totalLabel;
    private JButton button1;
    private DiceRoll[] Die;
    private Thread[] threads;
    private int total;

    JFrame frame;

    /**
     * no arg constructor
     */
    public YahtzeeGUI(){
        Initialize();
    }

    /**
     * initialization used in constructor
     */
    private void Initialize() {
        // setup the frame
        frame = new JFrame();
        frame.setSize(700,400);



        // get all of the die face image icons
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        URL dice1URL = getClass().getResource("/resources/die_face_1.png");
        Image die1 = toolkit.getImage(dice1URL);
        die1 = die1.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die1Icon = new ImageIcon(die1);

        URL dice2URL = getClass().getResource("/resources/die_face_2.png");
        Image die2 = toolkit.getImage(dice2URL);
        die2 = die2.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die2Icon = new ImageIcon(die2);

        URL dice3URL = getClass().getResource("/resources/die_face_3.png");
        Image die3 = toolkit.getImage(dice3URL);
        die3 = die3.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die3Icon = new ImageIcon(die3);

        URL dice4URL = getClass().getResource("/resources/die_face_4.png");
        Image die4 = toolkit.getImage(dice4URL);
        die4 = die4.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die4Icon = new ImageIcon(die4);

        URL dice5URL = getClass().getResource("/resources/die_face_5.png");
        Image die5 = toolkit.getImage(dice5URL);
        die5 = die5.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die5Icon = new ImageIcon(die5);

        URL dice6URL = getClass().getResource("/resources/die_face_6.png");
        Image die6 = toolkit.getImage(dice6URL);
        die6 = die6.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon die6Icon = new ImageIcon(die6);

        Die = new DiceRoll[5];


        dice1Label.setText("");
        dice2Label.setText("");
        dice3Label.setText("");
        dice4Label.setText("");
        dice5Label.setText("");

        dice1Label.setIcon(die1Icon);
        dice2Label.setIcon(die2Icon);
        dice3Label.setIcon(die3Icon);
        dice4Label.setIcon(die4Icon);
        dice5Label.setIcon(die5Icon);

        Die[0]= new DiceRoll(dice5Label);
        Die[1]= new DiceRoll(dice1Label);
        Die[2]= new DiceRoll(dice2Label);
        Die[3]= new DiceRoll(dice3Label);
        Die[4]= new DiceRoll(dice4Label);

        rollButton.addActionListener(this);

        frame.setVisible(true);
        frame.add(backgroundPanel);
    }

    //main used to test
    public static void main(String[] args) {
        YahtzeeGUI test = new YahtzeeGUI();
    }

    /**
     * used to roll the die when the button is clicked
     * @param e is the Action Event of pressing the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton){
            rollDie();
            Thread scoreThread = new Thread(this::calculateScore);
            scoreThread.start();

        }
    }

    /**
     * this function makes new threads and each one rolls a dice
     */
    public void rollDie(){
        total = 0;
        threads = new Thread[5];
        for (int i =0; i<threads.length;i++){
            threads[i] = new Thread(Die[i]);
            threads[i].start();

            try{
                Thread.sleep(100);
            }
            catch (InterruptedException ex){;}
        }


    }

    /**
     * calculates the total roll of all the die together
     */
    public void calculateScore(){
         /*
       for (int i =0; i<threads.length;i++){
            try {
                threads[i].join();
            }
            catch (InterruptedException ex) {;}
        }
        */

         // waits until all the threads have stopped to output total score
        // I received help from Levi Russell on this portion of code

        boolean allThreadsDone;
        do{
            total = 0;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            allThreadsDone = true;
            for(int i = 0; i < threads.length; i++){
                if(threads[i].getState() != Thread.State.NEW && threads[i].getState() != Thread.State.TERMINATED){
                    allThreadsDone = false;
                }
                }
            } while(!allThreadsDone);
        for (int j = 0; j < Die.length; j++) {
            total += Die[j].getDiceValue();
        }
        totalLabel.setText("Total: " + total);
        }
}
