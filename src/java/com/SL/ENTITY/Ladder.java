package com.SL.ENTITY;

import java.util.Hashtable;

public class Ladder {

    Hashtable<Integer,Integer> ht = null;
    int playerCount = 0;
    
    public Ladder(){
        ht = new Hashtable<Integer,Integer>();
        ht.put(8,31);
        ht.put(15,97);
        ht.put(42,81);
        ht.put(66,87);
    }
    
    public int checkLadderFoot(int pcount) {
        
        if(ht.containsKey(pcount)){
            playerCount = ht.get(pcount);
        }
        else{
            playerCount = pcount;
        }
        
        return playerCount;
    }
}
