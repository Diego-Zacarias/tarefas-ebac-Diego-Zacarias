package br.com.dlima.dao;

import br.com.dlima.domain.Cliente;
import br.com.dlima.exceptions.DAOException;
import br.com.dlima.exceptions.MaisDeUmRegistroException;
import br.com.dlima.exceptions.TableException;
import br.com.dlima.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDAOTest {
    private final IClienteDAO dao;

    private final Random rd;

    public ClienteDAOTest() {
        this.dao = new ClienteDAO();
        this.rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> entities = dao.buscarTodos();
        entities.forEach(entity -> {
            try {
                dao.excluir(entity);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente()
            throws  TipoChaveNaoEncontradaException,
                    DAOException,
                    MaisDeUmRegistroException,
                    TableException
    {
        Cliente entity = this.criarEntity();
        dao.cadastrar(entity);

        Cliente entityConsultado = dao.consultar(entity.getId());
        Assert.assertNotNull(entityConsultado);
    }

    @Test
    public void salvarCliente()
            throws  TipoChaveNaoEncontradaException,
                    MaisDeUmRegistroException,
                    TableException,
                    DAOException
    {
         Cliente entity = criarEntity();
         Cliente retorno = dao.cadastrar(entity);
         Assert.assertNotNull(retorno);

         Cliente entityConsultado = dao.consultar(retorno.getId());
         Assert.assertNotNull(entityConsultado);

         dao.excluir(entity);

         Cliente entityConsultado1 = dao.consultar(retorno.getId());
         Assert.assertNotNull(entityConsultado1);
    }

    @Test
    public void excluirCliente()
            throws  TipoChaveNaoEncontradaException,
                    MaisDeUmRegistroException,
                    TableException,
                    DAOException
    {
        Cliente entity = this.criarEntity();
        Cliente retorno = dao.cadastrar(entity);
        Assert.assertNotNull(retorno);

        Cliente entityConsultado = dao.consultar(entity.getId());
        Assert.assertNotNull(entityConsultado);

        dao.excluir(entity);
        entityConsultado = dao.consultar(entity.getId());
        Assert.assertNull(entityConsultado);
    }

    @Test
    public void alterarCliente()
            throws  TipoChaveNaoEncontradaException,
                    MaisDeUmRegistroException,
                    TableException,
                    DAOException
    {
        Cliente entity = criarEntity();
        Cliente retorno = dao.cadastrar(entity);
        Assert.assertNotNull(retorno);

        Cliente entityConsultado = dao.consultar(entity.getId());
        Assert.assertNotNull(entityConsultado);

        entityConsultado.setNome("Rodrigo Lima");
        dao.alterar(entityConsultado);

        Cliente entityAlterado = dao.consultar(entityConsultado.getId());
        Assert.assertNotNull(entityAlterado);
        Assert.assertEquals("Rodrigo Pires", entityAlterado.getNome());

        dao.excluir(entity);
        entityConsultado = dao.consultar(entityAlterado.getId());
        Assert.assertNull(entityConsultado);
    }

    @Test
    public void buscarTodos()
            throws  TipoChaveNaoEncontradaException,
                    DAOException
    {
        Cliente entity = this.criarEntity();
        Cliente retorno = dao.cadastrar(entity);
        Assert.assertNotNull(retorno);

        Cliente entity1 = this.criarEntity();
        Cliente retorno1 = dao.cadastrar(entity1);
        Assert.assertNotNull(retorno1);

        Collection<Cliente> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        list.forEach(cli -> {
            try {
                dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = dao.buscarTodos();
        assertNotNull(list1);
        assertTrue(list1.isEmpty());
    }

    private Cliente criarEntity() {
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.toString());
        cliente.setNome("Diego");
        cliente.setCidade("Alagoas");
        cliente.setEndereco("Endereco");
        cliente.setEstado("AL");
        cliente.setNumero(10);
        cliente.setTelefone("1199999999");
        return cliente;
    }

}

































