package methods;

import base.Base;
import base.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Methods extends Base {


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        Log.info(by +" Element bulundu.");
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        Log.info(by+" elementlerin listesi bulundu.");
        return driver.findElements(by);
    }

    public int randomPick(int size) {
        Random rand = new Random();
        int minimum = 1;
        int pick = rand.nextInt(size - minimum) + minimum;
        Log.info(minimum + " değeri ile "+size+ " değeri arasında rastgele seçilen sayı : "+pick);
        return pick;
    }

    public void randomBookPickClick(By by) {

        int a = randomPick(findElements(by).size());
        WebElement element = findElements(by).get(a);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        Log.info("Random seçilen elemente tıklandı ..");
    }

    public String getText(By by, String text) {

        wait.until(ExpectedConditions.textToBe(by, text));
        Log.info(by+ " elementinin text değeri :  " +text);
        return findElement(by).getText();


    }

    public void assertionTextControl(By by, String text) {

        Assert.assertEquals("Textlerin birbirine eşit olmadığı görüldü.",text, getText(by, text));

        System.out.println(by+ " elementindeki yazı ile "+ text +" yazısı karşılaştırıldı.");
    }

    public void clickToElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        Log.info(by + " elementine tıklandı.");


    }

    public void clearToElement(By by) {

        findElement(by).clear();
        Log.info(by + " elementi silindi.");
    }

    public void currentUrlControl(String url) {
        Log.info(driver.getCurrentUrl());
        Assert.assertEquals("Güncel sitenin hedeflenen site ile url'i aynı değildir.", driver.getCurrentUrl(), url);
        Log.info(url + " Siteye gidildiği doğrulandı.");


    }

    public void getUrl(String url) {
        driver.get(url);


    }

    public void sendKey(By by, String key) {
        findElement(by).sendKeys(key);
        Log.info(by +" elementine "+ key +" texti yazıldı.");
    }

    public void enterKey(By by) {
        findElement(by).sendKeys(Keys.ENTER);
        Log.info("Enter tuşu basıldı.");
    }

    public String csvRead() {
        String csv = "src/test/java/Roman.csv";
        File file = new File(csv);
        String roman = null;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                roman = sc.next();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            Log.warn("Dosya okumada hata ile karşılaşıldı.");
        }
        Log.info("*" + roman + " kelimesi csv dosyasından çekildi.*");
        return roman;
    }


}
