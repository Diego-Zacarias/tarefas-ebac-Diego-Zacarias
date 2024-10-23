package br.com.dlima.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import br.com.dlima.annotation.TipoChave;
import br.com.dlima.domain.Persistente;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {
	private SingletonMap singletonMap;
	
	public abstract Class<T> getTipoClasse();
	
	public GenericDAO() {
		this.singletonMap = SingletonMap.getInstance();
	}
	
	public abstract void atualizarDados(T entity, T entityCadastrado);
	
	public String getChave(T entity) throws TipoChaveNaoEncontradaException {
		Field[] fields = entity.getClass().getDeclaredFields();
		String returnValue = null;
		for (Field field : fields) {
			if(field.isAnnotationPresent(TipoChave.class)) {
				TipoChave tipoChave = field.getAnnotation(TipoChave.class);
				String nomeMetodo = tipoChave.value();
				try {
					Method method = entity.getClass().getMethod(nomeMetodo);
					returnValue = (String) method.invoke(entity);
					return returnValue;
				} catch (
						NoSuchMethodException | 
						IllegalAccessException | 
						InvocationTargetException e
					) {
					e.printStackTrace();
					throw new TipoChaveNaoEncontradaException(
						"Chave principal do objeto " + 
						entity.getClass() + 
						" não encontrada!"
					);
				}
			}
		}
		if (returnValue == null) {
			String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada!";
			System.out.println("*** ERRO ***\n" + msg);
			throw new TipoChaveNaoEncontradaException(msg);
		}
		return null;
	}
	
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
		String chave = getChave(entity);
		if (mapaInterno.containsKey(chave)) {
			return false;
		}
		
		mapaInterno.put(chave, entity);
		return true;
	}
	
	public void excluir(String chave) {
		Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
		T objetoCadastrado = mapaInterno.get(chave);
		if(objetoCadastrado != null) {
			mapaInterno.remove(chave, objetoCadastrado);
		}
	}
	
	public void alterar(T entity) throws TipoChaveNaoEncontradaException {
		Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
        String chave = getChave(entity);
        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null) {
            this.atualizarDados(entity, objetoCadastrado);
        }
	}
	
	public T consultar(String chave) {
		Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.get(chave);
	}
	
	public Collection<T> buscarTodos() {
		Map<String, T> mapaInterno = (Map<String, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.values();
	}
}
 