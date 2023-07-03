package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {

   /*

   Excel'de bir hucredeki veriye ulasmak icin

     -->   dosya/sayfa/satir/sutun

   siralamasi ile yazmamiz gerekiyor.
   satir ve hucre kombinasyonu ile verilere ulasabiliriz.

    */

    @Test
    public void excelReadTest1() throws IOException {

        //excel dosyasindan veri okuyabilmemiz icin
        //    1. dosya yolunu almamiz gerekir.

        String dosyaYolu ="src/test/java/resources/Capitals (2).xlsx";

        //    2. Capitals dosyasini sistemizie getirmemiz gerekir.
        FileInputStream fis = new FileInputStream(dosyaYolu);//dosyayi okuyabilmek icin akisa almamiz gerekir. bunu da stream ile yapmis oluruz.

        //  3. dosyayi workbook'a atamaliyiz, java ortaminda bir excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);

        //  4. sayfayi(sheet) secmeliyiz.
        Sheet sheet = workbook.getSheet("Sheet1");//sayfa numarasi secmeliyim.

        //  5. satiri secmeliyiz.
        Row row = sheet.getRow(0);// index 0 dan baslar. hangi satirda islem yapilacaksa index no yazilir.

        //6. hucreyi secmeliyiz
        Cell cell = row.getCell(0);


    }

    @Test
    public void excelReadTest2() throws IOException {
        //kisa yontem
        //1.satir,1.sutundaki bilgiyi yazdiriniz.

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
       String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();//toString koymazsak hata verir.
        System.out.println("satir1Sutun1 = " + satir1Sutun1);

    }

    @Test
    public void excelReadTest3() throws IOException {
        //kisa yontem
        //1.satir,1.sutundaki bilgiyi yazdiriniz.

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun2 = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();//toString koymazsak hata verir.
        System.out.println("satir1Sutun2 = " + satir1Sutun2);




    }
}
