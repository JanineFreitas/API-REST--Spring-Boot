package com.demojanine.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demojanine.model.Setor;
import com.demojanine.repository.SetorRepository;
import com.demojanine.service.SetorService;

public class SetorServiceTest {
	
	@InjectMocks
	private SetorService pessoaService;
	
	@Mock
	private SetorRepository pesssoaRepository;
	
	private Setor setor;
	
	private Setor criarSetor() {
		setor = new Setor(new Integer(1), "Informática");
		return setor;
	}
	
	//@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		criarSetor();
	}
	
	@Test
	public void deveRetornarSetorSalva() {
		
	}

}
