package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");




        //"Dosya sec" butonuna basalim
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        String dosyaYolu = "C:\\Users\\zulfi\\Downloads\\b10 all test cases, code.docx";
        dosyaSec.sendKeys(dosyaYolu);

        //dosyaSec.click(); dosya sec butonun basmamiz istenirse ve bu butona click yapmak istedigimizde
        // exception aliyorsak,direk upload yapmak istedigimiz dosya yolunu alip senKeys() methodu ile
        // dosyayi sayfaya upload yapabiliriz.
        // Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa ,
        // o webelemente sendKeys() methodu ile dosya gonderemeyebilirsiniz.
        // Boyle bir durumla karsilasirsaniz Romot class'indan obje ile methodlar kullanarak bunu asabilirsiniz.






        //Yuklemek istediginiz dosyayi secelim.


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();


        //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement FileUpload = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(FileUpload.isDisplayed());















    }
}
