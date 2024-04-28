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

public class pageStep6 {
	WebDriver driver;
	
	By titleStep6 = By.xpath("//*[@id=\"frmBeneficiaries\"]/div[1]/div");
	By buttonAddPersonBeneficiary = By.id("btnAddBeneficiaryNatural");
	By buttonaddPersonOrganization = By.id("btnAddBeneficiaryLegal");
	By inputName= By.xpath("//input[@placeholder='Nombre']");
	By inputLastName = By.xpath("//input[@placeholder='Apellido']");
	By inputDNI = By.xpath("//input[@placeholder='DNI']");
	By inputDay = By.xpath("//input[@placeholder='DD']");
	By inputMonth = By.xpath("//input[@placeholder='MM']");
	By inputYear = By.xpath("//input[@placeholder='AAAA']");
	By inputBeneficiaryPercentage = By.xpath("//input[@placeholder='% Beneficio']");
	By inputBusinessName = By.xpath("//input[@placeholder='Razón social']");
	By inputCUIT = By.xpath("//input[@placeholder='CUIT']");
	By selectRelationshipType = By.xpath("//*[@id=\"Beneficiario0\"]/div[2]/div[4]/span/span[1]/span");
	By optionChild = By.xpath("/html/body/span/span/span[2]/ul/li[3]");
	By buttonBack = By.xpath("//*[@id=\"frmBeneficiaries\"]/div[3]/center/button");
	By buttonNext = By.xpath("//*[@id=\"frmBeneficiaries\"]/div[3]/center/button");
	
	ArmadoReporte GenerarReporte = new ArmadoReporte();
	
	public void startDriver(WebDriver driver) {
		this.driver =driver;
	}
	
	public void assertYouAreOnStep6() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		WebElement title = driver.findElement(titleStep6);
		String textTitle = title.getText();
		String Valor_esperado = "¿Querés elegir a tus beneficiarios ahora?";
		Assert.assertEquals(textTitle, Valor_esperado);
		GenerarReporte.Paso("Se valida que estas en el step 6");
	} 
	
	public void addPersonBeneficiary(String Name,String LastName,String DNI,String Day,String Month,String Year,String BeneficiaryPercentage) throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(buttonAddPersonBeneficiary).click();
		driver.findElement(inputName).sendKeys(Name);
		driver.findElement(inputLastName).sendKeys(LastName);
		driver.findElement(inputDNI).sendKeys(DNI);
		driver.findElement(inputDay).sendKeys(Day);
		driver.findElement(inputMonth).sendKeys(Month);
		driver.findElement(inputYear).sendKeys(Year);
		driver.findElement(inputBeneficiaryPercentage).sendKeys(BeneficiaryPercentage);
		GenerarReporte.Paso("Se agrega un benificiario persona al seguro");
	}
	
	public void selectChild() throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(selectRelationshipType).click();
		driver.findElement(optionChild).click();
		GenerarReporte.Paso("Se selecciona hijo/a en Relación");
	}
	
	public void addPersonOrganization(String BusinessName,String CUIT,String BeneficiaryPercentage) throws HeadlessException, InvalidFormatException, IOException, AWTException, InterruptedException {
		driver.findElement(buttonaddPersonOrganization).click();
		driver.findElement(inputBusinessName).sendKeys(BusinessName);
		driver.findElement(inputCUIT).sendKeys(CUIT);
		driver.findElement(inputBeneficiaryPercentage).sendKeys(BeneficiaryPercentage);
		GenerarReporte.Paso("Se agrega un benificiario organización al seguro");
	}
	
	public void goSummary() throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		driver.findElement(buttonNext).click();
		GenerarReporte.Paso("Se presiona el botón Siguiente");
	} 
}