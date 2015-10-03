/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucm.pemba.ictime.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nelson Norte
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByVunitario", query = "SELECT p FROM Produto p WHERE p.vunitario = :vunitario"),
    @NamedQuery(name = "Produto.findByVtotal", query = "SELECT p FROM Produto p WHERE p.vtotal = :vtotal"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByData", query = "SELECT p FROM Produto p WHERE p.data = :data")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "quantidade")
    private String quantidade;
    @Size(max = 45)
    @Column(name = "vunitario")
    private String vunitario;
    @Size(max = 45)
    @Column(name = "vtotal")
    private String vtotal;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "Categoria_idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria categoriaidCategoria;
    @JoinColumn(name = "Utilizador_idUtilizador", referencedColumnName = "idUtilizador")
    @ManyToOne(optional = false)
    private Utilizador utilizadoridUtilizador;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getVunitario() {
        return vunitario;
    }

    public void setVunitario(String vunitario) {
        this.vunitario = vunitario;
    }

    public String getVtotal() {
        return vtotal;
    }

    public void setVtotal(String vtotal) {
        this.vtotal = vtotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Categoria getCategoriaidCategoria() {
        return categoriaidCategoria;
    }

    public void setCategoriaidCategoria(Categoria categoriaidCategoria) {
        this.categoriaidCategoria = categoriaidCategoria;
    }

    public Utilizador getUtilizadoridUtilizador() {
        return utilizadoridUtilizador;
    }

    public void setUtilizadoridUtilizador(Utilizador utilizadoridUtilizador) {
        this.utilizadoridUtilizador = utilizadoridUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucm.pemba.ictime.entidade.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
