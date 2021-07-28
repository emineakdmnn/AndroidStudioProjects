package com.emineakduman.retrofitjava.model;

import com.google.gson.annotations.SerializedName;

public class CryptoModel {
    @SerializedName("currency") //gelecek olan datayı direk okumak için Json daki isimle aynı isim olucak
   public String currency;
    @SerializedName("price")
    public  String price;
}
