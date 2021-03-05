package com.example.hotfxi

import android.util.Log
import dalvik.system.BaseDexClassLoader
import dalvik.system.PathClassLoader
import java.io.File
import java.io.IOException
import java.lang.reflect.Array
import java.lang.reflect.Field
import java.lang.reflect.Method

class RelectionHelper {
    companion object{
        val TAG = "RelectionHelper"
        fun callPrivateStaticMethod(classLoader:ClassLoader,name:String){

        }
        fun getPrivateField(classLoader: BaseDexClassLoader){
            val deClassLoader  = classLoader.javaClass.superclass
            val classLoaderPathList = deClassLoader.getDeclaredField("pathList")
            classLoaderPathList.isAccessible = true
            val pathListObj = classLoaderPathList.get(classLoader)


            val pathListClass = pathListObj.javaClass





            val definingContextField:Field = pathListClass.getDeclaredField("definingContext")
            definingContextField.isAccessible = true
            val  definingContext = definingContextField.get(pathListObj) as ClassLoader

            val dexElementsField:Field = pathListClass.getDeclaredField("dexElements")
            dexElementsField.isAccessible = true
            val  dexElements = dexElementsField.get(pathListObj)



            val sue  = ArrayList<IOException>()

            val splitDexPathMethod = pathListClass.getDeclaredMethod("splitDexPath", String::class.java)
            splitDexPathMethod.isAccessible  =true
            val listFile = splitDexPathMethod.invoke(pathListObj,HotFix.dexPath) as List<File>

            val metods = pathListClass.declaredMethods
            metods.forEach {
//                Log.d(TAG,"name ${it.name}")
                it.parameterTypes.forEach {
//                    Log.d(TAG,"parameter ${it.name}")
                }
            }
            val  makeElementMehod = pathListClass.getDeclaredMethod("makeDexElements",List::class.java,File::class.java,List::class.java,ClassLoader::class.java)
            makeElementMehod.isAccessible  = true
            val listElement = makeElementMehod.invoke(pathListObj,listFile,null,sue,definingContext)



            Log.d(TAG,"list hotfix Element length ${Array.getLength(listElement)}  origin length = ${Array.getLength(dexElements)}")

            val  newArray = Array.newInstance(Array.get(dexElements,0).javaClass,2)
            Array.set(newArray,0,Array.get(listElement,0))
            Array.set(newArray,1,Array.get(dexElements,0))

            dexElementsField.set(pathListObj,newArray)


            val  dexElements2 = dexElementsField.get(pathListObj)

            Log.d(TAG,"affter replace  Element length ${Array.getLength(dexElements2)}")

        }
    }
}