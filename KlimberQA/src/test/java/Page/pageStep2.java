package Page;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Reporte.ArmadoReporte;

public class pageStep2 {
	WebDriver driver;
	
	By titleStep2 = By.xpath("//*[@id=\"frmStep2\"]/div[1]/div[1]/div");
	By radioCauses = By.name("UnderwritingCustom[0].ResponseBool");
	By radioAssistance = By.name("UnderwritingCustom[1].ResponseBool");
	By inputHeight = By.name("Height");
	By inputWeight = By.name("Weight");
	By radioCovid = By.name("UnderwritingCustom[2].ResponseBool");
	By buttonBack = By.xpath("//*[@id=\"frmStep2\"]/div[2]/center/a");
	By buttonNext = By.id("btnSaveStep2");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep2() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep2);
		String textTitle = title.getText();
		String Valor_esperado = "Necesito conocerte un poco más:";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 2");
	} 
	
	public void checkCauses() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(radioCauses).click();
		GenerarReporte.Paso("Marcar el radio button de Causas");
	} 
	
	public void checkAssistance() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(radioAssistance).click();
		GenerarReporte.Paso("Marcar el radio button de Asistencias");
	} 
	
	public void fillFormAndGoNext(String Height, String Weight) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(inputHeight).sendKeys(Height);
		driver.findElement(inputWeight).sendKeys(Weight);
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Se llena los campos con altura: " + Height + "cm y peso: " + Weight + "Kg " + "y se presiona el botón Siguiente");
	} 
	
	public void checkCovid() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(radioCovid).click();
		GenerarReporte.Paso("Marcar el radio button de Covid");
	} 
	
	public void goBack() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(buttonBack).click();
		GenerarReporte.Paso("Se presiona el botón Atras y redirige al Step 1");
	} 
}