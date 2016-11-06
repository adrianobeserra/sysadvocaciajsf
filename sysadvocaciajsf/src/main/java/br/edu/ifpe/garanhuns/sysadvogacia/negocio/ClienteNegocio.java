/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.sysadvogacia.excecoes.ClienteComProcessosException;
import br.edu.ifpe.garanhuns.sysadvogacia.persistencia.ClienteDAO;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class ClienteNegocio {

    private final ClienteDAO repositorioClientes;

    public ClienteNegocio() {
        repositorioClientes = new ClienteDAO();
    }
    
    public Cliente salvar(Cliente cliente){
        return repositorioClientes.save(cliente);
    }
    
    public void remover (Cliente cliente) throws ClienteComProcessosException{
        if(cliente.getProcessoList().size()>0){
            throw new ClienteComProcessosException(cliente);
        }
        repositorioClientes.remove(cliente);
    }
    
    public List<Cliente> listarClientes(){
        return repositorioClientes.getAll();
    }
    
    public Cliente clientePorCodigo(int codigoCliente){
        return repositorioClientes.getById(codigoCliente);
    } 

}
