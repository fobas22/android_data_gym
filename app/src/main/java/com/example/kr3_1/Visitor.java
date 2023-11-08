package com.example.kr3_1;

import android.os.Parcel;
import android.os.Parcelable;

public class Visitor implements Parcelable
{

    String name ="";
    String lastName = "";
    String height = "";
    int weight = 0;
    String bYear = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getbYear() {
        return bYear;
    }

    public void setbYear(String bYear) {
        this.bYear = bYear;
    }

    public Visitor(String name, String lastName, int weight) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
    }

    public Visitor(){}

    public Visitor(String name, String lastName, String bYear) {
        this.name = name;
        this.lastName = lastName;
        this.bYear = bYear;
    }

    public Visitor(String name, String lastName, String height, int weight, String bYear) {
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.bYear = bYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(lastName);
        parcel.writeString(height);
        parcel.writeInt(weight);
        parcel.writeString(bYear);
    }

    protected Visitor(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        height = in.readString();
        weight = in.readInt();
        bYear = in.readString();
    }

    public static final Creator<Visitor> CREATOR = new Creator<Visitor>() {
        @Override
        public Visitor createFromParcel(Parcel in) {
            return new Visitor(in);
        }

        @Override
        public Visitor[] newArray(int size) {
            return new Visitor[size];
        }
    };
}
