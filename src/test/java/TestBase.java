import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    public WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        log.info(">>>>>  Driver initiated successfully.");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        log.info(">>>>>  Driver closed successfully.");
    }
}
