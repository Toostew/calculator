package org.tookaystewie.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class calculatorViewController {
    //controller class for calculatorView.fxml
    //idea: use Shunting Yard algorithm to convert an expression into RPN form
    //I know how to calculate RPN forms so this is appropriate
    //DONE: implement shunting yard algorithm, then RPN parser.
    //TODO: change ints to something larger like long

    @FXML
    private Label resultLabel;

    private int sinceLastOperator = 0;
    private int multiplyer = 10;
    private int currentNumber = 0;
    private LinkedList<String> firstInput = new  LinkedList<>();

    //operator list add
    private HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));




    //number methods
    //one for each number
    public void zero(){
        //if currentNumber is not initialized, do not perform
        if(!(currentNumber == 0)){
            currentNumber *= multiplyer;
            sinceLastOperator++;
            updateDisplay("no");
            if(multiplyer == 1){
                multiplyer = 10;
            }
        }
    }
    public void one(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        //this checks if the multiplyer is still 1, applicable to the very first number
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 1;
        updateDisplay("no");

    }
    public void two(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 2;
        updateDisplay("no");

    }
    public void three(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 3;
        updateDisplay("no");

    }
    public void four(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 4;
        updateDisplay("no");

    }
    public void five(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 5;
        updateDisplay("no");

    }
    public void six(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 6;
        updateDisplay("no");

    }
    public void seven(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 7;
        updateDisplay("no");

    }
    public void eight(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 8;
        updateDisplay("no");

    }
    public void nine(){
        sinceLastOperator++;
        currentNumber *= multiplyer;
        if(multiplyer == 1){
            multiplyer = 10;
        }
        currentNumber += 9;
        updateDisplay("no");


    }

    //operator methods
    //when an operator is added immediately add the currentNumber to the list
    //prevent double inputs of operators
    public void plus(){
        if(sinceLastOperator != 0){
            firstInput.addLast(String.valueOf(currentNumber));
            firstInput.addLast("+");
            resetCurrentNumber();
            updateDisplay("+");
            sinceLastOperator = 0;
        }


    }
    public void minus(){
        if(sinceLastOperator != 0){
            firstInput.addLast(String.valueOf(currentNumber));
            firstInput.addLast("-");
            resetCurrentNumber();
            updateDisplay("-");
            sinceLastOperator = 0;

        }


    }
    public void multiply(){
        if(sinceLastOperator != 0){
            firstInput.addLast(String.valueOf(currentNumber));
            firstInput.addLast("*");
            resetCurrentNumber();
            updateDisplay("*");
            sinceLastOperator = 0;

        }


    }
    public void divide(){
        if(sinceLastOperator != 0){
            firstInput.addLast(String.valueOf(currentNumber));
            firstInput.addLast("/");
            resetCurrentNumber();
            updateDisplay("/");
            sinceLastOperator = 0;

        }


    }

    //equate
    public void equals(){
        if(sinceLastOperator != 0 && currentNumber != 0){
            firstInput.addLast(String.valueOf(currentNumber));
            resetCurrentNumber();
            currentNumber = compute();
            updateDisplay("=");
            firstInput.clear();



        }



        for(int i =0; i < firstInput.size(); i++){
            System.out.println(firstInput.get(i));
        }
    }



    //other methods
    public void resetCurrentNumber(){
        currentNumber = 0;
        multiplyer = 1;
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
                case "=":
                    resultLabel.setText(String.valueOf(compute()));
            }
        }

    }

    public int compute(){
        //converts firstInput into RPN, then equates
        var outputQueue = new LinkedList<String>();
        var operatorStack = new LinkedList<String>();

        for(int i = 0; i < firstInput.size(); i++){
            //numbers are pushed directly into the outputQueue
            if(!operators.contains(firstInput.get(i))){
                outputQueue.add(firstInput.get(i));
            }
            //operators are added here based on scrutiny
            else {
                while(!operatorStack.isEmpty() && precedence(operatorStack.getLast()) >= precedence(firstInput.get(i))){
                    outputQueue.add(operatorStack.removeLast()); //remove until no longer precedence
                }
                operatorStack.addLast(firstInput.get(i));
            }
        }
        //pop any remaining operators
        while(!operatorStack.isEmpty()){
            outputQueue.add(operatorStack.removeLast());
        }


        //evaluate RPN in outputQueue and calculate
        //operatorStack is now re-used to calculate
        operatorStack.clear();
        for(int i = 0; i < outputQueue.size(); i++){
            if(!operators.contains(outputQueue.get(i))){
                operatorStack.addLast(outputQueue.get(i));
            }
            else if(operators.contains(outputQueue.get(i))){
                int secondNum = Integer.parseInt(operatorStack.removeLast());
                int firstNum = Integer.parseInt(operatorStack.removeLast());
                int result = 0;

                switch(outputQueue.get(i)){
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;

                    case "*":
                        result = firstNum * secondNum;
                        break;

                    case "/":
                        result = firstNum / secondNum;
                        break;

                }
                operatorStack.addLast(String.valueOf(result));
            }
        }
        return Integer.parseInt(operatorStack.getLast());


    }

    public int precedence(String operator){
        switch (operator){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
        }
        return 0; //this is a formality, logically this is never reached
    }


}
