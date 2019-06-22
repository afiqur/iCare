package com.example.piash.icare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by PIASH on 07-Apr-17.
 */

public class SignupActivity extends AppCompatActivity {
    public static final String USER_NAME = "user_name";
    public static final String USER_USERNAME = "user_username";
    public static final String USER_PASSWORD = "user_password";
    public static final String MY_PREFERENCE_FILE = "User Authentication";

    private EditText nameET;
    private EditText usernameET;
    private EditText passET;

    private SharedPreferences myPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameET = (EditText) findViewById(R.id.name);
        usernameET = (EditText) findViewById(R.id.username);
        passET = (EditText) findViewById(R.id.password);

        myPreferences = getSharedPreferences(MY_PREFERENCE_FILE, MODE_PRIVATE);
        editor = myPreferences.edit();
    }

    public void signup(View view) {

        String name = nameET.getText().toString();
        String username = usernameET.getText().toString();
        String pass = passET.getText().toString();

        editor.putString(USER_NAME, name);
        editor.putString(USER_USERNAME, username);
        editor.putString(USER_PASSWORD, pass);
        editor.commit();

        nameET.setText("");
        usernameET.setText("");
        passET.setText("");
        Toast.makeText(this, "Signup Successfully", Toast.LENGTH_SHORT).show();


    }

    public void back(View view) {
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
    }
}