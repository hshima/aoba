package br.com.adesc.caucaia.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class CreateResourceEvent extends ApplicationEvent{

	private HttpServletResponse response;
	private Long id;
	
	private static final long serialVersionUID = 1L;

	public CreateResourceEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}
	
}
