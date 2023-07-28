package com.example.sd18103.repository;

import com.example.sd18103.entity.Account;

public class UserRepository {

    // fake tai khoan
    private static Account[] accounts = new Account[]{
            new Account("user", "123", "User"),
            new Account("admin", "321", "Admin")
    };

    public Account getByUserName(String username){
        for (Account account: accounts){
            // kiem tra tai khoan co ton tai trong DB hay khong
            if (account.getUsername().equals(username)){
                return account;
            }
        }
        // khong tim thay
        return null;
    }
}
