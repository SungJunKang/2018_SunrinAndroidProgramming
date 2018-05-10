package com.example.sunrin.singerlist;

public class SingerItem {
    String name;
    String tel;
    int memberCount;
    public int imageId;

    SingerItem(String name, String tel, int memberCount, int imageId) {
        this.name = name;
        this.tel = tel;
        this.memberCount= memberCount;
        this.imageId = imageId;
    }

    SingerItem(String name) {
        this.name = name;
    }
}
