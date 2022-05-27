package org.MohammadAli.models;


import org.MohammadAli.entities.Audit;

public class AccountDTO extends Audit {

    private String accountID;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return  "\n"+ "\t" +'{' + "\n" +
                "\t"+ "\t" +"accountID :'" + accountID + '\'' + "\n" +
                "\t"+ "\t" +"createDate :'" + getCreateDate() + '\'' + "\n" +
                "\t"+ "\t" +"updateDate :'" + getUpdateDate()+ '\'' + "\n" +
                "\t"+ '}';
    }
}
