package br.pro.delfino.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.ClienteDAO;
import br.pro.delfino.drogaria.dao.FuncionarioDAO;
import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private Funcionario funcionario;
	private Cliente cliente;
	private Produto produto;

	private Venda venda;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@PostConstruct
	public void novo() {
		funcionario = new Funcionario();
		funcionario.setPessoa(new Pessoa());

		cliente = new Cliente();
		cliente.setPessoa(new Pessoa());

		produto = new Produto();

		venda = new Venda();
	}

	public void buscarFuncionario() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			venda.setFuncionario(funcionarioDAO.buscar(funcionario.getPessoa().getCpf()));

			if (venda.getFuncionario() == null) {
				Messages.addGlobalError("O funcionário informado não esta cadastrado");
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar um funcionário");
			erro.printStackTrace();
		}
	}

	public void buscarCliente() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			venda.setCliente(clienteDAO.buscar(cliente.getPessoa().getCpf()));

			if (venda.getCliente() == null) {
				Messages.addGlobalError("O cliente informado não esta cadastrado");
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar um cliente");
			erro.printStackTrace();
		}
	}

	public void buscarProduto() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produtoRetorno = produtoDAO.buscar(produto.getCodigo());

			if (produtoRetorno == null) {
				produtoRetorno = new Produto();
				produtoRetorno.setCodigo(produto.getCodigo());
				
				Messages.addGlobalError("O produto informado não esta cadastrado");
			} 
			
			produto = produtoRetorno;
			

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar buscar um produto");
			erro.printStackTrace();
		}
	}
}
