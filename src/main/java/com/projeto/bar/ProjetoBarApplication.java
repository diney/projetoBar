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
import com.projeto.bar.domain.PagamentoComDinheiro;
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
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}	

}
