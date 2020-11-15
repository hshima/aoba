package br.com.adesc.caucaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adesc.caucaia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
