package com.example.firstassignment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class GameHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView name, category, price,rating;
    Button add;

    public GameHolder(View view) {
        super(view);
        img = view.findViewById(R.id.gameimg);
        name = view.findViewById(R.id.txtgamename);
        category = view.findViewById(R.id.CategoryGame);
        price = view.findViewById(R.id.PriceGame);
        add = view.findViewById(R.id.buybtn);
        rating=view.findViewById(R.id.Rate);
    }
}
