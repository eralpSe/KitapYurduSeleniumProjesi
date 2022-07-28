package pageObj;


import org.openqa.selenium.By;


public class MainPage {


    public static By mainBasePageLogo = By.cssSelector(".logo-text");
    public static By searchBar = By.xpath("//input[@name='search_keyword']");
    public static By productList = By.cssSelector("div[id='product-table']>.product-cr>.grid_2.alpha.omega.relative>.hover-menu>.add-to-cart");


}
