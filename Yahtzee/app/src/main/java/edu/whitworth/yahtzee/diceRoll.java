package edu.whitworth.yahtzee;

import java.util.Random;


/**
 * diceRoll class to be used as a thread in the main
 */
public class diceRoll implements Runnable {
    Random rnd = new Random();
    int rndInt;


    /**
     * no arg constructor
     */
    public diceRoll(){}


    /**
     * creates thread and generates new random int
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            rndInt = rnd.nextInt(6)+1;

            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.getStackTrace();
            }

        }
    }

    /**
     * returns the random number
     * @return
     */
    public int getFaceValue(){
        return rndInt;
    }
}
