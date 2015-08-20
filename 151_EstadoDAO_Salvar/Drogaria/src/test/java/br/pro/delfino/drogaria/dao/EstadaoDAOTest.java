package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadaoDAOTest {
	@Test
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
}
