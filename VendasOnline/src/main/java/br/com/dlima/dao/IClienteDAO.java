/**
 * 
 */
package br.com.dlima.dao;

import java.util.List;

import br.com.dlima.dao.generic.IGenericDAO;
import br.com.dlima.domain.Cliente;

/**
 * @author diego.lima
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}