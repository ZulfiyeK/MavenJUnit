package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionClassWork {

     /*
  1)https://amazon.com adresine gidin
  2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
   */

    WebDriver driver;
    @BeforeClass
    public static void before() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void title() {
    // ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actuelTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));
    }
    @Test
    public void image() {
    //  ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());//baktim gordum var, o zaman true ile yapabilirim.
    }
    @Test
    public void SearchBox() {
    //○ SearchBox 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(SearchBox.isEnabled());//ulasilabilir.

    }
    @Test
    public void wrongTitle() {
    //  ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        String actuelTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actuelTitle.contains(expectedTitle));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
}
