package com.kayak.exercise.one;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean validCommand = false;
        while(!validCommand){
            try{
                System.out.println("Enter command: ");
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();
                Robot robot = new Robot();
                robot.setCommand(command);
                validCommand = true;
                robot.move();
                String finalPosition = robot.getFinalPosition();
                System.out.println(finalPosition);
            }catch(IllegalArgumentException ex){
                System.out.println("Please enter a valid command(String containing characters 'L','R' and 'F').");
            }
        }

    }
}
