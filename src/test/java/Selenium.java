import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import javax.swing.*;
import java.time.Duration;

public class Selenium {
    public static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
      /*  OpenBroswer("https://the-internet.herokuapp.com/login");
        OpenBrowserUsingNavigation("https://www.nezamacademy.com");
        ClickOnBack();
        ClickOnForward();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/login");
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/dynamic_loading/1");
        Elementhidden();
        System.out.println(Helloworld());
         OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/checkboxes");
        handlingCheckbox();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/context_menu");
        rightClick();
       OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/drag_and_drop");
                OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/drag_and_drop");
       implicitWait();
       // Dropdown();
        Click_hold();
         */
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/hovers");
        implicitWait();
        hover();
      // QuiteWindows();

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
    public static void ClickOnBack(){
        driver.navigate().back();
    }
    public static void ClickOnForward(){
        driver.navigate().forward();
    }

    public static void ManageWindows(){
        //driver.manage().window().setSize(new Dimension(430,932));
        driver.manage().window().maximize();
    }

    public static void GetCurrentUrlOfThePage(){
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
    }
    public static void GetSourceCode(){
        String SourceCode = driver.getPageSource();
        System.out.println(SourceCode);
    }

    public static void GetPageTitle(){
        String Titel = driver.getTitle();
        System.out.println(Titel);
    }
    public static void GetWindowsIde(){
        String handel1 = driver.getWindowHandle();
        System.out.println(handel1);

        driver.switchTo().newWindow(WindowType.TAB);
        String handel2 = driver.getWindowHandle();
        System.out.println(handel2);

    }
    public static void cleartext(){
        By usernamelocator = By.id("username");
        driver.findElement(usernamelocator).clear();
    }
    public static void EnterText(String username , String password){
        By usernamelocator = By.id("username");
        By passwordlocator = By.id("password");
        driver.findElement(usernamelocator).sendKeys(username);
        driver.findElement(passwordlocator).sendKeys(password);
    }
    public static void Clicking(){
        By LoginButtonLocator = By.className("radius");
        driver.findElement(LoginButtonLocator).click();
    }
    public static String getMassegetext(){
        By successmessageLecator = By.id("flash");
        return driver.findElement(successmessageLecator).getText();
       // System.out.println(driver.findElement(successmessageLecator).getText());

    }
    public static void Elementhidden(){
        By hiddenelementLocator = By.partialLinkText("Example 1");
        driver.findElement(hiddenelementLocator).click();
    }
    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void explicitWait(By locator){
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(byToWebelement(locator)));
    }
    public static void fluentWait(By locator){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .withMessage(locator.toString()+ "doesn't meet the criteria")
                .pollingEvery(Duration.ofMillis(2l))
                .until(ExpectedConditions.alertIsPresent());
    }

    public static String Helloworld(){
            By clickbuttonLocator = By.tagName("button");
        By gettextlocator = By.xpath("//div[@id=\"finish\"]/h4");

            driver.findElement(clickbuttonLocator).click();
        fluentWait(gettextlocator);
        return  driver.findElement(gettextlocator).getText();
        }

    public static void handlingDropdown(){
        By dropdown = By.cssSelector("select#dropdown");
        String text = new Select(byToWebelement(dropdown)).getFirstSelectedOption().getText();
        System.out.println(text);
        int size = new Select(byToWebelement(dropdown)).getOptions().size();
        System.out.println(size);

    }
    public static void handlingCheckbox(){
        By checkbox = By.cssSelector("input[type='checkbox']:nth-of-type(2)");
        driver.findElement(checkbox).click();
        new Actions(driver).doubleClick(byToWebelement(checkbox)).perform();
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
