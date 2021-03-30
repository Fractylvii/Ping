package Ping;
import java.util.ArrayList;

public class frontToBack {
    //from Account class
    public static String aName;
    public static String aBirthday;
    public static boolean aDriver;
    public static ArrayList<?> aWeek;
    public static ArrayList<?> aContactList;
    //from Contact class
    public static String cName;
    public static String cPhoneNumber;
    public static Account cAccount;
    //from Day class
    public static String dDay;
    public static ArrayList<?> dEvents;
    //
    static Account AccountVar = new Account();
    static Contact ContactVar = new Contact();
    static Day DayVar = new Day();
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET METHODS
    /////////////////////////////////////////////////////////// Account
    public static String getAName(){
        aName = AccountVar.getName();
        return aName;
    }
    public static String getABirthday() {
        aBirthday = AccountVar.getBirthday();
        return aBirthday;
    }
    public static boolean getADriver() {
        aDriver = AccountVar.isDriver();
        return aDriver;
    }
    public static ArrayList<?> getAWeek(){
        aWeek = AccountVar.getWeek();
        return aWeek;
    }
    public static ArrayList<?> getAContactList(){
        aContactList = AccountVar.getContacts();
        return aContactList;
    }
    /////////////////////////////////////////////////////// Contact
    public static String getCName(){
        cName = ContactVar.getName();
        return cName;
    }
    public static String getCPhoneNumber() {
        cPhoneNumber = ContactVar.getPhone();
        return cPhoneNumber;
    }
    public static Account getCAccount() {
        cAccount = ContactVar.getAccount();
        return cAccount;
    }
    ////////////////////////////////////////////////////// Day
    public static String getDDay() {
        dDay = DayVar.getDay();
        return dDay;
    }
    public static ArrayList<?> getDEvents() {
        dEvents = DayVar.getEvents();
        return dEvents;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //SET METHODS (includes adding, removing, and editing lists)
    //////////////////////////////////////////////////////////////Account
    public static void setAName(String name){
        AccountVar.editName(name);
    }

        /* 									Birthdays unchangeable?
        public static void setABirthday(String Birthday) {
        AccountVar.editBirthday(Birthday);
        }
        */

    public static void setADriver(boolean IsDriver) {
        AccountVar.editDriver(IsDriver);
    }
    /*									Week (events?) unchangeable/ no set method?
    public static void setAWeek(){
     AccountVar.setWeek();
    }
    */
    public static void addAContact(Contact newContact){
        AccountVar.addContact(newContact);
    }
    public static void removeAContact(int index){
        AccountVar.removeContact(index);
    }
    public static void removeAContact(Contact oldContact){
        AccountVar.removeContact(oldContact);
    }
    //////////////////////////////////////////////////// Contact
    public static void setCName(String newName){
        ContactVar.editName(newName);
    }

    public static void setCPhoneNumber(String newPhone) {	//who dis
        ContactVar.editPhone(newPhone);
    }

    public static void addCAccount(Account newAccount) {
        ContactVar.addAccount(newAccount);
    }

    /*								Day unchangeable/no set method?
    public void setDDay() {
    DayVar.getDay();
    }
    */
    //////////////////////////////////////////////////// Day
    public static void addDEvents(String newEvent) {
        DayVar.addEvent(newEvent);
    }

    public static void removeDEvents(int index) {
        DayVar.removeEvent(index);
    }
    public static void editDEvents(int index, String newEvent) {
        DayVar.editEvent(index, newEvent);
    }

}

