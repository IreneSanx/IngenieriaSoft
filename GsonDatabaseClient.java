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
			InhalersCategory ic = new InhalersCategory(aic);
			UserManualPhysioStepsCategory umpsc = new UserManualPhysioStepsCategory(ic);
			UserManualStepsCategory umsc = new UserManualStepsCategory(umpsc);
			MedicinesCategory mc = new MedicinesCategory(umsc);
			
			DatabaseJSonReader dr = new DatabaseJSonReader(mc);
			//DatabaseJSonReader dbjp = new DatabaseJSonReader();

			try {
				System.out.println(dr.parse("./datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
