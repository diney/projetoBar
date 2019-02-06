package com.projeto.bar;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.bar.domain.Categoria;
import com.projeto.bar.domain.Produto;
import com.projeto.bar.repositories.CategoriaRepository;
import com.projeto.bar.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoBarApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Pratos");
		Categoria cat2 = new Categoria(null,"Aperitivos");
		Categoria cat3 = new Categoria(null,"Bebidas");
		Produto  p1 = new Produto(null,"Cerveja", 11.00, cat3);
        Produto  p2 = new Produto();
		Produto  p3 = new Produto();
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); 
		produtoRepository.save(p1);
		
		cat3.getProdutos().addAll(Arrays.asList(p1));
		
		
		
	}

}
