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
import com.projeto.bar.domain.Pagamento;
import com.projeto.bar.domain.Pedido;
import com.projeto.bar.domain.Produto;
import com.projeto.bar.enums.EstadoPagamento;
import com.projeto.bar.repositories.CategoriaRepository;
import com.projeto.bar.repositories.ItemPedidoRepository;
import com.projeto.bar.repositories.MesaRepository;
import com.projeto.bar.repositories.PagamentoRepository;
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
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy HH:MM");
		
		Categoria cat1 = new Categoria(null,"Pratos");
		Categoria cat2 = new Categoria(null,"Aperitivos");		
		Categoria cat3 = new Categoria(null,"Bebidas");
		
		Produto  p1 = new Produto(null,"Cerveja", 11.00);
		
		Mesa mesa = new Mesa(null,1,4);
       
		
		
		cat3.getProdutos().addAll(Arrays.asList(p1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); 
		produtoRepository.save(p1);
		
		Pedido ped1 = new Pedido(null,sdf.parse("08/02/2019 14:39"),mesa);
		
		Pagamento pag = new Pagamento(null, EstadoPagamento.PAGO, ped1);
		
		ped1.setPagamento(pag);
		
		mesa.getPedidos().addAll(Arrays.asList(ped1));
		
		mesaRepository.save(mesa);
		pedidoRepository.save(ped1);
		pagamentoRepository.save(pag);
		
		ItemPedido ip1 = new  ItemPedido(ped1,p1,0.0,1, 2000.00);
		
		
		ped1.getItens().add(ip1);
		p1.getItens().add(ip1);
		itemPedidoRepository.save(ip1);
		
		
	}

}
