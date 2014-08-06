package ar.com.spring.webservice.service;

import javax.jws.WebService;


@WebService
public interface HolaMundoService {
	
	String saludaMundoHola(String text);

}
