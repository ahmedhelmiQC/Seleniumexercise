import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

public class HandingWindows {
    public static WebDriver driver = new ChromeDriver();
    public static String firstTab;
    public static String secondTab;

    public static void main(String[] args) {
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/windows");
        implicitWait();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("firstTab", firstTab);
        hashMap.put("secondTab",secondTab);
        Set<String> handles = openNewTab();
        for (String h :handles){
            if (! h.equals(firstTab))
                secondTab = h;
        }
        driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://github.com/");
        System.out.println(firstTab);
        System.out.println(secondTab);
        System.out.println(driver.getCurrentUrl());
        switchingTab(secondTab);
        System.out.println(driver.getCurrentUrl());

        QuiteWindows();
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
    public static Set<String> openNewTab(){
        By newTabButtom = By.cssSelector("a[href='/windows/new']");
        driver.findElement(newTabButtom).click();
        firstTab = driver.getWindowHandle();
        return driver.getWindowHandles();
    }
    public static void switchingTab( String handle){
        driver.switchTo().window(handle);
    }
    public static void CloseWendows(){
        driver.close();
    }
    public static void QuiteWindows(){
        driver.quit();
    }
}
