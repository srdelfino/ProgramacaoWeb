package br.pro.delfino.drogaria.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

public class Relatorio {
	@Test
	public void gerar() throws JRException {
		SessionFactory factory = HibernateUtil.getFabricaDeSessoes();
		Session session = factory.openSession();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
		
		//JasperFillManager.fillReportToFile("C:/Programação Web com Java/Workspace/Drogaria/src/test/resources/Simple_Blue.jasper", parameters);
		//JasperExportManager.exportReportToPdfFile("C:/Programação Web com Java/Workspace/Drogaria/src/test/resources/Simple_Blue.jrprint");
		
		JasperPrint print = JasperFillManager.fillReport("C:/Programação Web com Java/Workspace/Drogaria/src/test/resources/Simple_Blue.jasper", parameters);
		JasperPrintManager.printReport(print, true);
	}
}
