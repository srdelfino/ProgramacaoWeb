package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Caixa;

public class CaixaDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Caixa caixa = new Caixa();
		caixa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse("14/12/2015"));
		caixa.setValorAbertura(new BigDecimal("100.00"));
		
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.salvar(caixa);
	}

	@Test
	@Ignore
	public void buscar() throws ParseException {
		CaixaDAO caixaDAO = new CaixaDAO();
		Caixa caixa = caixaDAO.buscar(new SimpleDateFormat("dd/MM/yyyy").parse("13/12/2015"));
		System.out.println(caixa);
		Assert.assertNull(caixa);
	}
}
