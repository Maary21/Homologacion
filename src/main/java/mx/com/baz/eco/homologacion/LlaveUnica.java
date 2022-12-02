package mx.com.baz.eco.homologacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LlaveUnica {

	//int idTransaccion;
	//int fecha;
	static int consecutivo;

	public static int GenLLavUnica(int LlaveUnica) {

		int Digito = 1;

		do {
			for (int j = 1; j <= 9999; j++) {
				consecutivo = Integer.toString(j).length();
				if (consecutivo == 1) {
					System.out.println("00000" + j);
				} else if (consecutivo == 2) {
					System.out.println("0000" + j);
				} else if (consecutivo == 3) {
					System.out.println("000" + j);
				} else if (consecutivo == 4) {
					System.out.println("00" + j);
				} else if (consecutivo == 5) {
					System.out.println("0" + j);
				} else if (consecutivo == 6) {
					System.out.println(j);
				}
			}
		} while (!(Digito == 9999));
		return LlaveUnica;
	}

	
public static void llaveunica() {
	
	String cadena = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<Transaccion><Cabecero><FIPAISID>1</FIPAISID><FICANALID>27</FICANALID>"
			+ "<FINOTIENDA>1239</FINOTIENDA><FITRANNO>5139629</FITRANNO>"
			+ "<FITRANTIPO>5322</FITRANTIPO><FICONSECTIPO>9735</FICONSECTIPO>"
			+ "<FDTRANSFECHR>2022-04-01 13:27:00</FDTRANSFECHR><FCTRANWS>WS_CAJA01</FCTRANWS>"
			+ "<FCTRANUSR>1014698   </FCTRANUSR><FITRANNOREG>4</FITRANNOREG></Cabecero>"
			+ "<Detalle><FICONSDETA>1</FICONSDETA><FITIPOREG>2719</FITIPOREG>"
			+ "<FCDATODETA>2022-04-01-13.26.45.0200216                    "
			+ "+000000000000000000+000000000000000000+000000                    "
			+ "TOTAL_PLAY          +000000000000063900+000000000000063900+000000000000000750+00000000E"
			+ "Pagon Con Efectivo                      1239</FCDATODETA></Detalle><Detalle><FICONSDETA>2</FICONSDETA>"
			+ "<FITIPOREG>2720</FITIPOREG><FCDATODETA>2022-04-01-13.26.45.02009000001088700751                       "
			+ "+0000000000000639000.16WS_C1014698                                                   "
			+ "Elekt13:26              000011330                               </FCDATODETA></Detalle>"
			+ "<Detalle><FICONSDETA>3</FICONSDETA><FITIPOREG>400</FITIPOREG><FCDATODETA>  481101469  0  "
			+ "1000011330               2022-04-01-13.27.00+000000063900         0    0       775         "
			+ "0  0    0WS_CAJA01         775  632  1012390005139629004811014698         </FCDATODETA></Detalle>"
			+ "<Detalle><FICONSDETA>4</FICONSDETA><FITIPOREG>408</FITIPOREG><FCDATODETA>  481  1+000000063900</FCDATODETA></Detalle></Transaccion>";

	 String cadenaspei = "{\"STSINTERFAZ\":\"F\",\"NUMCONF\":null,\"NUMCONCIL\":368773474,\"PAQUETEPAGO\":3857,\"MONTO\":2240.0,\"TIPOPAGO\":1,\"NOM_BEN\":\"FIDEICOMISO GLOBAL DEL SINTICATO NACIONA\",\"RASTREO_ORIGINAL\":\"                              \",\"RASTREO\":\"2021SIAFP630938               \",\"PAQUETEPAGOSUB\":24,\"STATUS\":\"C\",\"FOLIOSPEI\":849713,\"HORA\":50106,\"REFERENCIANUM\":530,\"RFC_ORD\":\"SHC850101U37      \",\"HORAABONOSTP\":\"09:13.0\",\"TIPOENVIO\":\"C\",\"TIPOCUENTA_ORD\":40,\"HORASTP\":\"09:11.0\",\"CUENTA_ORD\":\"1180228001000100    \",\"CUENTA_BEN\":\"127180001109922000  \",\"FECHAOPERACION\":20220912,\"STATUSDEV\":\" \",\"NOM_ORD\":\"TESORERIA DE LA FEDERACION              \",\"TIPOCUENTA_BEN\":40,\"CONCEPTOPAGO\":\"33-416-40436  PAGO TESOFE  0100                                                                                                                                                                                   \",\"RFC_BEN\":\"FGS110530IY7      \",\"IVA\":0.0,\"FOLIO\":24,\"INSTITUCION\":\"2001  \",\"MONTO_COMISION\":null}";

	
	/*
	 * System.out.println("JSON IS"); try { JSONObject json =
	 * XML.toJSONObject(cadena); String jsonString = json.toString(4);
	 * System.out.println(jsonString); }catch(Exception e){}
	 * 
	 */

//String cadena2 = "<FDTRANSFECHR>2022-04-01 13:26:00</FDTRANSFECHR>";

//Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
	Pattern pattern = Pattern.compile("<FDTRANSFECHR>(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})</FDTRANSFECHR>",
			Pattern.CASE_INSENSITIVE);
	Pattern pattern20 = Pattern.compile("FECHAOPERACION\":(\\d{4}\\d{2}\\d{2}),",Pattern.CASE_INSENSITIVE);

	
	Matcher matcher = pattern20.matcher(cadena);
	   String fecha="";
	 //Vemos si coincide el patrón con el texto
	 	if(matcher.find())
	 	{
	 		// Coincidió => obtener el valor del grupo 1
	 		fecha = matcher.group(1);
	 		// System.out.println(fecha);
	 	}else
	 	{
	 		// No coincidió
	 		System.out.println("No se reconoce fecha");
	 	}

	System.out.println(fecha);  

	Pattern pattern2 = Pattern.compile("(\\d{4})-", Pattern.CASE_INSENSITIVE);
	Matcher matcher2 = pattern2.matcher(fecha);
	String fechaanio = "";if(matcher2.find())
	{
		fechaanio = matcher2.group(1);
		// System.out.println(fechaanio);
	}else
	{
		System.out.println("No se reconocen el anio");
	}

	Pattern pattern3 = Pattern.compile("-(\\d{2})", Pattern.CASE_INSENSITIVE);
	Matcher matcher3 = pattern3.matcher(fecha);
	String fechames = "";if(matcher3.find())
	{
		fechames = matcher3.group(1);
		// System.out.println(fechames);
	}else
	{
		System.out.println("No se reconoce mes");
	}

	Pattern pattern4 = Pattern.compile("-(\\d{2})\\s", Pattern.CASE_INSENSITIVE);
	Matcher matcher4 = pattern4.matcher(fecha);
	String fechadia = "";if(matcher4.find())
	{
		fechadia = matcher4.group(1);
		// System.out.println(fechadia);
	}else
	{
		System.out.println("No se reconoce el dia");
	}

	Pattern pattern5 = Pattern.compile("\\s(\\d{2}):", Pattern.CASE_INSENSITIVE);
	Matcher matcher5 = pattern5.matcher(fecha);
	String hora = "";if(matcher5.find())
	{
		hora = matcher5.group(1);
		// System.out.println(hora);
	}else
	{
		System.out.println("No se reconoce la hora");
	}

	Pattern pattern6 = Pattern.compile(":(\\d{2}):", Pattern.CASE_INSENSITIVE);
	Matcher matcher6 = pattern6.matcher(fecha);
	String min = "";if(matcher6.find())
	{
		min = matcher6.group(1);
		// System.out.println(min);
	}else
	{
		System.out.println("No se reconocen los minutos");
	}

//System.out.println("IdTransaccion: " + fechadia + fechames + fechaanio);
//System.out.println("fdoperacion: " + hora + min);
	System.out.println("Llave Unica: "+fechadia+fechames+fechaanio+hora+min);

	/*
	 * int Digito = 1;
	 * 
	 * do{ for(int j= 1; j <= 999 ;j++){ //Digito++; //System.out.println(j);
	 * //System.out.println("El número " + j + " tiene " +
	 * Integer.toString(j).length() + " dígitos"); int a =
	 * Integer.toString(j).length(); //System.out.println(a); if(a == 1) { String c
	 * =String.valueOf("00000" + j); System.out.println(c); }else if(a == 2) {
	 * String c =String.valueOf("0000" + j); System.out.println(c); }else if(a == 3)
	 * { String c =String.valueOf("000" + j); System.out.println(c); }else if(a ==
	 * 4) { String c =String.valueOf("00" + j); System.out.println(c); }else if(a ==
	 * 5) { String c =String.valueOf("0" + j); System.out.println(c); }else if(a ==
	 * 6) { System.out.println(j); }
	 * 
	 * } }while(!(Digito==999));
	 * 
	 */

}

}

