package org.example;

import java.util.Scanner;

public class Calculator {
    public void run(){
        while(true) {
            Calculate userCalculate = new Calculate();
            System.out.println(userCalculate.calculate(userInput()));
        }
    }
    public String userInput(){
        System.out.println("Type in your calculation then press enter");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
