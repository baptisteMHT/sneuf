package com.github.baptistemht.sneuf.train;

public enum Classe {
    PREMIERE,SECONDE;

    public static Classe fromString(String s){
        for(Classe c : Classe.values()){
            if(c.toString().equalsIgnoreCase(s)) return c;
        }
        return null;
    }
}
