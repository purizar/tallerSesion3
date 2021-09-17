package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
    //Atributo del mismo tipo
    private static Session instance=null;
    private WebDriver driver;
    //constructor privado --seleccionar el navegador
    private Session(){
        driver = FactoryBrowser.make(FactoryBrowser.PROXY).create();

    }
    //No usar synchronized cuando se quiere ejecutar en forma paralela varios navegadores
    //metodo statico publico que me retorne la instancia unica
    public static Session getSession(){
        if (instance==null)
            instance= new Session();
        return instance;
    }

    public void closeSession(){
        driver.quit();
        instance=null;
    }

    public WebDriver getDriver(){
        return driver;
    }


}
