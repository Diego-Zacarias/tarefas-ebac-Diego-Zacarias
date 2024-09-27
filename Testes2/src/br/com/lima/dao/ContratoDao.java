package br.com.lima.dao;

public class ContratoDao implements IContratoDao {
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Erro ao salvar contrato");
    }

    @Override
    public void buscar(String id) {
        throw new UnsupportedOperationException("Erro ao buscar contrato");
    }

    @Override
    public void excluir(String id) {
        throw new UnsupportedOperationException("Erro ao excluir contrato");
    }

    @Override
    public void atualizar(String id) {
        throw new UnsupportedOperationException("Erro ao atualizar contrato");
    }
}
