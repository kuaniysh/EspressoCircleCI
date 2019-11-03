package com.freenow.android_demo.activities.utility;

import android.util.Log;

import com.freenow.android_demo.models.Driver;

import java.util.ArrayList;


public class Utility {

    public static Driver getDriverByName(ArrayList<Driver> drivers, String name){

        try{
            Driver driver = null;
            for(int i = 0; i< drivers.size(); i++){
                driver = drivers.get(i);
                if(driver.getName().equals(name)){
                    break;
                }
            }
            return driver;
        }
        catch(Exception ex){
            Log.i("Test", "Error when getting driver in the driver list");
        }

        return null;

    }



}
