package com.projeto.bar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.bar.domain.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>  {

}
