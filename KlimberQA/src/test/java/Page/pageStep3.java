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

public class pageStep3 {
	WebDriver driver;
	
	By titleStep3 = By.xpath("//*[@id=\"frmRegistration\"]/div[1]/div");
	By inputName = By.id("Name");
	By inputLastName = By.id("Surname");
	By inputDNI = By.id("ID_Number");
	By selectSex = By.xpath("//*[@id=\"frmRegistration\"]/div[2]/div[1]/div[5]/span");
	By optionMale = By.xpath("/html/body/span/span/span[2]/ul/li[2]");
	By selectMaritialStatus = By.xpath("//*[@id=\"frmRegistration\"]/div[2]/div[1]/div[7]/span");
	By optionConviviente = By.xpath("/html/body/span/span/span[2]/ul/li[6]");
	By inputMail = By.id("txtEmail");
	By inputPassword = By.id("Password");
	By inputPhoneCode = By.id("PhoneCode");
	By inputPhoneNumber = By.id("PhoneNumber");
	By inputStreet = By.id("Street");
	By inputStreetNumber = By.id("HouseNumber");
	By inputStreetFloor = By.id("Floor");
	By inputStreetDepartment = By.id("Apartment");
	By inputPostalCode = By.id("zipCode");
	By buttonBack = By.xpath("//*[@id=\"frmRegistration\"]/div[3]/center/a");
	By buttonNext = By.id("btnRegister");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep3() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep3);
		String textTitle = title.getText();
		String Valor_esperado = "Completá tus datos... Ya casi terminamos";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 3");
	} 
	
	public void selectOptionMale() throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(selectSex).click();
		driver.findElement(optionMale).click();
		GenerarReporte.Paso("Se selecciona Maculino en Sexo biológico");
	}
	
	public void fillFormAndGoNext(String Name, String LastName, String DNI, String Mail, String Password, String PhoneCode, String PhoneNumber, String Street, String StreetNumber, String StreetFloor, String StreetDepartment, String PostalCode) throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(inputName).sendKeys(Name);
		driver.findElement(inputLastName).sendKeys(LastName);
		driver.findElement(inputDNI).sendKeys(DNI);
		driver.findElement(selectMaritialStatus).click();
		driver.findElement(optionConviviente).click();
		driver.findElement(inputMail).sendKeys(Mail);
		driver.findElement(inputPassword).sendKeys(Password);
		driver.findElement(inputPhoneCode).sendKeys(PhoneCode);
		driver.findElement(inputPhoneNumber).sendKeys(PhoneNumber);
		driver.findElement(inputStreet).sendKeys(Street);
		driver.findElement(inputStreetNumber).sendKeys(DNI);
		driver.findElement(inputStreetNumber).sendKeys(StreetNumber);
		driver.findElement(inputStreetDepartment).sendKeys(StreetDepartment);
		driver.findElement(inputPostalCode).sendKeys(PostalCode);
		driver.findElement(buttonNext).click();
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Interacción con el formulario y se presiona el botón siguiente");
	}
}