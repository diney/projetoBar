package com.projeto.bar.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.bar.domain.Mesa;
import com.projeto.bar.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>  {
	
	/*@Query("SELECT  i.id  from Pedido obj JOIN obj.itens i  WHERE obj.mesa.id = :id")			
	List<Pedido> pedidosByMesa(@Param("id")Integer id);
	*/
    @Transactional(readOnly =true)
	Page<Pedido>findByMesa(Mesa mesa,Pageable pageRequest);
}
