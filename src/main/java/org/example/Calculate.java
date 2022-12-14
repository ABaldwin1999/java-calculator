package org.example;

public class Calculate {///fix brackets

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
        StringBuilder equation = new StringBuilder();/////sort this out
        int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
                char c = input.charAt(i);
                if((input.charAt(i) == c )&& (c=='+'||c==('-')||c=='/'||c=='*'||c=='^'||c==' ')) {
                    equation.append(c);
                    while (i < inputLength-1 && input.charAt(i+1) == c) {
                        ++i;
                    }
                }
                else{
                    equation.append(c);
            }
            }
            return equation.toString();
    }

    private String getEquation(String input,String operator) {
        StringBuilder equation = new StringBuilder("");
        String[] inputArr = makeDecimalArray(input);
        if (input.toString().isBlank()){
            equation = new StringBuilder("0");
        }
        else if(operator.equals("+")||operator.equals("-")||operator.equals("/")||operator.equals("*")||operator.equals("^")){
            for (int i = 0; i < inputArr.length ; i++) {
                System.out.println(inputArr[i].equals(operator));
                if(inputArr[i].replace(" ","").equals(operator)){
                    System.out.println(inputArr[i - 1] +","+ inputArr[i] +","+ inputArr[i + 1]);
                    return inputArr[i - 1] + inputArr[i] + inputArr[i + 1];
                }
            }
        } else if (operator.equals("(")) {
            int openingBrackets = 1;
            int closingBrackets = 0;
            for (String s : inputArr) {
                if (s.equals(operator) && openingBrackets != closingBrackets) {////make if stament for the true/false of being inside brackets
                    openingBrackets++;
                    equation.append(s);
                }
                if (s.equals(")") && openingBrackets != closingBrackets) {
                    closingBrackets++;
                    equation.append(s);
                }
            }
        }
        else{
            for (String s : inputArr){
                equation.append(s);
            }
        }
        return equation.toString();
    }
    public String[] makeDecimalArray(String input){
        String[] inputArr = new String[equationLength(input)];
        int i =0;
        for (int j = 0; j < input.length(); j++) {
            boolean operator =currentCharOperator(input.split("")[j]);
            if(operator){
                i++;
                if(!inputArr[i-1].contains(".")){
                inputArr[i-1] = inputArr[i-1]+". ";
             }
                inputArr[i]=input.split("")[j]+" ";
                i++;
            }
            else if(input.split("")[j].equals("(") || input.split("")[j].equals(")")) {
                i++;
                inputArr[i]=input.split("")[j]+" ";
                i++;
            }
            else {
                if(inputArr[i]==null){
                    inputArr[i] = input.split("")[j];
                }
                else {
                    inputArr[i] = inputArr[i] + input.split("")[j];
                }
            }
        }
        if(!inputArr[inputArr.length-1].contains(".")){
            inputArr[inputArr.length-1] = inputArr[inputArr.length-1]+". ";
        }
        return inputArr;
    }

    private boolean currentCharOperator(String operator) {
        return (operator.equals("+")||operator.equals("-")||operator.equals("/")||operator.equals("*")||operator.equals("^"));
    }

    public int equationLength(String equation){
        int i=0;
        int k=0;
        for (int j = 0; j < equation.length(); j++) {
            if(equation.split("")[j].equals("*")||equation.split("")[j].equals("+")||equation.split("")[j].equals("-")||equation.split("")[j].equals("/")){
                i++;
            }
            else if(equation.split("")[j].equals("(") || equation.split("")[j].equals(")")){
                k++;
            }
        }
        return k+((i*2)+1);
    }
    public double BODMAS(String equation){
        String calculation = equation;
        if(equation.contains("(")){
            calculation = calculation.replace(getEquation(calculation,"("),""+calculate(getEquation(calculation,"(")));
    } else if (equation.contains("^")) {
            calculation = calculation.replace(getEquation(calculation,"^"),""+calculate(getEquation(calculation,"^")));
    } else if (equation.contains("/")) {
            calculation = calculation.replace(getEquation(calculation,"/"),""+calculate(getEquation(calculation,"/")));
    }else if (equation.contains("*")) {
            calculation = calculation.replace(getEquation(calculation,"*"),""+calculate(getEquation(calculation,"*")));
    }else if (equation.contains("+")) {
            calculation = calculation.replace(getEquation(calculation,"+"),""+calculate(getEquation(calculation,"+")));
        }
    else if (equation.contains("-")) {
            calculation = calculation.replace(getEquation(calculation,"-"),""+calculate(getEquation(calculation,"-")));
        }
        return Double.parseDouble(calculation);
    }


    public double operations(String input){
        double answer=0;
        input = removeDuplicateOrSuperfluousOperators(input);
        System.out.println((input));
        System.out.println((input.split(" ").length));
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
        System.out.println(answer);
        return answer;
    }

}
