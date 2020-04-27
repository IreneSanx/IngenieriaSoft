package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class RescueMedicineCategory extends ElementoCadMan {
	private static final String RESCUEMEDPRES_TAGNAME = "rescueMedicinePresentations";
	
	private static final String MEDREF_FIELD_TAGNAME = "medicineRef";
	private static final String ACTINGREF_FIELD_TAGNAME = "activeIngRef";
	private static final String INHREF_FIELD_TAGNAME = "inhalerRef";
	private static final String DOSE_FIELD_TAGNAME = "dose";
	
	private static final String FIELD_SEPARATOR = ";";
	
	public RescueMedicineCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException{
		if(name.equals(RESCUEMEDPRES_TAGNAME)) {
			return super.leerComun(reader, name);
			/*StringBuffer rescueMedicinePresentationData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				rescueMedicinePresentationData.append(readEntry(reader)).append("\n");
				reader.endObject();
			}
			rescueMedicinePresentationData.append("\n");
			reader.endArray();
			return rescueMedicinePresentationData;*/
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
	

	// Parses the contents of a rescue medicine presentation entry
	public String readEntry(JsonReader reader) throws IOException {
		String medRef = null;
		String aiRef = null;
		String inhRef = null;
		String dose = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if (name.equals(MEDREF_FIELD_TAGNAME)) {
				medRef = reader.nextString();
			} else if (name.equals(ACTINGREF_FIELD_TAGNAME)) {
				aiRef = reader.nextString();
			} else if (name.equals(INHREF_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				inhRef = new String(res);
			} else if (name.equals(DOSE_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				dose = new String(res);
			} else {
				reader.skipValue();
			}
		}
		return medRef + FIELD_SEPARATOR + aiRef + FIELD_SEPARATOR +
				inhRef + FIELD_SEPARATOR + dose;
	}
	
}
