package com.oocl.packagebooking.Entity;


import javax.persistence.*;

@Entity
public class PackageOrder {
    public PackageOrder() {
    }
    public PackageOrder(String number, String name, String phone, int weigth){
        this.name=name;
        this.number=number;
        this.phone=phone;
        this.weigth=weigth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number", length = 100, nullable = false)
    private String number;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "status")
    private boolean status;

    @Column(name = "weigth")
    private int weigth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isStatus() {
        return status;
    }

    public int getWeigth() {
        return weigth;
    }

    public String getNumber() {
        return number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

}
