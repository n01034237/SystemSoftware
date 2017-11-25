//import libraries
import java.util.*;
import java.lang.*;
import java. io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class passTwo{

   //main method
   public static void main(String args[]) throws FileNotFoundException{
        
      //Creates new entries for the elements of the hashTable ie the OPTAB from Appendix
      Hashtable<String, Integer> optab = new Hashtable<String, Integer>();
      optab.put("ADD", new Integer (0x18));
      optab.put("ADDF", new Integer(0x58));
      optab.put("AND", new Integer(0x40));
      optab.put("COMP", new Integer(0x28));
      optab.put("COMPF", new Integer(0x88));
      optab.put("DIV", new Integer(0x24));
      optab.put("DIVF", new Integer(0x64));
      optab.put("J", new Integer(0x3C));
      optab.put("JEQ", new Integer(0x30));
      optab.put("JLT", new Integer(0x38));
      optab.put("JSUB", new Integer(0x48));
	   optab.put("LDA", new Integer(0x00));
      optab.put("LDB", new Integer(0x68));
      optab.put("LDCH", new Integer(0x50));
      optab.put("LDF", new Integer(0x70));
      optab.put("LDL", new Integer(0x08));
      optab.put("LDS", new Integer(0x6C));
      optab.put("LDT", new Integer(0x74));
      optab.put("LDX", new Integer(0x04));
	   optab.put("MUL", new Integer(0x20));
      optab.put("OR", new Integer(0x44));
      optab.put("RD", new Integer(0xD8));
      optab.put("RSUB", new Integer(0x4C));
	   optab.put("STA", new Integer(0x0C));
      optab.put("STB", new Integer(0x78));
      optab.put("STCH", new Integer(0x54));
      optab.put("STF", new Integer(0x80));
      optab.put("STI", new Integer(0xD4));
      optab.put("STL", new Integer(0x14));
      optab.put("STS", new Integer(0x7C));
      optab.put("STSW", new Integer(0xE8));
      optab.put("STT", new Integer(0x84));
      optab.put("STX", new Integer(0x10));
      optab.put("SUB", new Integer(0x1C));
      optab.put("SUBF", new Integer(0x5C));
      optab.put("TD", new Integer(0xE0));
      optab.put("TIX", new Integer(0x2C));
      optab.put("WD", new Integer(0xDC));
      
      Hashtable<String, Integer> optab2 = new Hashtable<String, Integer>();
      optab2.put("ADDR", new Integer(0x90));
      optab2.put("CLEAR", new Integer(0xB4));
      optab2.put("COMPR", new Integer(0xA0));
      optab2.put("DIVR", new Integer(0x9C));
      optab2.put("RMO", new Integer(0xAC));
      optab2.put("SHIFTL", new Integer(0xA4));
      optab2.put("SHIFTER", new Integer(0xA8));
      optab2.put("SUBR", new Integer(0x94));
      optab2.put("TIXR", new Integer(0xB8)); 
      
      ArrayList<String> headerBit = new ArrayList<String>();
      
     //enumeration for optab keys
     Enumeration en = optab.keys();
     while (en.hasMoreElements()) {
      String header = (String) en.nextElement();
      int hexVar = optab.get(header);
      String hexa = Integer.toHexString(hexVar).toUpperCase();
      headerBit.add(new String((header + " : " + hexa)));
    }
      Enumeration eno = optab2.keys();    
      while (eno.hasMoreElements()) {
      String header2 = (String) eno.nextElement();
      int hexVar2 = optab2.get(header2);
      String hexa2 = Integer.toHexString(hexVar2).toUpperCase();
      headerBit.add(new String((header2 + " : " + hexa2)));
    } 


try{

 Hashtable<String, String> symtab = new Hashtable<String, String>();
 ArrayList<String> row = new ArrayList<String>();

 

         Scanner r = new Scanner(new File("output.txt"));
         
         //program reads file
         while(r.hasNextLine()){

           
            //if file has next line then continue to read and store into array
            String string = r.nextLine();
   
            
            //add line into arraylist
            row.add(new String(string));
               
         }
         r.close();
         
         String[] rO = row.toArray(new String[row.size()]);
            
            for(String arrange : row){
            String[] rowPart = arrange.split("\\s");
            String part1,part2, part3, part4;
            
            if(arrange.trim().split("\\s").length == 4){
            part1 = rowPart[0];
            part2 = rowPart[1];
            part3 = rowPart[2];
            part4 = rowPart[3];
            
            ArrayList<String> divide = new ArrayList<String>();
            if(!(part2.isEmpty()))
            {
               symtab.put(new String(part2), new String(part1));
            }

            
            
            //System.out.println(part3 + " " + part4);
            
           /* if(part2.equals(" ")){
            
            System.out.println(part1 + " " + part3);
      
            
            }
            else{
            System.out.println(part1 + " " + part2);
            }*/
            
          /*  if(part2.equals(" ")){
            part2 = "null";
            System.out.println(part2);
            }
            else{
            System.out.println(part2);
            }*/

         }

       }
         System.out.println("LOCCTR" + " \t\t" + "Program" + "\t\t\t" + "Opcode");
         System.out.println();
         for(int g = 2; g < row.size(); g++){


         System.out.println(rO[g]);
         }

         

      }
      catch(FileNotFoundException er){
         System.out.println("Error. Cannot read file.");
         return;
      }
     
                 
   }
}
