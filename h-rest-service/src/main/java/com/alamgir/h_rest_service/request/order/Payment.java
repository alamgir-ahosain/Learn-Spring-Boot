package com.alamgir.h_rest_service.request.order;

public class Payment {
    private double paidAmount;
    private String paymentStatus;
    private String bankTransaction;

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBankTransaction() {
        return bankTransaction;
    }

    public void setBankTransaction(String bankTransaction) {
        this.bankTransaction = bankTransaction;
    }

    @Override
    public String toString() {
        return "Payment [paidAmount=" + paidAmount + ", paymentStatus=" + paymentStatus + ", bankTransaction="
                + bankTransaction + "]";
    }

    
}
