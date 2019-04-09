import java.util.ArrayList;

public class testListClienti {
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		
		al = Connectors.getClienti();
		
		System.out.println("getClienti:");
		for(String e : al){
			System.out.println(e);
		}
		
		System.out.println("getCliente:");
		System.out.println(Connectors.getCliente("GLNDRA93E12A512L"));
		
		//Connectors.updateValutazione(5, "01255448245");
		//System.out.println("updateVenditore: OK!");
		
		//Connectors.updatePunti(60, "GLNDRA93E12A512L");
		//System.out.println("updatePunti: OK!");
		
		System.out.println(Connectors.getPuntiCliente("GLNDRA93E12A512L"));
		System.out.println("getPunti: \nOK!");
		
		//Connectors.deleteCouponScaduti("2015-9-18");
		
		Connectors.recensitoDa(8, "2015-07-17", "2VVWQQCDW79KDOMQ", "BLSLFN91C07A717C", "aiufhaifuahfiaufh");
	}
}
