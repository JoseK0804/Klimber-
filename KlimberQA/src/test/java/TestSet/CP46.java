package TestSet;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Page.pageStep1;
import Page.pageStep2;
import Page.pageStep3;
import Page.pageStep4;
import Page.pageStep5;
import Page.pageStep6;
import Page.pageStep7;
import Page.pageStep8;
import Reporte.ArmadoReporte;

public class CP46 {
	public static void main (String arggs[]) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		// Variables
		String baseUrl = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
		String driverPath = "..\\..\\target\\driver\\geckodriver.exe";
		
		// Inicializar
		pageStep1 step1 = new pageStep1();
		pageStep2 step2 = new pageStep2();
		pageStep3 step3 = new pageStep3();
		pageStep4 step4 = new pageStep4();
		pageStep5 step5 = new pageStep5();
		pageStep6 step6 = new pageStep6();
		pageStep7 step7 = new pageStep7();
		pageStep8 step8 = new pageStep8();

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
		
		// CP46 - Contratar seguro exitosamente
		step1.startDriver(driver);
		step1.fillForm("08042001","CABA", "11","33675885");
		step1.insurance100();
		step1.trueAccident();
		step1.assertFormOK();
		step1.goStep2();
		
		// Step 2
		step2.startDriver(driver);
		step2.assertYouAreOnStep2();
		step2.fillFormAndGoNext("171", "68");
		
		// Step 3
		step3.startDriver(driver);
		step3.assertYouAreOnStep3();
		step3.selectOptionMale();
		step3.fillFormAndGoNext("José", "Aguilar", "95846816", "josekarlosvz2@gmail.com", "JoseQA1234", "AA", "33675885", "Av Belgrano", "3200", "2", "", "1210");
		
		// Step 4
		step4.startDriver(driver);
		step4.assertYouAreOnStep4();
		step4.selectedOptionSsalary();
		step4.fillFormAndGoNext("Venezuela", "Carabobo", "QA Tester", "2.500.000$", "Jose Karlos Aguilar Corro", "95846814");
		
		// Step 5
		step5.startDriver(driver);
		step5.assertYouAreOnStep5();
		step5.fillFormAndGoNext("4242424242424242");
		
		// Step 6
		step6.startDriver(driver);
		step6.assertYouAreOnStep6();
		step6.addPersonBeneficiary("Jose", "Aguilar", "95846814", "08", "04", "2001", "100");
		step6.selectChild();
		// step6.addPersonOrganization("Nombre", "20958468140", "100");
		step6.goSummary();
		
		// Step 7
		step7.startDriver(driver);
		step7.assertYouAreOnStep7();
		step7.summarySubmit();
		
		// Step 8
		step8.startDriver(driver);
		step8.assertYouAreOnStep8();
		step1.closeDriver(driver);
	}
}