package com.example.covid_works;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class vaccination extends Activity {
    private Button button;
    private RecyclerView mList;
    private String url = "https://disease.sh/v3/covid-19/states/washington";
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<locationInfo> vaccList;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacc_menu);
        mList = findViewById(R.id.main_list);

        vaccList = new ArrayList<>();
        adapter = new infoAdapter(getApplicationContext(), vaccList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getData();
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            openCases();
        }
    });
}


    private void getData() {



        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        locationInfo info = new locationInfo();

                /*
                        info.setProvider(jsonObject.getString("provider"));
                        info.setAddress(jsonObject.getString("address"));
                        info.setUrl(jsonObject.getString("url")); */

                        info.setProvider(jsonObject.getString("cases"));
                        vaccList.add(info);



                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }



    public void openCases(){
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }
}
