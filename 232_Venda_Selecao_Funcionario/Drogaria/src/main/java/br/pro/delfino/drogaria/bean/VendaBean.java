package br.pro.delfino.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.FuncionarioDAO;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private Funcionario funcionario;
	private Venda venda;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	@PostConstruct
	public void novo(){
		funcionario = new Funcionario();
		funcionario.setPessoa(new Pessoa());
		
		venda = new Venda();
	}

	public void buscarFuncionario() {
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			venda.setFuncionario(funcionarioDAO.buscar(funcionario.getPessoa().getCpf()));
			
			if(venda.getFuncionario() == null){
				Messages.addGlobalError("O funcionário informado não esta cadastrado");
			}
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar um funcionário");
			erro.printStackTrace();
		}
	}
}
