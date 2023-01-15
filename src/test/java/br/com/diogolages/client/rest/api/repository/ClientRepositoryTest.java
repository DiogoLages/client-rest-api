package br.com.diogolages.client.rest.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.diogolages.client.rest.api.entity.Client;

class ClientRepositoryTest {

	private static final String NAME = "Diogo Lages";
	private static final String CPF = "049.187.886-96";
	private static final String ADDRESS = "Avenida Brasil";
	private static final String EMAIL = "diogolages@gmail.com";
	
	@Mock
	private ClientRepository repository;
	private Optional<Client> optionalClient;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startClient();
		
	}

	private void startClient() {
		optionalClient = Optional.of(new Client(1L, NAME, CPF, ADDRESS, EMAIL));
	}

	@Test
	void whenFindByCpfReturnThenReturnSuccess() {
		when(repository.findByCpf(anyString())).thenReturn(optionalClient);
		Optional<Client> response = repository.findByCpf(CPF);
		assertNotNull(response);
		assertEquals(CPF, response.get().getCpf());
	}

}
