package com.mitchellkopczyk.calculator;

public class SimpleExpression {
    private Integer operand1, operand2, result;
    private String operator;
    public  SimpleExpression(){
        operand1 = 0;
        operand2 = 0;
        result = 0;
        operator = "+";
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public Integer getResult(){
        computeValue();
        return result;
    }

    private void computeValue(){
        result = 0;
        if(operator.contentEquals("+"))
            result = operand1 + operand2;
        else if (operator.contentEquals("-"))
            result = operand1 - operand2;
        else if (operator.contentEquals("X"))
            result = operand1 * operand2;
        else if (operator.contentEquals("/") && operand2 != 0)
            result = operand1 / operand2;
        else
            result = operand1 % operand2;
    }

    public void clearOperands(){
        operand2 = 0;
        operand1 = 0;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
