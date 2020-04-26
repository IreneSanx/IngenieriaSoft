package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class MedicinesCategory extends ElementoCadMan {

	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";

	public MedicinesCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(MEDICINES_TAGNAME)) {
			return super.leerComun(reader, name);
			/*StringBuffer medicineData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				medicineData.append(readMedicineEntry(reader)).append("\n");
				reader.endObject();
			}
			medicineData.append("\n");
			reader.endArray();
			return medicineData;*/
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
		String medName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				medName = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}
		return medName;
	}
}
