package jm.mind.mobile.courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import jm.mind.mobile.MainActivity;
import jm.mind.mobile.R;
import jm.mind.mobile.courses.model.ProgrammeModel;


public class DetailActivity extends ActionBarActivity {

    private TextView courseName;
    private TextView description;
    private TextView location;
    private TextView cost;
    private TextView hours;
    private TextView day;
    private TextView time;
    private TextView date;

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        img = (ImageButton) findViewById(R.id.backbtn);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CourseActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        getSupportActionBar().setTitle("Course Details");

        // setting up text views and stuff
        setUpUIViews();

        // recovering data from CourseActivity, sent via intent
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String json = bundle.getString("programmeModel"); // getting the model from CourseActivity send via extras
            ProgrammeModel programmeModel = new Gson().fromJson(json, ProgrammeModel.class);

            // Then later, when you want to display image


            courseName.setText(programmeModel.getCourse());
            description.setText(programmeModel.getDescription());
            location.setText(programmeModel.getLocation());
            cost.setText(programmeModel.getCost());
            hours.setText(programmeModel.getHours());
            day.setText(programmeModel.getDay());
            time.setText(programmeModel.getTime());
            date.setText(programmeModel.getDate());


            }


    }

    private void setUpUIViews() {
        courseName = (TextView)findViewById(R.id.course);
        description = (TextView)findViewById(R.id.description);
        location = (TextView)findViewById(R.id.location);
        cost = (TextView)findViewById(R.id.cost);
        hours = (TextView)findViewById(R.id.hours);
        day = (TextView)findViewById(R.id.classid);
        time = (TextView)findViewById(R.id.time);
        date = (TextView)findViewById(R.id.date);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
