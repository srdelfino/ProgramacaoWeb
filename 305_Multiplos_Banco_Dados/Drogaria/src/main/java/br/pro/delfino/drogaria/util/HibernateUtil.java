package br.pro.delfino.drogaria.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes("hibernate.cfg.drogaria.xml");
	private static SessionFactory fabricaDeSessoesMySQL = criarFabricaDeSessoes("hibernate.cfg.mysql.xml");

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	public static SessionFactory getFabricaDeSessoesMySQL() {
		return fabricaDeSessoesMySQL;
	}
	
	public static Connection getConexao(){
		Session sessao = fabricaDeSessoes.openSession();
		
		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});
		
		return conexao;
	}

	private static SessionFactory criarFabricaDeSessoes(String nomeArquivo) {
		try {
			Configuration configuracao = new Configuration().configure(nomeArquivo);
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
