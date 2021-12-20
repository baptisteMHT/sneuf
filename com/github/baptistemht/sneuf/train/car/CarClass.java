package com.github.baptistemht.sneuf.train.car;

public enum CarClass {
    FIRST,SECOND;

    public static CarClass fromString(String s){
        for(CarClass c : CarClass.values()){
            if(c.toString().equalsIgnoreCase(s)) return c;
        }
        return null;
    }
}
