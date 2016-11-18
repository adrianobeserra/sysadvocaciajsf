package br.edu.ifpe.garanhuns.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Lei;
import br.edu.ifpe.garanhuns.sysadvogacia.excecoes.LeiComProcessosException;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.LeiNegocio;


import util.MensagemJSF;
import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Gleydson
 *
 */
@ManagedBean(name = "CadastroLeiController")
@ViewScoped
public class LeiController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Lei bean;
    private LeiNegocio negocio;
    private String nomeCadastro;

    public LeiController() {
        nomeCadastro = "Cadastro de Lei";
        negocio = new LeiNegocio();
        TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }

    public void botaoInserirAction() {
        this.setBean(new Lei());
        //RequestContext.getCurrentInstance().execute("PF('dialogCadastro').show();");
    }

    public void botaoAlterarAction() {

    }

    public void botaoSalvarAction() {
        negocio = new LeiNegocio();
        try {
            negocio.salvar(getBean());
            RequestContext.getCurrentInstance().execute("PF('dialogCadastro').hide();");
            MensagemJSF.mensagem(FacesMessage.SEVERITY_INFO, getNomeCadastro(),
                    "Lei Salva com sucesso.");
        } catch (Exception ex) {
            MensagemJSF.mensagem(FacesMessage.SEVERITY_ERROR, getNomeCadastro(), ex.getMessage());
        }
    }

    public void botaoExcluirAction(ActionEvent actionEvent) {
        negocio.remover(negocio.LeiPorCodigo(getBean().getCodigo()));
    }

    public List<Lei> getListaBean() {
        return negocio.listarLeis();
    }

    /**
     * @return the bean
     */
    public Lei getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(Lei bean) {
        this.bean = bean;
    }

    /**
     * @return the nomeCadastro
     */
    public String getNomeCadastro() {
        return nomeCadastro;
    }

}
