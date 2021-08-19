import java.time.LocalDate;

import com.bos.Business.Privilege;
import com.bos.Business.Savings;
import com.bos.service.AccountManager;
import com.bos.service.*;
public class AccountData {


    public static void openSaving(){
        Savings s = new Savings();
        s.setName("Adithya");
        s.setPinNo(123);
        s.setBalance(50000);
        s.setActivitedDate(LocalDate.now());
        s.setActive(true);
        s.setDateOfBirth(LocalDate.of(1999,10,31));
        s.setPhoneNo("1234567890");
        s.setGender("male");
        s.setAccountNo(AccountManager.getAccountCount());
        s.setPrivilege(Privilege.SILVER);
        AccountManager.addAccount(s);
        AccountManager.incAccountCount();


        s = new Savings();
        s.setName("Darshan");
        s.setPinNo(123);
        s.setBalance(50000);
        s.setActivitedDate(LocalDate.now());
        s.setActive(true);
        s.setDateOfBirth(LocalDate.of(1969,10,31));
        s.setPhoneNo("1234567890");
        s.setGender("male");
        s.setAccountNo(AccountManager.getAccountCount());
        s.setPrivilege(Privilege.GOLD);
        AccountManager.addAccount(s);
        AccountManager.incAccountCount();
    }
}
