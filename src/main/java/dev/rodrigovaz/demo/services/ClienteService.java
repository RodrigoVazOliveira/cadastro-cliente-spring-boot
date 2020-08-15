package dev.rodrigovaz.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rodrigovaz.demo.domain.Cliente;
import dev.rodrigovaz.demo.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente insert(Cliente obj) {
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		Cliente obj;
		obj = repo.findById(id).get();		
		
		if (obj != null) {
			repo.delete(obj);
		}
			
	}
	
	public Cliente findByEmail(String email) {
		
		try {
			Cliente obj = repo.findByEmail(email).get();
			return obj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
		
	}
	
	public Cliente update(Cliente update) {
		Cliente obj;
		obj = repo.findById(update.getId()).get();		
		
		System.out.println(obj.getDataDeNascimento());
		
		if (obj != null) {
			obj.setId(update.getId());
			obj.setNomeCompleto(update.getNomeCompleto());
			obj.setEmail(update.getEmail());
			return repo.save(obj);
		}
		return null;
	}
	
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
}
