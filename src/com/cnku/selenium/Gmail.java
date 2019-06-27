package com.cnku.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Gmail
{
    public static void main(String[] args) throws InterruptedException {
// Create a new instance of the Firefox driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CNKU\\Downloads\\Compressed\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("http://mail.google.com");
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("my_email_address");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

        Thread.sleep(10000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pass.click();
        pass.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        Thread.sleep(1000);
        List<WebElement> unread = driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println(unread.size() + " Unread Messages Exit");

        FileWriter writer;
        try {
            writer = new FileWriter("My Unread Messages.txt");
            for (WebElement message: unread  ) {
                System.out.println(message.getText());
                writer.write(message.getText()+"\n");

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
