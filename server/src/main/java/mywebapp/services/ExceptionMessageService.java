package mywebapp.services;

import mywebapp.viewData.ExceptionData;

public interface ExceptionMessageService {
	
	ExceptionData getCustomMessageByCode(String code);

}
