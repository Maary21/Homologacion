package mx.com.baz.eco.controller;

import static mx.com.baz.eco.utils.Constant.SEPARADOR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.com.baz.eco.model.response.GenericResponse;
import mx.com.baz.eco.service.HomologacionService;
import reactor.core.publisher.Mono;

@Slf4j
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET})
@RestController
@RequestMapping(value= "/homologacion")
public class HomologacionController {
	private static final Logger log = LoggerFactory.getLogger(HomologacionController.class);

	@Autowired
	private HomologacionService service;
	
	@PostMapping(value="/info",
			consumes = MediaType.ALL_VALUE,  
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<GenericResponse<String>>> executeSpeiRec(@RequestBody String query )
	{
		//log.info(SEPARADOR);
		//System.out.println("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//log.info("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//System.out.println(query);
		//log.info(query);
		//log.info(SEPARADOR);
		return service.queryExeHom(query)
				/**
				 * Cuando obtenemos la respuesta se contruye la respuesta
				 */
				.map(q -> new ResponseEntity<>(new GenericResponse<>(200, "consulta correcta", q), HttpStatus.OK))
				/**
				 * Cuenta se completa la accion u ocurre un error
				 * se recibe la señal y se pintan los logs
				 */
				.doFinally(signalType -> {
					//log.info(SEPARADOR);
					//log.info(SEPARADOR);
					//System.out.println("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info(SEPARADOR);
				});

	}

	@PostMapping(value="/info/alnova",
			consumes = MediaType.ALL_VALUE,  
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<GenericResponse<String>>> executeAl(@RequestBody String query )
	{
		//log.info(SEPARADOR);
		//System.out.println("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//log.info("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//System.out.println(query);
		//log.info(query);
		//log.info(SEPARADOR);
		return service.queryExeHomAl(query)
				/**
				 * Cuando obtenemos la respuesta se contruye la respuesta
				 */
				.map(q -> new ResponseEntity<>(new GenericResponse<>(200, "consulta correcta", q), HttpStatus.OK))
				/**
				 * Cuenta se completa la accion u ocurre un error
				 * se recibe la señal y se pintan los logs
				 */
				.doFinally(signalType -> {
					//log.info(SEPARADOR);
					//log.info(SEPARADOR);
					//System.out.println("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info(SEPARADOR);
				});

	}
	
	@PostMapping(value="/info/SpeiEnv",
			consumes = MediaType.ALL_VALUE,  
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<GenericResponse<String>>> executeSpeiEnv(@RequestBody String query )
	{
		//log.info(SEPARADOR);
		//System.out.println("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//log.info("SE INICIALIZA EL ENDPOINT DE CONSULTAS A BD EO");
		//System.out.println(query);
		//log.info(query);
		//log.info(SEPARADOR);
		return service.queryExeHomSE(query)
				/**
				 * Cuando obtenemos la respuesta se contruye la respuesta
				 */
				.map(q -> new ResponseEntity<>(new GenericResponse<>(200, "consulta correcta", q), HttpStatus.OK))
				/**
				 * Cuenta se completa la accion u ocurre un error
				 * se recibe la señal y se pintan los logs
				 */
				.doFinally(signalType -> {
					//log.info(SEPARADOR);
					//log.info(SEPARADOR);
					//System.out.println("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info("SE FINALIZA EL ENDPOINT DE CONSULTAS A BD EO");
					//log.info(SEPARADOR);
				});

	}
	
}
