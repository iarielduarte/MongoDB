package ar.com.spring.webservice.service;

import javax.jws.WebService;

@WebService(endpointInterface="ar.com.spring.webservice.service.HolaMundoService")
public class HolaMundoServiceImpl implements HolaMundoService {

	@Override
	public String saludaMundoHola(String text) {
		String var = "Hola Web Service con cxf y Spring by :"+text;
		System.out.println(var);
		return var;
	}

}
