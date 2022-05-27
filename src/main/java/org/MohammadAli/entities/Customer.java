package org.MohammadAli.entities;


public class Customer {

    private String name;
    private String family;
    private float age;
    private String accountID;


    public Customer(){

    }

    public Customer( String name, String family, float age, String accountID) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
