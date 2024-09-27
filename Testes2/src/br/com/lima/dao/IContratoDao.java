package br.com.lima.dao;

// Fazer métodos de buscar, excluir e atualizar;

public interface IContratoDao {
    void salvar();

    void buscar(String id);

    void excluir(String id);

    void atualizar(String id);

}
