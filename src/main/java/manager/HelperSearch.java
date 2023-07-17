package manager;


import models.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }
    public void fillSearchForms(Search search){
        fillCity(search);
        selectPeriod(search);

    }
    public void fillCity(Search search){
        type(By.id("city"), search.getCity());
        click(By.cssSelector("div.pac-item"));
    }
    public void submitForm(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void selectPeriod(Search search){

        String[] startDate = search.getStartDate().split("/");
        String[] endDate = search.getEndDate().split("/");

//        LocalDate fromDate = LocalDate.of(startDate[0], startDate[1], startDate[2]);
//        LocalDate toDate = LocalDate.parse(search.getEndDate(), DateTimeFormatter.ofPattern("MMM/dd/yyyy"));



        String yearStart = "//td[@aria-label='" + startDate[2] +"']";
        String monthStart = "//div[normalize-space()='"+ startDate[0] +"']";
        String dayStart = "//div[normalize-space()='" + startDate[1] + "']";
        String yearEnd = "//td[@aria-label='" + endDate[2] +"']";
        String monthEnd = "//div[normalize-space()='"+ endDate[0] +"']";
        String dayEnd = "//div[normalize-space()='" + endDate[1] + "']";

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
