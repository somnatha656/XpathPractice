import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class XpathPra {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='bmw']")).click();
        driver.findElement(By.xpath("//input[@id='benzradio']")).click();
        driver.findElement(By.xpath("//input[@id='hondaradio']")).click();
        driver.findElement(By.cssSelector("option[value='apple']")).click();
        driver.findElement(By.cssSelector("option[value='orange']")).click();
        driver.findElement(By.cssSelector("option[value='peach']")).click();
    }

    @Test
    public void dropdown() throws InterruptedException {

        driver.findElement(By.cssSelector("option[value= 'bmw']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value= 'benz']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value= 'honda']")).click();
        Thread.sleep(5000);

    }

    @Test
    public void checkbox() {
        driver.findElement(By.cssSelector("input#bmwcheck")).click();
      driver.findElement(By.xpath("//input[@id = 'benzcheck']")).click();
       driver.findElement(By.cssSelector("input#hondacheck")).click();

    }
    @Test
    public void switchWindow(){
        driver.findElement(By.cssSelector("button#openwindow")).click();

    }
    @Test
    public void switchTab(){
        driver.findElement(By.xpath("//a [@id= 'opentab']")).click();

    }
    @Test
    public void alertSwitch() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Jalpa");
       // driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //alert.accept();
        alert.dismiss();
    }
    @Test
    public void iframeSwitch() throws InterruptedException {
        //driver.switchTo().frame(0);//switch to frame by index
       // driver.switchTo().frame("courses-iframe"); //switch to frame by id
        driver.switchTo().frame("iframe-name"); //switch to frame by name
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("java");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//iframe[@id='courses-iframe']")).click();
        //driver.findElement(By.name("iframe-name")).click();

    }
    @Test
    public void disableEnable() throws InterruptedException {
        driver.findElement(By.id("disabled-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("enabled-button")).click();
        driver.findElement(By.cssSelector("#enabled-example-input")).sendKeys("field is enabled");
    }
    @Test
    public void elementDisplayed() throws InterruptedException {
       // driver.findElement(By.id("hide-textbox")).click();
        driver.findElement(By.xpath("//input[@id= 'hide-textbox']")).click();
       Thread.sleep(3000);
        driver.findElement(By.id("show-textbox")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id= 'displayed-text']")).sendKeys("Patel");
    }
    @Test
    public void mouseHover() throws InterruptedException {
        WebElement mainElement = driver.findElement(By.xpath("//button[@id='mousehover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainElement).perform();
       WebElement topElement=driver.findElement(By.xpath("//a[@href='#top']"));
        Thread.sleep(3000);
        WebElement mainElement1 = driver.findElement(By.xpath("//button[@id='mousehover']"));
        actions.moveToElement(topElement).click().perform();
        Thread.sleep(3000);
        WebElement subElement1=driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
        Thread.sleep(3000);
        actions.moveToElement(subElement1).click().perform();
        Thread.sleep(3000);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}

