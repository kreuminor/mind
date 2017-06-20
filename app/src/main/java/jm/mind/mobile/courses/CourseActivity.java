package jm.mind.mobile.courses;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jm.mind.mobile.MainActivity;
import jm.mind.mobile.R;
import jm.mind.mobile.courses.model.ProgrammeModel;

public class CourseActivity extends ActionBarActivity {

    private final String URL_TO_HIT = "https://drive.google.com/uc?export=download&id=0B1VzuZrVMPLNdndpVzFKVUlvM00";
    private TextView tvData;
    private ListView lvProgramme;
    private ProgressDialog dialog;
    ImageButton img;

    // Git error fix - http://stackoverflow.com/questions/16614410/android-studio-checkout-github-error-createprocess-2-windows

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        img = (ImageButton) findViewById(R.id.backbtn);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        getSupportActionBar().setTitle("Scheduled Courses");

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading. Please wait..."); // showing a dialog for loading the data
        // Create default options which will be used for every
        //  displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
        .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .defaultDisplayImageOptions(defaultOptions)
        .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        lvProgramme = (ListView)findViewById(R.id.lvMovies);


        // To start fetching the data when app start, uncomment below line to start the async task.
                new JSONTask().execute(URL_TO_HIT);
    }

    public class JSONTask extends AsyncTask<String,String, List<ProgrammeModel> > {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected List<ProgrammeModel> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("programmes");

                List<ProgrammeModel> programmeModelList = new ArrayList<>();

                Gson gson = new Gson();
                for(int i=0; i<parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    /**
                     * below single line of code from Gson saves you from writing the json parsing yourself
                     * which is commented below
                      */
                    ProgrammeModel programmeModel = gson.fromJson(finalObject.toString(), ProgrammeModel.class); // a single line json parsing using Gson
//                    programmeModel.setMovie(finalObject.getString("movie"));
//                    programmeModel.setYear(finalObject.getInt("year"));
//                    programmeModel.setRating((float) finalObject.getDouble("rating"));
//                    programmeModel.setDirector(finalObject.getString("director"));
//
//                    programmeModel.setDuration(finalObject.getString("duration"));
//                    programmeModel.setTagline(finalObject.getString("tagline"));
//                    programmeModel.setImage(finalObject.getString("image"));
//                    programmeModel.setStory(finalObject.getString("story"));
//
//                    List<ProgrammeModel.Cast> castList = new ArrayList<>();
//                    for(int j=0; j<finalObject.getJSONArray("cast").length(); j++){
//                        ProgrammeModel.Cast cast = new ProgrammeModel.Cast();
//                        cast.setName(finalObject.getJSONArray("cast").getJSONObject(j).getString("name"));
//                        castList.add(cast);
//                    }
//                    programmeModel.setCastList(castList);
                    // adding the final object in the list
                    programmeModelList.add(programmeModel);
                }
                return programmeModelList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  null;
        }

        @Override
        protected void onPostExecute(final List<ProgrammeModel> result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if(result != null) {
                MovieAdapter adapter = new MovieAdapter(getApplicationContext(), R.layout.row, result);
                lvProgramme.setAdapter(adapter);
                lvProgramme.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // list item click opens a new detailed activity
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ProgrammeModel programmeModel = result.get(position); // getting the model
                        Intent intent = new Intent(CourseActivity.this, DetailActivity.class);
                        intent.putExtra("programmeModel", new Gson().toJson(programmeModel)); // converting model json into string type and sending it via intent
                        startActivity(intent);
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public class MovieAdapter extends ArrayAdapter {

        private List<ProgrammeModel> programmeModelList;
        private int resource;
        private LayoutInflater inflater;
        public MovieAdapter(Context context, int resource, List<ProgrammeModel> objects) {
            super(context, resource, objects);
            programmeModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView == null){
                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);

                holder.courseName = (TextView)convertView.findViewById(R.id.pCourse);
                holder.location = (TextView)convertView.findViewById(R.id.pLocation);
                holder.hours = (TextView)convertView.findViewById(R.id.pHours);
                holder.date = (TextView)convertView.findViewById(R.id.pDate);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }



            // Then later, when you want to display image
            final ViewHolder finalHolder = holder;



            holder.courseName.setText(programmeModelList.get(position).getCourse());
            holder.location.setText("Location: " + programmeModelList.get(position).getLocation());
            holder.hours.setText("Hour: " + programmeModelList.get(position).getHours());
            holder.date.setText("Date: " + programmeModelList.get(position).getDate());

            // rating bar
            //holder.rbMovieRating.setRating(programmeModelList.get(position).getRating()/2);

            StringBuffer stringBuffer = new StringBuffer();


            return convertView;
        }


        class ViewHolder{
            private TextView courseName;
            private TextView location;
            private TextView hours;
            private TextView date;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            new JSONTask().execute(URL_TO_HIT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        this.finish();
    }
}
