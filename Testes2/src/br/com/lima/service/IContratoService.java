package br.com.lima.service;

public interface IContratoService {
    String salvar();

    String buscar(String id);

    String excluir(String id);

    String atualizar(String id);
}
