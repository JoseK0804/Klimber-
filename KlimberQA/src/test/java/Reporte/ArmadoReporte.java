package Reporte;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ArmadoReporte {

	MetodoGenerarReporte documento;
	
	public void  Paso(String descpripcionPaso) throws InvalidFormatException, IOException, HeadlessException, AWTException {
		documento.OpenFile(1, descpripcionPaso); 
		documento.screenshoot();
	}
	
	public void InicializaFile() throws HeadlessException, InvalidFormatException, IOException, AWTException {
		documento.defineVariables();
	}
	
	public void GeneraEvidencia(String nombreArchivo) throws HeadlessException, InvalidFormatException, IOException, AWTException {
		documento.CloseFile(nombreArchivo);
	}
}
