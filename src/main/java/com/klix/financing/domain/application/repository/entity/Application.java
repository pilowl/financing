package com.klix.financing.domain.application.repository.entity;

import java.util.Set;
import java.util.UUID;

import com.klix.financing.domain.bankapplication.repository.entity.BankApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "uuid")
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @Column(name = "monthly_income")
    private float monthlyIncomeAmount;

    private float amount;

    @Column(name = "monthly_credit_liabilities")
    private float monthlyCreditLiabilities;

    private int dependents;

    @Column(name = "data_sharing_agreed")
    private boolean agreeToDataSharing;

    @Column(name = "monthly_expenses")
    private float monthlyExpenses;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "scoring_agreed")
    private boolean agreeToBeScored;

    @OneToMany
    @JoinColumn(name = "application_id")
    private Set<BankApplication> bankApplications;

    public Set<BankApplication> getBankApplications() {
        return bankApplications;
    }

    public void setBankApplications(Set<BankApplication> bankApplications) {
        this.bankApplications = bankApplications;
    }

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public float getMonthlyIncomeAmount() {
        return monthlyIncomeAmount;
    }

    public float getAmount() {
        return amount;
    }

    public float getMonthlyCreditLiabilities() {
        return monthlyCreditLiabilities;
    }

    public int getDependents() {
        return dependents;
    }

    public boolean isAgreeToDataSharing() {
        return agreeToDataSharing;
    }

    public float getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public boolean isAgreeToBeScored() {
        return agreeToBeScored;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMonthlyIncomeAmount(float monthlyIncomeAmount) {
        this.monthlyIncomeAmount = monthlyIncomeAmount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setMonthlyCreditLiabilities(float monthlyCreditLiabilities) {
        this.monthlyCreditLiabilities = monthlyCreditLiabilities;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public void setAgreeToDataSharing(boolean agreeToDataSharing) {
        this.agreeToDataSharing = agreeToDataSharing;
    }

    public void setMonthlyExpenses(float monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAgreeToBeScored(boolean agreeToBeScored) {
        this.agreeToBeScored = agreeToBeScored;
    }
}
