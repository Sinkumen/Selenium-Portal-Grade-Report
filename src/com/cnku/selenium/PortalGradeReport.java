package com.cnku.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GoBack;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PortalGradeReport {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CNKU\\Downloads\\Compressed\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("https://portal.aait.edu.et/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("Successfully opened the website localhost");


        driver.findElement(By.id("UserName")).sendKeys("ATR/5357/09");
        Thread.sleep(1000);
        driver.findElement(By.id("Password")).sendKeys("My Password");
        Thread.sleep(1000);
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(1000);
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        String hh = driver.getCurrentUrl();
        driver.get(hh);
        System.out.println(driver.findElement(By.tagName("table")).getText());

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("My Grade Report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("");
            printWriter.append("\t\tAddis Ababa University\n");
            printWriter.append("\t\t\t\tAAIT\n");
            printWriter.append("Name: Sinkumen Aseffa\n");
            printWriter.append("Id: ATR/5357/09\n");
            printWriter.append("Stream: Software Section - 3\n\n\n");
            printWriter.append(driver.findElement(By.tagName("table")).getText());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        }
}
