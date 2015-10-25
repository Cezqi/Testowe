import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Odszyfr{
	public static int iloscKrypto=8;
	
	
	 String data = new String();
	 String[] tekst;
	 String[][] kryptogramy;
	 String[] wynik;
	 String[] pomoc;
	 String line=new String();
	 int ilosc;
	public static void main(String[] args) throws IOException
	{ System.getProperty("user.dir");
		/*
		 * String s1 = "0101";
			String s2 = "1100";
			String xor = Integer.toBinaryString(Integer.parseInt(s1, 2) ^ Integer.parseInt(s2, 2), 2);
			System.out.println(xor);
		 * 
		 */
	    
		 File inputFile = null;
		 File inputFile2= null;
		 inputFile = new File("tekst.txt");
		 String data = new String();
		 String[] tekst;
		 String[][] kryptogramy;
		 String[] wynik = null;
		 String[] pomoc;
		 String line=new String();
		 int ilosc;
		 try {
             
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));


           
             while ((line = reader.readLine()) != null) {
                 data += line;
                
             }
             
             tekst=data.split(" ");
             ilosc=tekst.length;
             pomoc=new String[ilosc];
             System.out.println(data);
             reader.close();
             kryptogramy= new String [iloscKrypto][];
             for(int i=0; i<iloscKrypto; i++)
             		{ data="";
            	 inputFile=new File("krypto"+(i+1 )+".txt");
            	 BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));


                 
                 while ((line = reader2.readLine()) != null) {
                     data += line;
                    
                 }
                
                 kryptogramy[i]=data.split(" ");
                 

                 reader2.close();
            	
             		}
             wynik=xorowanie(tekst, kryptogramy[0], wynik);
        	 System.out.println("tttrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrttttttttttttttttttttJej" );
        	 pomoc=xorowanieZeZnakiem(wynik,"01000011", pomoc);
        	 System.out.println("Jtttttttttttttttttttttttttttej" );
        	 wynik=xorowanie(tekst, kryptogramy[1], wynik);
        	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjJej" );
        	 pomoc=xorowanieZeZnakiem(wynik,"01000011", pomoc);
        	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjJej" );
        	 wynik=xorowanie(tekst, kryptogramy[2], wynik);
        	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjJej" );
        	 pomoc=xorowanieZeZnakiem(wynik,"01000011", pomoc);
        	 System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjJej" );

         } catch (FileNotFoundException e) {
             System.out.println("Pliku nie znaleziono" + e);
             System.exit(0);
         }
		 
		 System.out.println("Koniec" );
		 
	
	}
	
	
	public static String [] xorowanie(String[] a, String[] b, String[] wynik)
	{  wynik =new String [a.length];
		for(int i=0; i<a.length; i++)
		{
			wynik[i]=Integer.toBinaryString(Integer.parseInt(a[i], 2) ^ Integer.parseInt(b[i], 2));
			//System.out.println(wynik[i] + " "  + Integer.parseInt( wynik[i],2));
		}
		
		return wynik;
	}
	
	public static String [] xorowanieZeZnakiem(String[] a, String b, String[] wynik)
	{  wynik =new String [a.length];
		for(int i=0; i<a.length; i++)
		{
			wynik[i]=Integer.toBinaryString(Integer.parseInt(a[i], 2) ^ Integer.parseInt(b, 2));
			System.out.println(wynik[i] + " "  + Integer.parseInt( wynik[i],2));
		}
		
		return wynik;
	}
}
