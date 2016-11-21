package br.edu.ifpe.garanhuns.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Processo;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.AdvogadoNegocio;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.ClienteNegocio;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.ProcessoNegocio;

import util.MensagemJSF;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "CadastroProcessosController")
@ViewScoped
public class ProcessoController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Processo bean;
    private ProcessoNegocio negocio;
    private String nomeCadastro;
    private Cliente cliente;
    private Advogado advogado;

    public ProcessoController() {
        nomeCadastro = "Cadastro de Processos";
        negocio = new ProcessoNegocio();
        TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }

    public void botaoInserirAction() {
        this.setBean(new Processo());
        getBean().setClienteList(new ArrayList<Cliente>());
        getBean().setAdvogadoList(new ArrayList<Advogado>());
        //RequestContext.getCurrentInstance().execute("PF('dialogCadastro').show();");
    }

    public void botaoAlterarAction() {

    }

    public void botaoAdicionarClienteProcesso(){
        getBean().getClienteList().add(getCliente());
    }
    
    
    public void botaoAdicionarAdvodagoProcesso(){
        getBean().getAdvogadoList().add(getAdvogado());
    }
    
    public List<Cliente> listarClientes(){
        ClienteNegocio clientes = new ClienteNegocio();
        return clientes.listarClientes();
    }
    
    public List<Advogado> listarAdvogados(){
        AdvogadoNegocio advogados = new AdvogadoNegocio();
        return advogados.listarAdvogados();
    }
    
    public void botaoSalvarAction() {

        try {
            negocio.salvar(getBean());
            RequestContext.getCurrentInstance().execute("PF('dialogCadastro').hide();");
            MensagemJSF.mensagem(FacesMessage.SEVERITY_INFO, getNomeCadastro(),
                    "Processo Salvo com sucesso.");
        } catch (Exception ex) {
            MensagemJSF.mensagem(FacesMessage.SEVERITY_ERROR, getNomeCadastro(), ex.getMessage());
        }
    }

    public void botaoExcluirAction(ActionEvent actionEvent) {
        try {
            negocio.remover(negocio.processoPorCodigo(getBean().getCodigo()));
        } catch (Exception ex) {
            MensagemJSF.mensagem(FacesMessage.SEVERITY_ERROR, getNomeCadastro(), ex.getMessage());
        }
    }

    public List<Processo> getListaBean() {
        return negocio.listarProcessos();
    }

    /**
     * @return the bean
     */
    public Processo getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(Processo bean) {
        this.bean = bean;
    }

    /**
     * @return the nomeCadastro
     */
    public String getNomeCadastro() {
        return nomeCadastro;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the advogado
     */
    public Advogado getAdvogado() {
        return advogado;
    }

    /**
     * @param advogado the advogado to set
     */
    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

}
