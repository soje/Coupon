import java.sql.*;
import java.util.ArrayList;

public class Connectors{
	
	//aggiunge un cliente
	public static void addClienti(String codFiscale, String nome, String cognome, String email, String preferenze){	
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO cliente(codiceFiscale, nome, cognome, email, preferenze) VALUES('"
	        		  			+codFiscale+"','"
	        		  			+nome+"','"
	        		  			+cognome+"','"
	        		  			+email+"','"
	        		  			+preferenze+"');"
	        		  			);
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}
	
	//ritorna la lista dei clienti
	public static ArrayList<String> getClienti(){
		ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT *"
	          				  + "FROM cliente;");
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
	}
	
	//ritorna lo specifico cliente mediante il codice fiscale
	public static String getCliente(String codFisc){
        String tmp= null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE codiceFiscale = '"+codFisc+"';");
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return tmp;
	} 
	
	//aggiunge un coupon
	public static void addCoupon(String codice, String descrizione, double prezzoEffettivo, double prezzoScontato, int valorePunti, String pIva){	
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO coupon VALUES('"
	        		  			+codice+"','"
	        		  			+descrizione+"','"
	        		  			+prezzoEffettivo+"','"
	        		  			+prezzoScontato+"','"
	        		  			+valorePunti+"','"
	        		  			+pIva+"');"
	        		  			);
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}
	
	//ritorna la lista dei coupon inseriti
	public static ArrayList<String> getListaCoupon(){
		ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT codice, descrizione, prezzoEffettivo, prezzoScontato, valorePunti, valutazione "
	          								 + "FROM coupon, venditore "
	          								 + "WHERE coupon.pIva = venditore.pIva;"
	          								   );
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + " - " + rs.getString(3) + " € - " + rs.getString(4) + " € - " + rs.getString(5) + " punti - " + rs.getString(6) + " - " + rs.getString(2);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
	}
	
	//ritorna la liista dei coupon inseriti da un singolo venditore
	public static ArrayList<String> getListaCouponVenditore(String pIva){
		ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT codice, descrizione, prezzoEffettivo, PrezzoScontato FROM coupon WHERE pIva= '"+pIva+"';");
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(2);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
	}
	
	//inserisce un'azienda
	public static void addAzienda(String pIva,String nomeAzienda,String via,int numCivico, int cap) {	
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO venditore(pIva, nomeAzienda, via, numeroCivico, cap) VALUES('"
	        		  			 +pIva+"','"
	        		  			 +nomeAzienda+"','"
	        		  			 +via+"','"
	        		  			 +numCivico+"','"
	        		  			 +cap+"');"
	        		  			);
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}

	//aggiunge un privato
	public static void addPrivato(String pIva,String nomePrivato,String via,int numCivico, int cap) {	
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO venditore(pIva, nomePrivato, via, numeroCivico, cap) VALUES('"
	        		  			 +pIva+"','"
	        		  			 +nomePrivato+"','"
	        		  			 +via+"','"
	        		  			 +numCivico+"','"
	        		  			 +cap+"');"
	        		  			);
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}
	
	//ritorna un venditore
	public static String getVenditore(String pIva){
		String tmp= null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * FROM venditore WHERE pIva = '"+pIva+"';");
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6)+ "-" + rs.getString(7);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return tmp;
	}
	
	//aggiunge il genere di un coupon 
	public static void addGenere(String categoria, String codice, String tipo){
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO genere VALUES('"
	        		  			+categoria+"','"
	        		  			+codice+"','"
	        		  			+tipo+"');"

	        		  			 );
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}

	//aggiunge un numero di telefonpo relativo ad un venditore
	public static void addTelefono(String numero, String pIva){
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO telefono VALUES('"+numero+"','"+pIva+"');");

	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
	}

	//aggiunge un premio 
    public static void addPremio(String id, String costoPunti){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO premio VALUES('"
	        		  			 +id+"','"
	        		  			 +costoPunti+"');"
	        		  			 );
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }

    }

    //rappresenta l'acquisto di un coupon da parte di un cliente
    public static void acquistatoDa(String dataAcquisto, String dataScadenza, String codice, String codiceFiscale){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO acquistato_da VALUES('"
	        		  +dataAcquisto+"','"
	        		  +dataScadenza+"','"
	        		  +codice+"','"
	        		  +codiceFiscale+"');");

			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }

    //verifica se un il cliente ha acquistato quel dato coupon 
    public static boolean getAcquistatoDa(String codFisc, String codiceCoup){
    	String tmp= null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * "
	          								 + "FROM acquistato_da "
	          								 + "WHERE codiceFiscale = '"+codFisc+"' AND codice = '"+codiceCoup+"';"
	          								   );
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return (tmp != null);
    }
    
    //raprresenta la valutazione che un cliiente da ad un coupon acquistato
    public static void recensitoDa(int voto, String dataInserimento, String codice, String codFisc, String descrizione){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO recensito_da VALUES('"
	        		  			+ voto+"','"
	        		  			+ dataInserimento+"','"
	        		  			+ codice+"','"
	        		  			+ codFisc+"','"
	        		  			+ descrizione
	        		  			+"');"
	        		  			);

			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }

    //Rappresenta il riscatto di un premio da parte di un cliente
    public static void addRiscatta(String dataRiscatto, String idPremio, String codiceFiscale){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("INSERT INTO riscatta VALUES('"
	        		  			 +dataRiscatto+"','"
	        		  			 +idPremio+"','"
	        		  			 +codiceFiscale+"');"
	        		  			 );
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }
    
    public static int getValorePuntiPremio(String id){
    	int vPunti = 0;
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT costoPunti FROM premio WHERE idPremio= '"+id+"';");
	          while(rs.next()){
	        	  vPunti = rs.getInt(1);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }return vPunti;
    }
    
    //rimozione di un coupon da parte di un venditore
    public static void removeCoupon(String codice, String pIva){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("DELETE FROM coupon"
	          		           + " WHERE pIva='"+pIva+"' AND codice ='"+codice+"';");
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }
 
    //aggiornare il valore dei punti
    public static void updatePunti(int punti, String codFisc){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("UPDATE cliente "
	          		           + "SET punti = '"+punti+"' "
	          				   + "WHERE codiceFiscale = '"+codFisc+"';"
	          				     );
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }
    
    //ritorna i punti di un cliente singolo
    public static int getPuntiCliente(String codFisc){
    	int vPunti = 0;
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT punti FROM cliente WHERE codiceFiscale = '"+codFisc+"';");
	          
	          while(rs.next()){
	        	  vPunti = rs.getInt(1);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }return vPunti;
    }
   
    //aggiornare la valutazione del venditore se è stata fatta una recensione
    public static void updateValutazione(int nVal, String pIva){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("UPDATE venditore "
	          				   + "SET valutazione = '"+nVal+"' "
	          				   + "WHERE pIva = '"+pIva+"';"
	          				     );
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
    }
    
    //elimina i coupon scaduti da acquistatoDa
    public static void deleteCouponScaduti(String data){
    	try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("DELETE FROM acquistato_da WHERE dataScadenza<'"+data+"';");
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }
     }
    
    //calcolo della valutazione del venditore in base alle recensioni dei coupon inseriti dallo stesso
    public static int calcolaMediaValutazioneVenditore(String pIva){
    	 int avg = 0;
    	 try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT AVG(voto) FROM recensito_da, coupon WHERE  recensito_da.codice= coupon.codice AND pIva = '"+pIva+"';");
	          
	          while(rs.next()){
	        	  avg = rs.getInt(1);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }return avg;
    }
     
    //ritorna il numero di volte in cui è stato acquistato un coupon
    public static ArrayList<String> getNumeroCouponVenduti(){
    	ArrayList<String> al = new ArrayList<>();
    	String tmp = null;
   	 try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	         
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT codice, COUNT(codice) as numeroAcquisti FROM acquistato_da GROUP BY codice;");
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + " - " + rs.getString(2);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      }return al;
    }
    
    //ritorna i 3 venditori con la valutazione migliore
    public static ArrayList<String> getTopVenditori(){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * "
	          								 + "FROM venditore "
	          								 + "ORDER BY valutazione DESC "
	          								 + "LIMIT 3;"
	          								   );
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
    }
    
    //ritorna l'elenco dei 10 clienti con punti maggiore
    public static ArrayList<String> getTopClientiPunti(){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * "
	          								 + "FROM cliente "
	          								 + "ORDER BY punti DESC "
	          								 + "LIMIT 10;"
	          								   );
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
    }
    
    //ritorna l'elenco dei 5 clienti che hanno effettuato più recensioni
    public static ArrayList<String> getTopClientiRecensioni(){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT codiceFiscale, COUNT(*) as recensioniEffettuate FROM recensito_da GROUP BY codiceFiscale ORDER BY recensioniEffettuate DESC LIMIT 5;"
	          								   );
	          
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;
    }
    
    //Controlla se un cliente ha acquistato il coupon da recensire
    public static boolean checkRecensioneCliente(String codFisc, String codice){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp = null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT codice FROM acquistato_da WHERE codice='"+codice+"' AND codiceFiscale= '"+codFisc+"';");
	        		  
	          while(rs.next()){
	        	  tmp = rs.getString(1);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return (tmp != null);
    }
    
    //ritorna nome, cognome e punti dei clienti che non hanno acquistato una delle 3 categorie di coupon
    public static ArrayList<String> getCouponNonAcquistatiPerCategoriaDaClienti(String categoria){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT DISTINCT nome, cognome, punti FROM cliente "
	                   						  +"WHERE codiceFiscale NOT IN (SELECT codiceFiscale "
	                   						  + 						   "FROM acquistato_da "
	                   						  +							   "WHERE codice IN (SELECT codice "
	                   						  + 						   "FROM genere "
	                   						  +							   "WHERE categoria = '" + categoria + "'));"
	          								   );
	        		  
	          while(rs.next()){
	        	  tmp = rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;  
	     }
    
    //ritorna la partita iva del venditore tramite il codice del coupon
    public static String getPivaVenditore(String codice){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp=null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT pIva FROM coupon WHERE codice= '"+codice+"';"); 
	        		  
	          while(rs.next()){
	        	  tmp = rs.getString(1);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return tmp;  
    
    }
    
    public static ArrayList<String> getListaPremi(){
    	ArrayList<String> al = new ArrayList<String>();
        String tmp=null;
		try{
	          Class.forName("com.mysql.jdbc.Driver").newInstance();

	          String url = "jdbc:mysql://localhost:3306/coupon";
	          Connection con = DriverManager.getConnection(url,"root","progetto");
	          
	          Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery("SELECT * FROM premio;"); 
	        		  
	          while(rs.next()){
	        	  tmp = rs.getString(1) + " - " + rs.getString(2);
	        	  al.add(tmp);
	          }
	          
			  stmt.close();
			  con.close();
	      }
	      catch(Exception e){
	         System.out.println("Connessione Fallita \n");   
			 System.out.println(e);
	      } return al;  	
    }
    
}