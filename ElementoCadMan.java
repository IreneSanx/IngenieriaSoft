package salud.isa.gsonMedBD;

import com.google.gson.stream.JsonReader;

public class ElementoCadMan {
	protected ElementoCadMan siguiente;
	
	public ElementoCadMan(ElementoCadMan sig) {
		siguiente = sig;
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) {
		return siguiente.leerCategoria(reader,name);
	}

}
