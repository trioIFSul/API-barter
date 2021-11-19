package br.com.barter.APIbarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barter.APIbarter.modelos.Categorias;


public interface CategoriasRepository extends JpaRepository<Categorias, Long>{ 

}
