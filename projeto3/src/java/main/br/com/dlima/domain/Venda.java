/**
 * 
 */
package br.com.dlima.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import br.com.dlima.annotation.ColunaTabela;
import br.com.dlima.annotation.Tabela;
import br.com.dlima.annotation.TipoChave;

/**
 * 
 */
@Tabela("TB_VENDA")
public class Venda implements Persistente {
	
	public enum StatusVenda {
		INICIADA, CONCLUIDA, CANCELADA;
		
		public static StatusVenda getByName(String value) {
			for (StatusVenda status : StatusVenda.values()) {
				if (status.name().equals(value)) {
					return status;
				}
			}
			return null;
		}
	}

	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@TipoChave("getCodigo")
	@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
	private String codigo;
	
	@ColunaTabela(dbName = "id_cliente_fk", setJavaName = "setIdClienteFk")
	private Cliente cliente;
	
//	@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
	private Set<ProdutoVenda> produtos;
	
	@ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
	private BigDecimal valorTotal;
	
	@ColunaTabela(dbName = "data_venda", setJavaName = "setDataVenda")
	private Instant dataVenda;
	
	@ColunaTabela(dbName = "status_venda", setJavaName = "setSatatusVenda")
	private StatusVenda statusVenda;
	
	public Venda() {
		produtos = new HashSet<>();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public StatusVenda getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoVenda> op = produtos
				.stream()
				.filter(
						filter -> filter
						.getProduto()
						.getCodigo()
						.equals(produto.getCodigo())
						)
				.findAny();
		if (op.isPresent()) {
			ProdutoVenda pv = op.get();
			pv.adicionar(quantidade);
		} else {
			ProdutoVenda prod = new ProdutoVenda();
			prod.setProduto(produto);
			prod.adicionar(quantidade);
			produtos.add(prod);
		}
		recalcularValorTotalVenda();
	}
	
	private void validarStatus() {
		if (this.statusVenda == StatusVenda.CONCLUIDA) {
			throw new UnsupportedOperationException("Impossivel Alterar venda finalizada!");
		}
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoVenda> op = produtos
				.stream()
				.filter(
						filter -> filter
						.getProduto()
						.getCodigo()
						.equals(produto.getCodigo())
						)
				.findAny();
		if (op.isPresent()) {
			ProdutoVenda pv = op.get();
			if (pv.getQuantidade() > quantidade) {
				pv.remover(quantidade);
				recalcularValorTotalVenda();
			} else {
				produtos.remove(op.get());
				recalcularValorTotalVenda();
			}
		}
	}
	
	public void removerTodosProdutos() {
		validarStatus();
		produtos.clear();
		valorTotal = BigDecimal.ZERO;
	}
	
	public Integer getQuantidadeTotalProdutos() {
		int result = produtos
				.stream()
				.reduce(
						0, 
						(
							partialCountResult, prod) -> partialCountResult + prod.getQuantidade(),
							Integer::sum
						);
		return result;
	}
	
	public Set<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}

	public void recalcularValorTotalVenda() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (ProdutoVenda prod : this.produtos) {
			valorTotal = valorTotal.add(prod.getValorTotal());
		}
		this.valorTotal = valorTotal;
	}

}



































