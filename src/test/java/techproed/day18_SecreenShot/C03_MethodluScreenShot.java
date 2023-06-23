package techproed.day18_SecreenShot;
import org.junit.Test;
import utilities.TestBase;
import java.io.IOException;

public class C03_MethodluScreenShot extends TestBase {

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım
        allscreenShots();


    }















}
