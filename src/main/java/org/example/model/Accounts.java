package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    private String account_type;
    private String opening_date;
    private Double amount;
    private Integer status;

    private Accounts(){}
    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(String opening_date) {
        this.opening_date = opening_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "account_id=" + account_id +
                ", account_type='" + account_type + '\'' +
                ", opening_date='" + opening_date + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
