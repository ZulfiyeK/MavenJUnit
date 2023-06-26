package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {

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
    public void webTablesTest1() {


        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        // Table1'i yazdirin
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());


        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");//kalip
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

    }


    @Test
    public void webTablesTest2() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        // 3.satır verilerini yazdırın
        List<WebElement> ucuncuSatir = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));

        ucuncuSatir.stream().forEach(t -> System.out.print(t.getText() + " - "));

    }


    @Test
    public void webTableTest3() {


        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        //son satir verilerini yazdirin
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td"));//tablo,body,4.satir,satir verileri seklinde yolu aliyoruz.

        sonSatir.stream().forEach(t -> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTableTest4() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        // 5. Sütun baslıgını yazdırın
        WebElement besinciSutunBasligi = driver.findElement(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        System.out.println(besinciSutunBasligi.getText());



        // 5.Sütun verilerini yazdırın
        List<WebElement> besinciSutunVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        besinciSutunVerileri.stream().forEach(t-> System.out.println(t.getText() + " - "));

    }


    @Test
    public void webTableTest5() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        // iki parametreli bir java methodu olusturalım
        // Parametre 1 => satır numarasını
        // Parametre 2 => sutun numarası
        // prinData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın

        prinData(2,2);
        prinData(2,5);
        prinData(3,3);
       // prinData(3,7);//7.sutun olmadigi icin NoSuchElementException verir.

    }
    private void prinData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }
}
