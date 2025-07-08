package com.example.calculator.model;


import jakarta.validation.constraints.NotNull;
public class CalculationRequest {

    @NotNull
    private Double operand1;

    @NotNull
    private Double operand2;

    @NotNull
    private String operation;

    public CalculationRequest(){}

    public CalculationRequest(Double operand1, Double operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
