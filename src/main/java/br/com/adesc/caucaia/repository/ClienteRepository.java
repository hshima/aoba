package br.com.adesc.caucaia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adesc.caucaia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByNomeContaining(String nome);

}
