package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.HistoricoDAO;
import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Historico;
import br.pro.delfino.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	private Produto produto;
	private Boolean exibePainelDados;
	
	private Historico historico;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}

	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}
	
	public Historico getHistorico() {
		return historico;
	}
	
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	@PostConstruct
	public void novo() {
		historico = new Historico();
		produto = new Produto();
		exibePainelDados = false;
	}

	public void buscar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto resultado = produtoDAO.buscar(produto.getCodigo());

			if (resultado == null) {
				exibePainelDados = false;
				Messages.addGlobalWarn("Não existe produto cadastrado para o código informado");
			} else {
				exibePainelDados = true;
				produto = resultado;
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar o produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			historico.setHorario(new Date());
			historico.setProduto(produto);
			
			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicoDAO.salvar(historico);
			
			Messages.addGlobalInfo("Histórico salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o histórico");
			erro.printStackTrace();
		}
	}
}
