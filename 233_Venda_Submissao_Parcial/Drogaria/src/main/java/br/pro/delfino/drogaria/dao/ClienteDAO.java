package br.pro.delfino.drogaria.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.util.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {
	public Cliente buscar(String cpf) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cliente.class);
			consulta.createAlias("pessoa", "p");
			consulta.add(Restrictions.eq("p.cpf", cpf));
			Cliente resultado = (Cliente) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
