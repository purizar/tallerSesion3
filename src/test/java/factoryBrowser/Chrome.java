package factoryBrowser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Chrome implements IBrowser{
    @Override
    public WebDriver create() {
        //usar rutas relativas
        String rutaDriver="src/test/resources/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //espera 15 segundos a todos los objetos para que se carguen
        return driver;
    }
}
