package com.sales.sales.management.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.sales.management.repository.ClientRepositoryInterface;

import entity.Client;
import exceptions.BusinessRuleException;

@Service
public class ClientService {

	@Autowired
	private ClientRepositoryInterface clientRepositoryInterface;

	public List<Client> listAll() {
		return clientRepositoryInterface.findAll();
	}

	public Optional<Client> searchByCode(Long code) {
		return clientRepositoryInterface.findById(code);
	}

	public Client register(Client client) {
		validateDuplicateCustomer(client);
		return clientRepositoryInterface.save(client);
	}

	public Client update(Long code, Client client) {
		Client clientUpdate = validateIfTheClientExists(code);
		validateDuplicateCustomer(client);
		BeanUtils.copyProperties(client, clientUpdate, "code");
		return clientRepositoryInterface.save(clientUpdate);
	}
	
	public void delete(Long code) {
		Client client = validateIfTheClientExists(code);
		clientRepositoryInterface.deleteById(client.getCode());
	}

	private void validateDuplicateCustomer(Client client) {
		Client existsName = clientRepositoryInterface.findByName(client.getName());
		if (existsName != null && client.getCode() != existsName.getCode()) {
			throw new BusinessRuleException(
					String.format("Cliente [%s] já cadastrado no base de dados.", client.getName().toUpperCase()));
		}
	}

	private Client validateIfTheClientExists(Long code) {
		Optional<Client> client = searchByCode(code);
		if (client.isEmpty()) {
			throw new BusinessRuleException(
					String.format("Codigo do cliente [%s] não cadastrado na base de dados.", code));
		}
		return client.get();
	}

}
