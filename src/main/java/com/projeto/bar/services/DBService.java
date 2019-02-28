package com.projeto.bar.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.Categoria;
import com.projeto.bar.domain.ItemPedido;
import com.projeto.bar.domain.Mesa;
import com.projeto.bar.domain.Pedido;
import com.projeto.bar.domain.Produto;
import com.projeto.bar.domain.Usuario;
import com.projeto.bar.enums.EstadoPagamento;
import com.projeto.bar.enums.Perfil;
import com.projeto.bar.repositories.CategoriaRepository;
import com.projeto.bar.repositories.ItemPedidoRepository;
import com.projeto.bar.repositories.MesaRepository;
import com.projeto.bar.repositories.PedidoRepository;
import com.projeto.bar.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	
	
	@Autowired
	private UsuarioService usuarioService;

	public void instantiateTesteDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Categoria cat1 = new Categoria(null, "Pratos");
		Categoria cat2 = new Categoria(null, "Aperitivos");
		Categoria cat3 = new Categoria(null, "Bebidas");
		Usuario user = new  Usuario(null,"test","sssss","Diney");
		Usuario user1 = new  Usuario(null,"Admin","qqqqq","Administrador");
		user1.addPerfil(Perfil.ADMIN);
		usuarioService.insert(user);
		usuarioService.insert(user1);


		Produto p1 = new Produto(null, "Cerveja", 14.00);
		Produto p2 = new Produto(null, "Suco", 10.00);

		Mesa mesa = new Mesa(null, 1, 4,EstadoPagamento.PAGO, sdf.parse("14/02/2019 13:20"),user);
		Mesa mesa1 = new Mesa(null, 2, 2, EstadoPagamento.PAGO,sdf.parse("14/02/2019 13:20"),user1);

		cat3.getProdutos().addAll((Arrays.asList(p1, p2)));
		p1.getCategorias().addAll(Arrays.asList(cat3));
		p2.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2));

		Pedido ped1 = new Pedido(null, sdf.parse("15/02/2019 13:20"), mesa,user);
		Pedido ped2 = new Pedido(null, sdf.parse("15/02/2019 13:20"), mesa1,user);
		mesaRepository.saveAll(Arrays.asList(mesa, mesa1));
		//Pagamento pag = new PagamentoComDinheiro(null, EstadoPagamento.PAGO, mesa1, sdf.parse("15/02/2019 13:20"));

		//mesa1.setPagamento(pag);
		mesa.setUsuario(user);
		mesa.getPedidos().addAll(Arrays.asList(ped1));
		mesa1.getPedidos().addAll(Arrays.asList(ped2));

		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		//pagamentoRepository.save(pag);

		ItemPedido ip1 = new ItemPedido(ped1, p1, 9, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(ped1, p2, 4, p2.getPreco());
		ItemPedido ip3 = new ItemPedido(ped2, p2, 4, p2.getPreco());

		// ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		// ped2.getItens().addAll(Arrays.asList(ip3));
		// p1.getItens().add(ip1);
		// p2.getItens().add(ip2);
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
