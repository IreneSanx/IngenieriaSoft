package salud.isa.gsonMedBD;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class UserManualPhysioStepsCategory extends ElementoCadMan {

	private static final String USERMANUAL_TAGNAME = "userManualPhysioSteps";
	private static final String STEPTITLE_FIELD_TAGNAME = "stepTitle";
	private static final String STEPIMAGE_FIELD_TAGNAME = "stepImage";
	private static final String STEPTEXT_FIELD_TAGNAME = "stepText";
	private static final String PHYSIOREF_FIELD_TAGNAME = "physioRef";
	
	private static final String FIELD_SEPARATOR = ";";


	public UserManualPhysioStepsCategory(ElementoCadMan sig) {
		super(sig);
	}
	
	public StringBuffer leerCategoria(JsonReader reader, String name) throws IOException {
		if(name.equals(USERMANUAL_TAGNAME)) {
			return super.leerComun(reader, name);
			/*StringBuffer userManualData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				userManualData.append(readUserManualEntry(reader)).append("\n");
				reader.endObject();
			}
			userManualData.append("\n");
			reader.endArray();
			return userManualData;*/
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
		String stepTit = null;
		String stepIm = null;
		String stepTe = null;
		String phyRef = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			if(name.equals(STEPTITLE_FIELD_TAGNAME)) {
				stepTit = reader.nextString();
			}
			else if(name.equals(STEPIMAGE_FIELD_TAGNAME)) {
				stepIm = reader.nextString();
			}
			else if(name.equals(STEPTEXT_FIELD_TAGNAME)) {
				stepTe = reader.nextString();
			}
			else if(name.equals(PHYSIOREF_FIELD_TAGNAME)) {
				phyRef = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}
		return stepTit + FIELD_SEPARATOR + stepIm + FIELD_SEPARATOR + stepTe + FIELD_SEPARATOR + phyRef;
	}

}
