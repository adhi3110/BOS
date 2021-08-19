import java.time.LocalDate;
import com.bos.Logger.Logger;
import com.bos.UI.MainMenu;
public class Main {

    public static void main(String[] args) {

        Logger l = new Logger();
        MainMenu inp = new MainMenu();
        AccountData.openSaving();
        System.out.println(LocalDate.now());
        while (true)
            inp.run();
    }
}