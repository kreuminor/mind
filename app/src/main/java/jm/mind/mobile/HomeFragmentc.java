package jm.mind.mobile;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jm.mind.mobile.evaluation.Registration;
import jm.mind.mobile.location.MapsCActivity;
import jm.mind.mobile.profile.ProfileModelHome;
import jm.mind.mobile.speaker.SpeakerActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragmentc extends Fragment {

    private GridView lvProfilesm;
    private MyAppAdapter myAppAdapter;
    private ArrayList<ProfileModelHome> profileModelArrayList;

    public HomeFragmentc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        profileModelArrayList = new ArrayList<>();
        profileModelArrayList.add(new ProfileModelHome("Schedule", "", R.drawable.sched));
        profileModelArrayList.add(new ProfileModelHome("Speakers", "", R.drawable.speakss));
        profileModelArrayList.add(new ProfileModelHome("Sponsors", "", R.drawable.sponser));
        profileModelArrayList.add(new ProfileModelHome("Location", "", R.drawable.mapss));
        profileModelArrayList.add(new ProfileModelHome("Register", "", R.drawable.questions));
        profileModelArrayList.add(new ProfileModelHome("Contact Us", "", R.drawable.consum));

        lvProfilesm = (GridView) v.findViewById(R.id.grid);
        myAppAdapter = new MyAppAdapter(profileModelArrayList, getActivity());
        lvProfilesm.setAdapter(myAppAdapter);
        lvProfilesm.setOnItemClickListener(new ItemList());

        return v;
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
                LayoutInflater inflater = getLayoutInflater(null);
                rowView = inflater.inflate(R.layout.grid_single, parent, false);

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
            Glide.with(getActivity()).load(profileList.get(position).getProfilePic()).into(viewHolder.profilePic);

            return rowView;
        }

    }

    private class ItemList implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            if (i == 0) {

                Intent intent = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(intent);
                getActivity().finish();

            }

            else if (i == 1) {

                Intent intent = new Intent(getActivity(), SpeakerActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
            else if (i == 2) {

                Intent intent = new Intent(getActivity(), SponsorActivity.class);
                startActivity(intent);
                getActivity().finish();

            }

            else if (i == 3) {

                Intent intent = new Intent(getActivity(), MapsCActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

            else if (i == 4) {

                Intent intent = new Intent(getActivity(), Registration.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 5) {

                Intent intent = new Intent(getActivity(), ContactActivity1.class);
                startActivity(intent);
                getActivity().finish();


            }

            }
        }

    }