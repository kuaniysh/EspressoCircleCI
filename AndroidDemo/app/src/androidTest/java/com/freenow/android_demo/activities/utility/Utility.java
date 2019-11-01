package com.freenow.android_demo.activities.utility;

import android.util.Log;

import com.freenow.android_demo.models.Driver;

import java.util.ArrayList;

public class Utility {

    public static Driver getDriverByName(ArrayList<Driver> drivers, String name){

        try{
            return drivers.stream().filter(d -> name.equals(d.getName())).findFirst().get();
        }
        catch(Exception ex){
            Log.i("Test", "Error when getting driver in the driver list");
        }

        return null;

    }



}
