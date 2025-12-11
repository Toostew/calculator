package org.tookaystewie.controllers;

import java.util.LinkedList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class calculatorViewController {
    //controller class for calculatorView.fxml
    //idea: use Shunting Yard algorithm to convert an expression into RPN form
    //I know how to calculate RPN forms so this is appropriate

    @FXML
    private Label resultLabel;

    private int multiplyer = 10;
    private int currentNumber = 0;
    private LinkedList<String> firstInput = new  LinkedList<>();
    private LinkedList<String> output = new  LinkedList<String>();


    //number methods
    //one for each number
    public void zero(){
        //if currentNumber is not initialized, do not perform
        if(!(currentNumber == 0)){
            currentNumber *= multiplyer;
            updateDisplay("no");
            if(multiplyer == 1){
                multiplyer = 10;
            }
        }
    }
    public void one(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 1;
        updateDisplay("no");

    }
    public void two(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 2;
        updateDisplay("no");

    }
    public void three(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 3;
        updateDisplay("no");

    }
    public void four(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 4;
        updateDisplay("no");

    }
    public void five(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 5;
        updateDisplay("no");

    }
    public void six(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 6;
        updateDisplay("no");

    }
    public void seven(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 7;
        updateDisplay("no");

    }
    public void eight(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 8;
        updateDisplay("no");

    }
    public void nine(){
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 9;
        updateDisplay("no");


    }

    //operator methods
    //when an operator is added immediately add the currentNumber to the list
    public void plus(){
        firstInput.addLast(String.valueOf(currentNumber));
        firstInput.addLast("+");
        resetCurrentNumber();
        updateDisplay("+");

    }
    public void minus(){
        firstInput.addLast(String.valueOf(currentNumber));
        firstInput.addLast("-");
        resetCurrentNumber();
        updateDisplay("-");

    }
    public void multiply(){
        firstInput.addLast(String.valueOf(currentNumber));
        firstInput.addLast("*");
        resetCurrentNumber();
        updateDisplay("*");

    }
    public void divide(){
        firstInput.addLast(String.valueOf(currentNumber));
        firstInput.addLast("/");
        resetCurrentNumber();
        updateDisplay("/");

    }

    //equate
    public void equals(){
        firstInput.addLast(String.valueOf(currentNumber));
        for(int i =0; i < firstInput.size(); i++){
            System.out.println(firstInput.get(i));
        }
    }
    public void updateDisplay(String value){
        if(value.equals("no")){
            resultLabel.setText(String.valueOf(currentNumber));
        }else {
            switch (value){
                case "+":
                    resultLabel.setText("+");
                    break;
                case "-":
                    resultLabel.setText("-");
                    break;
                case "*":
                    resultLabel.setText("*");
                    break;
                case "/":
                    resultLabel.setText("/");
                    break;
            }
        }

    }


    //other methods
    public void resetCurrentNumber(){
        currentNumber = 0;
        multiplyer = 1;
    }

}
