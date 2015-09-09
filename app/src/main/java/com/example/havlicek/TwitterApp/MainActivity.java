package com.example.havlicek.TwitterApp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button _loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences("TwitterApp", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String uname = prefs.getString("username", null);
        String passwd = prefs.getString("password", null);

        if (uname !=null && passwd != null) {
            //super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_tweet_list);
            Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
            startActivity(intent);

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _loginBtn = (Button) findViewById(R.id.btn_login);

        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is a comment line. The next line is replace.
                // _loginBtn.setText("I am Clicked");
                EditText username = (EditText) findViewById(R.id.fld_username);
                EditText password = (EditText) findViewById(R.id.fld_pwd);
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                Log.d("CodeLearn","username - " + usernameValue);
                Log.d("CodeLearn","password - " + passwordValue);

                SharedPreferences prefs = getSharedPreferences("TwitterApp", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("username", usernameValue);
                editor.putString("password", passwordValue);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
