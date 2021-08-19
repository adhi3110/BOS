import java.time.LocalDate;
import com.bos.Logger.logger;
import com.bos.UI.MainMenu;
public class Main {

    public static void main(String[] args) {

        MainMenu inp = new MainMenu();
        AccountData.openSaving();
        System.out.println(LocalDate.now());
        while (true)
            inp.run();
    }
}