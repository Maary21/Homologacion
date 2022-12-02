package mx.com.baz.eco.homologacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j2;
import mx.com.baz.eco.dto.Cabecero;

import mx.com.baz.eco.dto.RequestSendKafka;
import mx.com.baz.eco.service.RestClientServiceImpl;
import reactor.core.publisher.Mono;

@Log4j2
@Repository
public class ConversionAlnova {

	@Autowired
	private RestClientServiceImpl resT;

	private static Logger log = Logger.getLogger(Conversion.class.getName());
	public static int cont = 0;
	
	/* Homologacion de ALNOVA */
	public Mono<String> SepCadenaAl(String cadenahomologar) throws ParseException {
		cont++;
		try {
			
			//cadenahomologar = "{\"T071_ENT_UPDATE\":\"0127\",\"T071_ENT\":\"0127\",\"T071_FLG_UPDATE\":\"N\",\"T071_CEN_UPDATE\":\"9546\",\"T071_TIMESTAMP\":\"2022-09-12-18.11.12.150779\",\"T071_TIM_OPERATION\":\"1810\",\"T071_FLG_CREDEB\":\"D\",\"T071_CEN_REG\":\"2175\",\"T071_OBSERVATIONS\":\"ANN SPEI POR NO AUTENTICARSE  &\",\"T071_CODE\":\"217\",\"T071_FLG_MODIFIED\":\"N\",\"T071_COD_SPROD\":\"0017\",\"T071_FLG_FREE3\":null,\"T071_CHECK\":0,\"T071_FLG_CHECKED\":\"N\",\"T071_NTNMUPD\":\"FE4C0710\",\"T071_FLG_FREE2A\":null,\"T071_NUM_RNWSEQ\":0,\"T071_FLG_FREE2B\":null,\"T071_FCC\":\"MXP\",\"T071_ENT_ACCT\":\"0127\",\"T071_UPDATM\":null,\"T071_AMT_ORIGIN\":44200,\"T071_AMOUNT\":44200,\"T071_DAT_ACCT\":\"2022-09-12\",\"T071_COD_PRODUCT\":\"13\",\"T071_ACC\":\"1375295969\",\"T071_OCC\":\"MXP\",\"T071_NUM_OPERATION\":554,\"T071_DAT_VALUE\":\"2022-09-12\",\"T071_AMT_FREE1\":0,\"T071_FLG_AUTOMAN\":\"A\",\"T071_AMT_FREE2\":0,\"T071_AMT_FREE3\":24278.31,\"T071_FLG_FREE1\":\"06 \",\"T071_FLG_ANN\":\"N\",\"T071_DAT_OPERATION\":\"2022-09-12\",\"T071_USERUPD\":\"BATCH OI\",\"T071_AUTBAL\":24278.31,\"T071_INTREF\":\"5603778552I0700\",\"T071_CEN_ACCT\":\"2175\",\"T071_TYP_ACCT\":\"044\"}";
		String cadenahomologarnuevo = ("\""+cadenahomologar+"\"");

		String[] ncadena = cadenahomologarnuevo.replaceAll("\\{", "").replaceAll("\"", "").split(",");
		String cadena = String.join("", ncadena);
		String[] array = cadena.replaceAll("\"", "").split("");
		String arrayToString3 = String.join("", array);
		// String ejemploq = ncadena[1];
		// System.out.println(ejemploq);
		
		String T071_DAT_OPERATION = ncadena[3];
		//[0] FCNOM_ORD
		//[1] 
		//[2] 
		//[3]
		//System.out.println(T071_DAT_OPERATION);
		
	String fechaop = ("\"" + "FC" + T071_DAT_OPERATION + "\",");

	
	// fechaop FC	
	String separoFO = String.join("", fechaop);
	String[] separoFO1 = separoFO.split(":");
	String atributoFO = separoFO1[0];
	String datoFO = separoFO1[1];
	String convatributoFO = String.join("", atributoFO);
	convatributoFO = "FIFECHAOPERACION";
	String nuevoatributoFO = (convatributoFO + "\"");
	String convdatoFO = String.join("", datoFO);
	String newFO = ("\"" + convdatoFO);
	//System.out.println(convdatoFO);
	
	/* formato correcto de la fecha */
	String formatoFecha = convdatoFO.replaceAll(",", "");
	// Formato inicial.
	//System.out.println(atributoFO);
	//System.out.println(formatoFecha);
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
	Date d = formato.parse(formatoFecha);
	// Aplica formato requerido.
	formato.applyPattern("yyyymmdd"); //se cambio MM por mm
	String nuevoFormatofecha = formato.format(d);
	//System.out.println(nuevoFormatofecha); //nuevo formato de la fecha
	
	String datoJsonFO = (convatributoFO + ":" + nuevoFormatofecha +"," );

	/* formato correcto de la fecha */
	//String formatoFecha2 = convdatoFO.replaceAll(",", "");
	// Formato inicial.
	SimpleDateFormat formato2 = new SimpleDateFormat("yyyymmdd");
	Date d2 = formato2.parse(nuevoFormatofecha);
	// Aplica formato requerido.
	formato2.applyPattern("ddmmyyyy"); //se cambio MM por mm
	String nuevoFormatofecha2 = formato2.format(d2);
	//System.out.println(nuevoFormatofecha); //nuevo formato de la fecha

	// 01 de conciliacion, fecha en ddMMYYYY de la fecha de operacion y el
	// consecutivo
	String FCIDTRANSACCION = ("\"FCID_TRANSACCION\"" + ":" + "\"" + "01" + nuevoFormatofecha2 + cont + "\",");
	//System.out.println(FCIDTRANSACCION);
	String idsolo = ("01"+nuevoFormatofecha2 + cont);
	// 03 indica el flujo de entrada 01 tipo de operacion conciliacion y consecutivo
	String formatoflujo = "0301";
	String IDFLUJO = ("\"FCIDFLUJO\"" + ":" + "\"" + formatoflujo + cont + "\",");
	int pk = 16;
	String PKafka = ("\"keyKafka\""+":"+pk + ",");
	int idconc = 4;
	String IDCONCI = ("\"partitionKafka\""+":"+idconc);
	

	//log.info("------dato1");
	//log.info(dato1.toString());
	/*reemplazo los { } por coma */
	
	String ncadenaNu = cadenahomologar.replaceAll("\\{", "").replaceAll("}", ",").replaceAll("-", "").replaceAll("&", "").trim();
	System.out.println(ncadenaNu);
	
	String cadenaNu = String.join("", ncadenaNu);
	//log.info("------cadenaNu");
	//log.info(cadenaNu);

	
	String JsonPrueba = ("{"+FCIDTRANSACCION+IDFLUJO+ cadenaNu + PKafka + IDCONCI + "}");
	//log.info("------JsonPrueba");
	//log.info(JsonPrueba); 
	
	Cabecero dataNuevo = new Gson().fromJson(JsonPrueba, Cabecero.class);
	//log.info("------data Nuevo");
	//log.info(dataNuevo.toString());
	
	String llave = (idsolo + nuevoFormatofecha2+ cont);
	//System.out.println("---ALNOVA");
	//log.info(llave);
	//log.info(data.toString());
	
	RequestSendKafka datos = new RequestSendKafka(llave ,dataNuevo); //se quito la particion del llamado
	//System.out.println(datos);
	resT.getAllObjects(datos);
	
	//System.out.println(Json);
	//log.info(Json);
	return Mono.just(JsonPrueba);
	
	}catch(Exception e)
	{
		//log.info(e.toString());
		return Mono.error(e);
	}

	}
}
