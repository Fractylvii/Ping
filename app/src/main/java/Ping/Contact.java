package Ping;

public class Contact {
    private String Name;
    private String PhoneNumber;
    private Account Account;

    public Contact(){
        this.Name = "Default Name";
        this.PhoneNumber = "0000000000";
        this.Account = null;
    }

    public Contact(String Name, String PhoneNumber){
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Account = null;
    }

    public Contact(String Name, String PhoneNumber, Account Account){
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Account = Account;
    }

    public void editName(String name){
        this.Name = name;
    }

    public void editPhone(String phone){
        this.PhoneNumber = phone;
    }

    public void addAccount(Account account){
        this.Account = account;
    }

    public String getName(){
        return this.Name;
    }

    public String getPhone(){
        return this.PhoneNumber;
    }

    public Account getAccount(){
        return this.Account;
    }
}