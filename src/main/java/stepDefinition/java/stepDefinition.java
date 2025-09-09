package stepDefinition.java;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepDefinition {
    WebDriver driver;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testapp.doctorin.app/");
    }

    @When("User selects clinic {string}")
    public void userSelectsClinic(String clinicName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement changeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("AbpTenantSwitchLink")));
        changeBtn.click();
        WebElement tenantInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input_Name")));
        tenantInput.clear();
        tenantInput.sendKeys(clinicName);
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        saveBtn.click();
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"LoginInput_UserNameOrEmailAddress\"]")));
        userInput.click();
        userInput.clear();
        userInput.sendKeys(username);
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-input")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div[3]/form/div[3]/button")));
        loginBtn.click();
    }

    @When("User waits for {int} seconds")
    public void userWaitsForSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    // Personel Ekleme
    @When("User clicks on Kaynaklar module")
    public void userClicksOnKaynaklarModule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kaynaklar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/main/section/div[1]/div/div/div/div[2]/div/div/a[7]")));
        kaynaklar.click();
    }

    @When("User clicks on Personel Yönetimi button")
    public void userClicksOnPersonelYonetimiButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement personelBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"MenuItem_ResourceService_StaffManagement\"]")));
        personelBtn.click();
    }

    @When("User clicks on popup screen")
    public void userClicksOnPopupScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupscreen = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("dropdownlist-74700189-98bf-4e56-8bc7-db6d556862cb")));
        popupscreen.click();
    }

    @When("User clicks on Yeni Ekle button")
    public void userClicksOnYeniEkleButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement yeniEkleBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/main/section/div[1]/div/div[1]/div/div[2]/button")));
        yeniEkleBtn.click();
    }

    @When("Popup Checkout")
    public void userpopupcheck() {

    // Popup container bekleniyor
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'e-popup') or contains(@class,'modal-dialog')]")));

    }

    @When("User fills personnel form")
    public void userFillsPersonnelForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Popup bekleniyor...
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[class*='e-popup'], div[class*='modal-dialog'], div[data-popup='true']")));

        // Ad
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Ad')]")));
        firstName.sendKeys("Sude");

        // Soyad
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Soyad')]")));
        lastName.sendKeys("Erdoğan");

        // Ünvan
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Ünvan')]")));
        title.sendKeys("Doç. Dr.");

        //Görünen Ad
        title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Görünen Ad')]")));
        title.sendKeys("Doç. Dr. Sude Erdoğan");


        // TC Kimlik
        WebElement tcInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Kimlik Numarası')]")));
        tcInput.sendKeys("11111111111");

        // Cinsiyet dropdown
        WebElement genderDropdown = popup.findElement(By.xpath("//input[contains(@class,'e-dropdownlist')]"));
        genderDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Kadın')]"))).click();

        // Doğum tarihi
        WebElement dob = popup.findElement(By.xpath("//input[contains(@placeholder,'Doğum Tarihi')]"));
        dob.sendKeys("31.01.1990");

        // Departmanlar (multi-select)
        WebElement deptMultiSelect = popup.findElement(
                By.xpath(".//input[contains(@placeholder,'Departmanlar')]")
        );
        deptMultiSelect.click();

// Dahiliye seçimi
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'e-ul')]//li[contains(.,'Dahiliye')]")
        )).click();

        // Tek seçimli departman
        WebElement deptDropdown = popup.findElement(By.xpath("//input[contains(@class,'e-dropdownlist')]"));
        deptDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Dahiliye')]"))).click();
    }

    @When("User saves the personnel form")
    public void userSavesThePersonnelForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Popup container
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.e-popup, div.modal-dialog, div[data-popup='true']")));

        // Kaydet butonu
        WebElement saveBtn = popup.findElement(By.xpath(".//button[contains(text(),'Kaydet')]"));
        saveBtn.click();
    }

    // Hasta Kabul
    @When("User clicks on Hasta Kabul module")
    public void userClicksOnHastaKabulModule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hastaKabul = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/main/section/div[1]/div/div/div/div[2]/div/div/a[2]")));
        hastaKabul.click();
    }

    @When("User clicks on Yeni Ekle in Hasta Kabul")
    public void userClicksOnYeniEkleInHastaKabul() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement yeniEkle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"e-toolbar-item-ea1b2745-c4a2-4e51-94b8-661481c6b01b\"]/div/button")));
        yeniEkle.click();
    }

    @When("User fills patient admission form")
    public void userFillsPatientAdmissionForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bb9ba3b8-0cb2-4a9f-abb1-76d2663f7155"))).sendKeys("Yiğit");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("006581a5-4782-4d1a-8b6b-e7aa19df4067"))).sendKeys("Aslan");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"admission-sidebar__registration-form\"]/div[1]/div/div/div/div[8]/span/input"))).sendKeys("20.06.1995");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownlist-38c70115-0df8-4366-841e-b8936b72c0fb"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mask-1009bc5f-a941-4f3e-9a7f-e942d1496eef"))).sendKeys("555-555-5555");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textbox-ca0ad647-dc2b-471b-9484-f4e26cdd5e70"))).sendKeys("test@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownlist-9e076d6d-4496-4c52-b3e1-5f7a205aa221"))).click();
    }

    @When("User saves the patient admission form")
    public void userSavesThePatientAdmissionForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"admission-sidebar__registration-form\"]/div[2]/div/button")));
        saveBtn.click();
    }

    @When("User fills new admission popup")
    public void userFillsNewAdmissionPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownlist-360aed1f-3834-4878-8376-0204c5a8c213"))).click(); // Vizit Tipi 001
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownlist-90e0bcb3-310e-4bb4-bf81-060c91cd8bf1"))).click(); // Departman Dahiliye
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownlist-ab815b60-ea04-4a3d-92a1-e93fdb891ba3"))).click(); // Doktor Dr. Sude Erdoğan
    }

    @When("User saves the new admission popup")
    public void userSavesTheNewAdmissionPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"admission-sidebar__admission-form\"]/div[2]/div/button[1]")));
        saveBtn.click();
    }
}
