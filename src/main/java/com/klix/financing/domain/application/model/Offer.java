package com.klix.financing.domain.application.model;

import java.time.LocalDate;

public class Offer {
    private String bankName;

    private LocalDate firstRepayment;

    private Double monthlyPayment;

    private Integer paymentAmount;

    private Double totalRepayment;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public LocalDate getFirstRepayment() {
        return firstRepayment;
    }

    public void setFirstRepayment(LocalDate firstRepayment) {
        this.firstRepayment = firstRepayment;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(Double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }
}
