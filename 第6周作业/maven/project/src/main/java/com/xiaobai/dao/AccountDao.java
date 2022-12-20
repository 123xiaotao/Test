package com.xiaobai.dao;

import com.xiaobai.pojo.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    int deleteById(String id);
    int insert(Account account);
    Account selectById(String id);
    int update(Account account);
}
