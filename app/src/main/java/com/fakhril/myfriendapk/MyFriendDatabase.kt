package com.fakhril.myfriendapk

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyFriend::class], version = 1)
abstract class MyFriendDatabase:  RoomDatabase(){
    abstract fun myFriendDao(): MyFriendDao

    companion object{
        var INSTANCE: MyFriendDatabase? = null

        fun getAppDatabase(context: Context): MyFriendDatabase? {
            if (INSTANCE == null) {
                synchronized(MyFriendDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyFriendDatabase::class.java,
                        "MyFriendApkDB"
                    ).build()
                }
            }
            return INSTANCE
        }
        fun destroyDabase(){
            INSTANCE = null
        }
    }
}