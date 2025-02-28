package br.com.dlima.ExemploMaven;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.loadable.annotation.LoadableComponent;
import br.com.dlima.ExemploMaven.conditions.AppActivityLoadedCond;
import br.com.dlima.ExemploMaven.guice.GuiceModule;
import br.com.dlima.ExemploMaven.pageobjects.MainActivity;
import br.com.dlima.ExemploMaven.pageobjects.WebFormResponse;
import com.google.inject.Inject;
import io.appium.java_client.MobileDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class EspressoAppTest {

  public static final String WEBVIEW_CONTEXT =
      "WEBVIEW_com.example.android.testing.espresso.web.BasicSample";

  public static final String TEST_MESSAGE = "Test message";

  @Inject
  private WebDriver driver;

  @Inject
  @LoadableComponent(condClass = AppActivityLoadedCond.class)
  private MainActivity mainActivity;

  @Inject
  @LoadableComponent(condClass = AppActivityLoadedCond.class)
  private WebFormResponse formResponse;

  @Before
  public void setUp() {
    ((MobileDriver) driver).context(WEBVIEW_CONTEXT);
  }

  @Test
  public void testMessageChange() {
    mainActivity.changeMessage(TEST_MESSAGE);
    assertThat(mainActivity.getMessage()).isEqualTo(TEST_MESSAGE);
  }

  @Test
  public void testSubmitMessage() {
    mainActivity.submitMessage(TEST_MESSAGE);
    assertThat(formResponse.getResponseMessage()).isEqualTo(TEST_MESSAGE.replaceAll(" ", "+"));
  }

}
