package com.example.firstassignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameHolder> {

    Context context;
    List<games> gamelistarray;

    public GameAdapter(Context context, List<games> list) {
        this.context = context;
        this.gamelistarray = list;
    }

    @Override
    public GameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_gameshopart, parent, false);
        return new GameHolder(v);
    }

    @Override
    public void onBindViewHolder(GameHolder holdervar, int i) {
        games g = gamelistarray.get(i);

        holdervar.img.setImageResource(g.getImgGameId());
        holdervar.name.setText(g.getName());
        holdervar.category.setText(g.getCat());
        holdervar.price.setText("$" + g.getPrice());
        holdervar.rating.setText(g.getRate());

        holdervar.add.setOnClickListener(v -> {
            Toast.makeText(context, g.getName() + "has been added to gaming cart", Toast.LENGTH_LONG).show();

            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = pref.edit();

            String json = pref.getString("cart", "");
            List<games> cart = new ArrayList<>();

            if (!json.equals("")) {
                games[] items = new Gson().fromJson(json, games[].class);
                cart = new ArrayList<>(Arrays.asList(items));
            }

            boolean found = false;
            for (games item : cart) {
                if (item.getName().equals(g.getName())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                cart.add(g);
                String updated = new Gson().toJson(cart);
                editor.putString("cart", updated);
                editor.apply();
            }

        });
    }

    @Override
    public int getItemCount() {
        return gamelistarray.size();
    }
}
