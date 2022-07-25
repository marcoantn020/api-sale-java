package com.sales.sales.management.controller.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sales.sales.management.service.client.ClientService;

import dto.clientDTO.ClientRequestDTO;
import dto.clientDTO.ClientResponseDTO;
import entity.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@ApiOperation(value = "listar", nickname = "ListAllClient")
	@GetMapping
	public List<ClientResponseDTO> listAll() {
		return clientService.listAll().stream().map(client -> ClientResponseDTO.convertToClientDTO(client))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "buscar por codigo", nickname = "searchByCodeClient")
	@GetMapping("/{code}")
	public ResponseEntity<ClientResponseDTO> searchByCode(@PathVariable Long code) {
		Optional<Client> client = clientService.searchByCode(code);
		return client.isPresent() ? ResponseEntity.ok(ClientResponseDTO.convertToClientDTO(client.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "registrar", nickname = "registerClient")
	@PostMapping
	public ResponseEntity<ClientResponseDTO> register(@Valid @RequestBody ClientRequestDTO clientDto) {
		Client registerClient = clientService.register(clientDto.covertToClientEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(ClientResponseDTO.convertToClientDTO(registerClient));
	}

	@ApiOperation(value = "atualizar", nickname = "updateClient")
	@PutMapping("/{code}")
	public ResponseEntity<ClientResponseDTO> update(@PathVariable Long code,
			@Valid @RequestBody ClientRequestDTO clientDto) {
		Client clientUpdate = clientService.update(code, clientDto.covertToClientEntity(code));
		return ResponseEntity.ok(ClientResponseDTO.convertToClientDTO(clientUpdate));
	}
	
	@ApiOperation(value = "deletar", nickname = "deleteClietn")
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long code) {
		clientService.delete(code);
	}
}







