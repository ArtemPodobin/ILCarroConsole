package manager;

import models.Car;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm(){
        pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));

    }

    public void fillCarForm(Car car){
        if(isCarFormPresent()==false) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
//        clickSerialNumber(car.getCarRegNumber());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }
    public void typeCity(String address){
        type(By.id("city"), address);
        click(By.cssSelector("div.pac-item"));

    }

    public void clickSerialNumber(String text){

//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
        WebElement rect = wd.findElement(By.id("serialNumber"));
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();
        actions.moveToElement(rect).click().perform();
        rect.clear();
        rect.sendKeys(text);
    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(
                                wd.findElement(By.cssSelector("h2")),
                                "details"));
    }

    public void fillSearchForm(Car car) {
        if(isSearchForm()==false) return;
        typeCity(car.getLocation());
        typeDate(car.getDate());
    }

    private void typeDate(String date) {
        type(By.id("dates"), date);

    }

    private boolean isSearchForm() {
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(
                                wd.findElement(By.cssSelector("h1")),
                                "Find"));
    }
    public String getDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        String datePickUp = date.format(calendar.getTime());
        calendar.add(Calendar.DATE, 2);
        String datePickDown = date.format(calendar.getTime());
        String dates = datePickUp + " - " + datePickDown;
        return dates;
    }
    private LocalDate getRandomDate(){
        Random random = new Random();
        int start = (int) LocalDate.now().toEpochDay();
        int end = (int) LocalDate.now().plusYears(1).toEpochDay();
        long randomDay = start + random.nextInt(end - start);
        LocalDate date = LocalDate.ofEpochDay(randomDay);
        return date;
    }


    public void fillSearchFormForRandomDates(Car car) {
        if(isSearchForm()==false) return;
        Random random = new Random();
        LocalDate startDate = getRandomDate();
        int i = random.nextInt(365);
        LocalDate endDate = startDate.plusDays(i);


        String yearStart = "//td[@aria-label='" + startDate.getYear() +"']";
        String monthStart = "//div[normalize-space()='"+ String.valueOf(startDate.getMonth()).substring(0, 3) +"']";
        String dayStart = "//div[normalize-space()='" + startDate.getDayOfMonth() + "']";
        String yearEnd = "//td[@aria-label='" + endDate.getYear() +"']";
        String monthEnd = "//div[normalize-space()='"+ String.valueOf(endDate.getMonth()).substring(0, 3) +"']";
        String dayEnd = "//div[normalize-space()='" + endDate.getDayOfMonth() + "']";


        typeCity(car.getLocation());
        click(By.id("dates"));
        click(By.xpath("//button[@type='button']"));
        click(By.xpath(yearStart));
        click(By.xpath(monthStart));
        click(By.xpath(dayStart));
        click(By.xpath("//button[@type='button']"));
        click(By.xpath(yearEnd));
        click(By.xpath(monthEnd));
        click(By.xpath(dayEnd));











    }

}
