package com.finance.expense.entities;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private Date date;
    private Double amount;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;




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
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public void setDate (String date) throws ParseException {
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
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

    public Category getCategory () {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }

}
