/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boebot.project.communicationLayer;

import TI.*;
import boebot.project.hardwareLayer.*;
import java.util.ArrayList;

/**
 *
 * @author Luc Verstraaten
 */

public class Detectie {

    private LineFollower LineSensors = new LineFollower();
    private BluetoothModule btModule = new BluetoothModule();
    private Boolean ldRight;
    private Boolean ldMiddel;
    private Boolean ldLeft;
    private static Sonar sonar = new Sonar();
    private static int command;

    public Detectie() {

    }

    public static boolean obstacle(int distance) {
        if (distance <= sonar.pulseEcho()) {
            return true;
        }
        return false;
    }

    public void readLinesensors() {


        LineSensors.setSensorL(BoeBot.analogRead(1));
        LineSensors.setSensorM(BoeBot.analogRead(2));
        LineSensors.setSensorR(BoeBot.analogRead(3));

        ldRight = LineSensors.lineLeft();
        ldMiddel = LineSensors.lineMiddle();
        ldLeft = LineSensors.lineRight();
    }

    public static int ReadBluetooth() {
        command = BluetoothModule.ReadBluetooth();
        if ((command > 0) && (command < 100)) {

        } else {
            command = 0;
        }
        return command;
    }

    public Boolean getLdMiddel() {
        return ldMiddel;
    }

    public Boolean getLdLeft() {
        return ldLeft;
    }

    public Boolean getLdRight() {
        return ldRight;
    }
    
}
