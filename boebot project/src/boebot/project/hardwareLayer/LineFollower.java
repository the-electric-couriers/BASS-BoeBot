package boebot.project.hardwareLayer;

import TI.*;
import java.util.*;
/**
 *
 * @author Luc Verstraaten
 */
public class LineFollower {
    private int SensorL = 0;
    private int SensorM = 0;
    private int SensorR = 0;

    private boolean lineLeft;
    private boolean lineMiddle;
    private boolean lineRight;
    private ArrayList LineList;
    private int DetectionValue = 1300; //wanneer deze waarde wordt overschreven ziet hij zwart
    
    public LineFollower()
    {
    }
    
    public int highest(int Number1, int Number2, int Number3){
        int Highest = 0;
        if ((Number1 > Number2) && (Number1 > Number3)){
            Highest = Number1;
        }
        if ((Number2 > Number1) && (Number2 > Number3)){
            Highest = Number1;
        }
        if ((Number3 > Number1) && (Number3 > Number2)){
            Highest = Number1;
        }
        
        return Highest;
    }
    
    public int lowest(int Number1, int Number2, int Number3){
        int Lowest = 0;
        if ((Number1 < Number2) && (Number1 < Number3)){
            Lowest = Number1;
        }
        if ((Number2 < Number1) && (Number2 < Number3)){
            Lowest = Number1;
        }
        if ((Number3 < Number1) && (Number3 < Number2)){
            Lowest = Number1;
        }
        
        return Lowest;
    }

    public int getSensorL() {
        return SensorL;
    }

    public void setSensorL(int SensorL) {
        this.SensorL = SensorL;
    }

    public int getSensorM() {
        return SensorM;
    }

    public void setSensorM(int SensorM) {
        this.SensorM = SensorM;
    }

    public int getSensorR() {
        return SensorR;
    }

    public void setSensorR(int SensorR) {
        this.SensorR = SensorR;
    }


    public boolean lineLeft()
    {
        lineLeft = false;
        if (SensorL >= DetectionValue)
            lineLeft = true;

        return lineLeft;
    }

    public boolean lineRight()
    {
        lineRight = false;
        if (SensorR >= DetectionValue)
            lineRight = true;

        return lineRight;
    }
    
    public boolean lineMiddle()
    {
        lineMiddle = false;
        if (SensorM >= DetectionValue)
            lineMiddle = true;

        return lineMiddle;
    }
}
