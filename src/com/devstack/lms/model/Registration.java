package com.devstack.lms.model;

import com.devstack.lms.util.PaymentType;

import java.util.Date;

public class Registration {
    private String registerId;
    private Date date;
    private byte[] nic;
    private PaymentType paymentType;
    private String student;
    private String course;

    public Registration() {
    }

    public Registration(String registerId, Date date, byte[] nic, PaymentType paymentType, String student, String course) {
        this.registerId = registerId;
        this.date = date;
        this.nic = nic;
        this.paymentType = paymentType;
        this.student = student;
        this.course = course;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getNic() {
        return nic;
    }

    public void setNic(byte[] nic) {
        this.nic = nic;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
