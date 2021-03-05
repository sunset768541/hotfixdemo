package com.example.hotfxi

import dalvik.system.BaseDexClassLoader

class HotFix {
    companion object{
        val  dexPath = "/sdcard/bugf/bugfix.dex"
        fun init(){
          val load:ClassLoader  =  javaClass.classLoader

        }
    }
}