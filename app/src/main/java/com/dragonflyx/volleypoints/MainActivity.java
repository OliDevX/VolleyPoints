package com.dragonflyx.volleypoints;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    /// Declares Variables to Keep Team points & Names ///

    public int Team1Points = 0; // Holds Team1Points
    public int Team2Points = 0; // Holds Team2Points

    public String Team1Name = "HOME"; // Holds Team1 Name
    public String Team2Name = "VISIT"; // Holds Team2 Name

    public int Team1TimeOuts = 0;  // Holds Team1 Used TimeOuts
    public int Team2TimeOuts = 0;  // Holds Team2 Used TimeOuts

    ////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        updateDisplays();  // Calls function to update the displays with new point

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Declares Timeout TextView and Layout variables

        TextView TextViewTimeOutTeam1 = (TextView) findViewById(R.id.textView_timeout_team1);
        TextView TextViewTimeOutTeam2 = (TextView) findViewById(R.id.textView_timeout_team2);

        LinearLayout LayoutTimeOutTeam1 = (LinearLayout) findViewById(R.id.Layout_timeout_team1);
        LinearLayout LayoutTimeOutTeam2 = (LinearLayout) findViewById(R.id.Layout_timeout_team2);

        // Sets listeners for Timeouts (for both TextViews and LinearLayouts directly above checkboxes)

        TextViewTimeOutTeam1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addTimeOut(1);
            }
        });

        TextViewTimeOutTeam2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addTimeOut(2);
            }
        });

        LayoutTimeOutTeam1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addTimeOut(1);
            }
        });

        LayoutTimeOutTeam2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addTimeOut(2);
            }
        });

        // Declares TextView variables

        TextView TextViewTeam1Name = (TextView) findViewById(R.id.txtViewTeam1Name);
        TextView TextViewTeam2Name = (TextView) findViewById(R.id.txtViewTeam2Name);

        // Sets listeners for TextViews

        TextViewTeam1Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamNameSet(1);
                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

        TextViewTeam2Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamNameSet(2);
                // Toast.makeText(MainActivity.this, "test 2", Toast.LENGTH_SHORT).show();
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

    // addTimeOut method increases the number of timeouts of the specific team by 1
    // team parameter tells the team: 1 - Team1 and 2 - Team2

    public void addTimeOut(int team){
        if (team==1){
            if (Team1TimeOuts <2){
                Team1TimeOuts++;
            }
        }
        if (team==2){
            if (Team2TimeOuts <2){
                Team2TimeOuts++;
            }
        }

        updateDisplays();  // Calls function to update the displays with new timeouts
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

    public void teamNameSet(int team){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.abc_change_teams_name);

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons depending if we are changing name of team 1 or 2
        if (team == 1) {
            builder.setPositiveButton(R.string.abc_ok_caps, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Team1Name = input.getText().toString();
                    updateDisplays();
                }
            });
        }

        if (team == 2) {
            builder.setPositiveButton(R.string.abc_ok_caps, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Team2Name = input.getText().toString();
                    updateDisplays();
                }
            });
        }

        builder.setNegativeButton(R.string.abc_cancel_caps, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    // upadteDisplays method is invoqued every time an element on the scoreboard changes
    // it updates the layout with current information of team name, score and timeouts

    public void updateDisplays(){

        // Declares both text views

        TextView txtViewTeam1Name = (TextView) findViewById(R.id.txtViewTeam1Name);
        TextView txtViewTeam2Name = (TextView) findViewById(R.id.txtViewTeam2Name);

        txtViewTeam1Name.setText(Team1Name);
        txtViewTeam2Name.setText(Team2Name);

        TextView txtViewScoreTeam1 = (TextView) findViewById(R.id.txtview_score_team1);
        TextView txtViewScoreTeam2 = (TextView) findViewById(R.id.txtview_score_team2);

        // Updates textviews with current points on each team

        txtViewScoreTeam1.setText(Integer.toString(Team1Points));
        txtViewScoreTeam2.setText(Integer.toString(Team2Points));


        // Declares Checkboxes for timeouts & checkes boxes according to current state

        CheckBox CheckBoxTeam1_1 = (CheckBox) findViewById(R.id.checkBox_1_1);
        CheckBox CheckBoxTeam1_2 = (CheckBox) findViewById(R.id.checkBox_1_2);
        CheckBox CheckBoxTeam2_1 = (CheckBox) findViewById(R.id.checkBox_2_1);
        CheckBox CheckBoxTeam2_2 = (CheckBox) findViewById(R.id.checkBox_2_2);

        if (Team1TimeOuts ==0) {
            CheckBoxTeam1_1.setChecked(false);
            CheckBoxTeam1_2.setChecked(false);
        }

        if (Team1TimeOuts ==1) {
            CheckBoxTeam1_1.setChecked(true);
            CheckBoxTeam1_2.setChecked(false);
        }

        if (Team1TimeOuts ==2) {
            CheckBoxTeam1_1.setChecked(true);
            CheckBoxTeam1_2.setChecked(true);
        }

        if (Team2TimeOuts ==0) {
            CheckBoxTeam2_1.setChecked(false);
            CheckBoxTeam2_2.setChecked(false);
        }

        if (Team2TimeOuts ==1) {
            CheckBoxTeam2_1.setChecked(true);
            CheckBoxTeam2_2.setChecked(false);
        }

        if (Team2TimeOuts ==2) {
            CheckBoxTeam2_1.setChecked(true);
            CheckBoxTeam2_2.setChecked(true);
        }

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

        switch (item.getItemId()) {
            case R.id.action_reset:
                resetScores();
                return true;
            case R.id.action_reset_timeouts:
                resetTimeouts();
                return true;
            case R.id.action_help:
                // Todo: Respond to the help menu click
                return true;
            case R.id.action_about:
                // ToDo: Respond to the about menu click
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // Method resetScores resets all scores for points and timeouts to 0

    public void resetScores(){
        Team1Points = 0;
        Team2Points = 0;
        Team2TimeOuts = 0;
        Team1TimeOuts = 0;
        updateDisplays();

    }

    // Method resetTimeouts resets all timeouts to 0

    public void resetTimeouts(){
        Team1TimeOuts =0;
        Team2TimeOuts =0;
        updateDisplays();
    }

}