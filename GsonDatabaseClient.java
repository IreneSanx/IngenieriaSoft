package salud.isa.gsonMedBD;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try{
			PosologiesCategory pc = new PosologiesCategory(null);
			PhysiotherapiesCategory phc = new PhysiotherapiesCategory(pc);
			MedicinePresentationsCategory mpc = new MedicinePresentationsCategory(phc);
			RescueMedicineCategory rmc = new RescueMedicineCategory(mpc);
			ActiveIngredientsCategory aic = new ActiveIngredientsCategory(rmc);
			MedicinesCategory mc = new MedicinesCategory(aic);
			
			DatabaseJSonReader dr = new DatabaseJSonReader(mc);
			//DatabaseJSonReader dbjp = new DatabaseJSonReader();

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
