package br.com.diogolages.client.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
	
	private Long id;
	private String name;
	private String cpf;
	private String address;
	private String email;

}
