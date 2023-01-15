package br.com.diogolages.client.rest.api.service.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.access.AccessDeniedException;

class ResourceExceptionHandlerTest {
	
	private static final String LOCALE = "BR";
	private static final String ACCESS_DENIED = "Access denied";
	private static final String CPF_ALREADY_REGISTERED_IN_THE_SYSTEM = "CPF already registered in the system";
	private static final String OBJECT_NOT_FOUND = "Object not found";
	
	@InjectMocks
	private ResourceExceptionHandler exception;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenResourceNotFoundThenReturnAnResponseEntity() {
		ResponseEntity<ExceptionResponse> response = 
				exception
				.resourceNotFound(new ResourceNotFoundException(OBJECT_NOT_FOUND), 
								  new MockHttpServletRequest());
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(OBJECT_NOT_FOUND, response.getBody().getMessage());
	}

	@Test
	void whenHandleThrowableThenReturnAnResponseEntity() {
		ResponseEntity<ExceptionResponse> response = 
				exception.handleThrowable(new AccessDeniedException(ACCESS_DENIED), new Locale(LOCALE));
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(ACCESS_DENIED, response.getBody().getMessage());
	}

	@Test
	void whenDataIntegratyViolationExceptionThenReturnAnResponseEntity() {
		ResponseEntity<ExceptionResponse> response = 
				exception
				.dataIntegratyViolationException(new DataIntegratyViolationException(CPF_ALREADY_REGISTERED_IN_THE_SYSTEM), new Locale(LOCALE));
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(CPF_ALREADY_REGISTERED_IN_THE_SYSTEM, response.getBody().getMessage());
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getBody().getStatus());
		assertNotEquals(LocalDateTime.now(), response.getBody().getDateTime());
	}

}
