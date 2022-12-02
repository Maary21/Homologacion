package mx.com.baz.eco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSendKafka {
	private String key;
	//private Integer partition;
	private Cabecero cabecero;
	//private Renombre renombre;
}
