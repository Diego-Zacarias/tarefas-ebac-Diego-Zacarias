/**
 * 
 */
package br.com.dlima.dao;

import java.util.List;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Produto;

/**
 * @author diego.lima
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}