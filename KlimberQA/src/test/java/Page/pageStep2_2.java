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

public class pageStep2_2 {
	WebDriver driver;
	
	By titleStep2_2 = By.xpath("//*[@id=\"frmInsuranceRejected\"]/div[1]/div[1]/div/p");
	By inputName = By.id("txtName");
	By inputMail = By.id("txtEmailFrom");
	By inputPhone = By.id("PhoneNumber");
	By buttonBack = By.xpath("//*[@id=\"frmInsuranceRejected\"]/div[2]/center/a");
	By buttonNext = By.id("btnSaveStep2_2");
	By messageOK = By.xpath("//div[3]/div/div[3]");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep2_2() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep2_2);
		String textTitle = title.getText();
		String Valor_esperado = "Muchas gracias por tu interés en nuestros seguros. Nuestro equipo se pondrá en contacto a la brevedad para acercarte el seguro que mejor se adapta a tus necesidades.";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 2_2");
	} 
	
	public void fillFormAndGoNext(String Name, String Mail, String Phone) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(inputName).sendKeys(Name);
		driver.findElement(inputMail).sendKeys(Mail);
		driver.findElement(inputPhone).sendKeys(Phone);
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Se llena los campos con nombre: " + Name + ", e-mail: " + Mail + " y celular: " + Phone + " Se presionar el botón Siguiente");
		Thread.sleep(5000);
	} 
	
	public void goBack() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(buttonBack).click();
		GenerarReporte.Paso("Se presiona el botón Atras y redirige al Step 2");
	} 
	
	public void assertEmailWasSent() throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		WebElement messageForm = driver.findElement(messageOK);
		String textMessage = messageForm.getText();
		String Valor_esperado = "El e-mail fue enviado correctamente.";
		Assert.assertEquals(textMessage, Valor_esperado);
		GenerarReporte.Paso("Se valida que se muestra el mensaje de exito, al presionar el botón Siguiente");
	} 
}