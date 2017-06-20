package jm.mind.mobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jm.mind.mobile.profile.ProfileModelHome;

public class ContactActivity1 extends AppCompatActivity {

    private ListView lvProfilesm;
    private MyAppAdapter myAppAdapter;
    private ArrayList<ProfileModelHome> profileModelArrayList;


    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profileModelArrayList = new ArrayList<>();
        profileModelArrayList.add(new ProfileModelHome("(876) 927-1761", "235A Old Hope Road\n" + "Kingston", R.drawable.phone));
        profileModelArrayList.add(new ProfileModelHome("(876) 962-2183 ", "5 Perth Road,Mandeille\n" + "Manchester", R.drawable.phone));
        profileModelArrayList.add(new ProfileModelHome("(876) 962-0428 ", "5 Perth Road,Mandeille\n" + "Manchester", R.drawable.phone));
        profileModelArrayList.add(new ProfileModelHome("Website ", "http://www.mind.edu.jm/", R.drawable.web));
        profileModelArrayList.add(new ProfileModelHome("Email Us ", "marketing@mind.edu.jm", R.drawable.email));

        lvProfilesm = (ListView) findViewById(R.id.lblist);
        myAppAdapter = new MyAppAdapter(profileModelArrayList, getApplicationContext());
        lvProfilesm.setAdapter(myAppAdapter);
        lvProfilesm.setOnItemClickListener(new ItemList());

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        img = (ImageButton) findViewById(R.id.backbtn);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConferenceMain.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        getSupportActionBar().setTitle("Contact Us");


    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView username, country;
            ImageView profilePic;

        }

        public ArrayList<ProfileModelHome> profileList;

        public Context context;


        private MyAppAdapter(ArrayList<ProfileModelHome> apps, Context context) {
            this.profileList = apps;
            this.context = context;

        }

        @Override
        public int getCount() {
            return profileList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            MyAppAdapter.ViewHolder viewHolder;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.list_single, parent, false);

                viewHolder = new MyAppAdapter.ViewHolder();
                viewHolder.profilePic = (ImageView) rowView.findViewById(R.id.imgProfile);
                viewHolder.username = (TextView) rowView.findViewById(R.id.txtUsername);
                viewHolder.country = (TextView) rowView.findViewById(R.id.txtCountry);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (MyAppAdapter.ViewHolder) convertView.getTag();
            }

            viewHolder.username.setText(profileList.get(position).getUsername() + "");
            viewHolder.country.setText(profileList.get(position).getCountry() + "");
            Glide.with(getApplicationContext()).load(profileList.get(position).getProfilePic()).into(viewHolder.profilePic);

            return rowView;
        }
    }

    private class ItemList implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            if (i == 0) {

                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity1.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try{
                    Intent phoneDialerIntent= new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                }
                catch (Exception e)
                {
                }
            }

            else if (i == 1) {
                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity1.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try{
                    Intent phoneDialerIntent= new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                }
                catch (Exception e)
                {
                }

            }
            else if (i == 2) {
                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity1.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try {
                    Intent phoneDialerIntent = new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                } catch (Exception e) {
                }
            }
            else if (i == 3) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.mind.edu.jm/"));
                startActivity(intent);

            }

            else if (i == 4) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"marketing@mind.edu.jm"});  //Heart Trust 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Add your Subject"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear MIND," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback/Query:"));
            }

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ContactActivity1.this, ConferenceMain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        this.finish();
    }
}