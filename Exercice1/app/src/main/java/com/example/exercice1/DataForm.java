package com.example.exercice1;

import android.os.Parcel;
import android.os.Parcelable;

public class DataForm implements Parcelable {
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

    protected DataForm(Parcel in) {
        name = in.readString();
        surname = in.readString();
        date = in.readString();
        email = in.readString();
        sport = in.readByte() != 0;
        music = in.readByte() != 0;
        reading = in.readByte() != 0;
        videogames = in.readByte() != 0;
    }

    public static final Creator<DataForm> CREATOR = new Creator<DataForm>() {
        @Override
        public DataForm createFromParcel(Parcel in) {
            return new DataForm(in);
        }

        @Override
        public DataForm[] newArray(int size) {
            return new DataForm[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(date);
        parcel.writeString(email);
        parcel.writeByte((byte) (sport ? 1 : 0));
        parcel.writeByte((byte) (music ? 1 : 0));
        parcel.writeByte((byte) (reading ? 1 : 0));
        parcel.writeByte((byte) (videogames ? 1 : 0));
    }
}
