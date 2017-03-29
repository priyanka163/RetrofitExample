package com.example.next.githubsample.models;

/**
 * Created by next on 10/3/17.
 */
public class Commit {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private String url;
    private long comment_count;
    private Committer committer;
    private  Author author;
    private Tree tree;
    private String html_url;
    private String comments_url;

    public Commit() {
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }
}
