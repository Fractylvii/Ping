package com.example.ping_application;

import android.os.Parcel;
import android.os.Parcelable;

public class CurrentUser implements Parcelable
{
    private String username;
    private String password;
    private String fullName;
    private String birthday;
    private String phoneNum;
    private String driverBool;

    protected CurrentUser(Parcel in) {
        username = in.readString();
        password = in.readString();
        fullName = in.readString();
        birthday = in.readString();
        phoneNum = in.readString();
        driverBool = in.readString();
    }

    public static final Creator<CurrentUser> CREATOR = new Creator<CurrentUser>() {
        @Override
        public CurrentUser createFromParcel(Parcel in) {
            return new CurrentUser(in);
        }

        @Override
        public CurrentUser[] newArray(int size) {
            return new CurrentUser[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDriverBool() {
        return driverBool;
    }

    public void setDriverBool(String driverBool) {
        this.driverBool = driverBool;
    }

    public CurrentUser(String...info) {
        username = info[0];
        password = info[1];
        fullName = info[2];
        birthday = info[3];
        phoneNum = info[4];
        driverBool = info[5];
    }

    public CurrentUser() {
        username = "";
        password = "";
        fullName = "";
        birthday = "";
        phoneNum = "";
        driverBool = "";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(fullName);
        dest.writeString(birthday);
        dest.writeString(phoneNum);
        dest.writeString(driverBool);
    }

    public void readFromParcel(Parcel dest) {
        username = dest.readString();
        password = dest.readString();
        fullName = dest.readString();
        birthday = dest.readString();
        phoneNum = dest.readString();
        driverBool = dest.readString();
    }

    public void printAllInfo() { //Test method to ensure object is passed from one Activity to another properly
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Driver Boolean: " + driverBool);
    }
}
