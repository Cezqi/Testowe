
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Odkodo{
	public static int iloscKrypto=20;
	public static String znaki ="01100001";
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
		 
		 int [] wynik = null;
		 String[] pomoc;
		 String [][] alternatywy = null;
		 String line=new String();
		 int ilosc;
		 try {
             
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));


           
             while ((line = reader.readLine()) != null) {
                 data += line;
                
             }
             
             tekst=data.split(" ");
             ilosc=tekst.length;
             wynik =new int[ilosc];
             pomoc=new String[ilosc];
            
             alternatywy= new String [ilosc][5];
             
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
             int i=0;
       
            ArrayList<Integer> przypuszczalne = new ArrayList<Integer>();
            ArrayList<Integer> zapas = new ArrayList<Integer>();
      	     i=0;
            for(int x=0; x<tekst.length; x++)  
            {    i=0;
            	while( i<iloscKrypto) {
            		 String a=xor(tekst, kryptogramy[i],x);
            		 //System.out.println( "1  "+a);
            		 int w=Integer.parseInt(a,2);
            		 if( (65<=w  && w<=90) || (97<=w  && w<=121))
            		 przypuszczalne.add(w);
            		// System.out.println("2  " + przypuszczalne.get(i));
            		  i++;
            	 }
            	Object[] st = przypuszczalne.toArray();
            	zapas=przypuszczalne;
            	
            	for (Object s : st) 
            		{
            			if (przypuszczalne.indexOf(s) != przypuszczalne.lastIndexOf(s)) 
            				{
            					przypuszczalne.remove(przypuszczalne.lastIndexOf(s));
            				}
            		}
            	
            	if(przypuszczalne.size()==1) wynik[x]=przypuszczalne.get(0);
            	else
            		{ 
            		  wynik[x]=przypuszczalne.size()*-1;
            		 if(przypuszczalne.size()>5)  wynik[x]=0;
            		 if(przypuszczalne.size()==0)  wynik[x]=-1;
            		 String zapis="";
            		 int f=0;
            		 for(int j=0; j<5;j++)
            			 alternatywy[x][j]="-";
            		 if(przypuszczalne.size()<5 && przypuszczalne.size()>0)
            		 for(int k: przypuszczalne)
              		  {   System.out.println( x+ " fff "+ f + ": " + alfabet(k));
            			alternatywy[x][f]=alfabet(k);
            			f++;
              		  }
            		
            		}
            	    
            	
            	 System.out.println("wynik cz¹stkowy  " +  wynik[x] + " " + alfabet(wynik[x]));
            	przypuszczalne.clear();
            	zapas.clear();
            }
            	

         } catch (FileNotFoundException e) {
             System.out.println("Pliku nie znaleziono" + e);
             System.exit(0);
         }
		 
		 
		 
		 
		 System.out.println(Integer.toBinaryString(Integer.parseInt("101", 2) ^ Integer.parseInt("111", 2)));
		 System.out.println("Wynik:" );
		 for(int x=0; x<wynik.length; x++)  
			 System.out.print(""+  alfabet(wynik[x]));
	 System.out.print("     " );
		 System.out.println("Mo¿liwe wybory dla brakuj¹cych znaków" );
		
		for(int y=0; y<5; y++)
		 { System.out.print( "");
			for(int x=0; x<wynik.length; x++)  
			{
			 if(alfabet(wynik[x]).equals("-"))
				{ 
				
					  if(!alternatywy[x][y].equals("-"))
						  System.out.print( alternatywy[x][y]);
					  else System.out.print( " ");
					
					  System.out.print( "");
				 	
				
				}
			 else  System.out.print( " ");
		     
				
			}
		 System.out.println( "");
		 }
	
	}
	
	public static String alfabet(int i)
	{
		String alf[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		if(65<=i  && i<=90) return alf[i-65];
		else if (97<=i  && i<=121) return alf[i-97];
		else if (i==0) return " ";
		return "-";
	}
	
	
	public static String xor(String[] a, String[] b, int i)
	{ 
			return Integer.toBinaryString(Integer.parseInt(a[i], 2) ^ Integer.parseInt(b[i], 2));
			//System.out.println(wynik[i] + " "  + Integer.parseInt( wynik[i],2));
		
		
		
	}
	
	public static String xorznak(String a, String b )
	{      String wyn=Integer.toBinaryString(Integer.parseInt(a, 2) ^ Integer.parseInt(b, 2));
			int w=Integer.parseInt(wyn,2);
			return wyn;
			//System.out.println(wyn +"    dddd" + w);
			//if( (65<=w  && w<=90) || (97<=w  && w<=121))
	
	     // return wyn;
	   ///  else return "0";
			//System.out.println(wynik[i] + " "  + Integer.parseInt( wynik[i],2));
		
		
		
	}
	
	
}