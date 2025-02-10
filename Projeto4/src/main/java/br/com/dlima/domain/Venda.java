package br.com.dlima.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "sq_venda", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk",
            foreignKey = @ForeignKey(name = "fk_venda_cliente"),
            referencedColumnName = "id", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private Set<ProdutoQuantidade> produtoQuantidadeSet;
    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;
    @Column(name = "DATA_VENDA", nullable = false)
    private Instant dataVenda;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA", nullable = false)
    private StatusVenda statusVenda;

    public Venda() {
        produtoQuantidadeSet = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<ProdutoQuantidade> getProdutoQuantidadeSet() {
        return produtoQuantidadeSet;
    }

    public void setProdutoQuantidadeSet(Set<ProdutoQuantidade> produtoQuantidadeSet) {
        this.produtoQuantidadeSet = produtoQuantidadeSet;
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

    private void validarStatus() {
        if (this.statusVenda == StatusVenda.CONCLUIDA) {
            throw new UnsupportedOperationException("Impossível alterar venda finalizada");
        }
    }

    public void adicionarProdutoQuantidade(Produto produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidade> opq = this.produtoQuantidadeSet
                .stream()
                .filter(filter ->
                        filter.getProduto()
                                .getCodigo()
                                .equals(produto.getCodigo())).findAny();
        if (opq.isPresent()) {
            ProdutoQuantidade produtoQuantidade = opq.get();
            produtoQuantidade.adicionar(quantidade);
        } else {
            ProdutoQuantidade pq = new ProdutoQuantidade();
            pq.setVenda(this);
            pq.setProduto(produto);
            pq.adicionar(quantidade);
            this.produtoQuantidadeSet.add(pq);
        }
        recalcularValorTotalVenda();
    }

    public void removerProduto(Produto produto, Integer quantidade) {
        this.validarStatus();
        Optional<ProdutoQuantidade> opq = produtoQuantidadeSet
                .stream()
                .filter(filter ->
                        filter.getProduto()
                                .getCodigo()
                                .equals(produto.getCodigo())).findAny();
        if (opq.isPresent()) {
            ProdutoQuantidade pq = opq.get();
            if (pq.getQuantidade() > quantidade) {
                pq.remover(quantidade);
            } else {
                this.produtoQuantidadeSet.remove(opq.get());
            }
            this.recalcularValorTotalVenda();
        }
    }

    public void removerTodosProdutos() {
        validarStatus();
        this.produtoQuantidadeSet.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        Integer result;
        return result = produtoQuantidadeSet
                .stream()
                .reduce(0,
                        (partialCountResult, prod) ->
                                partialCountResult + prod.getQuantidade(), Integer::sum
                );
    }

    private void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidade pq : this.produtoQuantidadeSet) {
            valorTotal = valorTotal.add(pq.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }

    public enum StatusVenda {
        INICIADA, CONCLUIDA, CANCELADA;

        public static StatusVenda getByName(String value) {
            for (StatusVenda statusVenda : StatusVenda.values()) {
                if (statusVenda.name().equals(value)) {
                    return statusVenda;
                }
            }
            return null;
        }
    }
}






























