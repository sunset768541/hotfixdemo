package com.example.hotfxi;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dalvik.system.BaseDexClassLoader;

public class Reflhep {

    public static void getPrivateStatic(BaseDexClassLoader dexClassLoader){
        Log.d("Reflhep",""+dexClassLoader);
        Class cla = dexClassLoader.getClass();
        Method[] fields= cla.getDeclaredMethods();
        Log.d("Reflhep","或读取的 "+fields.length);
        for (Method field:fields){
            Log.d("Reflhep",field.getName());
        }
        hhh(dexClassLoader);
    }

    public static void hhh(BaseDexClassLoader dexClassLoader){
        try {
//            Class<?> obj = Class.forName("dalvik.system.BaseDexClassLoader");
            Class<?> obj = ((BaseDexClassLoader)dexClassLoader).getClass();
            Class<?> pobj = obj.getSuperclass();
            Field f = pobj.getDeclaredField("pathList");
            f.setAccessible(true);

        }catch (Exception e){

        }

    }
}
