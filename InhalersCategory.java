package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class InhalersCategory extends ElementoCadMan {

	private static final String INHALERS_TAGNAME = "inhalers";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";


	public InhalersCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(INHALERS_TAGNAME)) {
			return super.leerComun(reader, name);
			/*StringBuffer inhalersData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				inhalersData.append(readEntry(reader)).append("\n");
				reader.endObject();
			}
			inhalersData.append("\n");
			reader.endArray();
			return inhalersData;*/
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
	prublic String readEntry(JsonReader reader) throws IOException {
		//	        reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String inhName = null;
		String imName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				inhName = reader.nextString();
			}
			else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				imName = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}
		return inhName + FIELD_SEPARATOR + imName;
	}
	

}
