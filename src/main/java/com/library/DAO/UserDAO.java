package com.library.DAO;

import com.library.model.User;

import java.util.List;

public interface UserDAO extends BasicPersonDAO<User> {

    List<User> getLibrarians();

    List<User> getDebtors();
}
