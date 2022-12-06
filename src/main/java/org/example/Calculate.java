package org.example;

public class Calculate {
    public double calculate(String input) {
        double answer;
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
        StringBuilder equation = new StringBuilder(input);
        String[] inputArr = makeDecimalArray(input);
        if (equation.toString().isBlank()){
            equation = new StringBuilder("0");
        }
        else if(operator.equals("+")||operator.equals("-")||operator.equals("/")||operator.equals("*")||operator.equals("^")){
            for (int i = 0; i < inputArr.length ; i++) {
                if(inputArr[i].equals(operator)){
                    equation = new StringBuilder(inputArr[i - 1] + inputArr[i] + inputArr[i + 1]);
                }
            }
        } else if (operator.equals("(")) {
            equation = new StringBuilder();
            int openingBrackets =0;
            int closingBrackets =0;
            for (String s : inputArr) {
                if (s.equals(operator) && openingBrackets != closingBrackets) {
                    openingBrackets++;
                    equation.append(s);
                }
                if (s.equals(")") && openingBrackets != closingBrackets) {
                    closingBrackets++;
                    equation.append(s);
                }
            }

        }
        return equation.toString();
    }
    public String[] makeDecimalArray(String input){
        String[] inputArr = new String[equationLength(input)];
        int i =0;
        boolean operator = false;
        for (int j = 0; j < input.length(); j++) {
            if(operator){
                i++;
                if(!inputArr[i-1].contains(".")){
                inputArr[i-1] = inputArr[i-1]+". ";
             }
                else {
                inputArr[i]=inputArr[i]+input.split("")[j];
                }
            }
            operator =currentCharOperator(input.split("")[j]);///input current character
        }
        return inputArr;
    }

    private boolean currentCharOperator(String s) {
        return true;
    }

    public int equationLength(String equation){
        ///count number of operators then *2+1
        return 3;
    }
    public double BODMAS(String equation){
        String calculation = equation;
        if(equation.contains("(")){
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"(")));
    } else if (equation.contains("^")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"^")));
    } else if (equation.contains("/")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"/")));
        }
    else if (equation.contains("*")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"*")));
        }
    else if (equation.contains("+")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"+")));
        }
    else if (equation.contains("-")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"-")));
        }
        return Double.parseDouble(calculation);
    }


    public double operations(String input){
        double answer=0;
        double num0= Double.parseDouble((input.split(" ")[0]));
        double num1=Double.parseDouble((input.split(" ")[2]));
        String operator = input.split(" ")[1];
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
