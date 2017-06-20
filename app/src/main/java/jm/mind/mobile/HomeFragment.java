package jm.mind.mobile;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jm.mind.mobile.apply.ApplyActivity;
import jm.mind.mobile.calender.AnnounceActivity;
import jm.mind.mobile.courses.CourseActivity;
import jm.mind.mobile.faq.FaqActivity;
import jm.mind.mobile.products.ProductActivity;
import jm.mind.mobile.profile.ProfileModelHome;
import jm.mind.mobile.evaluation.Registration;
import jm.mind.mobile.speaker.SpeakerActivity;
import jm.mind.mobile.vacancy.VacancyActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private GridView lvProfilesm;
    private MyAppAdapter myAppAdapter;
    private ArrayList<ProfileModelHome> profileModelArrayList;

    FragmentTransaction fragmentTransaction;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home1, container, false);

        profileModelArrayList = new ArrayList<>();
        profileModelArrayList.add(new ProfileModelHome("COURSES", "", R.drawable.courses));
        profileModelArrayList.add(new ProfileModelHome("HOW TO APPLY", "", R.drawable.apply));
        profileModelArrayList.add(new ProfileModelHome("CALENDER", "", R.drawable.cale));
        profileModelArrayList.add(new ProfileModelHome("CONFERENCE", "", R.drawable.conf));
        profileModelArrayList.add(new ProfileModelHome("PRODUCTS", "", R.drawable.products));
        profileModelArrayList.add(new ProfileModelHome("VACANCIES", "", R.drawable.job));
        profileModelArrayList.add(new ProfileModelHome("FAQ'S", "", R.drawable.quest));
        profileModelArrayList.add(new ProfileModelHome("LOCATION", "", R.drawable.locals));
        profileModelArrayList.add(new ProfileModelHome("CONTACT US", "", R.drawable.consum));


        lvProfilesm = (GridView) v.findViewById(R.id.grid);
        myAppAdapter = new MyAppAdapter(profileModelArrayList, getActivity());
        lvProfilesm.setAdapter(myAppAdapter);
        lvProfilesm.setOnItemClickListener(new ItemList());


        return v;
    }
    //-----------------------------Click List----------------------

    public void onClick(View view) {

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
                rowView = inflater.inflate(R.layout.grid_single1, parent, false);
                // configure view holder
                viewHolder = new MyAppAdapter.ViewHolder();
//                viewHolder.copy = (ImageView) rowView.findViewById(R.id.copy);
//                viewHolder.share = (ImageView) rowView.findViewById(R.id.share);
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
                Intent intent = new Intent(getActivity(), CourseActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 1) {
                Intent intent = new Intent(getActivity(), ApplyActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 2) {
                Intent intent = new Intent(getActivity(), AnnounceActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 3) {
                Intent intent = new Intent(getActivity(), ConferenceMain.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 4) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 5) {
                Intent intent = new Intent(getActivity(), VacancyActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 6) {
                Intent intent = new Intent(getActivity(), FaqActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 7) {
                Intent intent = new Intent(getActivity(), Maps2Activity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if (i == 8) {
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }

    }


}