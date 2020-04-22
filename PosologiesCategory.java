package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class PosologiesCategory extends ElementoCadMan{

	private static final String POSOLOGIES_TAGNAME = "posologies";
	private static final String DESC_FIELD_TAGNAME = "medicineRef";
	
	public PosologiesCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(POSOLOGIES_TAGNAME)) {
			StringBuffer posologiesData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				posologiesData.append(readPosologiesEntry(reader)).append("\n");
				reader.endObject();
			}
			posologiesData.append("\n");
			reader.endArray();
			return posologiesData;
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
	private String readPosologiesEntry(JsonReader reader) throws IOException {
		//	        reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String posName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(DESC_FIELD_TAGNAME)) {
				posName = reader.nextString();
			}
			reader.skipValue();
		}
		return posName;
	}

}
