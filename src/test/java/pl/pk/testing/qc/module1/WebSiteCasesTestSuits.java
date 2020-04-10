package pl.pk.testing.qc.module1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WebSiteCasesTestSuits {

    private WebDriver driver;

    @Before
    public void initTest() {
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        driver = new ChromeDriver();

    }

    public static class Field {
        public static final String LOGIN = "login";
        public static final String PASS = "password";
        private Field() {}
    }

    @Test
    public void should_open_web_site_and_check_is_button_login_exists() {
        //Given
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");

        //When
        WebElement loginPlace = driver.findElement(By.id("login"));
        WebElement passwordPlace = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/button"));

        //Then
        assertThat(loginButton).isNotNull().isInstanceOf(WebElement.class);

    }

    @Test
    public void should_open_web_site_and_check_are_fields_login_and_password_exists() {
        //Given
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");

        //When
        WebElement loginPlace = driver.findElement(By.id("login"));
        WebElement passwordPlace = driver.findElement(By.id("password"));

        //Then
        assertThat(loginPlace).isNotNull().isInstanceOf(WebElement.class);
        assertThat(passwordPlace).isNotNull().isInstanceOf(WebElement.class);

    }

    @Test
    public void should_fill_login_form_and_go_to_loginPage() {
        //Given
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        WebElement loginPlace = driver.findElement(By.id(Field.LOGIN));
        WebElement passwordPlace = driver.findElement(By.id(Field.PASS));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/button"));
        String url = driver.getCurrentUrl();

        //When
        loginPlace.sendKeys("demo");
        passwordPlace.sendKeys("demo");
        loginButton.submit();

        //Then
        String confirmaitonLoginMsg = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/div/h5")).getText();
        String logoutButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/div/a")).getText();
        String currentUrlAfterLogin = driver.getCurrentUrl();

        assertThat(confirmaitonLoginMsg).isEqualTo("Zalogowano pomyślnie!");
        assertThat(logoutButton).isEqualTo("Wyloguj");
        assertThat(url).isEqualTo(currentUrlAfterLogin);
    }

    @Test
    public void should_after_logout_show_first_page_with_login_form() {
        //Given
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        correctLogin(driver);

        //When
        driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/div/a")).click();

        //Then
        WebElement loginPlaceAfterLogout = driver.findElement(By.id("login"));
        WebElement passwordPlaceAfterLogout = driver.findElement(By.id("password"));

        assertThat(loginPlaceAfterLogout).isNotNull().isInstanceOf(WebElement.class);
        assertThat(passwordPlaceAfterLogout).isNotNull().isInstanceOf(WebElement.class);
    }

    @Test
    public void should_after_incorrect_login_show_msg_and_clear_password_field() {
        //Given
        String expectedMessage = "Niepoprawne dane logowania";
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        inCorrectLogin(driver);

        //When
        String afterWrongLoginMsg = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/div[3]/p[2]")).getText();
        WebElement passwordPlace = driver.findElement(By.id("password"));

        //Then
        String passwordPlaceValue = passwordPlace.getText();

        assertThat(passwordPlaceValue).isNullOrEmpty();
        assertThat(expectedMessage).isEqualTo(afterWrongLoginMsg);
    }

    @Test
    public void should_after_incorrect_login_show_msg() {
        //Given
        String expectedMessage = "Wypełnij wszystkie pola";
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        inCorrectLogin(driver);

        //When
        String afterWrongLoginMsg = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/div[3]/p[0]")).getText();

        //Then
        assertThat(expectedMessage).isEqualTo(afterWrongLoginMsg);
    }

    @Test
    public void should_after_setting_only_login_show_msg() {
        //Given
        String expectedMessage = "Wypełnij wszystkie pola";
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        loginWithOneFiled(driver, Field.LOGIN);

        //When
        String messageAfterFillOnlyOneField = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/div[3]/p[1]")).getText();

        //Then
        assertThat(expectedMessage).isEqualTo(messageAfterFillOnlyOneField);
    }

    @Test
    public void should_after_setting_only_password_show_msg() {
        //Given
        String expectedMessage = "Wypełnij wszystkie pola";
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");
        loginWithOneFiled(driver, Field.PASS);

        //When
        String messageAfterFillOnlyOneField = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/div[3]/p[1]")).getText();

        //Then
        assertThat(expectedMessage).isEqualTo(messageAfterFillOnlyOneField);
    }

    @Test
    public void should_user_after_incorrect_login_cant_relogin_although_correct_authorisation() {
        //Given
        String expectedMessage = "Wypełnij wszystkie pola";
        driver.navigate().to("https://project-ta-acme-01.netlify.com/");


        //When 3 times incorrect login
        for (int i=0; i <3; i++) {
            inCorrectLogin(driver);
            clearFieldsLoginAndPass(driver);
        }

        //Try correct login
        correctLogin(driver);

        //Then
        WebElement loginPlace = driver.findElement(By.id(Field.LOGIN));
        WebElement passwordPlace = driver.findElement(By.id(Field.PASS));
        String messageAfterFillOnlyOneField = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/div[3]/p[3]")).getText();

        assertThat(expectedMessage).isEqualTo(messageAfterFillOnlyOneField);
        assertThat(loginPlace).isNotNull().isInstanceOf(WebElement.class);
        assertThat(passwordPlace).isNotNull().isInstanceOf(WebElement.class);
    }

    private WebDriver correctLogin(WebDriver driver) {
        WebElement loginPlace = driver.findElement(By.id(Field.LOGIN));
        WebElement passwordPlace = driver.findElement(By.id(Field.PASS));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/button"));
        loginPlace.sendKeys("demo");
        passwordPlace.sendKeys("demo");
        loginButton.submit();
        return driver;
    }

    private WebDriver inCorrectLogin(WebDriver driver) {
        WebElement loginPlace = driver.findElement(By.id(Field.LOGIN));
        WebElement passwordPlace = driver.findElement(By.id(Field.PASS));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/button"));
        loginPlace.sendKeys("fakeLogin");
        passwordPlace.sendKeys("fakePass");
        loginButton.submit();
        return driver;
    }

    private WebDriver clearFieldsLoginAndPass(WebDriver webDriver) {
        driver.findElement(By.id(Field.LOGIN)).clear();
        driver.findElement(By.id(Field.PASS)).clear();
        return driver;
    }

    private WebDriver loginWithOneFiled(WebDriver driver, String field) {
        WebElement loginPlace = driver.findElement(By.id(Field.LOGIN));
        WebElement passwordPlace = driver.findElement(By.id(Field.PASS));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div/form/button"));

        if (Field.LOGIN.equals(field)) {
            loginPlace.sendKeys("demo");
        } else {
            passwordPlace.sendKeys("demo");
        }

        loginButton.submit();
        return driver;
    }


    @After
    public void shutDown() {
        if (driver != null) {
            driver.close();
        }

    }
}
