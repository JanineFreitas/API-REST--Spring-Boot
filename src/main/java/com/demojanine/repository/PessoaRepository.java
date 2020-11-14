package com.demojanine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demojanine.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

	List<Pessoa> findBySetorId(Integer setorId);

}
