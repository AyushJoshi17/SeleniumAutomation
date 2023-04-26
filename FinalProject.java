package org.example.assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FinalProject {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("input-email")).sendKeys("ayush401298@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("ayush.12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement laptopsnoteBookMenu = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement AllLaptopNoteBookslink = driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));

        Actions action = new Actions(driver);
        action.moveToElement(laptopsnoteBookMenu).click(AllLaptopNoteBookslink).build().perform();

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String product_text1 = driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String product_text2 = driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();

        if(product_text1.equals("MacBook Air")){
            System.out.println("Product 1 is correct");
        }
        else{
            System.out.println("Product1 is incorrect");
        }

        if(product_text2.equals("MacBook Pro")){
            System.out.println("Product 2 is correct");
        }
        else{
            System.out.println("Product 2 is incorrect");
        }

        String amount = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[2]//td[2]")).getText();
        if(amount.equals("$3,000.00")){
            System.out.println("Amount is correct");
        }
        else{
            System.out.println("Amount is incorrect");
        }

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.quit();
    }
}
