import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;

/**
 * this class will be able to roll a dice on its own thread
 */
public class DiceRoll implements Runnable {
   private JLabel _label;
   private ImageIcon dieFace1;
    private ImageIcon dieFace2;
    private ImageIcon dieFace3;
    private ImageIcon dieFace4;
    private ImageIcon dieFace5;
    private ImageIcon dieFace6;
    private int diceValue;

    /**
     * DiceRoll constructor that takes in a JLabel
     * @param label of type JLabel
     */
   public DiceRoll(JLabel label){
       init(label);
   }

    /**
     * setter for the dice value
     * @param n integer value
     */
   public void setDiceValue(int n){
       diceValue = n;
   }

    /**
     * this gets the current value of the dice
     * @return dicevalue of type int
     */
   public int getDiceValue(){
       return diceValue;
   }

    /**
     * this initializes the class and is used in the constructor
     * @param label is the label you want to create the class with
     */
   private void init(JLabel label) {
       _label = label;

       // get all of the die face image icons
       Toolkit toolkit = Toolkit.getDefaultToolkit();
       URL dice1URL = getClass().getResource("/resources/die_face_1.png");
       Image die1 = toolkit.getImage(dice1URL);
       die1 = die1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace1 = new ImageIcon(die1);

       URL dice2URL = getClass().getResource("/resources/die_face_2.png");
       Image die2 = toolkit.getImage(dice2URL);
       die2 = die2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace2 = new ImageIcon(die2);

       URL dice3URL = getClass().getResource("/resources/die_face_3.png");
       Image die3 = toolkit.getImage(dice3URL);
       die3 = die3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace3 = new ImageIcon(die3);

       URL dice4URL = getClass().getResource("/resources/die_face_4.png");
       Image die4 = toolkit.getImage(dice4URL);
       die4 = die4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace4 = new ImageIcon(die4);

       URL dice5URL = getClass().getResource("/resources/die_face_5.png");
       Image die5 = toolkit.getImage(dice5URL);
       die5 = die5.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace5 = new ImageIcon(die5);

       URL dice6URL = getClass().getResource("/resources/die_face_6.png");
       Image die6 = toolkit.getImage(dice6URL);
       die6 = die6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
       dieFace6 = new ImageIcon(die6);
   }

    /**
     * this gives DiceRoll a runnable function needed to make it a thread
     */
    @Override
    public void run() {
        Random rnd = new Random();
        for (int i =8; i >=0; i--){
            int n = rnd.nextInt(6)+1;
            switch (n){
                case 1: _label.setIcon(dieFace1);
                        setDiceValue(1);
                        break;
                case 2: _label.setIcon(dieFace2);
                        setDiceValue(2);
                        break;
                case 3: _label.setIcon(dieFace3);
                        setDiceValue(3);
                        break;
                case 4: _label.setIcon(dieFace4);
                        setDiceValue(4);
                        break;
                case 5: _label.setIcon(dieFace5);
                        setDiceValue(5);
                        break;
                case 6: _label.setIcon(dieFace6);
                    setDiceValue(6);
                    break;
                default: break;
            }
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException ex){;}

        }
    }
}
