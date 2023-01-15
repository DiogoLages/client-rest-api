package br.com.diogolages.client.rest.api.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ClientTest {

	@Test
	void testClient() {
		Client client = new Client(1L, "Diogo Lages", "049.187.886-96", "Avenida Brasil", "diogolages@gmail.com");
		assertEquals("Diogo Lages", client.getName());
		assertTrue(client.toString().contains("Client("));
	}

}
