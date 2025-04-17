/**
 * 
 */
package br.com.dlima.service;

import java.util.List;

import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.services.generic.IGenericService;

/**
 * @author diego.lima
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}