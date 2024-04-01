package com.finance.expense.Controllers;

import com.finance.expense.Service.ExpenseService;
import com.finance.expense.entities.Expense;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {
    private final ExpenseService expenseService;
    Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    public ExpenseController (ExpenseService expenseService){
        logger.info("inside controller");
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Expense>> getExpenses(){
        logger.info("get all expenses");
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpenses());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) throws BadRequestException{
        try {
            expenseService.getExpense(id);
            return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpense(id)) ;
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping(value = "create")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws BadRequestException{
        try {
            return new ResponseEntity<>(expenseService.createExpense(expense), HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    @PutMapping(value = "update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) throws BadRequestException {
            try {
                expenseService.updateExpense(expense);
                return new ResponseEntity<>(expenseService.updateExpense(expense), HttpStatus.OK);
            } catch (Exception e) {
                throw new BadRequestException(e.getMessage());
            }
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(expenseService.deleteExpense(id),HttpStatus.OK);
    }
}
