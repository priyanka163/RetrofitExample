package com.example.next.githubsample;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.next.githubsample.models.GithubRepoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText mUsername,mPassword;
    Button mClick;
    String mData_username;
    String mData_password;
    ListView listView;
    String API_BASE_URL = "https://api.github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.repos);
        mClick = (Button) findViewById(R.id.click);

        mClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData_username = mUsername.getText().toString();
                mData_password = mPassword.getText().toString();
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
fetchData();

            }
        });

    }


    public  void fetchData(){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        //GsonConverterFactory-this claa gives implementation for interface which uses  gson for its deserialization
        Log.i("Mainactivity", "oncreate: "+builder);


        Retrofit retrofit= builder.build();

        //retrofit class generate interface implementation
        GitInterface ghubClientInterface=retrofit.create(GitInterface.class);

        Log.i("Interface", "onCreate: "+ghubClientInterface);

        final Call<List<GithubRepoModel>> listCall =ghubClientInterface.reposeforuser(mData_username,mData_password);
        Log.i("Mainactivity", "listcall: "+listCall);

//enqueue is asynchronous request and execute is synchronous request
        listCall.enqueue(new Callback<List<GithubRepoModel>>() {


            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {
                List<GithubRepoModel>  repos= response.body();
                listView.setAdapter(new ListAdapter(MainActivity.this, (ArrayList<GithubRepoModel>) repos));
                Log.i("Mainactivity", "onResponse: "+repos);
                Log.i("url", "onResponse: "+repos.toString());
                Log.i("Data", "onResponse: "+response.toString());

                GithubRepoModel model=new GithubRepoModel();

               /* try {
                    JSONArray array= new JSONArray(response);
                    JSONObject firstobj=array.getJSONObject(0);
                    Log.i("printdata", "onResponse: "+array.length());
                    //firstobj.getString("sha");
                    model.setSha(firstobj.getString("sha"));

                    JSONObject secobj=firstobj.getJSONObject("commit");

                    JSONObject thirdobj=secobj.getJSONObject("committer");
                  *//*  model.setName(thirdobj.getString("name"));
                    model.setmEmail(thirdobj.getString("email"));
                    model.setmDate(thirdobj.getString("date"));
                    model.setmMessage(thirdobj.getString("message"));
*//*
                    Log.i("size", "onResponse: "+array.length());
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/


            }

            @Override
            public void onFailure(Call<List<GithubRepoModel>> call, Throwable t) {
                Log.i("Mainactivity", "onFailure: "+call);

            }
        });
    }
    }
