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
import org.testng.Assert;
import Reporte.ArmadoReporte;

public class pageHome {
	WebDriver driver;
	
	By inputBirthday = By.name("Birthday");
	By selectProvince = By.id("select2-province-container");
	By inputProvince = By.xpath("/html/body/span/span/span[1]/input");
	By inputPhoneCode = By.name("PhoneCode");
	By inputPhoneNumber = By.name("PhoneNumber");
	By dragInsurance = By.xpath("//*[@id=\"frmIndex\"]/div[1]/div[4]/div/div[2]/div/div[5]");
	By drop30 = By.id("ex6SliderVal");
	By drop50 = By.id("monthlyText");
	By drop100 = By.xpath("//*[@id=\"frmIndex\"]/div[1]/div[4]/div/div[2]/span[2]");
	By check = By.id("ex6SliderVal");
	By checkDisability = By.id("chkDisability");
	By textDisability = By.xpath("//*[@id=\"frmIndex\"]/div[1]/div[6]/div[1]/span[1]");
	By checkAccident = By.id("chkAccident");
	By textAccident = By.id("//*[@id=\"frmIndex\"]/div[1]/div[6]/div[2]/span[1]");
	By checkIllness = By.id("chkIllness");
	By textIllness = By.id("//*[@id=\"frmIndex\"]/div[1]/div[6]/div[3]/span[1]");
	By amountInsurred = By.id("suma_aseguradatotal");
	By messageError = By.xpath("/html/body/div[3]/div/div[3]");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void fillForm(String Birthday, String Province, String PhoneCode, String PhoneNumber) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(inputBirthday).sendKeys(Birthday);
		driver.findElement(selectProvince).click();
		driver.findElement(inputProvince).sendKeys(Province);
		driver.findElement(inputProvince).sendKeys(Keys.ENTER);
		driver.findElement(inputPhoneCode).sendKeys(PhoneCode);
		driver.findElement(inputPhoneNumber).sendKeys(PhoneNumber);
		GenerarReporte.Paso("Interacción con el formulario");
	}
	
	public void insurance30() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		Actions acciones = new Actions(driver);
		acciones.dragAndDrop(driver.findElement(dragInsurance), driver.findElement(drop30)).build().perform();
		Thread.sleep(2000);
		GenerarReporte.Paso("Deslizar la suma asegurada al 30% de la barra");
	} 
	
	public void insurance50() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		Actions acciones = new Actions(driver);
		acciones.dragAndDrop(driver.findElement(dragInsurance), driver.findElement(drop50)).build().perform();
		Thread.sleep(2000);
		GenerarReporte.Paso("Deslizar la suma asegurada al 50% de la barra");
	} 
	
	public void insurance100() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		Actions acciones = new Actions(driver);
		acciones.dragAndDrop(driver.findElement(dragInsurance), driver.findElement(drop100)).build().perform();
		Thread.sleep(2000);
		GenerarReporte.Paso("Deslizar la suma asegurada al 100% de la barra");
	} 
	
	public void trueDisability() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(checkDisability).click();
		driver.findElement(checkDisability).click();
		GenerarReporte.Paso("Seleccionar checkbox de discapacidad");
	} 
	
	public void trueAccident() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(checkAccident).click();
		driver.findElement(checkAccident).click();
		GenerarReporte.Paso("Seleccionar checkbox de accidente");
	} 
	
	public void trueIllness() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(checkIllness).click();
		driver.findElement(checkIllness).click();
		GenerarReporte.Paso("Seleccionar checkbox de enfermedad");
	} 
	
	public void assertFormOK() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement sumInsurred = driver.findElement(amountInsurred);
		String textSumInsurred = sumInsurred.getText();
		Assert.assertNotEquals(textSumInsurred, "$ 0");
		System.out.println("Se valida que la suma asegurada es > a 0; la suma asegurda es: " + textSumInsurred);
		GenerarReporte.Paso("Se valida que la suma asegurada es > a 0; la suma asegurda es: " + textSumInsurred);
	} 
	
	public void assertEmptyField() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement message = driver.findElement(messageError);
		String textMessage = message.getText();
		String Valor_esperado = "Falta completar este campo.";
		Assert.assertEquals(textMessage,Valor_esperado);
		System.out.println("Se valida que muestra un mensaje de erorr al dejar un campo vacio, se muestra el siguiente mensaje de error: " + textMessage);
		GenerarReporte.Paso("Se valida que muestra un mensaje de erorr al dejar un campo vacio, se muestra el siguiente mensaje de error: " + textMessage);
	} 
	
	public void assertErrorIncorrectDate() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement message = driver.findElement(messageError);
		String textMessage = message.getText();
		String Valor_esperado = "La fecha que ingresaste es inválida";
		Assert.assertEquals(textMessage,Valor_esperado);
		System.out.println("Se valida que muestra un mensaje de erorr al escribir una fecha incorrecta, se muestra el siguiente mensaje de error: " + textMessage);
		GenerarReporte.Paso("Se valida que muestra un mensaje de erorr al escribir una fecha incorrecta, se muestra el siguiente mensaje de error: " + textMessage);

	} 

	public void assertErrorMinor18() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement message = driver.findElement(messageError);
		String textMessage = message.getText();
		String Valor_esperado = "Por el momento, la edad mínima de contratación es 18 años";
		Assert.assertEquals(textMessage,Valor_esperado);
		System.out.println("Se valida que muestra un mensaje de error al ser un usuario menor de 18, se muestra el siguiente mensaje de error: " + textMessage);
		GenerarReporte.Paso("Se valida que muestra un mensaje de error al ser un usuario menor de 18, se muestra el siguiente mensaje de error: " + textMessage);
	} 

	public void assertErrorIncorrectPhoneNumber() {
		WebElement message = driver.findElement(messageError);
		String textMessage = message.getText();
		String Valor_esperado = "Por favor, ingresá un valor entre 6 y 20 caracteres.";
		Assert.assertEquals(textMessage,Valor_esperado);
		System.out.println("Se valida que muestra un mensaje de erorr al escribir un numero de telefono incorrecto, se muestra el siguiente mensaje de error: " + textMessage);
	} 
	
	public void closeDriver(WebDriver driver) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.close();
		GenerarReporte.GeneraEvidencia("Reporte de caso de prueba.docx");
	}

}
