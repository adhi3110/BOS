import java.time.LocalDate;
import com.bos.Logger.logger;
import com.bos.UI.inputFile;
public class Main {

    public static void main(String[] args) {

        logger l = new logger();
        inputFile inp = new inputFile();
        AccountData.openSaving();
        System.out.println(LocalDate.now());
        while (true)
            inp.run();
    }
}