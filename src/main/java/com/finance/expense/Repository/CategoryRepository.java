package com.finance.expense.Repository;

import com.finance.expense.entities.Expense;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Expense,Long> {
}
