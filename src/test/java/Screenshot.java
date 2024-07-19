import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        //initalizeDriver();
        headlessDriver();

        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/forgot_password");
        takingScreenshot("screenbutton4");

    }

    public static void initalizeDriver()  // open edge browser as guest mode
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    public static void headlessDriver() // Run in headless mode, i.e., without a UI
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
    }

    public static void OpenBrowserUsingNavigation(String URL) {
        driver.navigate().to(URL);
    }

    public static WebElement byToWebelement(By locator) {
        return driver.findElement(locator);
    }

    public static void takingScreenshot(String imagename) throws IOException {
        String path = "E:\\Nezam\\Seleniumexercise\\src\\main\\resources\\";
        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File src = (byToWebelement(By.cssSelector("button[class='radius']"))).getScreenshotAs(OutputType.FILE);
        File target = new File(path + imagename + ".png");
        FileUtils.copyFile(src, target);        // commons-io <dependency>

    }
}
