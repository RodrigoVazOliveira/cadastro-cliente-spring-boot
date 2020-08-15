package dev.rodrigovaz.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.rodrigovaz.demo.domain.Cliente;
import dev.rodrigovaz.demo.services.ClienteService;

@RestController(value = "/")
public class ClienteResources {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> save(@RequestBody Cliente obj) {
		
		Cliente responseCliente = service.insert(obj);
		
		return ResponseEntity.status(201).body(responseCliente);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Long id) {
		cliente.setId(id);
		service.update(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByEmail( @RequestParam(value = "email") String email) {
		Cliente cliente = service.findByEmail(email);
		return ResponseEntity.ok().body(cliente);
	}
	
}
 