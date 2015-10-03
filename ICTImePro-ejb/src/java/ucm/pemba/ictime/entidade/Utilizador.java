/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucm.pemba.ictime.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nelson Norte
 */
@Entity
@Table(name = "utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u"),
    @NamedQuery(name = "Utilizador.findByIdUtilizador", query = "SELECT u FROM Utilizador u WHERE u.idUtilizador = :idUtilizador"),
    @NamedQuery(name = "Utilizador.findByNome", query = "SELECT u FROM Utilizador u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utilizador.findByApelido", query = "SELECT u FROM Utilizador u WHERE u.apelido = :apelido"),
    @NamedQuery(name = "Utilizador.findBySexo", query = "SELECT u FROM Utilizador u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Utilizador.findByNascimento", query = "SELECT u FROM Utilizador u WHERE u.nascimento = :nascimento"),
    @NamedQuery(name = "Utilizador.findByEmail", query = "SELECT u FROM Utilizador u WHERE u.email = :email"),
    @NamedQuery(name = "Utilizador.findByUtilizdor", query = "SELECT u FROM Utilizador u WHERE u.utilizdor = :utilizdor"),
    @NamedQuery(name = "Utilizador.findBySenha", query = "SELECT u FROM Utilizador u WHERE u.senha = :senha"),
    @NamedQuery(name = "Utilizador.findByPapel", query = "SELECT u FROM Utilizador u WHERE u.papel = :papel")})
public class Utilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apelido")
    private String apelido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "utilizdor")
    private String utilizdor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "papel")
    private String papel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilizadoridUtilizador")
    private List<Produto> produtoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilizadoridUtilizador")
    private List<Categoria> categoriaList;

    public Utilizador() {
    }

    public Utilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Utilizador(Integer idUtilizador, String nome, String apelido, String sexo, String utilizdor, String senha, String papel) {
        this.idUtilizador = idUtilizador;
        this.nome = nome;
        this.apelido = apelido;
        this.sexo = sexo;
        this.utilizdor = utilizdor;
        this.senha = senha;
        this.papel = papel;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUtilizdor() {
        return utilizdor;
    }

    public void setUtilizdor(String utilizdor) {
        this.utilizdor = utilizdor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.idUtilizador == null && other.idUtilizador != null) || (this.idUtilizador != null && !this.idUtilizador.equals(other.idUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucm.pemba.ictime.entidade.Utilizador[ idUtilizador=" + idUtilizador + " ]";
    }
    
}
