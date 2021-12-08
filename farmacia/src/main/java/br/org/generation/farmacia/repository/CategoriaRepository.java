package br.org.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import br.org.generation.farmacia.model.Categoria;

@Repository
		public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


			public List findAllByTipoContainingIgnoreCase(String tipo);
			

		}
