package org.MohammadAli.entities;

import java.util.Date;
import java.util.Random;

public class Account extends Audit{

    private String accountID;

    public static final String idPattern = "name" + "age";

    public Account(){
        Date date = new Date();
        setCreateDate(date);
        setUpdateDate(date);
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String name , float age) {
        Random random = new Random();
        accountID = idPattern.replace("name", name).replace("age",String.valueOf(age)) + random.nextInt(100);
    }


}
