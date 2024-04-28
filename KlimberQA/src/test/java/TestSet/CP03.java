package TestSet;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Page.pageStep1;
import Reporte.ArmadoReporte;

public class CP03 {
	public static void main (String arggs[]) throws InterruptedException, HeadlessException, InvalidFormatException, IOException, AWTException {
		// Variables
		String baseUrl = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
		String driverPath = "..\\..\\target\\driver\\geckodriver.exe";
		
		// Inicializar
		pageStep1 step1 = new pageStep1();
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
		
		// CP03 - Validar mensaje de error al ingresar un numero de telefono incorrecto (Letras) y (Menos de 6 caracteres)
		step1.startDriver(driver);
		step1.assertYouAreOnStep1();
		step1.fillForm("08042001","Chubut", "ABC","11");
		step1.insurance50();
		step1.assertErrorIncorrectPhoneNumber();
		step1.closeDriver(driver);
	}

}
