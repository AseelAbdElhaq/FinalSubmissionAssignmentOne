package com.example.firstassignment;

import java.util.ArrayList;

public class Database {

    ArrayList<com.example.firstassignment.games> gamesarray= new ArrayList<>();
    public Database(){
        gamesarray.add(new games(R.drawable.minishop, "Minecraft", "$6.99", "Sandbox", true, "4.8"));
        gamesarray.add(new games(R.drawable.survivalcraft2, "Survivalcraft 2", "$3.99", "Sandbox", false, "4.2"));
        gamesarray.add(new games(R.drawable.plaguelnc, "Plague Inc.", "$0.99", "Simulation", true, "4.6"));
        gamesarray.add(new games(R.drawable.terraria, "Terraria", "$4.99", "Adventure", true, "4.7"));
        gamesarray.add(new games(R.drawable.monumentvalley, "Monument Valley", "$3.99", "Puzzle", true, "4.5"));
        gamesarray.add(new games(R.drawable.geometrydash, "Geometry Dash", "$1.99", "Arcade", true, "4.4"));
        gamesarray.add(new games(R.drawable.stardewvalley, "Stardew Valley", "$4.99", "Simulation", true, "4.9"));
        gamesarray.add(new games(R.drawable.deadcells, "Dead Cells", "$8.99", "Action", true, "4.6"));
        gamesarray.add(new games(R.drawable.limbo, "Limbo", "$4.99", "Puzzle", true, "4.3"));
        gamesarray.add(new games(R.drawable.bloonstdshop, "Bloons TD 6", "$6.99", "Strategy", true, "4.7"));
        gamesarray.add(new games(R.drawable.dontstarve, "Don't Starve", "$4.99", "Survival", true, "4.4"));
        gamesarray.add(new games(R.drawable.gtasanandreas, "GTA: San Andreas", "$6.99", "Action", true, "4.8"));
        gamesarray.add(new games(R.drawable.theroom, "The Room", "$0.99", "Puzzle", true, "4.5"));
        gamesarray.add(new games(R.drawable.titanquest, "Titan Quest", "$8.99", "RPG", true, "4.2"));
        gamesarray.add(new games(R.drawable.rebellnc, "Rebel Inc.", "$1.99", "Simulation", true, "4.3"));
        gamesarray.add(new games(R.drawable.castlevaniasymphonyofthenightshop, "Castlevania: Symphony of the Night", "$2.99", "Adventure", true, "4.7"));
        gamesarray.add(new games(R.drawable.thiswarofmine, "This War of Mine", "$13.99", "Survival", true, "4.6"));
        gamesarray.add(new games(R.drawable.hitmansniper, "Hitman Sniper", "$0.99", "Shooter", true, "4.1"));
        gamesarray.add(new games(R.drawable.minimetro, "Mini Metro", "$1.99", "Strategy", true, "4.4"));
        gamesarray.add(new games(R.drawable.rfsrealflightsimulator, "RFS - Real Flight Simulator", "$0.99", "Simulation", true, "4.2"));
    }


    public ArrayList<com.example.firstassignment.games>retrieveGames(){
        ArrayList<games>resultofgames= new ArrayList<>();
        for(games g :gamesarray ){
            resultofgames.add(g);
        }
    return resultofgames;
    }


}
