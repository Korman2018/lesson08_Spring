package com.library.model;


public abstract class AbstractPersonContainer extends Entity {

    private Person person;

    public AbstractPersonContainer(Person person) {
        this.person = person;
    }

    public AbstractPersonContainer() {
        person = new Person();
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractPersonContainer) {
            AbstractPersonContainer personContainer = (AbstractPersonContainer) obj;

            if (person.equals(personContainer.getPerson())) {
                return getId() == personContainer.getId();
            }
        }
        return false;
    }
}
