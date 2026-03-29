package com.gigabudget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.gigabudget.model.Account;
import com.gigabudget.model.AccountType;
import com.gigabudget.model.Category;
import com.gigabudget.model.Transaction;
import com.gigabudget.model.TransactionType;
import com.gigabudget.model.User;
import com.gigabudget.repository.InMemoryAccountRepository;
import com.gigabudget.repository.InMemoryCategoryRepository;
import com.gigabudget.repository.InMemoryTransactionRepository;
import com.gigabudget.repository.InMemoryUserRepository;
import com.gigabudget.repository.AccountRepository;
import com.gigabudget.repository.CategoryRepository;
import com.gigabudget.repository.TransactionRepository;
import com.gigabudget.repository.UserRepository;
import com.gigabudget.service.AccountService;
import com.gigabudget.service.AccountServiceImpl;
import com.gigabudget.service.CategoryService;
import com.gigabudget.service.CategoryServiceImpl;
import com.gigabudget.service.TransactionService;
import com.gigabudget.service.TransactionServiceImpl;
import com.gigabudget.service.UserService;
import com.gigabudget.service.UserServiceImpl;

public class App {
    public static void main(String[] args) {

        // Step 1: Wire up repositories
        UserRepository userRepo = new InMemoryUserRepository();
        AccountRepository accountRepo = new InMemoryAccountRepository();
        CategoryRepository categoryRepo = new InMemoryCategoryRepository();
        TransactionRepository transactionRepo = new InMemoryTransactionRepository();

        // Step 2: Wire up services (pass repositories via constructors)
        UserService userService = new UserServiceImpl(userRepo);
        AccountService accountService = new AccountServiceImpl(accountRepo);
        CategoryService categoryService = new CategoryServiceImpl(categoryRepo);
        TransactionService transactionService = new TransactionServiceImpl(transactionRepo, accountService);

        // Step 3: Create a user
        User user = new User("Giga", "test@test.com", "password");
        User savedUser = userService.createUser(user);
        System.out.println("Created: " + savedUser);

        // Step 4: Create an account for that user
        Account account = new Account(savedUser.getId(), "My Bank", AccountType.BANK);
        Account savedAccount = accountService.createAccount(account);
        System.out.println("Created: " + savedAccount);

        // Step 5: Create categories
        Category salaryCategory = categoryService.createCategory(
            new Category(savedUser.getId(), "Salary", TransactionType.INCOME));
        Category foodCategory = categoryService.createCategory(
            new Category(savedUser.getId(), "Food", TransactionType.EXPENSE));
        System.out.println("Created: " + salaryCategory);
        System.out.println("Created: " + foodCategory);

        // Step 6: Add income — salary of 3000
        Transaction income = new Transaction(savedUser.getId(), savedAccount.getId(),
            salaryCategory.getId(), new BigDecimal("3000"), TransactionType.INCOME,
            "March salary", LocalDateTime.now());
        Transaction savedIncome = transactionService.addTransaction(income);
        System.out.println("Added: " + savedIncome);
        System.out.println("Balance after income: " + savedAccount.getBalance());

        // Step 7: Add expense — groceries for 50
        Transaction expense = new Transaction(savedUser.getId(), savedAccount.getId(),
            foodCategory.getId(), new BigDecimal("50"), TransactionType.EXPENSE,
            "Groceries", LocalDateTime.now());
        Transaction savedExpense = transactionService.addTransaction(expense);
        System.out.println("Added: " + savedExpense);
        System.out.println("Balance after expense: " + savedAccount.getBalance());

        // Step 8: List all transactions for the user
        System.out.println("\n--- All transactions ---");
        transactionService.getTransactionsByUserId(savedUser.getId())
            .forEach(t -> System.out.println(t));

        // Step 9: Test error — duplicate email
        try {
            userService.createUser(new User("Another", "test@test.com", "pass"));
        } catch (IllegalArgumentException e) {
            System.out.println("\nExpected error: " + e.getMessage());
        }

        // Step 10: Test error — insufficient balance
        try {
            transactionService.addTransaction(new Transaction(savedUser.getId(),
                savedAccount.getId(), foodCategory.getId(), new BigDecimal("99999"),
                TransactionType.EXPENSE, "Too expensive", LocalDateTime.now()));
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}