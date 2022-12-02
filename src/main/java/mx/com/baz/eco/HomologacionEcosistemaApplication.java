package mx.com.baz.eco;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class HomologacionEcosistemaApplication {

	public static void main(String[] args) throws ParseException{
		SpringApplication.run(HomologacionEcosistemaApplication.class,args);

		//System.out.println("Inicio");

		//new Conversion().separaCadena();
		//new Conversion();
		//Conversion.Cadena();

		//new Conversion().ConvierteJSON();
		//new Conversion().SepCadena();
		//new LlaveUnica();
		//LlaveUnica.llaveunica();
		
		
	}
  
}
