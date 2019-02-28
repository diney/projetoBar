package com.projeto.bar.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.ItemPedido;
import com.projeto.bar.domain.Pedido;
import com.projeto.bar.repositories.ItemPedidoRepository;
import com.projeto.bar.repositories.PedidoRepository;
import com.projeto.bar.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private MesaService mesaService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setMesa(mesaService.find(obj.getMesa().getId()));
		obj = repo.save(obj);
		for (ItemPedido ip : obj.getItens()) {			
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());

		return obj;
	}
	
	//public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		/*UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}*/
		//PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//Pedido prdido =  repo.find();
		//return repo.findByMesa(mesa, pageRequest);
	//}
	
	
	
	
	
	
	

}
