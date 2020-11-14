package com.demojanine.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demojanine.model.Pessoa;
import com.demojanine.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Pessoas")
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired(required=true)
	private PessoaService pessoaService;
	
	@GetMapping("listarTodos")
	@ApiOperation(value = "Mostrar lista de pessoas")
	public ResponseEntity<List<Pessoa>> listarTodos() {
		return new ResponseEntity<List<Pessoa>>(pessoaService.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("pesquisar/{pessoaId}")
	@ApiOperation(value = "Pesquisar pessoa por ID")
	public ResponseEntity<Pessoa> pesquisar(@PathVariable("pessoaId") Integer pessoaId){
		Pessoa pessoa = pessoaService.pesquisarId(pessoaId);
		if(pessoa != null) {
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Salvar pessoa")
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.salvar(pessoa), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Atualizar pessoa")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {
		Pessoa oldPessoa = pessoaService.pesquisarId(pessoa.getId());
		if(oldPessoa != null) {
			return new ResponseEntity<Pessoa>(pessoaService.salvar(pessoa), HttpStatus.OK);
		} else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("deletar/{pessoaId}")
	@ApiOperation(value = "Deletar pessoa")
	public ResponseEntity<Optional<Pessoa>> deletar(@PathVariable("pessoaId") Integer pessoaId) {
		try {
			pessoaService.delete(pessoaId);
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
		} catch (NoSuchElementException erro) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}		
	}
	
	//Listar Pessoas por Setor
	@GetMapping("listaPessoasPorSetor/{setorId}")
	@ApiOperation(value = "Listar todas as pessoas por setor")
	public ResponseEntity<List<Pessoa>> listaPessoasPorSetor(@PathVariable("setorId") Integer setorId) {
		return new ResponseEntity<List<Pessoa>>(pessoaService.listaPessoasPorSetor(setorId), HttpStatus.OK);
	}
	
}
