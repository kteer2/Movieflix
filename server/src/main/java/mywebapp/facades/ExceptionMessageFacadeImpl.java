package mywebapp.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mywebapp.services.ExceptionMessageService;

@Component
public class ExceptionMessageFacadeImpl implements ExceptionMessageFacade {

	private static final String EMPTY = "";
	@Autowired
	ExceptionMessageService exceptionMessageService;

	@Override
	public String getCustomExceptionMessageByCode(String code) {
		ObjectMapper obj = new ObjectMapper();
		try {
			return obj.writeValueAsString(exceptionMessageService.getCustomMessageByCode(code));
		} catch (JsonProcessingException e) {
			return EMPTY;
		}
	}
}
