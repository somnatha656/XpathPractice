import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void windowHandlePractice() throws InterruptedException {
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("This is Parent Window handle");
        System.out.println(parentWindowHandle);

        //new window
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")).click();
                Thread.sleep(3000);
                driver.close();
                break;

            }


        }
      Thread.sleep(3000);
        driver.switchTo().window(parentWindowHandle);
       driver.findElement(By.id("name")).sendKeys("text");
       Thread.sleep(2000);
    }

  @After
   public void exit() {
        driver.quit();
  }
    }

