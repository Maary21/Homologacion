package mx.com.baz.eco.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.com.baz.eco.dto.Cabecero;
import mx.com.baz.eco.dto.RequestSendKafka;

@Service
@Slf4j
public class RestClientServiceImpl {
	
	//private String url="http://localhost:8082/customers/";
	
	private String url1="http://localhost:8081/customers/datos";
	//private String url1="http://10.82.56.194:8081/customers/datos";
	
	/*public void  getAllObjects(Cabecero data) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();			
			HttpEntity<Cabecero> entity = new HttpEntity<>(data);
		//	restTemplate.exchange(url, HttpMethod.POST,entity,Cabecero.class);
			restTemplate.postForEntity(url, data, Cabecero.class);
			log.info("");
						
		}catch (Exception rae) {
			log.error("No se puede conectar al servicio", rae);
		}

	}*/
	
	public void  getAllObjects(RequestSendKafka data) {
		try {
			RestTemplate restTemplate = new RestTemplate();			
			HttpEntity<RequestSendKafka> entity = new HttpEntity<>(data);
		//	restTemplate.exchange(url, HttpMethod.POST,entity,Cabecero.class);
			restTemplate.postForEntity(url1, data, RequestSendKafka.class);
			//log.info("");
			log.info(data.toString());
						
		}catch (Exception rae) {
			log.error("No se puede conectar al servicio", rae);
		}

	}
}
