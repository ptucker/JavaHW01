package edu.whitworth.yahtzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


/**
 * main activity for application
 */
public class MainActivity extends AppCompatActivity {


    private int amountDice = 5;
    private int diceValue = 0;
    private ImageView diceImage1,diceImage2,diceImage3,diceImage4,diceImage5;

    public static final Random rnd = new Random();
    private Button rollDie;

    Thread[] diceThreads;
    diceRoll[] diceMoveArray;
    ImageView[] dices;
    Thread outputImages;
    TextView scoreOut;

    /**
     * on application startup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDie = (Button) findViewById(R.id.rollDie);
        diceImage1 = (ImageView) findViewByID(R.id.diceImage1);
        diceImage2 = (ImageView) findViewByID(R.id.diceImage2);
        diceImage3 = (ImageView) findViewByID(R.id.diceImage3);
        diceImage4 = (ImageView) findViewByID(R.id.diceImage4);
        diceImage5 = (ImageView) findViewByID(R.id.diceImage5);

        scoreOut = findViewById(R.id.scoreText);



        rollDie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diceSetup();
                for(int i = 0; i < amountDice; i++){
                    diceThreads[i].start();
                }
                outputImages.start();
            }
        });
    }

    /**
     * initializes the die and die threads
     */
    private void diceSetup(){
        outputImages = new Thread(this::outputImages);
        diceMoveArray = new diceRoll[amountDice];
        diceMoveArray[0] = new diceRoll();
        diceMoveArray[1] = new diceRoll();
        diceMoveArray[2] = new diceRoll();
        diceMoveArray[3] = new diceRoll();
        diceMoveArray[4] = new diceRoll();

        dices = new ImageView[amountDice];
        dices[0] = dice1;
        dices[1] = dice2;
        dices[2] = dice3;
        dices[3] = dice4;
        dices[4] = dice5;

        diceThreads = new Thread[amountDice];
        for (int i = 0;i < amountDice; i++){
            diceThreads[i] = new Thread(diceMoveArray[i]);
        }
    }

    private void outputImages(){
        try{
            Thread.sleep(100);
        }
        catch (Exception e){
        }
        diceValue = 0;
        for(int i = 0; i < diceAmount; i++){
            setImage(dices[i], diceMoveArray[i].getFaceValue());
            diceValue += diceMoveArray[i].getFaceValue();
        }
        scoreOut.setText("" + diceValue);
    }

    private void setImage(ImageView img, int faceValue){
        switch (faceValue){
            case 1:
                img.setImageResource(R.drawable.die_face_1);
                break;
            case 2:
                img.setImageResource(R.drawable.die_face_2);
                break;
            case 3:
                img.setImageResource(R.drawable.die_face_3);
                break;
            case 4:
                img.setImageResource(R.drawable.die_face_4);
                break;
            case 5:
                img.setImageResource(R.drawable.die_face_5);
                break;
            case 6:
                img.setImageResource(R.drawable.die_face_6);
                break;
            default:
                System.out.println("Error");
                break;
        }

    }




}
