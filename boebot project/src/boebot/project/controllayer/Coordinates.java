/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boebot.project.controllayer;

/**
 *
 * @author sjors
 */
public class Coordinates
{
    int x,y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
 
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}

