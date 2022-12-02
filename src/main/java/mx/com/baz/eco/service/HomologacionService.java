package mx.com.baz.eco.service;

import reactor.core.publisher.Mono;

public interface HomologacionService {
	
	/**
	 * 
	 * @param query representa el script de consulta a ejecutar en base de datos
	 * @return el resultado de la consulta de la base de datos EOBDDES
	 */
	Mono<String>queryExeHom(String query);
	
	Mono<String>queryExeHomAl(String query);
	
	Mono<String>queryExeHomSE(String query);

}
