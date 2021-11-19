package br.com.barter.APIbarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barter.APIbarter.modelos.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

}
