package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public void setText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
        }catch(Exception e){
            System.out.println("Not able to enter the text");
        }
    }

    public static String getCurrentEpochTime(){
          return "I want to be the best QA Engineer! "+Instant.now().toEpochMilli();
        }

    public void clickElement(WebElement element){
        try{
            element.click();
        }catch(Exception e){
            System.out.println("Not able to click on the element");
        }
    }

     public static String getDateBeforeSevenDays(){
            LocalDate currentDate = LocalDate.now();
            LocalDate sevenDaysBefore = currentDate.minusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return sevenDaysBefore.format(formatter);
        }
}
