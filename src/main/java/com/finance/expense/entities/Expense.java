package com.finance.expense.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date date;
    Double amount;

    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDate () {
        String pattern = "yyyy-MM-dd";
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public void setDate (String date) throws ParseException {
        try {
            String pattern = "yyyy-MM-dd";
            simpleDateFormat = new SimpleDateFormat(pattern);
            this.date = simpleDateFormat.parse(date);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Double getAmount () {
        return amount;
    }

    public void setAmount (Double amount) {
        this.amount = amount;
    }
}
