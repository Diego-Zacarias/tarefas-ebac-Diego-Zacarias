/**
 * 
 */
package br.com.dlima.service;

import java.util.List;

import br.com.dlima.domain.Produto;
import br.com.dlima.services.generic.IGenericService;

/**
 * @author diego.lima
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
