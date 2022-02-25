package org.example.controller;

import org.example.model.Accounts;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Accounts> getAllCustomers()
    {
        return accountService.getAllAccounts();
    }
}
