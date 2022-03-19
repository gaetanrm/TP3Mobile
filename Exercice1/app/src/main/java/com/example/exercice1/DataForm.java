package com.example.exercice1;

import android.os.Parcel;
import android.os.Parcelable;

public class DataForm {
    private String name, surname, date, email;
    private boolean sport, music, reading, videogames;

    public DataForm(String name, String surname, String date, String email, boolean sport, boolean music, boolean reading, boolean videogames) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.sport = sport;
        this.music = music;
        this.reading = reading;
        this.videogames = videogames;
    }

    @Override
    public String toString() {
        return "DataForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                ", sport=" + sport +
                ", music=" + music +
                ", reading=" + reading +
                ", videogames=" + videogames +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public boolean isVideogames() {
        return videogames;
    }

    public void setVideogames(boolean videogames) {
        this.videogames = videogames;
    }

}
