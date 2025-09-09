Feature: Klinik Yönetim Sistemi
  Kullanıcı sisteme giriş yaparak doktor ekleyebilmeli ve hasta kabul kaydı oluşturabilmeli.

  Scenario: Kullanıcı personel ekler ve yeni hasta kaydı açar
    Given User navigates to login page
    When User selects clinic "Nişantaşı Klinik"
    And User logs in with username "Test" and password "Test123."
    And User waits for 3 seconds

    # Personel Yönetimi
    And User clicks on Kaynaklar module
    And User clicks on Personel Yönetimi button
    And User clicks on Yeni Ekle button
    And User waits for 4 seconds
    And User fills personnel form
    And User saves the personnel form
    And User waits for 2 seconds

    # Hasta Kabul
    And User clicks on Hasta Kabul module
    And User clicks on Yeni Ekle in Hasta Kabul
    And User fills patient admission form
    And User saves the patient admission form
    And User fills new admission popup
    And User saves the new admission popup
