package com.library.DAO;

import com.library.model.AbstractPersonContainer;
import com.library.model.Person;

public interface BasicPersonDAO<T extends AbstractPersonContainer> extends BasicDAO<T> {

    T getByShortName(String name, String surname);

    T getByPerson(Person person);
}
