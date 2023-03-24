package com.fakhril.myfriendapk

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyFriendDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friend: MyFriend)

    @Query("Select * FROM MyFriend ORDER BY nama ASC")
    fun getAllData(): LiveData<List<MyFriend>>
}