package com.example.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dangnh
 * Http connection and JSON parser example
 * Getting infomation from https://jsonplaceholder.typicode.com/users
 * and display as a listview of contacts info:name, email, address (street,city)
 */
public class MainActivity extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        new GetInfoTask().execute();
    }

    private class GetInfoTask extends AsyncTask<Void, Integer, Void> {
        ProgressDialog dialog;
        String link;
        String info;
        ArrayList<ContactsInfo> info_list;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            link = "https://jsonplaceholder.typicode.com/users";
            info_list = new ArrayList<ContactsInfo>();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                publishProgress(1);
                URL url = new URL(link);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                int responseCode = conn.getResponseCode();
                Log.v("TAG", "Response code: " + responseCode);
                publishProgress(2);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder infoBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null)
                    infoBuilder.append(line);
                info = infoBuilder.toString();
                Log.v("TAG", info);
                reader.close();
            } catch (Exception ex) {
                Log.v("TAG", ex.getMessage());
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (values[0] == 1) {
                dialog.setMessage("Connecting to " + link + " ...");
            } else {
                dialog.setMessage("Getting infomations...");
            }
        }

        @Override
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            dialog.dismiss();
            try {
                JSONArray info_arr = new JSONArray(info);
                for (int i = 0; i < info_arr.length(); i++) {
                    JSONObject person = info_arr.getJSONObject(i);
                    String name = person.getString("name");
                    String email = person.getString("email");
                    JSONObject address = person.getJSONObject("address");
                    String street = address.getString("street");
                    String city = address.getString("city");
                    info_list.add(new ContactsInfo(name, email, street, city));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            MyArrayAdapter adapter = new MyArrayAdapter(MainActivity.this, info_list);
            listView.setAdapter(adapter);
        }
    }
}


