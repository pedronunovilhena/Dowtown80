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
    public int answer_number;
    public int player_number;

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
        String answer=getTextAnswer();
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        answer_number++;
        if(answer_number==3){
            showQuizzResults();
        }
    }

    public void showQuizzResults(){


    }

    private String getTextAnswer() {
        RadioButton c1 = (RadioButton)findViewById(R.id.answer1);
        RadioButton c2 = (RadioButton)findViewById(R.id.answer2);
        RadioButton c3 = (RadioButton)findViewById(R.id.answer3);
        if (c1.isChecked())
        {
            return c1.getText().toString();
        }
        if (c2.isChecked())
        {
            return c2.getText().toString();
        }
        if (c3.isChecked())
        {
            return c3.getText().toString();
        }

        return null;
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
