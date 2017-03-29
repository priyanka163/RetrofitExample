package com.example.next.githubsample.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by next on 10/3/17.
 */
public class GithubRepoModel {

   // private int id;

    private  String sha;
    private Commit commit;



    public GithubRepoModel() {
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
