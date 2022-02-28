package org.example.service;

import org.example.model.Accounts;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    List<Accounts> getAllAccounts();

    ResponseEntity<Accounts> getoneAccount(Long id);

    void deleteAccount(Long id);

    Accounts saveAccount(Accounts accounts);

    ResponseEntity<Accounts> updateAccount(Long id, Accounts accounts);
}
