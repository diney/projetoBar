package com.projeto.bar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto.bar.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>  {
	
	@Query("SELECT obj from Pedido obj  JOIN obj.mesa mesa WHERE mesa.id = :id")			
	List<Pedido> pedidosByMesa(@Param("id")Integer id);

}
