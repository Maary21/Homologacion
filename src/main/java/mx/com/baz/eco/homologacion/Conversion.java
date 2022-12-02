package mx.com.baz.eco.homologacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;
import mx.com.baz.eco.dto.Cabecero;
import mx.com.baz.eco.dto.RequestSendKafka;
import mx.com.baz.eco.service.RestClientServiceImpl;
import reactor.core.publisher.Mono;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

@Log4j2
@Repository
public class Conversion {
	
	@Autowired
	private RestClientServiceImpl resT;

	//private static Logger log = Logger.getLogger(Conversion.class.getName());
	public static int cont = 0;
	
	/*HoMologacion de SPEI RECEPCIONES*/
	public Mono<String> SepCadena(String cadenahomologar) throws ParseException {
		cont++;
		
		try {
			
		//cadenahomologar = "{\"STSINTERFAZ\":\"F\",\"NUMCONF\":null,\"NUMCONCIL\":368773474,\"PAQUETEPAGO\":3857,\"MONTO\":2240.0,\"TIPOPAGO\":1,\"NOM_BEN\":\"FIDEICOMISO GLOBAL DEL SINTICATO NACIONA\",\"RASTREO_ORIGINAL\":\"                              \",\"RASTREO\":\"2021SIAFP630938               \",\"PAQUETEPAGOSUB\":24,\"STATUS\":\"C\",\"FOLIOSPEI\":849713,\"HORA\":50106,\"REFERENCIANUM\":530,\"RFC_ORD\":\"SHC850101U37      \",\"HORAABONOSTP\":\"09:13.0\",\"TIPOENVIO\":\"C\",\"TIPOCUENTA_ORD\":40,\"HORASTP\":\"09:11.0\",\"CUENTA_ORD\":\"1180228001000100    \",\"CUENTA_BEN\":\"127180001109922000  \",\"FECHAOPERACION\":20220912,\"STATUSDEV\":\" \",\"NOM_ORD\":\"TESORERIA DE LA FEDERACION              \",\"TIPOCUENTA_BEN\":40,\"CONCEPTOPAGO\":\"33-416-40436  PAGO TESOFE  0100                                                                                                                                                                                   \",\"RFC_BEN\":\"FGS110530IY7      \",\"IVA\":0.0,\"FOLIO\":24,\"INSTITUCION\":\"2001  \",\"MONTO_COMISION\":null}";
		String cadenahomologarnuevo = ("\""+cadenahomologar+"\"");
			
		String[] ncadena = cadenahomologarnuevo.replaceAll("\\{", "").replaceAll("\"", "").split(",");
		String cadena = String.join("", ncadena);
		String[] array = cadena.replaceAll("\"", "").split("");
		String arrayToString3 = String.join("", array);
		// String ejemploq = ncadena[1];
		// System.out.println(ejemploq);

		String FECHAOPERACION = ncadena[0]; // Cabecero

		// CAMPO TIPOOPERACION INEXISTENTE EN LA CONSULTA String TIPOOPERACION =
		// ncadena[31];

		String fechaop = ("\"" + "FI" + FECHAOPERACION + ",");

		// fechaop FI
		String separoFO = String.join("", fechaop);
		String[] separoFO1 = separoFO.split(":");
		String atributoFO = separoFO1[0];
		String datoFO = separoFO1[1];
		String convatributoFO = String.join("", atributoFO);
		String nuevoatributoFO = (convatributoFO + "\"");
		String convdatoFO = String.join("", datoFO);
		String datoJsonFO = (nuevoatributoFO + ":" + convdatoFO);
		
		/*formato correcto de la fecha*/
		String formatoFecha = convdatoFO.replaceAll(",", "");
        //Formato inicial.  
		//log.info(formatoFecha);
		
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        
        Date d = formato.parse(formatoFecha); //error
        //log.info(d.toString());
		
        //Aplica formato requerido.
        formato.applyPattern("ddMMyyyy");
        String nuevoFormatofecha = formato.format(d);
        //El proceso se rompe por aqui
		
		//01 de conciliacion, fecha en ddMMYYYY de la fecha de operacion y el consecutivo
		String FCIDTRANSACCION = ("\"FCID_TRANSACCION\""+":"+"\""+"01"+nuevoFormatofecha + cont +"\",");
		//System.out.println(FCIDTRANSACCION);
		String idsolo = ("01"+nuevoFormatofecha + cont);
		//03 indica el flujo de entrada 01 tipo de operacion conciliacion y consecutivo
		String formatoflujo="0301";
		String IDFLUJO = ("\"FCIDFLUJO\""+":"+"\""+formatoflujo+ cont +"\",");	
		int pk = 17;
		String PKafka = ("\"keyKafka\""+":"+pk + ",");
		int idconc = 4;
		String IDCONCI = ("\"partitionKafka\""+":"+idconc);

		//log.info(data.toString());
		
		
		//LLAVE UNICA
		String llave = (idsolo + nuevoFormatofecha+ cont);
		//System.out.println("---SPEIRECEP");
		//System.out.println(llave);
		
		//RequestSendKafka datos = new RequestSendKafka(llave ,data);
		
		
		//RequestSendKafka datos1 = new Gson().toJson(datos, RequestSendKafka.class);

		String ncadenaNu = cadenahomologar.replaceAll("\\{", "").replaceAll("}", ",").replaceAll("-", "").replaceAll("&", "").trim();
		String cadenaNu = String.join("", ncadenaNu);
		
		String JsonPrueba = ("{"+FCIDTRANSACCION+IDFLUJO+ cadenaNu + PKafka + IDCONCI + "}");

		Cabecero dataNuevo = new Gson().fromJson(JsonPrueba, Cabecero.class);
		//log.info("------data Nuevo");
		//log.info(dataNuevo.toString());
		
		RequestSendKafka datos = new RequestSendKafka(llave ,dataNuevo); //se quito la particion del llamado

		resT.getAllObjects(datos);
		//resT.getAllObjects(datos1);
		//System.out.println(Json);
		//log.info(Json);
		
		return Mono.just(JsonPrueba);
	
		}catch(Exception e) {
			//log.info(e.toString());
			return Mono.error(e);
		}

		
	}
}

	
