package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite extends TestBase {

    @Test
    public void ExcelWrite() throws IOException {

        //Bir "Nufus" sutunu olusturun
        //Baskent nufuslarini excel dosyasina yazdiriniz.
        //(D.C = 1100, PARIS =1200 , LONDON =1300 , ANKARA = 1400)


        String dosyaYolu = "src/test/java/resources/Capitals (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);//dosyayi sistemimize getirdik
        Workbook workbook = WorkbookFactory.create(fis);//dosyayi workbook'a atadik
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");//yeni bir sutun ekledik ve adina NUFUS dedik.
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");// String olarak kayit yapacak ve sola yaslayacak
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(1500);// int olarak kayit yapacak ve saga yaslayacak
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(1400);
        //Excel'de bir hucre olusturmak icin "createCell()" methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin "setCellValue()" methodu kullanilir

        FileOutputStream fos = new FileOutputStream(dosyaYolu);//datalari bizim calss'imizdan Capital dosyasina gonderecegiz.
        workbook.write(fos);//workbook 'daki datalari fos'a yazdik.
















    }
}
