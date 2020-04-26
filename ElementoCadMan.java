package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class ElementoCadMan {
	protected ElementoCadMan siguiente;
	
	public ElementoCadMan(ElementoCadMan sig) {
		siguiente = sig;
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		return siguiente.leerCategoria(reader,name);
	}
	
	public StringBuffer leerComun(JsonReader reader, String name) throws IOException {
		StringBuffer data = new StringBuffer();
		reader.beginArray();
		while (reader.hasNext()) {
			reader.beginObject();
			data.append(readEntry(reader)).append("\n");
			reader.endObject();
		}
		data.append("\n");
		reader.endArray();
		return data;
	}

	public abstract String readEntry(JsonReader reader) throws IOException;

}

