import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadFile {
    public static WebDriver driver;

    public static void main(String[] args) throws AWTException {
        initializeDriver();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/upload");
        implicitWait();
        //uploadingUsingSenkeys("E:\\Nezam\\Seleniumexercise\\src\\main\\resources\\screentest.png");
        uploadUsingRobot("E:\\Nezam\\Seleniumexercise\\src\\main\\resources\\screentest.png");
        //QuiteWindows();

    }

    public static void initializeDriver()  /// open Edge as a guest mode
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    public static WebElement byToWebelement(By locator){
        return driver.findElement(locator);
    }
    public static void OpenBroswer(String URL){
        driver.get(URL);
    }
    public static void OpenBrowserUsingNavigation(String URL){
        driver.navigate().to(URL);
    }
    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void uploadingUsingSenkeys(String path){
        driver.findElement(By.id("file-upload")).sendKeys(path);
    }

    public static void uploadUsingRobot(String path) throws AWTException {
        driver.findElement(By.xpath("//*[@id=\"drag-drop-upload\"]")).click();

        StringSelection stringSelection = new StringSelection(path); // CTRL + C
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);  // SystemClipboard

        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);     //press enter
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);       // press control
        robot.keyPress(KeyEvent.VK_V);           // press v     // CTRL + V
        robot.keyRelease(KeyEvent.VK_V);        // release V
        robot.keyRelease(KeyEvent.VK_CONTROL);   // release Control
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);

    }

}
