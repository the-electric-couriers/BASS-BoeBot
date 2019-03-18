package boebot.project.hardwareLayer;

import TI.*;
/**
 *
 * @author Luc Verstraaten
 */
public class Sonar {

    public static void Sonar() {

    }

    public static int pulseEcho() {
        int pulse;
        BoeBot.digitalWrite(1, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(1, false);
        pulse = BoeBot.pulseIn(2, true, 10000);
        return (pulse / 58);
    }
}
