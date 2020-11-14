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

import com.demojanine.model.Setor;
import com.demojanine.service.SetorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/setores")
public class SetorController {
	
	@Autowired
	private SetorService setorService;

	@GetMapping("listarTodos")
	@ApiOperation(value = "Mostrar Lista de setores")
	public ResponseEntity<List<Setor>> listarTodos() {
		return new ResponseEntity<List<Setor>>(setorService.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("pesquisar/{setorId}")
	@ApiOperation(value = "Pesquisar setor por ID")
	public ResponseEntity<Setor> pesquisar(@PathVariable("setorId") Integer setorId){
		Setor setor = setorService.pesquisarId(setorId);
		if(setor != null) {
			return new ResponseEntity<Setor>(setor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Salvar setor")
	public ResponseEntity<Setor> salvar(@RequestBody Setor setor) {
		return new ResponseEntity<Setor>(setorService.salvar(setor), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Atualizar setor")
	public ResponseEntity<Setor> atualizar(@RequestBody Setor setor) {
		Setor oldSetor = setorService.pesquisarId(setor.getId());
		if(oldSetor != null) {
			return new ResponseEntity<Setor>(setorService.salvar(setor), HttpStatus.OK);
		} else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("deletar/{setorId}")
	@ApiOperation(value = "Deletar setor")
	public ResponseEntity<Optional<Setor>> delete(@PathVariable("setorId") Integer setorId) {
		try {
			setorService.delete(setorId);
			return new ResponseEntity<Optional<Setor>>(HttpStatus.OK);
		} catch (NoSuchElementException erro) {
			return new ResponseEntity<Optional<Setor>>(HttpStatus.NOT_FOUND);
		}		
	}
		
}
