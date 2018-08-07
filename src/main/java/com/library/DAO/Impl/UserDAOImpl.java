package com.library.DAO.Impl;

import com.library.DAO.UserDAO;
import com.library.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl extends AbstractPersonDAO<User> implements UserDAO {
    @Override
    public List<User> getLibrarians() {
        List<User> users = new ArrayList<>();

        for (User user : getAll()) {
            if (user.getIsLibrarian()) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<User> getDebtors() {
        List<User> users = new ArrayList<>();

        for (User user : getAll()) {
            if (user.getIsDebtor()) {
                users.add(user);
            }
        }
        return users;
    }
}
