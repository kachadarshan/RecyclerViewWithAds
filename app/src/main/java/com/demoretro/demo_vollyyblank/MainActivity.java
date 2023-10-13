package com.demoretro.demo_vollyyblank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    StringRequest stringRequest;

    String base_url = "https://jsonplaceholder.typicode.com/photos";

    ArrayList<ModelClass> arrayList ,narrylist;

    RecyclerView recyclerView;
    RecycAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        arrayList = new ArrayList<>();
        narrylist = new ArrayList<>();

        recyclerView = findViewById(R.id.main_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        stringRequest = new StringRequest(Request.Method.GET, base_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        arrayList.add(new ModelClass(jsonObject.getInt("albumId"), jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getString("url"), jsonObject.getString("thumbnailUrl")));

                        if (i % 10 == 0 && i != 0) {
                            MainActivity.this.narrylist.add(null);
                        }
                        narrylist.add(new ModelClass(jsonObject.getInt("albumId"), jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getString("url"), jsonObject.getString("thumbnailUrl")));

                    }

                    adapter = new RecycAdapter(MainActivity.this, narrylist);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);

    }
}