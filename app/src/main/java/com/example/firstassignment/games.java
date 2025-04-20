package com.example.firstassignment;

public class games {
    private String name;
    private String price;
    private String cat;
    private boolean isAvailable;
    private  int imgGameId;
    private String rate;



    // Constructor
    public games(int imgGameId, String name, String price, String cat, boolean isAvailable,String rate) {
        this.imgGameId = imgGameId;
        this.name = name;
        this.price = price;
        this.cat = cat;
        this.isAvailable = isAvailable;
        this.rate=rate;
    }
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getImgGameId() {
        return imgGameId;
    }

    public void setImgGameId(int imgGameId) {
        this.imgGameId = imgGameId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
