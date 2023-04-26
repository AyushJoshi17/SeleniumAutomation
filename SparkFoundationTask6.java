package org.SparkFoundationTask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SparkFoundationTask6 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.manage().window().maximize();

        //Script to search for spark foundation Website
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("The sparks foundation");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a"))));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a")).click();

        //Test of Main Page ; Page no-1
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //Test Case 1:To Check the title is correct or not
        WebElement title = driver.findElement(By.xpath("//a[@class='col-md-6 navbar-brand']"));

        if (title.equals(driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/h1/a")))) {
            System.out.println("Title is tested Successfully");
        } else {
            System.out.println("Title is wrong ");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Test case 2:To Check logo is correct or not

        driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/h1/a/img")).click();

        WebElement logo = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/h1/a/img"));
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed successfully");
        } else {
            System.out.println("Logo havent displayed");
        }

        //Test case 3:To check wheather linkedin link opening or not

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");
        driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[1]/div[1]/ul/li[2]/a")).click();

        String mainwindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!mainwindow.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }


        String url = js.executeScript("return document.URL;").toString();
        if (url.equals("https://www.linkedin.com/company/the-sparks-foundation/?original_referer=https%3A%2F%2Fwww.thesparksfoundationsingapore.org%2F")) {
            System.out.println("Linkedin page opened successfully");
        } else {
            System.out.println("Failed to open Linkedin page");
        }

        driver.close();
        driver.switchTo().window(mainwindow);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("toTopHover"))));

        driver.findElement(By.id("toTopHover")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Test case of About us Page; Page-2
        //Test case 4: Wheather about us page is displaying or not

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle menu__link'])[1]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[1]/a")).click();
        WebElement element = driver.findElement(By.xpath("//h2[text()='Vision, Mission and Values']"));

        if (element.isDisplayed()) {
            System.out.println("About page is displayed successfully");
        } else {
            System.out.println("About us page failed to display");
        }

        //Test case 5: Wheather Policies and code page displaying or not

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle menu__link'])[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[2]/ul/li[1]/a")).click();
        WebElement code = driver.findElement(By.xpath("//h2[text()='Policies']"));
        if (code.isDisplayed()) {
            System.out.println("Policies and code page is displayed successfully");
        } else {
            System.out.println("Policies and code page failed to display");
        }

        //Test case 6 : To check if join GRIP Intership page Opening or Not

        driver.findElement(By.xpath("//a[@class='col-md-6 navbar-brand']")).click();
        js.executeScript("window.scrollBy(0,2500)");
        driver.findElement(By.xpath("//a[text()='GRIP (Internship)']")).click();

        WebElement internship = driver.findElement(By.xpath("//h2[text()='Internship Positions']"));

        if (internship.isDisplayed()) {
            System.out.println("Grip Internship page opened successfully");
        } else {
            System.out.println("Failed to open Grip Internship page");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Test case 7: To check wheather Contact us page Opening or not

        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[6]/a")).click();

        WebElement contact = driver.findElement(By.xpath("//h2[text()='Contact Us']"));

        if (contact.isDisplayed()) {
            System.out.println("Contact us Page is Displayed successfully");
        } else {
            System.out.println("Failed to open contact us page");
        }

        // Test case 8:To check wheather Homepage opens when click on Main Title
        driver.findElement(By.xpath("//a[@class='col-md-6 navbar-brand']")).click();

        WebElement home = driver.findElement(By.xpath("//a[@class='col-md-6 navbar-brand']"));
        if (home.isDisplayed()) {
            System.out.println("Home page displayed Successfully");
        } else {
            System.out.println("Failed to display HomePage");
        }


        //Test Case 9: To check Wheather Join us page opening or not

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle menu__link'])[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[5]/ul/li[1]/a")).click();

        WebElement joinus = driver.findElement(By.xpath("//h2[text()='Join Us']"));
        if (joinus.isDisplayed()) {
            System.out.println("Join us page opened Successfully");
        } else {
            System.out.println("Failed to open Join us page");
        }

        //Test case 10:To check wheather Join us form works or not

        js.executeScript("window.scrollBy(0,1400)");
        WebElement fullname = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[1]"));
        fullname.sendKeys("Ayush Joshi");

        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[2]"));
        email.sendKeys("ayush401298@gmail.com");

        if(fullname.getAttribute("value").equals("Ayush Joshi")){
            System.out.println("Name displayed on form");
        }
        else{
            System.out.println("Name not displayed on form");
        }

        if(email.getAttribute("value").equals("ayush401298@gmail.com")){
            System.out.println("Email is displayed on form");
        }
        else{
            System.out.println("Email failed to display");
        }

        WebElement form = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/select"));
        Select select = new Select(form);
        select.selectByIndex(4);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //Test case 11:To check wheather Map displaying or not

        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[6]/a")).click();

        js.executeScript("window.scrollBy(0,500)");
        WebElement map = driver.findElement(By.xpath("/html/body/div[3]/iframe"));

        if(map.isDisplayed()){
            System.out.println("Map is displayed Successfully");
        }
        else{
            System.out.println("Failed to display map");
        }


    }
}
