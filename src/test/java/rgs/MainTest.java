package rgs;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainTest extends WebDriverSettings {

    @Test
    public void firstTest(){

        driver.get("https://www.rgs.ru/");

        driver.findElement(By.xpath("//li[@data-dropdown-hide-animation = \"navbar-rgs-droupdown-menu-animation-out\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//form/div/div//ul/li/A[@href='https://www.rgs.ru/products/private_person/health/dms/generalinfo/index.wbp']/parent::li")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "ДМС 2019 | Рассчитать стоимость добровольного медицинского страхования и оформить ДМС в Росгосстрах");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//A[@class=\"btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//B[contains(text(),'Заявка на добровольное медицинское страхование')]"));

        setForm();

        driver.findElement(By.xpath("//button[@id = 'button-m']")).click();

        System.out.println("Проверка неверного параметра: " + driver.findElement(By.xpath("//span[@class = \"validation-error-text\"]")).getText());


    }
    private void setForm(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name = 'LastName']")));

        WebElement lastName = driver.findElement(By.xpath("//input[@name = 'LastName']"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name = 'LastName']")));
        lastName.sendKeys("Петров");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name = 'LastName']")));
        System.out.println("Введена фамилия: " + lastName.getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name = 'LastName']")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstName = driver.findElement(By.xpath("//input[@name = 'FirstName']"));
        firstName.sendKeys("Александр");
        System.out.println("Введено имя: " + firstName.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement middleName = driver.findElement(By.xpath("//input[@name = 'MiddleName']"));
        middleName.sendKeys("Сергеевич");
        System.out.println("Введено отчество: " + middleName.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement selectElement = driver.findElement(By.xpath("//select"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Москва");
        System.out.println("Введен регион: " + selectElement.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement phone =  driver.findElement(By.xpath("//label[text()=\"Телефон\"]/parent::div/input"));
        phone.click();
        phone.sendKeys("8005553535");
        System.out.println("Введен телефон: " + phone.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement mail = driver.findElement(By.xpath("//label[text()=\"Эл. почта\"]/parent::div/input"));
        mail.click();
        mail.sendKeys("qwertyqwerty");
        System.out.println("Введено адрес электронной почты: " + mail.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement contactDate = driver.findElement(By.xpath("//input[@name='ContactDate']"));
        contactDate.click();
        contactDate.sendKeys("12.12.2019");
        System.out.println("Введена дата: " + contactDate.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement comment = driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("Хочу страховку");
        System.out.println("Введен комментарий: " + comment.getAttribute("value"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class=\"checkbox\"]")).click();
    }
   @Test
   public void secondTest() {
       driver.get("https://www.sberbank.ru/ru/person");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//div[@class=\"paste-region__region header__region header__region_77\"]/div/div/a")).click();

       WebDriverWait wait = new WebDriverWait(driver,60);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class = \"kit-input__control\" and @placeholder=\"Москва\"]")));
       driver.findElement(By.xpath("//input[@class = \"kit-input__control\" and @placeholder=\"Москва\"]")).sendKeys("Нижегородская область");


       driver.findElement(By.xpath("//a[@class = \"kit-link kit-link_m hd-ft-region__city\"]")).click();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       System.out.println("Выбранный регион: " + driver.findElement(By.xpath("//li/div/div/div/a[ @class=\"hd-ft-region\"]/div[ @class=\"hd-ft-region__title\"]/span")).getAttribute("innerHTML"));

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebElement element = driver.findElement(By.xpath("//footer"));
       driver.executeScript("arguments[0].scrollIntoView(true);", element);

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       for (int i = 1; i < 7; i++){
           System.out.println("Значек соц. сети: " + driver.findElement(By.xpath("//ul[@class =\"footer__social\"]/li[" + i + "]/a")).getAttribute("title"));
       }
   }
}
