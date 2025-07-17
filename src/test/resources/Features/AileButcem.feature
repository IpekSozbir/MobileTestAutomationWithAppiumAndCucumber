Feature: Kullanici Aile Butcem uygulamasini test eder


  Background:
    Given Ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin
    When "mail" ve "password" bilgilerini girerek kullanici bilgileriyle "Giriş Yap"
    Then Uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin


  Scenario: Kullanici hesabim bolumunden bilgilerini degistirir ve kaydeder
    Given Sol kisimdaki menuden "Hesabım" bolumune gidin
    When Hesabim sayfasindaki bilgileri degistirerek "isim" "soyisim" "sehir" "yas" "meslek" ve cinsiyet "Kadın" degisikleri kaydedin ve değişikleri dogrulayin
    And  Uygulamayi kapatir

  @aile
  Scenario: Kullanici Ayarlar bolumunde gorevleri yerine getirir
    Given Sol kisimdaki menuden "Ayarlar" bolumune gidin

