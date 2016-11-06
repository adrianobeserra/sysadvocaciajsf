package util;

/*
 * @Autor: Gleydson
 */

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



public class MensagemJSF {

    public static void mensagem(FacesMessage.Severity severidadeMensagem, String titulo, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidadeMensagem, titulo, mensagem));

    }

}
