package com.library.DAO.Impl;

import com.library.DAO.BasicPersonDAO;
import com.library.model.AbstractPersonContainer;
import com.library.model.Person;

public abstract class AbstractPersonDAO<T extends AbstractPersonContainer> extends AbstractDAO<T> implements BasicPersonDAO<T> {

    @Override
    public T getByShortName(String name, String surname) {
        Person person = new Person(name, surname);

        for (T t : getAll()) {
            Person tempPerson = t.getPerson();
            Person personForCompare = new Person(tempPerson.getFirstName(), tempPerson.getSurname());

            if (person.equals(personForCompare)) {
                return t;
            }
        }
        return null;
    }

    public T getByPerson(Person person) {
        for (T t : getAll()) {
            if (t.getPerson().equals(person)) {
                return t;
            }
        }
        return null;
    }
}
