package br.com.dlima.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.dlima.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
	
    public ClienteDAO() {
        super();
        Map<String, Cliente> mapaInterno = 
        		(Map<String, Cliente>) SingletonMap
        		.getInstance()
        		.getMap()
        		.get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
        }
    }

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente cliente, Cliente entityCadastrado) {
		entityCadastrado.setNome(cliente.getNome());
        entityCadastrado.setTel(cliente.getTel());
        entityCadastrado.setNumero(cliente.getNumero());
        entityCadastrado.setEnd(cliente.getEnd());
        entityCadastrado.setCidade(cliente.getCidade());
        entityCadastrado.setEstado(cliente.getEstado());
		
	}

}












