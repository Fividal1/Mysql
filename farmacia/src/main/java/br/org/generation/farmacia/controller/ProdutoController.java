package br.org.generation.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.org.generation.farmacia.model.Produto;
import br.org.generation.farmacia.repository.ProdutoRepository;

			@RestController
			@RequestMapping("/produto") 
			@CrossOrigin(origins = "*", allowedHeaders = "*") 
	        public class ProdutoController {
				
				@Autowired 
				private ProdutoRepository repositoryproduto;
				
				@GetMapping
				public ResponseEntity<List<Produto>> getAll (){
					return ResponseEntity.ok(repositoryproduto.findAll());
				}
				

				@GetMapping("/{id}")
				public ResponseEntity<Produto> getById(@PathVariable long id) {
					return repositoryproduto.findById(id)
						.map(resposta -> ResponseEntity.ok(resposta))
						.orElse(ResponseEntity.notFound().build());
				}
				
				
				@GetMapping("/tipo/{tipo}")
				public ResponseEntity<List<Produto>> getByTipo(@PathVariable String produto){
					return ResponseEntity.ok(repositoryproduto.findAllByProdutoContainingIgnoreCase(produto));
				}

				@PostMapping
				public ResponseEntity<Produto> postProduto (@Valid @RequestBody Produto produto){
					return ResponseEntity.status(HttpStatus.CREATED).body(repositoryproduto.save(produto));
				}
				
				
				@PutMapping
				public ResponseEntity<Produto> putProduto (@Valid @RequestBody Produto produto){
					
					return repositoryproduto.findById(produto.getId())
						.map(resposta -> ResponseEntity.ok().body(repositoryproduto.save(produto)))
						.orElse(ResponseEntity.notFound().build());
				}
				
				@DeleteMapping("/{id}")
				public ResponseEntity<?> deleteProduto(@PathVariable long id) {
					
					return repositoryproduto.findById(id)
							.map(resposta -> {
								repositoryproduto.deleteById(id);
								return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
							})
							.orElse(ResponseEntity.notFound().build());

		}
			}
