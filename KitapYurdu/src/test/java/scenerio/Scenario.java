package scenerio;

import base.Base;
import methods.Methods;
import org.junit.Test;
import pageObj.BasketPage;
import pageObj.BookPage;
import pageObj.MainPage;

public class Scenario extends Base {
    Methods methods = new Methods();



    @Test
    public void testM()  {

        methods.getUrl(firstUrl);//siteye gidiliyor.
        methods.currentUrlControl(firstUrl); // siteye gidildiği doğrulanır.
        methods.findElement(MainPage.mainBasePageLogo); // sitenin yüklendiği doğrulanır.
        methods.sendKey(MainPage.searchBar, methods.csvRead());// Csv dosyasından "Roman" yazısı searchbox'a yazıldı.
        methods.enterKey(MainPage.searchBar);// Searchbar'a roman yazıldıktan sonra klavyeden enter'a basıldı.
        methods.randomBookPickClick(MainPage.productList);// ProductList'ten rastgele bir roman seçildikten sonra sepete eklenir.
        methods.assertionTextControl(BookPage.basketLogo,"1");//Sepet Logosundaki değerin bir arttığı kontrol edildi.
        methods.clickToElement(BookPage.basketLogo);//Sepet logosuna tıklandı.
        methods.clickToElement(BookPage.goToBasketBtn);// Sepete git butonuna tıklandı.
        methods.clickToElement(BasketPage.quantity);//Ürün miktarına tıklandı.
        methods.clearToElement(BasketPage.quantity);// Ürün miktarı silindi.
        methods.sendKey(BasketPage.quantity,"2");// Ürün miktarını bir arttırıldı.
        methods.clickToElement(BasketPage.updateQuantity);//Ürün güncelleme butonuna basıldı.
        methods.assertionTextControl(BasketPage.updateQuantityText,"Sepetiniz güncelleniyor!"); // Sepet güncellendiği kontrol edilir.
        methods.clickToElement(BasketPage.cancelButton);// Çarpıya basılarak sepet temizlenir.
        methods.assertionTextControl(BookPage.basketLogo,"0");//Sepetin boş olduğu doğrulanır.

    }








}
