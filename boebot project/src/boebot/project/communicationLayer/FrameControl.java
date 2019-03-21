/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boebot.project.communicationLayer;

import TI.*;
import boebot.project.hardwareLayer.*;

/**
 *
 * @author Luc Verstraaten
 */
public class FrameControl {

    private static Servo s1 = new Servo(14);
    private static Servo s2 = new Servo(15);
    private static Motor mt = new Motor();
    private static int currentSpeed;

    public static void Drive() {
        currentSpeed = 0;
    }

    public static void TurnSeconds(String Direction, int time) {
        if (Direction.equals("Left")) {
            s1.update(1450);
            s2.update(1450);
            currentSpeed = 200;
        }

        if (Direction.equals("Right")) {
            s1.update(1550);
            s2.update(1550);
            currentSpeed = 200;
        }

        if (Direction.equals("Foreward")) {
            s1.update(1410);
            s2.update(1590);
            currentSpeed = 200;
        }

        if (Direction.equals("Backward")) {
            s1.update(1700);
            s2.update(1300);
            currentSpeed = 200;
        }
    }

    public static void forward() {
        mt.moveForward();
    }

    public static void backwards() {
        mt.moveBackward();
    }

    public static void toTheRight() {
        mt.turnDegrees(90, 1);
        currentSpeed = 0;
    }

    public static void toTheLeft() {
        mt.turnDegrees(90, 2);
        currentSpeed = 0;
    }

    public static void _45_DegreesToTheLeft() {
        mt.turnDegrees(45, 2);
        currentSpeed = 0;
    }

    public static void _45_DegreesToTheRight() {
        mt.turnDegrees(45, 1);
        currentSpeed = 0;
    }

    public static void _135_DegreesToTheLeft() {
        mt.turnDegrees(135, 1);
        currentSpeed = 0;
    }

    public static void _135_DegreesToTheRight() {
        mt.turnDegrees(135, 1);
        currentSpeed = 0;
    }

    public static void _180_DegreesToTheRight() {
        mt.turnDegrees(180, 1);
        currentSpeed = 0;
    }

    public static void emergencyBrake() {
        s1.update(1500);
        s2.update(1500);
        currentSpeed = 0;
    }

    public static void slowDownF() {
        mt.slowItDownForwards();
    }

    public static void slowDownB() {
        mt.slowItDownBackwards();
    }

    public static void speedUp() {
        mt.speedItUp();
    }

    public static void speedReverse() {
        mt.speedInRev();
    }

    public static void achtje() {
        forwardLong();
        toTheRight();
        forwardShort();
        toTheLeft();
        forwardLong();
        toTheLeft();
        forwardShort();
        toTheLeft();
        forwardLong();
        toTheLeft();
        forwardShort();
        toTheRight();
        forwardLong();
        toTheRight();
        forwardShort();
        emergencyBrake();
    }

    public static void forwardShort() {
        if (Detectie.obstacle(5)) {
            Timer timer = new Timer(1250);
            timer.mark();
            while (!timer.timeout()) {
                forward();
            }
        }
    }

    public static void forwardLong() {
        if (Detectie.obstacle(5)) {
            Timer timer = new Timer(2500);
            timer.mark();
            while (!timer.timeout()) {
                forward();
            }
        }
    }

}
