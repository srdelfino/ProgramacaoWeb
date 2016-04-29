package br.pro.delfino.drogaria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class CaixaBean {
	private ScheduleModel caixas;
	
	public ScheduleModel getCaixas() {
		return caixas;
	}
	
	public void setCaixas(ScheduleModel caixas) {
		this.caixas = caixas;
	}
	
	@PostConstruct
	public void listar(){
		caixas = new DefaultScheduleModel();
	}
}
