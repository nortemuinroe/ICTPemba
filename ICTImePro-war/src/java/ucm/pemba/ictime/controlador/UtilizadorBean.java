/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucm.pemba.ictime.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.ejb.EJB;
import ucm.pemba.ictime.entidade.Utilizador;
import ucm.pemba.ictime.modelo.UtilizadorFacade;
/**
 *
 * @author Nelson Norte
 */
@ManagedBean
@SessionScoped
public class UtilizadorBean {
    @EJB
    private UtilizadorFacade utilizadorFacade;
    private Utilizador utilizador = new Utilizador();

    
    /**
     * Creates a new instance of UtilizadorBean
     */
    public UtilizadorBean() {
    }
    
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    public String addUtilizador(){
        this.utilizadorFacade.create(this.utilizador);
        this.utilizador = new Utilizador();
        return "index";
    }
    
    public void delUtilizador(Utilizador u){
        this.utilizadorFacade.remove(u);
    }
    
    public String editUtilizador(Utilizador u){
        this.utilizador = u;
        return "atualizar";
    }
    
    public String editUtilizador(){
        this.utilizadorFacade.edit(this.utilizador);
        return "atualizar";
    }
    public List<Utilizador> listarUtilizador(){
        return this.utilizadorFacade.findAll();
    }
}
