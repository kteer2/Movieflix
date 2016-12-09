package mywebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import mywebapp.viewData.ExceptionData;

@Component
@Configuration
@PropertySource("classpath:exceptionmessage.properties")
public class ExceptionMessageServiceImpl implements ExceptionMessageService {

	@Value("${def_Exception_Message}")
	private String defExceptionMessage;
	
	@Autowired
	Environment env;
	
	@Override
	public ExceptionData getCustomMessageByCode(String code) {
		ExceptionData data = new ExceptionData();
		data.setErrorMessage(env.getProperty(code, defExceptionMessage));
		return data;
	}

}
