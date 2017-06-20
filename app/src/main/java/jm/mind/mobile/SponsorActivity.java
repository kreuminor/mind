package jm.mind.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jm.mind.mobile.adapters.SponsorAdapter;
import jm.mind.mobile.html.BurgerKing;
import jm.mind.mobile.html.glassActivity;
import jm.mind.mobile.html.heartActivity;
import jm.mind.mobile.html.kfcActivity;
import jm.mind.mobile.html.guardianActivity;
import jm.mind.mobile.html.udcActivity;
import jm.mind.mobile.objects.AboutItem;

public class SponsorActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<AboutItem> mAboutItems = new ArrayList<AboutItem>();

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        img = (ImageButton)findViewById(R.id.backbtn);

        if (mToolbar != null) {

            setSupportActionBar(mToolbar);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ConferenceMain.class);
                    startActivity(intent);
                    finish();
                }
            });

        }
        getSupportActionBar().setTitle("Our Sponsors");

        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);
        generateList();
        SponsorAdapter mAdapter = new SponsorAdapter(this, 0x00, mAboutItems);
        mListView.setAdapter(mAdapter);
    }

    private void generateList() {
        mAboutItems.clear();
        mAboutItems.add(new AboutItem(getString(R.string.sponsor),
                getString(R.string.sponor_text),
                R.drawable.kfc));
        mAboutItems.add(new AboutItem(getString(R.string.sponsor1),
                getString(R.string.sponsor1_text),
                R.drawable.burger));
        mAboutItems.add(new AboutItem(getString(R.string.sponsor2),
                getString(R.string.sponsor2_text),
                R.drawable.hlogo));
        mAboutItems.add(new AboutItem(getString(R.string.sponsor3),
                getString(R.string.sponsor3_text),
                R.drawable.udc));
        mAboutItems.add(new AboutItem(getString(R.string.sponsor4),
                getString(R.string.sponor4_text),
                R.drawable.glasses));
        mAboutItems.add(new AboutItem(getString(R.string.sponsor5),
                getString(R.string.sponor5_text),
                R.drawable.guardian));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: //Launch Navigation to the conference site
                Intent intent = new Intent(SponsorActivity.this, kfcActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            case 1: // Display the Open Source projects used for this application
                intent = new Intent(SponsorActivity.this, BurgerKing.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            case 2: //Open my twitter ;)
                intent = new Intent(SponsorActivity.this, heartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            case 3: //Open my twitter ;)
                intent = new Intent(SponsorActivity.this, udcActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            case 4: //Open the feedback form
                intent = new Intent(SponsorActivity.this, glassActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
            case 5: //Open the feedback form
                intent = new Intent(SponsorActivity.this, guardianActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SponsorActivity.this, ConferenceMain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        this.finish();
    }
}
