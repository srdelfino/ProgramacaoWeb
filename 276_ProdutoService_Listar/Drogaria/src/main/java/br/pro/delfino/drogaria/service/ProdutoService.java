package br.pro.delfino.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Produto;

// http://127.0.0.1:8080/Drogaria/rest/produto
@Path("produto")
public class ProdutoService {
	@GET
	public String listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listar("descricao");
		
		Gson gson = new Gson();
		String json = gson.toJson(produtos);
		
		return json;
	}
}
