package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void techproedTest() {
        driver.get("https://techproeducation.com");// her calismaya basladiginda @before gidecek

    }
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
    //sirali calissin istiyorsam 1,2,3 diye method isimleri siralandirilabilir. yoksa ilk olusturulan @Test once calisir.


    @BeforeClass
    public static void beforeClass() throws Exception {
        //@Before-After class methodlari statik olmak zorunda.
        System.out.println("@BeforeClass Her classtan once bir kez calisir.");//tum methodlardan once calismasini istedigim bir kod varsa buraya yazariz.
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass Her classtan sonra bir kez calisir.");//tum methodlardan sonra en son bir kez calsiir.
       }
}
