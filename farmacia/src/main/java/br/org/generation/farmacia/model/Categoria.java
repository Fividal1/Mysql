package br.org.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

			@Entity
			@Table(name = "tb_categoria") 
			public class Categoria {


			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY) 
			private long id; 

			@NotBlank(message = "O atributo título é Obrigatório e não pode utilizar espaços em branco!") 
			@Size(min = 2, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
			private String categoria;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getCategoria() {
				return categoria;
			}


}
