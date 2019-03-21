package boebot.project.hardwareLayer;

import TI.*;
/**
 *
 * @author Luc Verstraaten
 */
public class Motor {
    
    private static Servo s1 = new Servo(14);
    private static Servo s2 = new Servo(15);
    private static double wait;
    private static int CurrentSpeed;
    
    /**
     * 
     * @param degrees amount of degrees you want to turn
     * @param direction the derection you want to rutn to 1 right 2 left
     */
    public static void turnDegrees(double degrees, int direction)
    {
        s1.update(1500);
        s2.update(1500);
        BoeBot.wait(10);
        CurrentSpeed = 0;
        wait = (degrees/360.0) * 1800;
        Timer t1 = new Timer((int)wait);
        t1.mark();

        if(direction == 1)
        {
            s1.update(1600);
            s2.update(1600);
            CurrentSpeed = 100;
        }
        else if (direction == 2)
        {
            s1.update(1400);
            s2.update(1400);
            CurrentSpeed = 100;
        }
        while(!t1.timeout()){}
        s1.update(1500);
        s2.update(1500);
        CurrentSpeed = 0;
        
    }

    public static void slowItDownForwards()
    {
        System.out.println(s1.getPulseWidth());
        if(s1.getPulseWidth() + 200 > 1500)
        {
            int i = 80;
            while (i  <= CurrentSpeed)
            {
                if(CurrentSpeed > 0){
                    i++;
                    s1.update((1500 - CurrentSpeed) + i); 
                    s2.update((1500 + CurrentSpeed) - i);
                    BoeBot.wait(50);
                } else {
                    i++;
                }
            }
            CurrentSpeed = 0;
        }            
    }

    public static void slowItDownBackwards()
    {
        if(s1.getPulseWidth() - 200 < 1500)
        {
            int i = 80;
            while (i <= CurrentSpeed)
            {
                if(CurrentSpeed > 0){
                    i++;
                    s1.update((1500 + CurrentSpeed) - i); 
                    s2.update((1500 - CurrentSpeed) + i);
                    BoeBot.wait(50);
                } else {
                    i++;
                }
            }
            CurrentSpeed = 0;
        }
    }

    public static void speedItUp()
    {
        int i = 0;
        while (i  <= CurrentSpeed)
        {
            i++;
            s1.update((1300 + CurrentSpeed) - i); 
            s2.update((1700 - CurrentSpeed) + i);
            BoeBot.wait(50);
        }
        CurrentSpeed = 200;
    }

    public static void speedInRev() {
        int i = 0;
        while (i  <= CurrentSpeed)
        {
            i++;
            s1.update((1700 - CurrentSpeed) + i); 
            s2.update((1300 + CurrentSpeed) - i);
            BoeBot.wait(50);
        }
        CurrentSpeed = 200;
    }

    public static void moveForward()
    {
        if(CurrentSpeed == 200){
            s1.update(1300);
            s2.update(1700);
            CurrentSpeed = 200;
        } else {
            speedItUp();
            CurrentSpeed = 200;
        }
    }

    public static void moveBackward()
    {
        if (CurrentSpeed == 200){
            s1.update(1700);
            s2.update(1300);
            CurrentSpeed = 200;
        } else {
            speedInRev();
            CurrentSpeed = 200;
        }
    }
}

