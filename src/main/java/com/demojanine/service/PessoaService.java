package com.demojanine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demojanine.model.Pessoa;
import com.demojanine.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void delete(Integer pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}

	public List<Pessoa> listarTodos() {
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	public List<Pessoa> listaPessoasPorSetor(Integer setorId) {
		return pessoaRepository.findBySetorId(setorId);
	}

	public Pessoa pesquisarId(Integer pessoaId) {
		Optional<Pessoa> resultado = pessoaRepository.findById(pessoaId);
		if(resultado.isPresent()) {
			return resultado.get();
		}
		return null;
	}

}
