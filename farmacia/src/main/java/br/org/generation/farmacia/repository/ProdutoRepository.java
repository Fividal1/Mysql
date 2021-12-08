package br.org.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.Produto;
import java.util.List;

			@Repository
			public interface ProdutoRepository extends JpaRepository<Produto, Long>{

			public List<Produto> findAllByProdutoContainingIgnoreCase(String produto);
			}
