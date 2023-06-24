package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //her test classsinda test ve before anotation yaziyorduk..artik testbase class'imiz var
    // burada istedigimiz methotlari depolayabilecegiz.

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

    //**********************************************

    @After
    public void tearDown() throws Exception {
     // driver.quit();

    }

    //**********************************************

    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//*********************************************************************************************************************

    //Selenium Wait/Explicit Wait-visibilityif(elemet) methodu
    public void visibleWait(WebElement element,int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //**********************************************

    //Selenium Wait/Explicit Wait-visibilityOfElementLocated
    public void visibleWait(By locator, int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //**********************************************

    //FluentWait visible Methodu
    public void visibleFluentWait(WebElement element,int saniye,int milisaniye){
        new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }
//*********************************************************************************************************************

    //Alert cikana kadar bekle
    public void alerWait(int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //**********************************************
    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    //**********************************************
    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    //**********************************************
    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //**********************************************
    public String alertText(){
        return driver.switchTo().alert().getText();
    }


//*********************************************************************************************************************

    public void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //**********************************************
    public void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //**********************************************
    public void ddmValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

 //*********************************************************************************************************************
    //switchTo Window -1 (istemsiz acilan sekmeyi handle etme)
    public void SwitchToWindow(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }

    //**********************************************

    //SwitchTo Window-2 (istemsiz acilan sekmeyi handle etme)
    public void switchToWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

//*********************************************************************************************************************

    // tum sayfa screenShots
    public void allscreenShots(){
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/tumSayfaResmi/screenShot" + tarih+ ".jpg" ;
        TakesScreenshot ts = (TakesScreenshot) driver;

        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//*********************************************************************************************************************
    //WebElement screenshots
    public void WebElementscreenShots(WebElement element){
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/tumWebElementResimleri/WebElementScreenshot" + tarih+ ".jpg" ;

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//*********************************************************************************************************************

    //UploadFile Robot Class- siteye dosya yuklemek icin
    public void uploadFilePath(String filePath) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

//*********************************************************************************************************************
   protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected  ExtentTest extentTest;

    //Extent Report Methodu
    public void extentReport(String browser,String reportName){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());//gun,ay,yil,saat,dakika,saniye
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //raporda gozukmesini istedigimiz bilgiler icin;
        extentReports.setSystemInfo("Browser",browser);// calistigim browser
        extentReports.setSystemInfo("Tester","Zulfiye");
        extentHtmlReporter.config().setDocumentTitle("Extent Report"); // titlesine vermek istedigim baslik
        extentHtmlReporter.config().setReportName(reportName);//hangi test'i yapiyorsam onun adi
        extentReports.flush();

    }

//*********************************************************************************************************************

















}


