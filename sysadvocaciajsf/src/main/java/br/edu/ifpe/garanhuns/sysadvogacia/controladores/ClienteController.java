package br.edu.ifpe.garanhuns.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.sysadvogacia.excecoes.ClienteComProcessosException;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.ClienteNegocio;

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
@ManagedBean(name = "CadastroClientesController")
@ViewScoped
public class ClienteController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Cliente bean;
    private ClienteNegocio negocio;
    private String nomeCadastro;

    public ClienteController() {
        nomeCadastro = "Cadastro de Clientes";
        negocio = new ClienteNegocio();
        TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }

    public void botaoInserirAction() {
        this.setBean(new Cliente());
        //RequestContext.getCurrentInstance().execute("PF('dialogCadastro').show();");
    }

    public void botaoAlterarAction() {

    }

    public void botaoSalvarAction() {
        negocio = new ClienteNegocio();
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
        try {
            negocio.remover(negocio.clientePorCodigo(getBean().getCodigo()));
        } catch (ClienteComProcessosException ex) {
            MensagemJSF.mensagem(FacesMessage.SEVERITY_ERROR, getNomeCadastro(), ex.mensagem());
        }
    }

    public List<Cliente> getListaBean() {
        return negocio.listarClientes();
    }

    /**
     * @return the bean
     */
    public Cliente getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(Cliente bean) {
        this.bean = bean;
    }

    /**
     * @return the nomeCadastro
     */
    public String getNomeCadastro() {
        return nomeCadastro;
    }

}
