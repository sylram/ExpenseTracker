package com.finance.expense.Service;
import com.finance.expense.Repository.ExpenseRepository;
import com.finance.expense.entities.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpenses(){
        List<Expense> expenses = new ArrayList<>();
        expenseRepository.findAll().forEach(expenses::add);
        return expenses;
    }

    public Expense getExpense(Long id){
        return expenseRepository.findById(id).get();
    }

    public Expense createExpense (Expense expense){
        return expenseRepository.save(expense);
    }

    public Expense updateExpense (Expense expense) throws Exception {
       Expense expenseToUpdate = this.getExpense(expense.getId());
        expenseToUpdate.setDate(expense.getDate());
        expenseToUpdate.setAmount(expense.getAmount());
        expenseToUpdate.setName(expense.getName());
        expenseRepository.save(expenseToUpdate);
        return expenseToUpdate;
    }

    public Expense deleteExpense (Long id) throws Exception {
        Expense expense = this.getExpense(id);
        expenseRepository.deleteById(id);
        return expense;
    }
}
