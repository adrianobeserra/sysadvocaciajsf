/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.garanhuns.sysadvogacia.persistencia.AdvogadoDAO;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class AdvogadoNegocio {

    private final AdvogadoDAO repositorioAdvogados;

    public AdvogadoNegocio() {
        repositorioAdvogados = new AdvogadoDAO();
    }
    
    public Advogado salvar(Advogado advogado){
        return repositorioAdvogados.save(advogado);
    }
    
    public void remover(Advogado advogado){
        repositorioAdvogados.remove(advogado);
    }
    
    public List<Advogado> listarAdvogados(){
        return repositorioAdvogados.getAll();
    }
    
    public Advogado advogadoPorCodigo(int codigoAdvogado){
        return repositorioAdvogados.getById(codigoAdvogado);
    } 

}
