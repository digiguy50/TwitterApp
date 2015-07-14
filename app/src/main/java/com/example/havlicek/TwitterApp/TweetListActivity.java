package com.example.havlicek.TwitterApp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;


public class TweetListActivity extends Activity {
    private ListView tweetListView;
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
        tweetListView = (ListView) findViewById(R.id.tweetList);
        tweetListView.setAdapter(tweetItemArrayAdapter);
    }

}
