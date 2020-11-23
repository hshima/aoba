package br.com.adesc.caucaia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adesc.caucaia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Optional<List<Produto>> findByNomeContaining(String nome);

	List<Produto> findByDeletedNot(boolean b);

}
