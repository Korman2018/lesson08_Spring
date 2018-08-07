package com.library.model;


public class User extends AbstractPersonContainer {

    private boolean isLibrarian;

    private boolean isDebtor;


    public User(Person person, boolean isLibrarian) {
        super(person);
        this.isLibrarian = isLibrarian;
        this.isDebtor = false;
    }

    // user is not librarian by default
    public User(Person person) {
        this(person, false);
    }

    public boolean getIsLibrarian() {
        return isLibrarian;
    }

    public void setIsLibrarian(boolean librarian) {
        isLibrarian = librarian;
    }

    public boolean getIsDebtor() {
        return isDebtor;
    }

    public void setIsDebtor(boolean debtor) {
        isDebtor = debtor;
    }

    @Override
    public String toString() {
        return getId() + ". " + getPerson() + (isLibrarian ? "(librarian)" : isDebtor ? "(debtor)" : "");
    }
}
