package com.airmoll.easymap.models;

public class DataModel
{
    private String name;
    private int image1;
    private int image2;

    public DataModel(String name, int image1, int image2) {
        this.name = name;
        this.image1 = image1;
        this.image2 = image2;
    }

    public String getName() {
        return name;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }
}
