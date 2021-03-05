package com.example.hotfxi

import android.app.Application
import dalvik.system.BaseDexClassLoader

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        RelectionHelper.getPrivateField(classLoader as BaseDexClassLoader)
    }
}