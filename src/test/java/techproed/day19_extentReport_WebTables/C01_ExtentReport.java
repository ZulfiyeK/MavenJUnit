package techproed.day19_extentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    /*
    Testi calistirdik ve hic bir sorun olmasa bile calistirdigimiz hersey bu raporda olur.
    daha sonra olusturdugumuz bu dosyayi kaydetmek icin yol olusturup dosya yoluna ekleriz.

        EXTENTREPORT;
        1. Extentreport(aventstack) kullanabilmek icin oncellikle mvn adresinden
           4.0.9 versiyon numarali dependency'i pom.xml dosyamiza ekleriz.
        2. ExtentReports class'indan class seviyesinde obje olustururuz.
        3. ExtentHtmlReporter class'indan class seviyesinde obje olusturuz.
        4. ExtentTest class'indan class seviyesinde obje olusturuz.

     */


    ExtentReports extentReports; //raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter; // raporu HTML formatinda duzenler.
    ExtentTest extentTest; // test adimlarina eklemk istedigimiz bilgileri bu class ile olusruruz.
    @Test
    public void test1() {

    extentReports = new ExtentReports();
    String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
    String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
    extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
    extentReports.attachReporter(extentHtmlReporter);// HTML formatinda raporlamayi baslatacak

        //raporda gozukmesini istedigimiz bilgiler icin;
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Zulfiye");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest= extentReports.createTest("ExtentTest","Test Raporu");//test ismi ve aciklamasi
         /*
         Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama
         Extent Class' larini kullanrak testle ilgili bilgileri rapora ekleyebiliriz
         */


        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //Basligin Amazon icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info(" Basligin Amazon icerdigi test edildi");

        //arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("arama kutusunda iphone aratildi");

        //sonuc yazisini konsola yazdiralim.
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdirildi");
        extentTest.pass("Sayfa kapatildi");

    /*
      extentTest objesi ile info() methedunu kullanarak her step'te ne yaptigimizla alakali bilgi yazabiliriz.
      testimizin sonuna testin bittigini idade eden pass() methodu ile testimiz ile ilgili son bilgiyi ekleyebiliriz.
      Ve son olarak actions daki gibi perform() methodu gibi extentReports objesi ile flush() methodu kullanarak
                                                                                                  raporu sonlandiririz.
    */

        extentReports.flush();// bu kodu yazmazsak rapor olusmaz.
    }
}
