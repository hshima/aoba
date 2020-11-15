package br.com.adesc.caucaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adesc.caucaia.model.Produtor;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long>{

}
