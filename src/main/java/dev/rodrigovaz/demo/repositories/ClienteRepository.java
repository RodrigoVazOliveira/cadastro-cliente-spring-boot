package dev.rodrigovaz.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.rodrigovaz.demo.domain.Cliente;

@Repository
@Transactional(readOnly = true)
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	List<Cliente> findAll();
	Optional<Cliente> findByEmail(String email);
	
}
