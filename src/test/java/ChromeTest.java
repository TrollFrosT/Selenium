import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeTest {

    private WebDriver driver;

    @BeforeAll

    static void setUpAll() {

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

    }

    @BeforeEach

    @BeforeEach
    void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach

    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test

    void shouldTest() {
        driver.get("http://localhost:9999/");
        driver.findElements(By.className("input__control")).get(0).sendKeys("Иванов Иван");
        driver.findElements(By.className("input__control")).get(1).sendKeys("+79119999999");
        driver.findElement(By.className("checkbox__text")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("p")).getText().trim();
        Assertions.assertEquals(expected, actual);



    }



}
