package com.example.pedronunovilhena.dowtown80;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Quizz extends Activity {
    public int answer_number=1;
    public int player_number=1;

    Player Player1 = new Player();
    Player Player2 =new Player();
    Player Player3 =new Player();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        Start_Questions();
    }

    public void Start_Questions (){
            // fix, o fogg e o passepartout
            //set the question text from current question
            String question = "Qual das seguintes personagens gosta mais ?";
            TextView qText = (TextView) findViewById(R.id.question);
            qText.setText(question);

            TextView option1 = (TextView) findViewById(R.id.answer1);
            option1.setText("Fix");

            TextView option2 = (TextView) findViewById(R.id.answer2);
            option2.setText("Fogg");

            TextView option3 = (TextView) findViewById(R.id.answer3);
            option3.setText("Passepartout");
    }

    public void getSelectedAnswer(View v){
        int answer=getTextAnswer();

        //Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        if(answer==1){
            switch (player_number) {
                case 1:
                    Player1.Fix++;
                    break;
                case 2:
                    Player1.Fogg++;
                    break;
                case 3:
                    Player1.Passepartout++;
                    break;
            }
        }
        else if(answer==2) {
            switch (player_number) {
                case 1:
                    Player2.Fix++;
                    break;
                case 2:
                    Player2.Fogg++;
                    break;
                case 3:
                    Player2.Passepartout++;
                    break;
            }
        }
        else if(answer==3){
                switch (player_number) {
                    case 1:
                        Player3.Fix++;
                        break;
                    case 2:
                        Player3.Fogg++;
                        break;
                    case 3:
                        Player3.Passepartout++;
                        break;
                }

        }
        // Se é o ultimo jogador mostra os resultados, se não passa ao next player
         if(answer_number==3){
            if(player_number==3){

                showQuizzResults();
            }

            else{
                Toast.makeText(getApplicationContext(), "Next Player", Toast.LENGTH_SHORT).show();
                player_number++;
                answer_number=1;
            }

        }
        else{
             answer_number++;
         }
        Start_Questions();

    }


    public void showQuizzResults(){
        //setContentView(R.layout.answers_quizz);
        //setContentView(R.layout.fragment_etapa_0);
        Toast.makeText(getApplicationContext(), "Acabou", Toast.LENGTH_SHORT).show();
    }

    public int getTextAnswer() { // c1= Fix / C2= Forg / c3= Passepartout
        RadioButton c1 = (RadioButton)findViewById(R.id.answer1);
        RadioButton c2 = (RadioButton)findViewById(R.id.answer2);
        RadioButton c3 = (RadioButton)findViewById(R.id.answer3);

        if (c1.isChecked())
        {

            return 1;
        }
        if (c2.isChecked())
        {
            return 2;
        }
        if (c3.isChecked())
        {
            return 3;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quizz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
