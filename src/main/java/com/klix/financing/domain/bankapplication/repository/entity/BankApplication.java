package com.klix.financing.domain.bankapplication.repository.entity;

import com.klix.financing.domain.application.repository.entity.Application;
import com.klix.financing.domain.bankapplication.offer.repository.entity.Offer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_applications")
public class BankApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "bank_name")
    @Enumerated(EnumType.STRING)
    private Bank bankName;

    @Column(name = "status") 
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "external_uuid")
    private String externalUUID;

    @ManyToOne
    @JoinColumn(name="application_id", nullable=false)
    private Application application;

    @OneToOne(mappedBy = "bankApplication")
    private Offer offer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bank getBankName() {
        return bankName;
    }

    public void setBankName(Bank bankName) {
        this.bankName = bankName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getExternalUUID() {
        return externalUUID;
    }

    public void setExternalUUID(String externalUUID) {
        this.externalUUID = externalUUID;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Offer getOffer() {
        return offer;
    }

    public static BankApplicationBuilder builder() {
        return new BankApplicationBuilder();
    }

    public static class BankApplicationBuilder {
        private Bank bankName;
        private Status status;
        private String externalUUID;
        private Application application;

        public BankApplicationBuilder setBankName(final Bank bankName) {
            this.bankName = bankName;
            return this;
        }

        public BankApplicationBuilder setStatus(final Status status) {
            this.status = status;
            return this;
        }

        public BankApplicationBuilder setExternalUUID(final String uuid) {
            this.externalUUID = uuid;
            return this;
        }

        public BankApplicationBuilder setApplication(final Application application) {
            this.application = application;
            return this;
        }

        public BankApplication build() {
            BankApplication bankApplication = new BankApplication();
            bankApplication.setBankName(bankName);
            bankApplication.setStatus(status);
            bankApplication.setExternalUUID(externalUUID);
            bankApplication.setApplication(application);
            return bankApplication;
        }
    }
}
