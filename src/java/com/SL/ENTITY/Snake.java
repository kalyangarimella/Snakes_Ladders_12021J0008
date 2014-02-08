/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SL.ENTITY;

import java.util.Hashtable;

public class Snake {

    Hashtable<Integer,Integer> ht = null;
    int playerCount = 0;
    
    public Snake(){
        ht = new Hashtable<Integer,Integer>();
        ht.put(24,1);
        ht.put(55,13);
        ht.put(71,29);
        ht.put(88,67);
        ht.put(99,6);
    }
    
    public int checkSnakeHead(int pcount) {
        
        if(ht.containsKey(pcount)){
           playerCount = ht.get(pcount);
        }
        else{
           playerCount = pcount;
        }

        return playerCount;
    }
}
