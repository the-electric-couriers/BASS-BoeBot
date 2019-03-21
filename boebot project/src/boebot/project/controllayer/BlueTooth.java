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
import TI.*;
import jssc.SerialPort;
import jssc.SerialPortException;
import java.util.*;
/**
 * Write a description of class BlueTooth here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueTooth
{
    public SerialPort serialPort;
    ArrayList<Coordinates> route = new ArrayList();
    public BlueTooth(String port){
        serialPort = new SerialPort(port);
        openBluetoothPort();
    }

    public void openBluetoothPort(){
        try{
            serialPort.openPort();
            serialPort.setParams(   SerialPort.BAUDRATE_115200, 
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        }
        catch(SerialPortException ex){
        }
    }

    public void sendCommand(String command){
        try{
            serialPort.writeString(command);
            byte[] buffer = serialPort.readBytes(command.length());
            //for(int count = 0; count < 10; count++)System.out.print(buffer[count] + "-");
            serialPort.closePort();
            //System.out.println(command);
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
    }
}