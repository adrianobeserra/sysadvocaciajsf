/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sysadvogacia.excecoes;
import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Lei;

/**
 *
 * @author Gleydson
 */
public class LeiSemProcessosException extends Exception{
    private Lei lei;
    
    public LeiSemProcessosException(Lei lei){
        this.lei = lei;
    }
    
    public String mensagem(){
        return "A lei "+lei.getCodigo()+" não possui processo vinculado.";
    }
    
}
