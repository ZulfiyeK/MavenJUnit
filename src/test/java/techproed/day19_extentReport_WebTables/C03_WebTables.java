package techproed.day19_extentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    /*

    WEBTABLE;
    <table> tagi ile baslar
        <thead> basliklar icin bu tag ike devam eder
            <th> table head
                <td> basliktaki veriler
            <tbody> basliklar altindaki verileri temsizl eder
                <tr> table row (satir)
                    <td> table data(tablodaki veri)


    Thead : Tablo Başlığı
    Tbody : Tablo Body'si
    Tr : Table Row(Satır)
    Td : Table Data(Sütun olarak adlandırılabilir)

     WebTable de index kullanacagiz.

     */


    @Test
    public void test() {

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1 = " + table1.getText());

        System.out.println("**********************");
        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement satir3 = driver.findElement(By.xpath("(//tr)[4]"));
        System.out.println("satir3 = " + satir3.getText());


        //    Task 3 : Son satırın verilerini yazdırın


        //    Task 4 : 5. Sütun verilerini yazdırın


        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData


        //    Parameter 1 = satır numarası


        //    Parameter 2 = sütun numarası


        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.







    }
}
