package br.com.lima.service;

import br.com.lima.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        this.contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(String id) {
        this.contratoDao.buscar(id);
        return id;
    }

    @Override
    public String excluir(String id) {
        this.contratoDao.excluir(id);
        return id;
    }

    @Override
    public String atualizar(String id) {
        this.contratoDao.atualizar(id);
        return id;
    }
}
