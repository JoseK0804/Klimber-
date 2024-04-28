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

public class pageStep7 {
	WebDriver driver;
	
	By titleStep7 = By.xpath("//*[@id=\"frmSummary\"]/div[1]/div");
	By checkTermsAndConditions = By.id("chkTC");
	By buttonBack = By.id("//*[@id=\"frmBeneficiaries\"]/div[3]/center/button");
	By buttonNext = By.id("btnSummarySubmit");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep7() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep7);
		String textTitle = title.getText();
		String Valor_esperado = "Este es el resumen de tu póliza.";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 7");
	}
	
	public void summarySubmit() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(checkTermsAndConditions).click();
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Se presiona el botón Siguiente");
	} 
}