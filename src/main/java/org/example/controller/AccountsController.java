package org.example.controller;

import org.example.model.Accounts;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @RequestMapping
    public List<Accounts> getAllCustomers()
    {
        return accountService.getAllAccounts();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Accounts> getoneAccount(@PathVariable Long id)
    {
        return accountService.getoneAccount(id);
    }
    @RequestMapping(value ="{id}",method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
    }
    @PostMapping
    public Accounts saveAccount(@RequestBody Accounts accounts)
    {
        return  accountService.saveAccount(accounts);
    }
    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public ResponseEntity<Accounts> UpdateAccount(@PathVariable Long id,@RequestBody Accounts accounts)
    {
        return accountService.updateAccount(id,accounts);
    }
}
