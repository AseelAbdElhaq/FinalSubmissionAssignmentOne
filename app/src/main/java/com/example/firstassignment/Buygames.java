package com.example.firstassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class Buygames extends AppCompatActivity {
    public static final String DATA = "DATA";
    Button btn1 , btn2,btn3,checks;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buygames);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.buybtn);
        checks=findViewById(R.id.btnCart);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();

        Gson gson = new Gson();
        String str = pref.getString(DATA, "");
        games[] game;

        if (!str.equals("")) {
            game = gson.fromJson(str, games[].class);
        } else {
            // Fallback to default database and save it
            Database dataBase = new Database();
            game = dataBase.retrieveGames().toArray(new games[0]);

            String json = gson.toJson(game);
            editor.putString(DATA, json);
            editor.commit();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GameAdapter adapter = new GameAdapter(this, java.util.Arrays.asList(game));
        recyclerView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buygames.this, UserProfile.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buygames.this, TopRated.class);
                startActivity(intent);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Buygames.this, ContactUs.class);
                startActivity(intent);

            }
        });


        checks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buygames.this, GameCart.class);
                startActivity(intent);



            }
        });



    }



    }
