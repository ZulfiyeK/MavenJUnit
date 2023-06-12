package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //her test classsinda test ve before anotation yaziyorduk..artik testbase class'imiz var burada istedigimiz methotlari depolayabilecegiz.
    //bu class'ta obje olusturmayacagim icin abstract yapiyorum.
    //Bu class'a extends ettigimiz test classlarimizdan ulasabiliriz.

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
