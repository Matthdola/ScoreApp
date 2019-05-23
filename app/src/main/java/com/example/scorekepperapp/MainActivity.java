package com.example.scorekepperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaration of teams
    Team team1;
    Team team2;
    EditText team1EditText, team2EditText;
    LinearLayout startContainer, scoreKepperContainer;
    TextView team1Name, team2Name, team1Score, team2Score;
    final int initScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1EditText = (EditText) findViewById(R.id.team1_name_edit);
        team2EditText = (EditText) findViewById(R.id.team2_name_edit);
        startContainer = (LinearLayout) findViewById(R.id.welcome_container);
        scoreKepperContainer = (LinearLayout) findViewById(R.id.score_kepper_screen);
        team1Name = (TextView)findViewById(R.id.id_team1_name);
        team2Name = (TextView)findViewById(R.id.id_team2_name);
        team1Score = (TextView)findViewById(R.id.id_team1_score);
        team2Score  = (TextView)findViewById(R.id.id_team2_score);

        startContainer.setVisibility(View.VISIBLE);
        scoreKepperContainer.setVisibility(View.GONE);
    }

    void startGame(View v){
        String t1Name = team1EditText.getText().toString();
        String t2Name = team2EditText.getText().toString();

        if (t1Name.isEmpty() || t2Name.isEmpty()){
            Toast.makeText(this, "Please give names of the teams.", Toast.LENGTH_LONG).show();
            return;
        }
        team1 = new Team(t1Name);
        team2 = new Team(t2Name);

        startContainer.setVisibility(View.GONE);
        scoreKepperContainer.setVisibility(View.VISIBLE);

        team1Name.setText(t1Name);
        team2Name.setText(t2Name);

        clearContainers();
    }

    void clearContainers(){
        team1EditText.setText("");
        team2EditText.setText("");
    }

    void startNewGame(View view){
       initGame();
       startContainer.setVisibility(View.VISIBLE);
       scoreKepperContainer.setVisibility(View.GONE);
    }

    void reinitializeGame(View v)
    {
        initGame();
    }

    private void initGame(){
        team1Score.setText(initScore + "");
        team2Score.setText(initScore + "");
        team1.setScore(0);
        team2.setScore(0);
    }

    void incrementTeam1Score(View v)
    {
        team1.incrementScore();
        team1Score.setText(team1.getScore() + "");
    }

    void  incrementTeam2Score(View v){
        team2.incrementScore();
        team2Score.setText(team2.getScore() + "");
    }

    void quitApp(View v){
        finish();
    }
}
