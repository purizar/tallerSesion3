package pages;

import control.Button;
import control.Link;
import org.openqa.selenium.By;

public class MainPage {
    //public Button loginButton = new Button(By.xpath("//img[@src='/Images/design/pagelogin.png']"));
   public Link linkLogin = new Link(By.xpath("//a[@href='/users/showlogin']"));

}