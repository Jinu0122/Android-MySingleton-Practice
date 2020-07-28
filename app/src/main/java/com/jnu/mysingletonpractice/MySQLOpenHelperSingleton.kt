package com.jnu.mysingletonpractice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLOpenHelperSingleton private constructor(context: Context): SQLiteOpenHelper(context,"MyDB",null,1 ) {

    // 오브젝트를 클래스 안에있는애들을 지정할 때 사용한다.
    companion object{
        const val TAG: String = "로그"

        // 자기자신 변수 선언
        // Volatile 를 사용하게 되면 cpu 의 캐시를 거치지않고 바로 메인메모리의 항상 최신값을 가져올 수 있다.
        @Volatile private var instance: MySQLOpenHelperSingleton? = null

        //  자기 자신 가져오기
        fun getInstance(context: Context): MySQLOpenHelperSingleton =
            instance ?: synchronized(this){
                instance ?: MySQLOpenHelperSingleton(context).also {
                    instance = it
                }
            }
    }



    override fun onCreate(p0: SQLiteDatabase?) {

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}