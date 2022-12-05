package org.example;

public class Calculate {
    public double calculate(String input) {
        double answer=0;
        String newInput = prepareFrontOfEquation(input);
        String equation = getEquation(removeDuplicateOrSuperfluousOperators(newInput),"");
        if(equationLength(equation) == 3){
            answer = operations(equation);
        }
        else{
            answer =BODMAS(equation);
        }

        return answer;
    }

    private String prepareFrontOfEquation(String input){
        String firstChar = input.split("")[0];
        if(firstChar.equals("-")){
            return "0"+input;
        }
        return input;
    }

    private String removeDuplicateOrSuperfluousOperators(String input){
        String equation =input;
        for (int i = 0; i < input.length(); i++) {

        }
        return equation;
    }

    private String getEquation(String input,String operator) {
        String equation = input;
        if (equation.isBlank()){
            equation="0";
        }
        else if(operator.equals("+")||operator.equals("-")||operator.equals("/")||operator.equals("*")||operator.equals("^")){
            String[] inputArr = makeDecimalArray(input);
            for (int i = 0; i < inputArr.length ; i++) {
                if(inputArr[i].equals(operator)){
                    equation = inputArr[i-1]+inputArr[i]+inputArr[i+1];
                }
            }
        } else if (operator.equals("(")) {
            ///check there are no more brackets inside
            //check number even and odd brackets the same
        }
        return equation;
    }
    public String[] makeDecimalArray(String input){
        String[] inputArr;
        int i =0;
        boolean operator = currentCharOperator();
        for (int j = 0; j < input.length(); j++) {
            if(operator){
                if(!inputArr[i-1].contains(".")){
                inputArr[i-1] = inputArr[i-1]+".";
             }
            }
            operator =currentCharOperator();///input current character
        }
        return inputArr;
    }
    public int equationLength(String equation){
        ///count number of operators then *2+1
        return 3;
    }
    public double BODMAS(String equation){
        double answer=0;
        String calculation = equation;
        ///most of this can be boiled down to one repeating function
        equation.indexOf("(");
        if(equation.contains("(")){

        //calculation = calculation.replace(,);
    } else if (equation.contains("^")) {
            calculation.substring(FindNumberIndexToTheLeftOfTheOperator("^"), FindNumberIndexToTheRightOfTheOperator("^"));


            //calculation = calculation.replace(,);
    } else if (equation.contains("/")) {
            //calculation = calculation.replace(,);
        }
    else if (equation.contains("*")) {
            //calculation = calculation.replace(,);
        }
    else if (equation.contains("+")) {
            //calculation = calculation.replace(,);
        }
    else if (equation.contains("-")) {
            //calculation = calculation.replace(,);
        }
        return 0;
    }

    private int FindNumberIndexToTheLeftOfTheOperator(String calculation) {
        for (int i = calculation.length(); i > 0; i--) {
            if(calculation.split("")[i].equals("^")){
                return i+1;
            }
        }
        return 0;
    }
    private int FindNumberIndexToTheRightOfTheOperator(String calculation) {
        for (int i = 0; i <calculation.length(); i++) {
            if(calculation.split("")[i].equals("^")){
                return i;
            }
        }
        return calculation.length()+1;
    }
    public double operations(String input){
        double answer =0.;
        double num0=1.;
        double num1=1.;
        String operator = "";
        switch(operator) {
            case "+":
                answer = num0 + num1;
                break;
            case "-":
                answer = num0 - num1;
                break;
            case "/":
                answer = num0 / num1;
                break;
            case "*":
                answer = num0 * num1;
                break;
            case "^":
                answer = Math.pow(num0,num1);
                break;
        }
        return answer;
    }

}
