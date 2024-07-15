import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Action {
    public static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {
       // OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/context_menu");
        //rightClick();
      // OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/drag_and_drop");
        implicitWait();
         //Dropdown();
      //  Click_hold();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/hovers");
        hover();
         QuiteWindows();
    }
    public static WebElement byToWebelement(By locator){
        return driver.findElement(locator);
    }
    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void OpenBroswer(String URL){
        driver.get(URL);
    }
    public static void OpenBrowserUsingNavigation(String URL){
        driver.navigate().to(URL);
    }

    public static void handlingDropdown(){
        By dropdown = By.cssSelector("select#dropdown");
        String text = new Select(byToWebelement(dropdown)).getFirstSelectedOption().getText();
        System.out.println(text);
        int size = new Select(byToWebelement(dropdown)).getOptions().size();
        System.out.println(size);

    }

    public static void rightClick(){
        By rightclick = By.id("hot-spot");
        new Actions(driver).contextClick(byToWebelement(rightclick)).perform();
    }
    public static void Dropdown(){
        By boxA = By.id("column-a");
        By boxB = By.id("column-b");
        new Actions(driver).dragAndDrop(byToWebelement(boxA),byToWebelement(boxB)).perform();
        new Actions(driver).dragAndDrop(byToWebelement(boxB),byToWebelement(boxA)).perform();
    }
    public static void Click_hold(){
        By boxA = By.id("column-a");
        By boxB = By.id("column-b");
        new Actions(driver).clickAndHold(byToWebelement(boxA))
                .moveToElement(byToWebelement(boxB))
                .release()
                .build()
                .perform();
    }
    public static void hover(){
        By picture = By.xpath("(//img)[3]");
        new Actions(driver).moveToElement(byToWebelement(picture)).perform();

    }

    public static void CloseWendows(){
        driver.close();
    }
    public static void QuiteWindows(){
        driver.quit();
    }

}
