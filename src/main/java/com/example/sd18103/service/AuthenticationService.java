package com.example.sd18103.service;

import com.example.sd18103.entity.Account;
import com.example.sd18103.repository.UserRepository;

public class AuthenticationService {

    UserRepository userRepository = new UserRepository();

    public Account authenticate(String username, String password) {
        Account account = userRepository.getByUserName(username);
        if (account == null) {
            // khong tim thay account
            return null;
        }
        // tim thay => kiem tra den mat khau
        if (!account.getPassword().equals(password)) {
            return null;
        }
        return account;
    }


}
