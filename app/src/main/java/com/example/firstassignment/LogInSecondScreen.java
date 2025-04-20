package com.example.firstassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogInSecondScreen extends AppCompatActivity {
    TextView signupLinkForUser ;
    EditText email;
    EditText pass;
    Button button;

    private SharedPreferences prefererencesforGames;
    private SharedPreferences.Editor editor;
    public static final String Email = "Email";
    public static final String Pass = "PASS";
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    CheckBox checkboxforlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in_second_screen);
        signupLinkForUser = findViewById(R.id.signupLink);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.username);
        button = findViewById(R.id.login);
        checkboxforlogin = findViewById(R.id.checkbxforgms);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupSharedPrefs();
        checksharedprefs();
        signupLinkForUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInSecondScreen.this, SignUpThirdScreen.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();
                String password = pass.getText().toString();

                if (checkboxforlogin.isChecked()) {
                    editor.putString(Email, emaill);
                    editor.putString(Pass, password);
                    editor.putBoolean(FLAG, true);
                    editor.commit();
                }

                Intent intent = new Intent(LogInSecondScreen.this, Buygames.class);
                startActivity(intent);
            }
        });




    }

    private void setupSharedPrefs() {
        prefererencesforGames = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefererencesforGames.edit();
    }

    private void checksharedprefs() {
        flag = prefererencesforGames.getBoolean(FLAG, false);

        if(flag){
            String name = prefererencesforGames.getString(Email, "");
            String password = prefererencesforGames.getString(Pass, "");
            email.setText(name);
            pass.setText(password);
            checkboxforlogin.setChecked(true);
        }

    }

}