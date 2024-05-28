package com.demoqa.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserBuilder {

    public static User createSignUpUser() {
        return new User("a", "a", "89888888888", getRandomUsername()
                , getRandomMail(), "QWErty12");
    }

    public static User createUserWithMinimalCredentials() {
        return new User("a", "a", "89888888888", "a"
                , "a@a.com", "QWErty12");
    }

    public static User createUserWithMaximumCredentials() {
        return new User(getSimpleString(64), getSimpleString(64), "+79888888888"
                , getSimpleString(64), getSimpleString(58) + "@a.com"
                , getSimpleString(62) + "A" + 1);
    }

    public static User createUserWithNewCredentials() {
        return new User(getSimpleString(32), getSimpleString(32), "+79888888888"
                , getSimpleString(32), getSimpleString(29) + "@a.com"
                , getSimpleString(31) + "A" + 1);
    }

    public static String getSimpleString(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append("a");
        }
        return str.toString();
    }

    public static String getRandomMail() {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);
        return "randomemail" + todayDate + "@gmail.com";
    }

    public static String getRandomUsername() {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);
        return "randomusername" + todayDate;
    }
}
