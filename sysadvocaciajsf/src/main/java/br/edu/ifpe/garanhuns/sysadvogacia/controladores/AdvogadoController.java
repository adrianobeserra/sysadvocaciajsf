/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.sysadvogacia.excecoes.ClienteComProcessosException;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.AdvogadoNegocio;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.ClienteNegocio;
import java.util.List;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import util.MensagemJSF;

/**
 *
 * @author Adriano
 */
@ManagedBean(name = "CadastroAdvogadosController")
@ViewScoped
public class AdvogadoController {

    private Advogado bean;
    private AdvogadoNegocio negocio;
    private final String nomeCadastro;

    public AdvogadoController() {
        nomeCadastro = "Cadastro de Advogados";
        negocio = new AdvogadoNegocio();
        TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }

     public void botaoInserirAction() {
        this.setBean(new Advogado());
        //RequestContext.getCurrentInstance().execute("PF('dialogCadastro').show();");
    }

    public void botaoAlterarAction() {

    }

    public void botaoSalvarAction() {
        negocio = new AdvogadoNegocio();
        try {
            negocio.salvar(getBean());
            RequestContext.getCurrentInstance().execute("PF('dialogCadastro').hide();");
            MensagemJSF.mensagem(FacesMessage.SEVERITY_INFO, getNomeCadastro(),
                    "Cliente Salvo com sucesso.");
        } catch (Exception ex) {
            MensagemJSF.mensagem(FacesMessage.SEVERITY_ERROR, getNomeCadastro(), ex.getMessage());
        }
    }

    public void botaoExcluirAction(ActionEvent actionEvent) {
        negocio.remover(negocio.advogadoPorCodigo(getBean().getCodigo()));
    }

    public List<Advogado> getListaBean() {
        return negocio.listarAdvogados();
    }

    /**
     * @return the bean
     */
    public Advogado getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(Advogado bean) {
        this.bean = bean;
    }

    /**
     * @return the nomeCadastro
     */
    public String getNomeCadastro() {
        return nomeCadastro;
    }
    
}
