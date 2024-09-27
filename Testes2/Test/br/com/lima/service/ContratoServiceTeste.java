package br.com.lima.service;

import br.com.lima.dao.ContratoDao;
import br.com.lima.dao.IContratoDao;
import br.com.lima.mocks.ContratoDaoMock;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTeste {

    private String idTest = "01";
    private IContratoDao daoMock = new ContratoDaoMock();
    private IContratoDao dao = new ContratoDao();
    private IContratoService serviceMock = new ContratoService(this.daoMock);
    private IContratoService service = new ContratoService(this.dao);

    @Test
    public void salvarTest() {
       String res = this.serviceMock.salvar();
        Assert.assertEquals("Sucesso", res);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDados() {
        String res = this.service.salvar();
        Assert.assertEquals("Sucesso", res);
    }

    @Test
    public void buscarTest() {
        String res = this.serviceMock.buscar(this.idTest);
        Assert.assertEquals(this.idTest, res);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDados() {
        String res = this.service.buscar(this.idTest);
        Assert.assertEquals(this.idTest, res);
    }

    @Test
    public void excluirTest() {
        String res = this.serviceMock.excluir(this.idTest);
        Assert.assertEquals(idTest, res);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDados() {
        String res = this.service.excluir(this.idTest);
        Assert.assertEquals(this.idTest, res);
    }

    @Test
    public void atualizarTest() {
        String res = this.serviceMock.atualizar(this.idTest);
        Assert.assertEquals(this.idTest, res);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDados() {
        String res = this.service.salvar();
        Assert.assertEquals("Sucesso", res);
    }
}
