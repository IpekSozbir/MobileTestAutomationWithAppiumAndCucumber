package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {

    public AileButcemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)),this);
    }

    public void ilkEkranayarlari() throws InterruptedException {
        for (int i = 0; i <6 ; i++) {
            Thread.sleep(1000);
            ReusableMethods.ekranKaydirma(900,1300,500,150,1300);
        }
        Thread.sleep(1000);
        ReusableMethods.scrollWithUiScrollableAndClick("Giriş Yap");
    }


    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement emailTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement passwordTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement girisYapButton;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[17]")
    public MobileElement basariliPopUp;

    @FindBy (xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public MobileElement hamburgerMenu;

    @FindBy(xpath = "//*[@text='Hesabım']")
    public MobileElement hesabimButton;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement firstnameTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement lastnameTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement cityTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement genderDropDown;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement ageTextBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement professionTextBox;

    @FindBy(xpath = "//*[@text='Kadın']")
    public MobileElement kadinButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[3]")
    public MobileElement kaydetButton;


    public void bilgileriDegistirmeMethodu (String isim, String soyisim, String sehir, String yas, String meslek, String cinsiyet) throws InterruptedException {
       firstnameTextBox.clear();
       lastnameTextBox.clear();
       cityTextBox.clear();
       ageTextBox.clear();
       professionTextBox.clear();

       Thread.sleep(1000);

        firstnameTextBox.sendKeys(ConfigReader.getProperty("isim"));
        lastnameTextBox.sendKeys(ConfigReader.getProperty("soyisim"));
        cityTextBox.sendKeys(ConfigReader.getProperty("sehir"));
        ageTextBox.sendKeys(ConfigReader.getProperty("yas"));
        professionTextBox.sendKeys(ConfigReader.getProperty("meslek"));
        genderDropDown.click();

        Thread.sleep(1000);
        //kadinButton.click();
        ReusableMethods.scrollWithUiScrollableAndClick(cinsiyet);
        kaydetButton.click();


    }

    public void bilgileriDogrulamaMethodu (String isim, String soyisim, String sehir, String yas, String meslek, String cinsiyet) {
        Assert.assertTrue(firstnameTextBox.getText().equals(ConfigReader.getProperty(isim)));
        Assert.assertTrue(lastnameTextBox.getText().equals(ConfigReader.getProperty(soyisim)));
        Assert.assertTrue(cityTextBox.getText().equals(ConfigReader.getProperty(sehir)));
        Assert.assertTrue(ageTextBox.getText().equals(ConfigReader.getProperty(yas)));
        Assert.assertTrue(professionTextBox.getText().equals(ConfigReader.getProperty(meslek)));
        Assert.assertTrue(genderDropDown.getText().equals("Kadın"));
    }
























}
