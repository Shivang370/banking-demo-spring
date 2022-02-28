package org.example.service;

import org.example.model.Accounts;
import org.example.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("accountService")
public class DefaultAccountService implements AccountService {
    @Autowired
    private AccountRepository repository;

    public DefaultAccountService() {
    }

    //Setter Injection
    public void setAccountRepository(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Accounts> getAllAccounts() {

        return repository.findAll();
    }

    @Override
    public ResponseEntity<Accounts> getoneAccount(Long id) {
        Optional<Accounts> accounts = repository.findById(id);
        if (accounts.isPresent())
            return new ResponseEntity<>(accounts.get(), HttpStatus.OK);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account ID not Found !!");
    }

    @Override
    public void deleteAccount(Long id) {
        ResponseEntity<Accounts> responseEntity = getoneAccount(id);
        if (responseEntity.getStatusCode().is4xxClientError()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account ID not Found !!");
        }
        repository.deleteById(id);


    }

    @Override
    public Accounts saveAccount(Accounts accounts) {
            return repository.saveAndFlush(accounts);
    }

    @Override
    public ResponseEntity<Accounts> updateAccount(Long id, Accounts accounts) {
        ResponseEntity<Accounts> responseEntity=getoneAccount(id);
        if(responseEntity.getStatusCode().is4xxClientError())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID not present !!");
        Accounts existing_account=responseEntity.getBody();
        BeanUtils.copyProperties(accounts,existing_account);
        return new ResponseEntity<>(repository.saveAndFlush(existing_account),HttpStatus.OK);
    }
}
