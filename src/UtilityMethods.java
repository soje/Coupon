import java.util.Calendar;
import java.util.GregorianCalendar;

public class UtilityMethods {

	public static boolean checkPiva(String pIva){
		return (Connectors.getVenditore(pIva)!=null);		
	}
	
	public static boolean checkCodFisc(String codFisc){
		return (Connectors.getCliente(codFisc) != null);
	}
	
	public static int CalcolaValorePunti(double prezzo){ 
		if(prezzo>500.00 && prezzo<1000.00){
			return 2500;
		}else if(prezzo>250.00 && prezzo<499.99){
			return 1500;
		}else if(prezzo>100.00 && prezzo<249.99){
			return 600;
		}else if(prezzo>75.00 && prezzo<99.99){
			return 400;
		}else if(prezzo>50.00 && prezzo<74.99){
			return 300;
		}else if(prezzo>25.00 && prezzo<49.99){
			return 200;
		}else if(prezzo>10.00 && prezzo<24.99){
			return 100;
		}else{
			return 50;
		}
	}
	
	public static boolean checkPrezzoValido(Double preEff, Double preSco){
		if(preEff <= 0 || preSco <= 0)
			return false;
		if(preEff>preSco)
			return true;
		else 
			return false;
	}
	
	public static String ritornaDataCorrente(){
		GregorianCalendar calendar = new GregorianCalendar();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH)+1;
		int year = calendar.get(Calendar.YEAR);
		
		String tmp = year + "-" + month + "-" + day;
		
		return tmp;
	}
	
	public static String ritornaDataScadenza(){
		GregorianCalendar calendar = new GregorianCalendar();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.MONTH, +7);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		
		String tmp = year + "-" + month + "-" + day;
		
		return tmp;
	}

}
