
public class testConnections {
	public static void main(String[] args){
		
		Connectors.addClienti("AAAAAA22A11A145j", "ciccio", "pollo", "ciccio@pollo", "sport");
		
		Connectors.addCoupon("6A1241LK94CPO5Xb", "acqua fredda", 60.58, 25.50, 50, "25981458745");
		
		Connectors.addAzienda("11111111222", "ciaoBrutti", "bruttino", 25, 85185);
		
		Connectors.addPrivato("11111111124", "ciaoBelli", "bellino", 25, 85185);
		
		Connectors.addPremio("11111", "1500");
		
		Connectors.addTelefono("0812584798", "11111111222");
		
		Connectors.addGenere("sportivo", "6A1241LK94CPO5Xb", "palestra");
		
	}
}
