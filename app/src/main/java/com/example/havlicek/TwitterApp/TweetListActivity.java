package com.example.havlicek.TwitterApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.TextView;


public class TweetListActivity extends ListActivity {
    //private ListView tweetListView;
    private String[] stringArray;
    private ArrayAdapter<String> tweetItemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        //stringArray = new String[10];
        //for(int i=0;i < stringArray.length; i++) {
        //    stringArray[i] = "String " + i;
        //}

        //tweetItemArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringArray);
        tweetItemArrayAdapter = new TweetAdapter(this, new String[10]);
        //tweetListView = (ListView) findViewById(R.id.tweetList);
        //tweetListView.setAdapter(tweetItemArrayAdapter);
        setListAdapter(tweetItemArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //TextView t = (TextView) v.findViewById(R.id.tweetTitle);
        //t.setText("Tweet Click!");
        Intent intent = new Intent(this, TweetDetailActivity.class);
        startActivity(intent);
    }
}
