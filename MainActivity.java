package com.example.android.croatiaquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.croatiaquiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {

        /*Checkbox question 1 - Answer : Zagreb*/
        RadioButton answerZagreb = (RadioButton) findViewById(R.id.Zagreb_RadioButton);
        boolean isZagreb = answerZagreb.isChecked();

        /*Checkbox question 2 - Answer : 4*/

        EditText answerKarlovac = (EditText) findViewById(R.id.numberOfRiversKarlovac);
        String is4numberOfRiversKarlovac = answerKarlovac.getText().toString();


        /*Checkbox question 3 - 1st Answer : Stipe Mesic*/

        CheckBox selectStipeMesic = (CheckBox) findViewById(R.id.Stipe_Mesic_checkbox);
        boolean isStipeMesic = selectStipeMesic.isChecked();


    /*Checkbox question 3 - 2nd Answer : Franjo Tudman*/
        CheckBox selectFranjoTudman = (CheckBox) findViewById(R.id.Franjo_Tudman_checkbox);
        boolean isFranjoTudman = selectFranjoTudman.isChecked();


    /*Checkbox question 4 - Answer : Sava*/

        EditText answerSava = (EditText) findViewById(R.id.Sava_TextView);
        String isSava = answerSava.getText().toString();

    /*Radio button group question 5 - Answer : The Elysee Palace */

        RadioButton answerEurope = (RadioButton) findViewById(R.id.Europe_RadioButton);
        boolean isEurope = answerEurope.isChecked();


        /*Calcul du score*/
        int score = calculateScore(isStipeMesic,isFranjoTudman,isSava,is4numberOfRiversKarlovac,isEurope,isZagreb);
        String scoreMessage = createQuizSummary(score, isStipeMesic, isFranjoTudman,isSava,is4numberOfRiversKarlovac,isEurope,isZagreb);
        displayMessage(scoreMessage);

        Toast.makeText(this, "Your score is " + score + " out of 5 !",Toast.LENGTH_SHORT).show();
        return;

    }

    /* This method show the score after clicking on the button
     * @param score : score calculates by the method calculateScore
     * @param answerQ1Zagreb
     * @param answerQ3StipeMesic
     * @param answerQ24numberOfRiversKarlovac
     * @param answerQ3FranjoTudman
     * @param answerQ4Sava
     * @param answerQ5Europe*/
    public String createQuizSummary(int score, boolean answerQ3StipeMesic, boolean answerQ3FranjoTudman,String answerQ4Sava, String answerQ24numberOfRiversKarlovac, boolean answerQ5Europe, boolean answerQ1Zagreb) {

        String scoreMessage = "Try the quiz";

        if(score == 5) {
            scoreMessage = "Congrats! You know perfectly Croatia! (" + score +" out of 5)";
        } else if (score ==4 || score ==3){
            scoreMessage = "Almost perfect, try it one more time! (" + score +" out of 5)";
        } else if (score < 3 && score >=1){
            scoreMessage = "You can do better! (" + score +" out of 5)";
        }
        else {scoreMessage = "Try the quiz";
        }

        return scoreMessage;


                    /*String scoreMessage = "Your score is " + score + " out of 5 !";
        return scoreMessage;*/

    }

    /* This method is called for calculating the score */
    private int calculateScore(boolean isStipeMesic, boolean isFranjoTudman, String isSava, String is4numberOfRiversKarlovac, boolean isEurope, boolean isZagreb) {
        int basescore = 0;
        if (isStipeMesic && isFranjoTudman) {
            basescore = basescore + 1;
        }
        if (isSava.contains("SAVA")){
            basescore = basescore + 1;
        }
        if (is4numberOfRiversKarlovac.equals("4")){
            basescore = basescore + 1;
        }
        if (isEurope){
            basescore = basescore + 1;
        }
        if (isZagreb){
            basescore = basescore + 1;
        }

        return basescore;
    }

    /*
     This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ScoreSummaryTextView = (TextView) findViewById(R.id.totalAnswers);
        ScoreSummaryTextView.setText(message);
    }

}
