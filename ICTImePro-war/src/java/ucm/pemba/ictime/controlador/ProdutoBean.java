/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucm.pemba.ictime.controlador;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ucm.pemba.ictime.entidade.Produto;
import ucm.pemba.ictime.modelo.ProdutoFacade;

/**
 *
 * @author Nelson Norte
 */
@ManagedBean
@SessionScoped
public class ProdutoBean {
    @EJB
    private ProdutoFacade produtoFacade;
    private Produto produto = new Produto();
    
    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String addProduto(){
        this.produtoFacade.create(this.produto);
        this.produto = new Produto();
        return "index";
    }
    
    public void delProduto(Produto p){
        this.produtoFacade.remove(p);
    }
    
    public String editProduto(Produto p){
        this.produto = p;
        return "atualizar";
    }
    
    public String editProduto(){
        this.produtoFacade.edit(this.produto);
        return "atualizar";
    }
    
    public List<Produto> listarProduto(){
        return this.produtoFacade.findAll();
    }
}
