/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.persistencia;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Advogado;



/**
 *
 * @author Gleydson
 */
public class AdvogadoDAO extends DAOImpl<Advogado, Integer> {

    public AdvogadoDAO() {
        super(Advogado.class);
    }

}
