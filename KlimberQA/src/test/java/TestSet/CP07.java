package TestSet;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Page.pageStep1;
import Page.pageStep2;
import Page.pageStep2_2;
import Reporte.ArmadoReporte;

public class CP07 {
	public static void main (String arggs[]) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		// Variables
		String baseUrl = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
		String driverPath = "..\\..\\target\\driver\\geckodriver.exe";
		
		// Inicializar
		pageStep1 step1 = new pageStep1();
		pageStep2 step2 = new pageStep2();
		pageStep2_2 step2_2 = new pageStep2_2();
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
		
		// CP07 - Validar paso atras del step 2_2 al 2
		step1.startDriver(driver);
		step1.fillForm("08042001","Buenos Aires", "11","33675885");
		step1.insurance50();
		step1.trueIllness();
		step1.assertFormOK();
		step1.goStep2();
		
		// Step 2
		step2.startDriver(driver);
		step2.assertYouAreOnStep2();
		step2.checkAssistance();
		step2.fillFormAndGoNext("1", "1"); // Colocar numeros para que rechace el seguro y redirija al step 2_2
		
		// Step 2_2
		step2_2.startDriver(driver);
		step2_2.assertYouAreOnStep2_2();
		step2_2.goBack();
		
		step2.assertYouAreOnStep2();
		step1.closeDriver(driver);
	}
}