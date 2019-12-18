package model;

import com.google.gson.Gson;

import java.util.Date;

public class Payment implements Comparable<Payment> {
    private String fio;
    private String teleOperator;
    private Date dateOfSpeaking;
    private double cost;
    private int discount;

    public Payment(String fio, String teleOperator, Date dateOfSpeaking, double cost, int discount) {
        this.fio = fio;
        this.teleOperator = teleOperator;
        this.dateOfSpeaking = dateOfSpeaking;
        this.cost = cost;
        this.discount = discount;
    }

    public String getFio() {
        return fio;
    }

    public String getTeleOperator() {
        return teleOperator;
    }

    public Date getDateOfSpeaking() {
        return dateOfSpeaking;
    }

    public double getCost() {
        return cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setTeleOperator(String teleOperator) {
        this.teleOperator = teleOperator;
    }

    public void setDateOfSpeaking(Date dateOfSpeaking) {
        this.dateOfSpeaking = dateOfSpeaking;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public int compareTo(Payment o) {
        return Double.compare(this.getCost(), o.getCost());
    }
}