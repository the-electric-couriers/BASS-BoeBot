/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boebot.project.controllayer;

/**
 *
 * @author Luc Verstraaten
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RoutePlanner extends JFrame
{
    private int width = 5;
    private int height = 4;
    Intersection field[][] = new Intersection[height][width]; 
    JPanel routePanel;
    ArrayList<Coordinates> route = new ArrayList();
    BlueTooth bt;
    String command = "";
    int buttonsPressed;
    public RoutePlanner(String port){
        super("Route Planner");
        bt = new BlueTooth(port);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(new Dimension(500, 475));
        setResizable(false);

        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        routePanel = new JPanel(new GridLayout(height, width));

        setContentPane(contentPane);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(routePanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("Cancel");
        JButton sendButton = new JButton("Send");
        topPanel.add(resetButton);
        topPanel.add(sendButton);

        reset();
        resetButton.addActionListener(e ->
            {
                routePanel.removeAll();
                routePanel.revalidate();
                buttonsPressed = 0;
                route.clear();
                reset();
            });
        sendButton.addActionListener(e ->
            {
                routePanel.removeAll();
                routePanel.revalidate();
                setCommand();
                sendCommand();
                buttonsPressed = 0;
                route.clear();
                reset();
            });
        setVisible(true);
    }

    private void reset(){
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                final int xx = x;
                final int yy = y;
                field[y][x] = new Intersection(new JButton(""));               
                routePanel.add(field[y][x].getButton());
                field[y][x].getButton().setBorder(BorderFactory.createEmptyBorder());
                field[y][x].getButton().setIcon(new ImageIcon("ButtonTextureNormal.jpg"));
                field[y][x].getButton().addActionListener(e -> clickPosition(xx, yy));
            }
        }
    }

    private void clickPosition(int x, int y){
        route.add(new Coordinates(x, y));
        if(buttonsPressed < 1)field[y][x].getButton().setIcon(new ImageIcon("ButtonTextureStart.jpg"));
        else if(buttonsPressed < 2)field[y][x].getButton().setIcon(new ImageIcon("ButtonTextureFinish.jpg"));
        buttonsPressed++;
    }

    public void setCommand(){
        int beginX = route.get(0).getX();
        int beginY = route.get(0).getY();
        int endX = route.get(1).getX();
        int endY = route.get(1).getY();

        int amountHorizontal = endX - beginX;
        int amountVertical = endY - beginY;
        for(int i = 0; i < Math.abs(amountHorizontal); i++){
            if(i == 0){
                if(amountHorizontal <= -1){
                    command += "tw";
                }
                else{
                    command += "w";
                }
            }
            else{
                command += "w";
            }
        }
        for(int i = 0; i < Math.abs(amountVertical); i++){
            if(amountHorizontal <= -1){
                if(i == 0){
                    if(amountVertical <= -1){
                        command += "dw";
                    }
                    else{
                        command += "aw";
                    }
                }
                else{
                    command += "w";
                }
            }
            else if(i == 0){
                if(amountVertical <= -1){
                    command += "aw";
                }
                else{
                    command += "dw";
                }
            }
            else{
                command += "w";
            }
        }
        command += "z";
    }

    public void sendCommand(){
        bt.sendCommand(command);
        System.out.println(command);
        command = "";
    }
}

