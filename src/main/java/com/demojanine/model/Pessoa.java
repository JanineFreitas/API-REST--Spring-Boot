package com.demojanine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "SETOR_ID")
    private int setorId;
    
    public Pessoa() {
    	
    }
    
	@JsonCreator
	public Pessoa(@JsonProperty("id")Integer id, @JsonProperty("nome")String nome, @JsonProperty("setorId")Integer setorId) {
		super();
		this.id = id;
		this.nome = nome;
		this.setorId = setorId;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + setorId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (setorId != other.setorId)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSetorId() {
		return setorId;
	}

	public void setSetorId(int setorId) {
		this.setorId = setorId;
	}
}