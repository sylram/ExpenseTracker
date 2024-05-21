package com.finance.expense.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Expense> expenses = new ArrayList<>();

    public Category(){
    }

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

    public List<Expense> getExpenses () {
        return expenses;
    }

    public void setExpenses (List<Expense> expenses) {
        this.expenses = expenses;
    }
}
