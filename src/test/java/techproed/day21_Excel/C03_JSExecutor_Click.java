package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

   /*
    Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa o sayfayla
    etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir

    Bu durumda sayfa ile etkilesime gecebilmek icin Java Script Executor ara yuzunu kullanmak gerekir.
    Java Script Executor ara yuzu sayfaya dogrudan ulasabilir. Eger html kodlari sayet Java Script kullanilarak olusturulmadi,
    normal sekilde olusturulduysa bile biz yine Java Script Executor ara yuzunu kullanarak ulasabiliriz.

    Ancak mumkunse Webdriverin sundugu standar yontemlerle sayfayle etkilesime gecmek her zaan daha iyidir.
    Cunku Java Script kullanimi sayfanin daha yavas yuklenmesine neden olabilir.

   */

    @Test
    public void JSExecutorClick() {

   //https://amazon.com sayfasina gidiniz
    driver.get("https://amazon.com");


    //returns kismina tiklayiniz.
   WebElement returns =  driver.findElement(By.xpath("//*[@id='nav-orders']"));
   // returns.click();

    /*
    ilgili Webelementin HTML kodu Java Script kullanilarak olusturulduysa, standart Webdriver komutu olan Click() yetersi olabilir.
    Boyle durumlarda JavaScriptExecutor kullanilarak sayfayl etkilesime gecilebilir.
    */

       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].click();",returns);

    click(returns);//test base deki click methodumu kullandim.
   }






}
