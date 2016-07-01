package com.dragonflyx.volleypoints;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declares Variables to Keep Team points

    public int Team1Points; // Holds Team1Points
    public int Team2Points; // Holds Team2Points


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Declares ImageButton variables

        ImageButton AddPointTeam1 = (ImageButton) findViewById(R.id.imgbtn_add_point_team1);
        ImageButton ReducePointTeam1 = (ImageButton) findViewById(R.id.imgbtn_reduce_point_team1);
        ImageButton AddPointTeam2 = (ImageButton) findViewById(R.id.imgbtn_add_point_team2);
        ImageButton ReducePointTeam2 = (ImageButton) findViewById(R.id.imgbtn_reduce_point_team2);

        // OnClickListeners for all the buttons

        AddPointTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScore(1,true);
                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

        ReducePointTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScore(1,false);
                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

        AddPointTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScore(2,true);
                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

        ReducePointTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScore(2,false);
                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

        // End of OnClickListeners for Buttons

    }

    // changeScore method uses inputs from buttons to change scores on layout:
    // Parameters are: int team >> 1 or 2; Boolean action >>  True-increase points, False-decrease points

    public void changeScore(int team, boolean action){
        if(team==1){
            if(action == true){
                if (Team1Points<99){Team1Points++;}
            }
            if (action== false){
                if (Team1Points>0){Team1Points--;}
            }
        }

        if(team==2){
            if(action == true){
                if (Team2Points<99){Team2Points++;}
            }
            if (action== false){
                if (Team2Points>0){Team2Points--;}
            }
        }

        updateDisplays();  // Calls function to update the displays with new points
    }

    public void updateDisplays(){

        // Declares both text views

        TextView txtViewScoreTeam1 = (TextView) findViewById(R.id.txtview_score_team1);
        TextView txtViewScoreTeam2 = (TextView) findViewById(R.id.txtview_score_team2);

        // Updates textviews with current points on each team

        txtViewScoreTeam1.setText(Integer.toString(Team1Points));
        txtViewScoreTeam2.setText(Integer.toString(Team2Points));

        // Toast.makeText(MainActivity.this, "El marcador cambió", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


