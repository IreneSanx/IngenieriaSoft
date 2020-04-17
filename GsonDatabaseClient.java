package salud.isa.gsonMedBD;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try{
			DatabaseJSonReader dbjp = new DatabaseJSonReader();

			try {
				System.out.println(dbjp.parse("./datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
