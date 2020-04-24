package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class PhysiotherapiesCategory extends ElementoCadMan {

	private static final String PHYSIOTHERAPIES_TAGNAME = "physiotherapies";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";


	public PhysiotherapiesCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(PHYSIOTHERAPIES_TAGNAME)) {
			StringBuffer physiotherapiesData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				physiotherapiesData.append(readPhysiotherapiesEntry(reader)).append("\n");
				reader.endObject();
			}
			physiotherapiesData.append("\n");
			reader.endArray();
			return physiotherapiesData;
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
	private String readPhysiotherapiesEntry(JsonReader reader) throws IOException {
		//	        reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String phyName = null;
		String imName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				phyName = reader.nextString();
			}
			else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				imName = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}
		return phyName + FIELD_SEPARATOR + imName;
	}

}
