package Ping;
import java.util.ArrayList;
/*Var's include aName, aBirthday, aDriver, aWeek, aContactList from Account class
 * Var's include cName, cPhoneNumber, cAccount from Contact class*/
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



    public static void getVar(){
        Account AccountVar = new Account();
        Contact ContactVar = new Contact();
        Day DayVar = new Day();

        aName = AccountVar.getName();
        aBirthday = AccountVar.getBirthday();
        aDriver = AccountVar.isDriver();
        aWeek = AccountVar.getWeek();
        aContactList = AccountVar.getContacts();

        cName = ContactVar.getName();
        cPhoneNumber = ContactVar.getPhone();
        cAccount = ContactVar.getAccount();

        dDay = DayVar.getDay();
        dEvents = DayVar.getEvents();

    }

}

