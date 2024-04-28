package Page;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import Reporte.ArmadoReporte;

public class pageStep8 {
	WebDriver driver;
	
	By titleStep8 = By.xpath("//*[@id=\"frmSummary\"]/div[1]/div");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep8() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep8);
		String textTitle = title.getText();
		String Valor_esperado = "¡Felicitaciones!";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que se creo el seguro");
	}
}