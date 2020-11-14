package com.demojanine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demojanine.model.Setor;
import com.demojanine.repository.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;

	public Setor salvar(Setor setor) {
		return setorRepository.save(setor);	
	}

	public void delete(Integer setorId) {
		setorRepository.deleteById(setorId);
	}

	public List<Setor> listarTodos() {
		return (List<Setor>) setorRepository.findAll();
	}

	public Setor pesquisarId(Integer setorId) {
		Optional<Setor> resultado = setorRepository.findById(setorId);
		if(resultado.isPresent()) {
			return resultado.get();
		}
		return null;
	}

}
