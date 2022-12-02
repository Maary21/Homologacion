package mx.com.baz.eco.homologacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConversionTIBCO {

	public static String resultadoJson;
	private static String[] ncadena2;
	private static String resultado2;
	private static String resultado1;
	private static int datos;
	static String[] arreglo = new String[datos];
	public static ArrayList<String> caden = new ArrayList<>();

	public static String TEST_XML_STRING = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<Transaccion><Cabecero><FIPAISID>1</FIPAISID><FICANALID>9</FICANALID><FINOTIENDA>708</FINOTIENDA><FITRANNO>16814112</FITRANNO><FITRANTIPO>5322</FITRANTIPO><FICONSECTIPO>286073</FICONSECTIPO><FDTRANSFECHR>2022-04-01 13:25:00</FDTRANSFECHR><FCTRANWS>WS_CAJA03 </FCTRANWS><FCTRANUSR>1027355   </FCTRANUSR><FITRANNOREG>4</FITRANNOREG></Cabecero><Detalle><FICONSDETA>1</FICONSDETA><FITIPOREG>2719</FITIPOREG><FCDATODETA>2022-04-01-13.25.19.5370363                    +000000000000000000+000000000000000000+000561                    CFE.                +000000000000016000+000000000000016000+000000000000000000+00000089E Pagon Con Efectivo                      0708</FCDATODETA></Detalle><Detalle><FICONSDETA>2</FICONSDETA><FITIPOREG>2720</FITIPOREG><FCDATODETA>2022-04-01-13.25.19.537010711804921722204040000001609          +0000000000000166500.16WS_C1027355                                                   Elekt13:25              000282634                               </FCDATODETA></Detalle><Detalle><FICONSDETA>3</FICONSDETA><FITIPOREG>400</FITIPOREG><FCDATODETA>  481102735  0  1000282634               2022-04-01-13.25.00+000000016650         0    0       634         0  0    0WS_CAJA03         634  632  101458254F4390981    1027355                                           </FCDATODETA></Detalle><Detalle><FICONSDETA>4</FICONSDETA><FITIPOREG>408</FITIPOREG><FCDATODETA>  481  1+000000016650</FCDATODETA></Detalle></Transaccion>";

	
	/* METODO PARA LA HOMOLOGACION DE LA INFORMACION DEL ORIGEN DE TIBCO */
	public void separaCadena() {
		String[] ncadena = TEST_XML_STRING.split("</Cabecero>");// <Detalle>
		String cabecero = ncadena[0];

		String[] str1 = cabecero.replaceAll("\\?", "").split("");
		String arrayToString2 = String.join("", str1);

		String[] json = arrayToString2.replaceAll("xml version=\"1.0\" encoding=\"UTF-8\"", "").split("");
		String arrayToString3 = String.join("", json);

		String[] xml = arrayToString3.replaceAll("<><Transaccion>", "{").split("");
		String arrayToString4 = String.join("", xml);

		String[] json2 = arrayToString4.replaceAll("><", ",").split("");
		String arrayToString5 = String.join("", json2);

		ncadena2 = arrayToString5.split(",");
		resultadoJson = String.join("", ncadena2);
	}

	public static void Cadena() {
		for (int i = 0; i < ncadena2.length; i++) {
			if (ncadena2[i] == ncadena2[7]) {
				String[] words = ncadena2[i].split("(\\-)*+(:)*+(\\W+)");// ("\\W+");
				StringBuilder stringBuilder = new StringBuilder();
				Set<String> wordsHashSet = new HashSet<>();

				for (String word : words) {
					if (wordsHashSet.contains(word.toLowerCase()))
						continue;
					wordsHashSet.add(word.toLowerCase());
					stringBuilder.append(word).append(" ");
				}

				String nonDuplicateString = stringBuilder.toString().trim();
				String[] cadenajson = nonDuplicateString.split(" ");

				String nombre = cadenajson[0];
				String det = cadenajson[1];
				String det2 = cadenajson[2];

				resultado1 = nombre + "\":\"" + det + " " + det2;
				caden.add("\"" + resultado1 + "\",");
			}

			if (ncadena2[i] != ncadena2[7]) {
				String[] words = ncadena2[i].split("(\\-)*+(:)*+(\\W+)");
				StringBuilder stringBuilder = new StringBuilder();
				Set<String> wordsHashSet = new HashSet<>();

				for (String word : words) {
					if (wordsHashSet.contains(word.toLowerCase()))
						continue;
					wordsHashSet.add(word.toLowerCase());
					stringBuilder.append(word).append(" ");
				}

				String nonDuplicateString = stringBuilder.toString().trim();
				String[] cadenajsonarray = nonDuplicateString.replaceAll("\\W+", "\":\"").split("");

				resultado2 = String.join("", cadenajsonarray);
				caden.add("\"" + resultado2 + "\",");
			}
		}

		String[] nuevoArreglo = new String[caden.size()];
		caden.toArray(nuevoArreglo);

		String nuevacadena = String.join("", caden);
		nuevacadena = nuevacadena.substring(0, nuevacadena.length() - 1);
		String str1 = nuevacadena.replaceFirst(",", ":{");

		System.out.println("cadena JSON FINAL");
		str1 = ("{" + str1 + "}}");
		System.out.println(str1);

	}
	
	
}
