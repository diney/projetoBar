package com.projeto.bar;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.bar.domain.Categoria;
import com.projeto.bar.domain.ItemPedido;
import com.projeto.bar.domain.Mesa;
import com.projeto.bar.domain.Pedido;
import com.projeto.bar.domain.Produto;
import com.projeto.bar.repositories.CategoriaRepository;
import com.projeto.bar.repositories.ItemPedidoRepository;
import com.projeto.bar.repositories.MesaRepository;
import com.projeto.bar.repositories.PedidoRepository;
import com.projeto.bar.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoBarApplication implements CommandLineRunner {
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
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria cat1 = new Categoria(null,"Pratos");
		Categoria cat2 = new Categoria(null,"Aperitivos");		
		Categoria cat3 = new Categoria(null,"Bebidas");
		
		Produto  p1 = new Produto(null,"Cerveja", 14.00);
		Produto  p2 = new Produto(null,"Suco", 10.00);
		
		Mesa mesa = new Mesa(null,1,4,sdf.parse("14/02/2019 13:20"));
		Mesa mesa1 = new Mesa(null,2,2,sdf.parse("14/02/2019 13:20"));
       
		
		
		cat3.getProdutos().addAll((Arrays.asList(p1,p2)));
		p1.getCategorias().addAll(Arrays.asList(cat3));
		p2.getCategorias().addAll(Arrays.asList(cat3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); 
		produtoRepository.saveAll(Arrays.asList(p1,p2));
		
		Pedido ped1 = new Pedido(null,sdf.parse("15/02/2019 13:20"),mesa);
		Pedido ped2 = new Pedido(null,sdf.parse("15/02/2019 13:20"),mesa1);
		
		//Pagamento pag = new Pagamento(null, EstadoPagamento.PAGO, ped1);
		
		//ped1.setPagamento(pag);
		
		mesa.getPedidos().addAll(Arrays.asList(ped1));
		mesa1.getPedidos().addAll(Arrays.asList(ped2));
		
		mesaRepository.saveAll(Arrays.asList(mesa,mesa1));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		//pagamentoRepository.save(pag);
		
		ItemPedido ip1 = new  ItemPedido(ped1,p1,9, p1.getPreco());
		ItemPedido ip2 = new  ItemPedido(ped1,p2,4,  p2.getPreco());
		ItemPedido ip3 = new  ItemPedido(ped2,p2,4,  p2.getPreco());
		
		
		
		//ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		//ped2.getItens().addAll(Arrays.asList(ip3));
		//p1.getItens().add(ip1);
		//p2.getItens().add(ip2);
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
	}

}
