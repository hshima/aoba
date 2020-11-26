package br.com.adesc.caucaia.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adesc.caucaia.event.CreateResourceEvent;

@Component
public class CreatedEventListener implements ApplicationListener<CreateResourceEvent>{

	@Override
	public void onApplicationEvent(CreateResourceEvent event) {
		HttpServletResponse response = event.getResponse();
		Long codigo = event.getId();
		addHeaderLocation(response, codigo);
	}
	
	private void addHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/pedidos/{id}")
				.buildAndExpand(id)
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}
