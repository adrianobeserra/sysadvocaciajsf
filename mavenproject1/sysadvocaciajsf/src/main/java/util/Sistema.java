/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Gleydson
 */
public class Sistema {
    
    private static String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
        "Julho","Agosto","Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public static String mesPorExtenso(int mes){
        return meses[mes-1];
    }
    
}
