package com.example.piash.icare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.piash.icare.SignupActivity.MY_PREFERENCE_FILE;
import static com.example.piash.icare.SignupActivity.USER_PASSWORD;
import static com.example.piash.icare.SignupActivity.USER_USERNAME;

public class MainActivity extends AppCompatActivity {


    private EditText UsernameET;
    private EditText PassET;

    private String prefUsername;
    private String prefPass;

    private SharedPreferences myPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameET = (EditText) findViewById(R.id.enterusername);
        PassET = (EditText) findViewById(R.id.enterpassword);

        myPreferences = getSharedPreferences(MY_PREFERENCE_FILE,MODE_PRIVATE);
        editor = myPreferences.edit();
    }

    public void Login(View view) {
        String email = UsernameET.getText().toString();
        String pass = PassET.getText().toString();

        prefUsername = myPreferences.getString(USER_USERNAME,"No Email Found");
        prefPass = myPreferences.getString(USER_PASSWORD,"Incorrect Password");

        if (email.equals(prefUsername) && pass.equals(prefPass))
        {

            editor.commit();
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(MainActivity.this, Working.class));

        }
        else
        {
            Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void Signup(View view) {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }
}
