package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
      //  driver.quit();
    }


    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //Selenium Wait/Explicit Wait-visibilityif(elemet) methodu
    public void visibleWait(WebElement element,int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    //Selenium Wait/Explicit Wait-visibilityOfElementLocated
    public void visibleWait(By locator, int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    //FluentWait visible Methodu
    public void visibleFluentWait(WebElement element,int saniye,int milisaniye){
        new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }


    //Alert cikana kadar bekle
    public void alerWait(int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }


    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }


    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }


    public String alertText(){
        return driver.switchTo().alert().getText();
    }




    public void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }


    public void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }


    public void ddmValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }


    //switchTo Window -1 (istemsiz acilan sekmeyi handle etme)
    public void SwitchToWindow(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }


    //SwitchTo Window-2 (istemsiz acilan sekmeyi handle etme)

    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }



}
