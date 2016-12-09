package mywebapp.facades;

import mywebapp.exception.MovieFlixException;

public interface ExceptionMessageFacade {

	String getCustomExceptionMessageByCode(String code);
	}
