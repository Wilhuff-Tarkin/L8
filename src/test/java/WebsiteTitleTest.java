import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Execution(ExecutionMode.CONCURRENT)
public class WebsiteTitleTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(WebsiteTitleTest.class);

    @DisplayName("Validate page title test")
    @ParameterizedTest
    @MethodSource("DataProvider#pageTitlesSet")


    void titleTest (String pageUrl, String expectedTitle) {
        driver.get(pageUrl);
        log.info(">>>>>  Opening: " + pageUrl);
        String actualTitle = driver.getTitle();
        log.info(">>>>>  Actual page title is: " + actualTitle);
        assertThat("Title test failed", actualTitle, is(equalTo(expectedTitle)));
        log.info(">>>>>  Test for title of " + pageUrl + " passed.");
    }
}