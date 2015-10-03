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
import ucm.pemba.ictime.entidade.Categoria;
import ucm.pemba.ictime.modelo.CategoriaFacade;

/**
 *
 * @author Nelson Norte
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {
    @EJB
    private CategoriaFacade categoriaFacade;
    private Categoria categoria = new Categoria();
    
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String addCategoria(){
        this.categoriaFacade.create(this.categoria);
        this.categoria = new Categoria();
        return "index";
    }
    
    public void delCategoria(Categoria c){
        this.categoriaFacade.remove(c);
    }
    
    public String editCategoria(Categoria c){
        this.categoria = c;
        return "atualizar";
    }
    
    public String editCategoria(){
        this.categoriaFacade.edit(this.categoria);
        return "atualizar";
    }
    
    public List<Categoria> listarCategoria(){
        return this.categoriaFacade.findAll();
    }
    
}
