/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.persistencia;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;



/**
 *
 * @author Gleydson
 */
public class ClienteDAO extends DAOImpl<Cliente, Integer> {

    public ClienteDAO() {
        super(Cliente.class);
    }

}
