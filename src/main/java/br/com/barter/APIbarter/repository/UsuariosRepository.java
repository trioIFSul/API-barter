package br.com.barter.APIbarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barter.APIbarter.modelos.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{ 
	

}
