package com.klix.financing.domain.bankapplication.offer.repository.entity;

import java.sql.Date;

import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "monthly_payment")
    private Double monthlyPaymentAmount;

    @Column(name = "total_repayment")
    private Double totalRepaymentAmount;

    @Column(name = "payment_amount")
    private Integer numberOfPayments;

    @Column(name ="first_repayment")
    private Date firstRepaymentDate;

    @ManyToOne
    @JoinColumn(name="bank_application_id", nullable=false)
    private BankApplication application;

    public void setApplication(BankApplication application) {
        this.application = application;
    }

    public Double getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public void setMonthlyPaymentAmount(Double monthlyPaymentAmount) {
        this.monthlyPaymentAmount = monthlyPaymentAmount;
    }

    public Double getTotalRepaymentAmount() {
        return totalRepaymentAmount;
    }

    public void setTotalRepaymentAmount(Double totalRepaymentAmount) {
        this.totalRepaymentAmount = totalRepaymentAmount;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(Integer numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public Date getFirstRepaymentDate() {
        return firstRepaymentDate;
    }

    public void setFirstRepaymentDate(Date firstRepaymentDate) {
        this.firstRepaymentDate = firstRepaymentDate;
    }

    public BankApplication getApplication() {
        return application;
    }
}
