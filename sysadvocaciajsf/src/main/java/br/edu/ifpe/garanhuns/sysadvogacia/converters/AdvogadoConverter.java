package br.edu.ifpe.garanhuns.sysadvogacia.converters;

import br.edu.ifpe.garanhuns.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.garanhuns.sysadvogacia.negocio.AdvogadoNegocio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * @author Gleydson
 *
 */

@FacesConverter(value = "AdvogadoConverter", forClass=Advogado.class)
public class AdvogadoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object objeto = null;
		if (value != null && !value.equals("")) {
			AdvogadoNegocio negocio = new AdvogadoNegocio();
			objeto = negocio.advogadoPorCodigo(Integer.valueOf(value));
			}
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value){
		String string = "";
		if (value instanceof Advogado) {
			Advogado classe = (Advogado) value;
			string  = String.valueOf(classe.getCodigo());
		}
		return string;
	}
}
