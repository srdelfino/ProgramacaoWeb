package br.pro.delfino.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
		Session sessaoMySQL = HibernateUtil.getFabricaDeSessoesMySQL().openSession();
		sessaoMySQL.close();
		HibernateUtil.getFabricaDeSessoesMySQL().close();
	}
}
