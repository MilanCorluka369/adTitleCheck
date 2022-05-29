import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "G:\\Dev & QA\\IT Bootcamp\\Materijal\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.navigate().to("https://www.kupujemprodajem.com");

            Thread.sleep(3000);

            WebElement el1 = driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
            el1.click();

            WebElement el2 = driver.findElement(By.id("searchKeywordsInput"));
            el2.sendKeys("iphone 13" + Keys.ENTER);

            List<WebElement> listaOglasa = driver.findElements
                    (By.xpath("//a[contains(@class, 'adName')]"));

            String expectedResult = "iPhone 13, iPhone 12, iPhone 11 - NOVO!";
            String actualResult = listaOglasa.get(0).getText();

            if (expectedResult.equals(actualResult))
                System.out.println("Actual title is equal to expected title " + actualResult + " = " +
                        expectedResult + "\nTest Passed");
            else
                System.out.println("Actual title is equal to expected title " + actualResult + " = " +
                        expectedResult + "\nTest Failed");

            WebElement elementOglasa = listaOglasa.get(0);
            elementOglasa.sendKeys(Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
