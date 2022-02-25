package org.example.service;

import org.example.model.Accounts;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class DefaultAccountService implements AccountService{
    @Autowired
    private AccountRepository repository;

    public DefaultAccountService() {}

    //Setter Injection
    public void setCustomerRepository(AccountRepository repository)
    {
        this.repository=repository;
    }

    public List<Accounts> getAllAccounts()
    {

        return repository.findAll();
    }

}
