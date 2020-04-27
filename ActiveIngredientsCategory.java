package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ActiveIngredientsCategory extends ElementoCadMan {

	private static final String ACTIVEINGREDIENTS_TAGNAME = "activeIngredients";
	private static final String NAME_FIELD_TAGNAME = "name";

	public ActiveIngredientsCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(ACTIVEINGREDIENTS_TAGNAME)) {
			return super.leerComun(reader, name);
			/*StringBuffer activeIngredientsData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				activeIngredientsData.append(readEntry(reader)).append("\n");
				reader.endObject();
			}
			activeIngredientsData.append("\n");
			reader.endArray();
			return activeIngredientsData;*/
		}

		else {
			if(siguiente != null) {
				return super.leerCategoria(reader, name);
			}
			else {
				reader.skipValue();
			}
		}
		return null;
	}

	
	// Parses the contents of a medicine. 
	public String readEntry(JsonReader reader) throws IOException {
		//	        reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String acIngName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				acIngName = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}
		return acIngName;
	}

}
