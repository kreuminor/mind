package jm.mind.mobile.speaker;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jm.mind.mobile.ConferenceMain;
import jm.mind.mobile.MainActivity;
import jm.mind.mobile.R;
import jm.mind.mobile.adapters.SpeakerAdapter;
import jm.mind.mobile.animations.BugDroid;
import jm.mind.mobile.network.TSVRequest;
import jm.mind.mobile.network.VolleySingleton;
import jm.mind.mobile.objects.Conference;

public class SpeakerActivity extends AppCompatActivity implements
        Response.ErrorListener,
        Response.Listener<List<Conference>>,
        BugDroid.OnRefreshClickListener {

    public static final String CONFERENCES = "conferences";
    public static final String URL = "https://docs.google.com/spreadsheets/d/1VWF4YG3ZzmDt2FGKNAZzI0oeQykyLTcyUyGP3JOBiEc/pub?output=tsv";

    private VolleySingleton mVolley;
    Toolbar toolbar;
    private BugDroid mAnimatedBugDroid;
    private CoordinatorLayout mLayout;

    ImageButton img;

    SpeakerAdapter adapter;
    ListView lv;
    List<Conference> speakerList = new ArrayList<Conference>();
    HashMap<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);

        lv = (ListView) findViewById(R.id.lstview);

        final ArrayAdapter<Conference> arrayAdapter = new ArrayAdapter<>(SpeakerActivity.this, android.R.layout.simple_list_item_1, speakerList);
        lv.setAdapter(arrayAdapter);

        initVolley(this);

        img = (ImageButton)findViewById(R.id.backbtn);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConferenceMain.class);
                startActivity(intent);
                finish();
            }
        });

        getSupportActionBar().setTitle("Conference Speakers");

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
        onUpdateDone();
    }

    @Override
    public void onResponse(List<Conference> response) {
        speakerList.clear();
        speakerList.addAll(response);
        adapter.notifyDataSetChanged(); //might not work
        onUpdateDone();
    }

    private void onUpdateDone() {

    }
    @Override
    public void onRefreshClick() {
        update();
    }

    private void update() {

            mVolley.addToRequestQueue(new TSVRequest(this, Request.Method.GET, URL, this, this));

            adapter = new SpeakerAdapter(getApplicationContext(), speakerList);
            lv.setAdapter(adapter);

        //Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show();
    }

    private void go(){
        mVolley.addToRequestQueue(new TSVRequest(this, Request.Method.GET, URL, this, this));
    }

    private void initVolley(Context context) {
        if (mVolley == null) {
            mVolley = VolleySingleton.getInstance(context);
            update();
        }
    }

    public ArrayList<Conference> getConferences() {
        return (ArrayList<Conference>) speakerList;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SpeakerActivity.this, ConferenceMain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        this.finish();
    }

}