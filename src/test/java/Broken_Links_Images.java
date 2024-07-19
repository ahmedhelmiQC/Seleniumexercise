import dev.failsafe.internal.util.DelegatingScheduler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class Broken_Links_Images {
    public static WebDriver driver = new EdgeDriver();

    public static void main(String[] args) throws IOException, URISyntaxException {
        //OpenBrowserUsingNavigation("https://the-internet.herokuapp.com");   /// Broken Links

        //List<WebElement> elements = driver.findElements(By.tagName("a"));   /// Broken Links
        //checkBroken(elements , "links");      /// Broken Links
        OpenBrowserUsingNavigation("https://the-internet.herokuapp.com/broken_images");  /// Broken Images
        List<WebElement> elements = driver.findElements(By.tagName("img"));   /// Broken Images
        //checkBroken(elements , "photo");    /// Broken Images
        checkBrokenUsingRestAssured(elements,"photo");  // UsingRestAssured

    }
    public static void OpenBrowserUsingNavigation(String URL){
        driver.navigate().to(URL);
    }
    /*
    public static void checkBroken(List<WebElement> elements , String type) throws IOException, URISyntaxException {
        URL url = null;
        String attribute;

        for (WebElement element:elements){
            if (type.equals("photo"))
                attribute = "src";
              else
                attribute = "href";
            url = new URI(element.getAttribute(attribute)).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            System.out.println(httpURLConnection.getResponseMessage()+ "" + httpURLConnection.getResponseCode());
        }

     */

        public static void checkBrokenUsingRestAssured(List<WebElement> elements , String type) throws IOException, URISyntaxException {
            URL url = null;
            String attribute;

            for (WebElement element:elements){
                if (type.equals("photo"))
                    attribute = "src";
                else
                    attribute = "href";
                url = new URI(element.getAttribute(attribute)).toURL();
                Response response = RestAssured.given().get(url);
                System.out.println(response.getStatusLine());
            }

        }
}
