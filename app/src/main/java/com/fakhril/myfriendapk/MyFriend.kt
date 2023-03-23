package com.fakhril.myfriendapk

class MyFriend(
    private var nama: String,
    private var kelamin: String,
    private var email: String,
    private var telp: String,
    private var alamat: String
){
    fun getNama() : String{
        return nama
    }

    fun setNama(nama: String){
        this.nama = nama
    }

    fun getKelamin() : String{
        return kelamin
    }

    fun setKelamin(kelamin: String){
        this.kelamin = kelamin
    }

    fun getEmail() : String{
        return email
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun getAlamat() : String{
        return alamat
    }

    fun setAlamat(alamat: String){
        this.alamat = alamat
    }

    fun getTelp() : String{
        return telp
    }

    fun setTelp(telp: String){
        this.telp = telp
    }
}


