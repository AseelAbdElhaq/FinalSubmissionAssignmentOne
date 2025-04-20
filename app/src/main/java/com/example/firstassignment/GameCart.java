package com.example.firstassignment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameCart extends AppCompatActivity {

    private static final String CART_PREFS_KEY = "cart";
    List<games> cartfilledwithgames = new ArrayList<>();
    SharedPreferences preferencesGames;
    Button buyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_cart);


        preferencesGames = PreferenceManager.getDefaultSharedPreferences(this);


        placeCartItems();
        buyNow=findViewById(R.id.buybtn);
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartfilledwithgames.isEmpty()) {
                    Toast.makeText(GameCart.this, "Your cart is not full yet, please add more", Toast.LENGTH_LONG).show();
                } else {
                    cartfilledwithgames.clear();

                    saveCartItems();

                    Toast.makeText(GameCart.this, "Purchase is completed! Thanks for shopping with us", Toast.LENGTH_LONG).show();


                }
            }
        });


        RecyclerView recyclerViewforGames = findViewById(R.id.recyclerView);
        recyclerViewforGames.setLayoutManager(new LinearLayoutManager(this));


        RecyclerView.Adapter recyclerViewAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cartsection, parent, false);
                return new RecyclerView.ViewHolder(itemView) {};
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                games gms= cartfilledwithgames.get(position);

                // Bind data to the view
                ImageView GameImage = holder.itemView.findViewById(R.id.gameimg);
                TextView GameName = holder.itemView.findViewById(R.id.txtgamename);
                TextView CatGame = holder.itemView.findViewById(R.id.CategoryGame);
                TextView priceGame = holder.itemView.findViewById(R.id.PriceGame);
                TextView ra= holder.itemView.findViewById(R.id.Rate);
                GameImage.setImageResource(gms.getImgGameId());
                GameName.setText(gms.getName());
                CatGame.setText(gms.getCat());
                priceGame.setText( gms.getPrice());
                ra.setText(gms.getRate()+"");

            }

            @Override
            public int getItemCount() {
                return cartfilledwithgames.size();
            }

        };

        recyclerViewforGames.setAdapter(recyclerViewAdapter);



    }


    private void placeCartItems() {
        String gamecartJson = preferencesGames.getString(CART_PREFS_KEY, ""); // Default to empty string
        if (!gamecartJson.isEmpty()) {
            Gson gson = new Gson();
            games[] items = gson.fromJson(gamecartJson, games[].class);
            cartfilledwithgames = new ArrayList<>(Arrays.asList(items));
        }
    }

    private void saveCartItems() {
        Gson gson = new Gson();
        String changecart = gson.toJson(cartfilledwithgames);
        SharedPreferences.Editor editor = preferencesGames.edit();
        editor.putString(CART_PREFS_KEY, changecart);
        editor.apply();
    }

        public void storeCartItem(games newItem) {
        cartfilledwithgames.add(newItem);
        saveCartItems();
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }

}