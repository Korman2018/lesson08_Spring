package com.library.DAO.Impl;

import com.library.DAO.AuthorDAO;
import com.library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl extends AbstractPersonDAO<Author> implements AuthorDAO {
}
