import org.apache.commons.io.FileUtils;
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
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Selenium {
    public static WebDriver driver = new EdgeDriver();
    public static String firstTab;
    public static String secondTab;
    public static void main(String[] args) throws InterruptedException, IOException {
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

        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/nested_frames");
        implicitWait();
        Ifram();
       Nestedfram();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/javascript_alerts");
        promptAlert();
       acceptAlert();
        dismissAlert();
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/key_presses");
       KeyUsingSendKeys();
        KeyUisingAction();
        UpperKeys();
        */
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/forgot_password");
        implicitWait();
        takingScreenshot("screenbutton2");
      //QuiteWindows();

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
    public static void handlingCheckbox(){
        By checkbox = By.cssSelector("input[type='checkbox']:nth-of-type(2)");
        driver.findElement(checkbox).click();
        new org.openqa.selenium.interactions.Actions(driver).doubleClick(byToWebelement(checkbox)).perform();
    }
    public static void Ifram(){
        By textArea = By.cssSelector("body#tinymce");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(textArea).clear();
        driver.findElement(textArea).sendKeys("ahmed");
        driver.switchTo().parentFrame();
    }
    public static void Nestedfram(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
    public static void acceptAlert(){
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    public static void dismissAlert(){
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
    }
    public static void promptAlert(){
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
       Alert alert = driver.switchTo().alert();
       alert.sendKeys("ahmed");
        alert.accept();
    }
    public static void KeyUsingSendKeys(){
        driver.findElement(By.id("target")).sendKeys(Keys.ARROW_DOWN);
        //driver.findElement(By.id("target")).sendKeys(Keys.ARROW_RIGHT);
    }
    public static void KeyUisingAction(){
        //new Actions(driver).keyDown(Keys.SHIFT).perform();
        new Actions(driver).keyDown(Keys.SHIFT)
                .keyDown(Keys.ALT)
                .keyUp(Keys.ALT)
                .keyUp(Keys.SHIFT).perform();
    }
    public static void UpperKeys(){
        By text = By.id("target");
        new Actions(driver).keyDown(byToWebelement(text),Keys.SHIFT)
                .sendKeys(byToWebelement(text), "ahmed")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }
    public static void scollingUsinJS(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",byToWebelement(By.id("")) );
        new WebDriverWait(driver,Duration.ofSeconds(5))
            .until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(byToWebelement(By.id("")),"disabled")));
        driver.findElement(By.id("")).sendKeys("test");
    }
    public static void scrollingUsingAction(){
        new Actions(driver).scrollToElement(byToWebelement(By.id(""))).perform();
        driver.findElement(By.id("")).sendKeys("test");
    }
    public static void takingScreenshot(String imagename) throws IOException {
        String path = "E:\\Nezam\\Seleniumexercise\\src\\main\\resources\\";
        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File src = (byToWebelement(By.cssSelector("button[class='radius']"))).getScreenshotAs(OutputType.FILE);
        File target = new File(path+imagename+".png");
        FileUtils.copyFile(src,target);

    }

    public static void CloseWendows(){
        driver.close();
    }
    public static void QuiteWindows(){
        driver.quit();
    }


}
