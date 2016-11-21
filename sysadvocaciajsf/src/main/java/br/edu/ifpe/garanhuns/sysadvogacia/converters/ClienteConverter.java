package br.edu.ifpe.garanhuns.sysadvogacia.converters;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.ClienteNegocio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * @author Gleydson
 *
 */

@FacesConverter(value = "ClienteConverter", forClass=Cliente.class)
public class ClienteConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object objeto = null;
		if (value != null && !value.equals("")) {
			ClienteNegocio negocio = new ClienteNegocio();
			objeto = negocio.clientePorCodigo(Integer.valueOf(value));
			}
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value){
		String string = "";
		if (value instanceof Cliente) {
			Cliente classe = (Cliente) value;
			string  = String.valueOf(classe.getCodigo());
		}
		return string;
	}
}
