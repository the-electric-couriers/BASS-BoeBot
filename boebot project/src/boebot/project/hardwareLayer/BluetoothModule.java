package boebot.project.hardwareLayer;
import TI.*;
/**
 *
 * @author Luc Verstraaten
 */
public class BluetoothModule {
        private static int command;
    public BluetoothModule()
    {

    }
    static SerialConnection conn = new SerialConnection(115200);
    public static int ReadBluetooth(){
        if(conn.available() > 0){
            command = conn.readByte();
        }
        
        return command;
    }
}
