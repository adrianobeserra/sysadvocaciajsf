/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.excecoes;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;

/**
 *
 * @author Gleydson
 */
public class ClienteComProcessosException extends Exception{
    private Cliente cliente;
    
    public ClienteComProcessosException(Cliente cliente){
        this.cliente = cliente;
    }
    
    public String mensagem(){
        return "O cliente "+cliente.getNome()+" possui "+cliente.getProcessoList().size()+" processos e não pode ser removido.";
    }
    
}
