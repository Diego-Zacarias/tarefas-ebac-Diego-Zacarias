package br.com.diego;

import br.com.diego.dao.ClienteMapDAO;
import br.com.diego.dao.IClienteDAO;

import javax.swing.*;

/**
 * @author diego
 */
public class App {
  private static IClienteDAO iClienteDAO;

  public static void main(String[] args) {
    iClienteDAO = new ClienteMapDAO();

    String opcao = JOptionPane.showInputDialog(
            null,
            "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração e 5 para sair",
            "Cadastro",
            JOptionPane.INFORMATION_MESSAGE
    );
  }
}
