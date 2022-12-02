package mx.com.baz.eco.serviceImpl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.baz.eco.homologacion.Conversion;
import mx.com.baz.eco.homologacion.ConversionAlnova;
import mx.com.baz.eco.homologacion.ConversionAlnovaSpeiEnvios;
import mx.com.baz.eco.service.HomologacionService;
import reactor.core.publisher.Mono;

@Service
public class HomologacionServiceImpl implements HomologacionService{

	@Autowired
	private Conversion conv;
	
	@Autowired
	private ConversionAlnova convAl;
	
	@Autowired
	private ConversionAlnovaSpeiEnvios convSE;
	
	
	
	@Override
	public Mono<String> queryExeHom(String query) {
		// TODO Auto-generated method stub
			try {
				return conv.SepCadena(query);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

	}
	
	@Override
	public Mono<String> queryExeHomAl(String query) {
		// TODO Auto-generated method stub
			try {
				return convAl.SepCadenaAl(query);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
		
	@Override
	public Mono<String> queryExeHomSE(String query) {
		// TODO Auto-generated method stub
			try {
				return convSE.SepCadenaSpeEnv(query);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}