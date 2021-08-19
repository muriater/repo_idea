package com.lagou.controller;

import com.lagou.domain.Account;
import com.lagou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/account")
    public List<Account> findAll(){
        List<Account> list = accountService.findAll();
        return list;
    }
}
