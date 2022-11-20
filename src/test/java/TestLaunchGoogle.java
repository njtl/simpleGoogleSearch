import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLaunchGoogle {

    WebDriver wd;
    @BeforeTest
    public void prepare(){
        wd = new ChromeDriver();
        wd.get("https://google.com");
        wd.manage().window().maximize();
        wd.findElement(By.id("L2AGLb")).click();
    }

    @Test
    public void ourTest() throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        search.click();
        search.sendKeys("Selenium");
        Thread.sleep(2000);
        search.sendKeys(Keys.RETURN);
        Thread.sleep(2000);

        String source = wd.getPageSource();
        String seleniumText = "selenium.dev";
        System.out.println(source.contains(seleniumText));
        Thread.sleep(2000);
    }

    //
    @AfterTest
    public void after(){
        wd.close();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wd.quit();
    }

}
