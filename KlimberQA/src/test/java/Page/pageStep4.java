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

public class pageStep4 {
	WebDriver driver;
	
	By titleStep4 = By.xpath("//*[@id=\"frmStep4\"]/div[1]/div[1]/div");
	By selectNationality = By.id("select2-Nationality-container");
	By inputNationality = By.xpath("/html/body/span/span/span[1]/input");
	By inputPlaceOfBirth = By.id("PlaceOfBirth");
	By radioArgentina = By.id("txtEmail");
	By inputCountries = By.id("txtEmail");
	By radioInsurancePurpose = By.id("Password");
	By inputOccupation = By.id("txtOccupation");
	By inputSalaryAnual = By.id("txtSalaryAnual");
	By inputName = By.id("txtFullName");
	By inputDNI = By.id("txtNumberId");
	By checkIsPoliticallyExposedPerson = By.id("Name");
	By selectAnnualIncome = By.id("select2-txtAnnualIncome-container");
	By optionSalary = By.xpath("/html/body/span/span/span[2]/ul/li[2]");
	By buttonBack = By.xpath("//*[@id=\"frmRegistration\"]/div[3]/center/a");
	By buttonNext = By.id("btnSaveInfo");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep4() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep4);
		String textTitle = title.getText();
		String Valor_esperado = "Necesito unos datos adicionales";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 4");
	} 
	
	public void checkArgentina(String Paises) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(radioArgentina).click();
		driver.findElement(inputCountries).sendKeys(Paises);
		GenerarReporte.Paso("Se marca el radio button de otra nacionalidad");
	} 
	
	public void checkInsurancePurpose() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(radioInsurancePurpose).click();
		GenerarReporte.Paso("Se marca el radio button de Mi actividad laboral");
	} 
	
	public void checkIsPoliticallyExposedPerson() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(checkIsPoliticallyExposedPerson).click();
		GenerarReporte.Paso("Se marca el checkBox de Persona expuesta políticamente");
	} 
	
	public void selectedOptionSsalary() throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(selectAnnualIncome).click();
		driver.findElement(optionSalary).click();
		GenerarReporte.Paso("Se selecciona sueldo en ingreso anual");
	}
	
	public void fillFormAndGoNext(String Nacionalidad, String LugarNacimiento, String Ocupacion, String Salario, String Name, String DNI) throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(selectNationality).click();
		driver.findElement(inputNationality).sendKeys(Nacionalidad);
		driver.findElement(inputNationality).sendKeys(Keys.ENTER);
		driver.findElement(inputPlaceOfBirth).sendKeys(LugarNacimiento);
		driver.findElement(inputOccupation).sendKeys(Ocupacion);
		driver.findElement(inputSalaryAnual).sendKeys(Salario);
		driver.findElement(inputName).sendKeys(Name);
		driver.findElement(inputDNI).sendKeys(DNI);
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Interacción con el formulario y se presiona el botón siguiente");
	}
}