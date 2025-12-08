# 📱 MobileTestAutomationWithAppiumAndCucumber

Bu depo, **Appium, Cucumber ve Java** kullanarak geliştirilmiş, gerçek bir Android uygulaması olan **Aile Bütçem**'in test otomasyon senaryolarını içerir. Proje, bir mobil uygulamanın temel kullanıcı akışlarının **BDD (Behavior-Driven Development)** yaklaşımıyla otomatikleştirilmesini amaçlamaktadır.

---

## 🛠️ Teknolojiler ve Yapı

Bu otomasyon projesi, aşağıdaki popüler teknolojileri ve kütüphaneleri kullanır:

* **Java (JDK 17):** Temel programlama dili.
* **Maven:** Proje bağımlılık yönetimi ve build aracı.
* **Appium:** Mobil uygulama otomasyon çatısı (Android/iOS).
* **Cucumber:** BDD (Behavior-Driven Development) için test çatısı. (Gherkin dilini kullanarak senaryolar yazılır.)
* **JUnit:** Test çalıştırma (`Runner.java` sınıfında kullanılır).
* **Selenium:** Mobil element etkileşimleri için (Appium, Selenium'un mobil uzantısıdır).

### 📁 Proje Yapısı

Proje, **Maven** standartlarına uygun şekilde düzenlenmiştir. Test senaryoları `src/test` altında bulunur.

MobileTestAutomationWithAppiumAndCucumber/ 
```
├── .idea/ 
├── src/ 
│ └── test/ 
│ ├── java/ 
│ │ ├── pages/ 
│ │ │ └── AileButcemPage.java # Page Object Model (POM) elementleri 
│ │ ├── runners/ 
│ │ │ └── Runner.java # Cucumber Test Çalıştırıcı 
│ │ └── stepdefinitions/ 
│ │ ├── AileButcemStepdefinitions.java # Gherkin adımlarının implementasyonu 
│ │ └── ApkYuklemeStepdefinitions.java # APK yükleme adımı 
│ └── resources/ 
│ ├── features/ 
│ │ ├── AileButcem.feature # Temel test senaryoları 
│ │ └── ApkYukleme.feature # APK yükleme senaryosu 
│ 
└── configuration.properties # Cihaz/Uygulama bilgileri ve test verileri 
├── Apps/ 
│ 
└── Aile Bütçem_...apk # Test edilen mobil uygulama dosyası 
├── pom.xml # Maven bağımlılıkları ve konfigürasyonu 
└── .gitignore
```
---

## 🎯 Test Edilen Uygulama ve Senaryolar

Bu projedeki testler, bir aile bütçesi yönetimi uygulaması olan **Aile Bütçem** üzerinde odaklanmıştır.

### 📜 Özellikler (Features)

| Dosya | Açıklama |
| :--- | :--- |
| `ApkYukleme.feature` | Uygulamanın cihaz/emülatöre yüklenmesi. |
| `AileButcem.feature` | Uygulamanın temel akışları (Login, Hesap Bilgileri Güncelleme). |

### 🔍 Ana Senaryolar

1.  **APK Yükleme:** Verilen APK dosya yolu ile uygulamanın Appium aracılığıyla Android cihaza/emülatöre yüklenmesi.
2.  **Kullanıcı Girişi (Login):**
    * Uygulama ilk açılış ekranlarının geçilmesi.
    * `configuration.properties` dosyasından alınan bilgilerle başarılı bir şekilde giriş yapılması.
    * Girişin başarılı olduğunun doğrulanması.
3.  **Hesap Bilgileri Güncelleme:**
    * Giriş yapıldıktan sonra hamburger menüden **"Hesabım"** bölümüne gidilmesi.
    * Kullanıcı bilgilerinin (`isim`, `soyisim`, `şehir`, `yaş`, `meslek`, `cinsiyet`) `configuration.properties` dosyasından okunarak güncellenmesi.
    * Değişikliklerin kaydedilmesi ve kaydedilen verilerin **doğru şekilde güncellendiğinin doğrulanması**.

---

## ⚙️ Appium Konfigürasyonu ve Yardımcı Sınıflar

Projede mobil otomasyonu kolaylaştırmak için aşağıdaki yardımcı yapılar kullanılmıştır:

### 📄 Page Object Model (POM)

* `pages/AileButcemPage.java`: Uygulamanın ana sayfasındaki tüm elementler (`emailTextBox`, `passwordTextBox`, `hamburgerMenu`, vb.) burada tanımlanmıştır. Ayrıca, bu elementleri kullanarak gerçekleştirilen kompleks aksiyon metodları (`ilkEkranayarlari()`, `bilgileriDegistirmeMethodu()`, `bilgileriDogrulamaMethodu()`) bu sınıfta yer alır.

### 🔗 Utilities (Yardımcı Sınıflar)

* `utilities/Driver.java`: Appium sürücüsünün başlatılması ve kapatılması (`getAndroidDriver()` ve `quitAppiumDriver()`). Uygulama paket adı (`appPackage`) ve aktivite adı (`appActivity`) gibi özel yetenekler (capabilities) burada ayarlanır.
* `utilities/ConfigReader.java`: Test verilerinin ve ortam konfigürasyonlarının (`mail`, `password`, `platformName`, `aileButcemPackage`, vb.) okunduğu `configuration.properties` dosyasını yönetir.
* `utilities/ReusableMethods.java`: Scroll, koordinat bazlı tıklama ve ekran görüntüsü alma gibi sık kullanılan mobil otomasyon işlemlerini içerir (`scrollWithUiScrollableAndClick()`, `ekranKaydirma()`).

---

## 🚀 Nasıl Çalıştırılır?

Bu projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları takip etmeniz gerekir:

### Ön Gereksinimler

* **Java Development Kit (JDK 17 veya üstü)**
* **Maven**
* **Android SDK ve bir Android Emülatörü veya fiziksel cihaz**
* **Appium Server** (Lokalde çalışır durumda olmalıdır: `http://127.0.0.1:4723/wd/hub`)

### Kurulum ve Çalıştırma

1.  **Depoyu Klonlayın:**
    ```bash
    git clone [https://github.com/KULLANICI_ADINIZ/MobileTestAutomationWithAppiumAndCucumber.git](https://github.com/KULLANICI_ADINIZ/MobileTestAutomationWithAppiumAndCucumber.git)
    ```
2.  **Bağımlılıkları Yükleyin:** Proje dizininde `pom.xml` dosyasını kullanarak Maven bağımlılıklarını indirin (IDE genellikle bunu otomatik yapar).
3.  **Konfigürasyonu Ayarlayın:** `src/test/resources/configuration.properties` dosyasındaki test verilerini ve cihaz/uygulama ayarlarını kontrol edin.
4.  **Testleri Çalıştırın:**
    * **IntelliJ IDEA:** `src/test/java/runners/Runner.java` sınıfını sağ tıklayıp "Run 'Runner'" seçeneği ile çalıştırın.
    * **Maven Komutu:** Belirli bir tag'i çalıştırmak için:
        ```bash
        mvn test -Dcucumber.options="--tags @mobile" 
        # Veya sadece APK yükleme için:
        # mvn test -Dcucumber.options="--tags @apk"
        ```

---
        
# 📱 MobileTestAutomationWithAppiumAndCucumber

This repository contains test automation scenarios for **Aile Bütçem** (My Family Budget), a real Android application, developed using **Appium, Cucumber, and Java**. The project aims to automate the essential user flows of a mobile application using the **BDD (Behavior-Driven Development)** approach.

---

## 🛠️ Technologies and Architecture

This automation project utilizes the following popular technologies and libraries:

* **Java (JDK 17):** The core programming language.
* **Maven:** Project dependency management and build tool.
* **Appium:** Mobile application automation framework (Android/iOS).
* **Cucumber:** Test framework for BDD, where scenarios are written using the Gherkin language.
* **JUnit:** Test runner (used in the `Runner.java` class).
* **Selenium:** Used for mobile element interactions (Appium is a mobile extension of Selenium).

### 📁 Project Structure

The project is structured according to **Maven** standards. Test scenarios are located under the `src/test` directory.

MobileTestAutomationWithAppiumAndCucumber/
``` 
├── .idea/ 
├── src/ 
│ └── test/ 
│ ├── java/ 
│ │ ├── pages/ 
│ │ │ └── AileButcemPage.java # Page Object Model (POM) elements 
│ │ ├── runners/ 
│ │ │ └── Runner.java # Cucumber Test Runner 
│ │ └── stepdefinitions/ 
│ │ ├── AileButcemStepdefinitions.java # Implementation of Gherkin steps 
│ │ └── ApkYuklemeStepdefinitions.java # APK installation step 
│ └── resources/ 
│ ├── features/ 
│ │ ├── AileButcem.feature # Core test scenarios 
│ │ └── ApkYukleme.feature # APK installation scenario 
│ └── configuration.properties # Device/Application details and test data 
├── Apps/ 
│ └── Aile Bütçem_...apk # The APK file of the mobile application under test 
├── pom.xml # Maven dependencies and configuration 
└── .gitignore
```
---

## 🎯 Application and Scenarios Under Test

The tests in this project focus on **Aile Bütçem**, a family budget management application.

### 📜 Features

| File | Description |
| :--- | :--- |
| `ApkYukleme.feature` | Installation of the application on the device/emulator. |
| `AileButcem.feature` | Core application flows (Login, Account Information Update). |

### 🔍 Main Scenarios

1.  **APK Installation:** Installing the application on the Android device/emulator via Appium using the provided APK file path.
2.  **User Login:**
    * Navigating through the application's initial splash screens.
    * Successfully logging in using credentials retrieved from the `configuration.properties` file.
    * Verifying that the login was successful.
3.  **Account Information Update:**
    * Navigating to the **"Hesabım" (My Account)** section from the hamburger menu after login.
    * Updating user details (`isim` - name, `soyisim` - surname, `şehir` - city, `yaş` - age, `meslek` - profession, `cinsiyet` - gender) read from the `configuration.properties` file.
    * Saving the changes and **verifying that the saved data was updated correctly**.

---

## ⚙️ Appium Configuration and Utility Classes

The following helper structures are used in the project to facilitate mobile automation:

### 📄 Page Object Model (POM)

* `pages/AileButcemPage.java`: All elements on the main page of the application (`emailTextBox`, `passwordTextBox`, `hamburgerMenu`, etc.) are defined here. Additionally, complex action methods (`ilkEkranayarlari()`, `bilgileriDegistirmeMethodu()`, `bilgileriDogrulamaMethodu()`) utilizing these elements are located in this class.

### 🔗 Utilities

* `utilities/Driver.java`: Manages the initialization and termination of the Appium driver (`getAndroidDriver()` and `quitAppiumDriver()`). Special capabilities (e.g., application package name - `appPackage`, and activity name - `appActivity`) are configured here.
* `utilities/ConfigReader.java`: Manages the reading of test data and environment configurations (`mail`, `password`, `platformName`, `aileButcemPackage`, etc.) from the `configuration.properties` file.
* `utilities/ReusableMethods.java`: Contains commonly used mobile automation actions like scrolling, coordinate-based tapping, and taking screenshots (`scrollWithUiScrollableAndClick()`, `ekranKaydirma()`).

---

## 🚀 How to Run?

To run this project in your local environment, you must follow the steps below:

### Prerequisites

* **Java Development Kit (JDK 17 or higher)**
* **Maven**
* **Android SDK and an Android Emulator or physical device**
* **Appium Server** (Must be running locally: `http://127.0.0.1:4723/wd/hub`)

### Setup and Execution

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/MobileTestAutomationWithAppiumAndCucumber.git](https://github.com/YOUR_USERNAME/MobileTestAutomationWithAppiumAndCucumber.git)
    ```
2.  **Load Dependencies:** Download the Maven dependencies using the `pom.xml` file in the project directory (the IDE usually does this automatically).
3.  **Configure Settings:** Verify the test data and device/application settings in the `src/test/resources/configuration.properties` file.
4.  **Run Tests:**
    * **IntelliJ IDEA:** Right-click the `src/test/java/runners/Runner.java` class and select "Run 'Runner'".
    * **Maven Command:** To run tests with a specific tag:
        ```bash
        mvn test -Dcucumber.options="--tags @mobile" 
        # Or for APK installation only:
        # mvn test -Dcucumber.options="--tags @apk"
          ```
