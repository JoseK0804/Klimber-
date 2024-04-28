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

public class pageStep5 {
	WebDriver driver;
	
	By titleStep5 = By.xpath("//*[@id=\"frmStep5\"]/div[1]/div");
	By inputCardNumber = By.id("CardNumber");
	By buttonBack = By.xpath("//*[@id=\"frmRegistration\"]/div[3]/center/a");
	By buttonNext = By.id("btnSubmitStep4");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep5() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep5);
		String textTitle = title.getText();
		String Valor_esperado = "Por favor, ingresá los datos de tu medio de pago";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 5");
	} 
	
	public void fillFormAndGoNext(String CardNumber) throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(inputCardNumber).sendKeys(CardNumber);
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Interacción con el formulario y se presiona el botón siguiente");
	}
}