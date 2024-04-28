package TestSet;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Page.pageStep1;
import Page.pageStep2;
import Reporte.ArmadoReporte;

public class CP05 {
	public static void main (String arggs[]) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		// Variables
		String baseUrl = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
		String driverPath = "..\\..\\target\\driver\\geckodriver.exe";
		
		// Inicializar
		pageStep1 step1 = new pageStep1();
		pageStep2 step2 = new pageStep2();
		ArmadoReporte GenerarReporte = new ArmadoReporte();
		GenerarReporte.InicializaFile();
		
		// Driver
		WebDriver driver;
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		GenerarReporte.Paso("Entra a la WEB");
		
		// CP05 - Validar mensaje de error al dejar un campo vacio Step 2
		step1.startDriver(driver);
		step1.assertYouAreOnStep1();
		step1.fillForm("08042001","Mendoza", "11","33675885");
		step1.insurance50();
		step1.trueAccident();
		step1.assertFormOK();
		step1.goStep2();
		
		 // Step 2
		step2.startDriver(driver);
		step2.assertYouAreOnStep2();
		step2.fillFormAndGoNext("","");
		step1.assertEmptyField();
		step1.closeDriver(driver);
	}
}
