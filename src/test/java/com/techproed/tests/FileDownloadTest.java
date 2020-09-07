package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        //C:\Users\harun\IdeaProjects\TestNGProje

        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));

        Assert.assertTrue(varMi);


    }
    @Test
    public void dosyaUpload(){

        // bilgisayardan websayfasına doysa yükleme

        //C:\Users\harun\Logo\logo.png
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        // yüklemek istediğimiz dosyanın, path(dosya yolunu) ekleyelim.

        chooseFile.sendKeys("C:\\Users\\harun\\Logo\\logo.png");
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));


        Assert.assertTrue(fileUploadedYazisi.isDisplayed());


    }

    @Test
    public void dosyaDownload(){
        // C:\Users\isimsiz\Downloads\Amsterdam.jpg
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:\\Users\\harun\\Downloads\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }


}
