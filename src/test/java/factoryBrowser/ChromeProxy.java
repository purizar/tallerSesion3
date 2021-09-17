package factoryBrowser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeProxy implements IBrowser{

    @Override
    public WebDriver create() {

        //usar rutas relativas
        String rutaDriver="src/test/resources/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        //proxy -zap
        Map<String,Object> preferencias = new HashMap<>();
        preferencias.put("credencials_enable_service",false);

        //para evitar problemas con los certificados ssl
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.setExperimentalOption("prefs", preferencias);

        Proxy proxy= new Proxy();
        proxy.setHttpProxy("127.0.0.1:8082");
        proxy.setSslProxy("127.0.0.1:8082");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy",proxy);
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);

        ChromeDriver driver = new ChromeDriver(capabilities);
        //espera 15 segundos a todos los objetos para que se carguen
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
