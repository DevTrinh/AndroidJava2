package com.example.readjson.Data;

import android.graphics.drawable.Drawable;

public class DataSong {
    private String nameSong;
    private String nameMusician;
    private int source;
    private int avtSong;

    public DataSong(String nameSong, String nameMusician, int source, int avtSong) {
        this.nameSong = nameSong;
        this.nameMusician = nameMusician;
        this.source = source;
        this.avtSong = avtSong;
    }


    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameMusician() {
        return nameMusician;
    }

    public void setNameMusician(String nameMusician) {
        this.nameMusician = nameMusician;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getAvtSong() {
        return avtSong;
    }

    public void setAvtSong(int avtSong) {
        this.avtSong = avtSong;
    }
}
