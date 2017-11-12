//import libraries
import java.util.*;
import java.lang.*;
import java. io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class assmbler2{

   //main method
   public static void main(String args[]) throws FileNotFoundException{
   
     //array that stores each line read from file
     ArrayList<String> array = new ArrayList<String>();

     //OPTAB HashTable - integer value is off
     Hashtable<String, Integer> optab = new Hashtable<String, Integer>();
      //Creates new entries for the elements of the hashTable ie the OPTAB from Appendix
      optab.put("ADD", new Integer (0x18));
      optab.put("ADDF", new Integer(0x58));
      //format2 optab.put("ADDR", new Integer(Token.Value.OP0, 0x90));
      optab.put("AND", new Integer(0x40));
      //format 2 optab.put("CLEAR", new Integer(Token.Value.CLEAR, 0xB4));
      optab.put("COMP", new Integer(0x28));
      optab.put("COMPF", new Integer(0x88));
      //format 2 optab.put("COMPR", new Integer(Token.Value.OP0, 0xA0));
      optab.put("DIV", new Integer(0x24));
      optab.put("DIVF", new Integer(0x64));
      //format 2 optab.put("DIVR", new Integer(Token.Value.OP0, 0x9C)); 
	   optab.put("LDA", new Integer(0x00));
	   optab.put("LDB", new Integer(0x68));
	   optab.put("MUL", new Integer(0x20));
	   optab.put("STA", new Integer(0x0C));
      
     
     //enumeration for optab keys
     //Enumeration en = optab.keys();
     
     //creatng a set of Strings to hold the keys// Same thing as enumeration
     Set<String> mnemonics = optab.keySet();
     ArrayList<String> keysTK = new ArrayList<String>();
     for(String key:mnemonics){
     keysTK.add(new String(key));
     }  
     
      
      if (args.length <= 0){
      
         System.out.println("File not found.");
         return;
      }
      
      try{
      
      
         Scanner reader = new Scanner(new File(args[0]));
         
         //program reads file
         while(reader.hasNextLine()){
         
            //if file has next line then continue to read and store into array
            String line = reader.nextLine();
            
            //add line into arraylist
            array.add(new String(line));
             
         }
         reader.close();
         
         BufferedWriter bw = null;
         FileWriter fw = null;
         
         //write a new line to the output file
         String newLine = System.getProperty("line.separator");
         
         //attempt at COUNTER
         int counter = 0;
         //int value = Integer.parseInt(LOCCTR, 16);
         
        
        //try to write to  output file 
         try{      
   
           //user can change output file name
           fw = new FileWriter("prog2.txt");
           bw = new BufferedWriter(fw);
           
           String LOCCTR = "0000";
           
           //padding zeros
           String ZEROS = "0000";
           
           //write header of file
           bw.write("Location" + "\t"  + "Program" + "\t\t\t " + "Opcode" + newLine);
           bw.write("-------\t   ----------------\t\t--------" + newLine);
           
           //gets LOCCTR from file and stores it 
           for(String str : array){
            if(str.contains("START")){
            String[] p = str.split(" ");
            String strand1 = p[0];
            String strand2 = p[1];
            String strand3 = p[2];
            LOCCTR = p[2].length() < 4 ? ZEROS.substring(p[2].length()) + p[2] : p[2];
            
            }
            int value = Integer.parseInt(LOCCTR, 16);

           //write arraylist into a seperate file
           
             if(str.split(" ").length == 1){
           bw.write("    "+ "\t" + "   " + str + newLine);
           }
           else{
            bw.write(LOCCTR + "\t" + "   " + str + newLine);
               }                      
           
          //increment LOCCTR by 3, need to replace with if statement and compare to OBTAB
            String split1, split2, split3;
            String splitter = str.trim();
            String[] pieces = splitter.split(" ");
            ArrayList<String> splinter = new ArrayList<String>();
                        
 
            if(splitter.split(" ").length == 2){

            split1 = " ";
            split2 = pieces[0];
            split3 = pieces[1];
           
            splinter.add(split2);
          
            }
            else if(str.split(" ").length == 3){
            split1 = pieces[0];
            split2 = pieces[1];
            split3 = pieces[2];
            splinter.add(split2);
            
            }
            else if(str.split(" ").length == 1){
            
            split2 = " ";
            splinter.add(split2);
           
            }
           
           //compare s to arraylist of optab keys 
            for(String s : splinter){
               

               for(int index = 0; index < keysTK.size() - 1; index++){
               if(s.equals(keysTK.get(index))){
               
               value+= 3;

               }

               }
                
String hexNum = Integer.toHexString(value);

LOCCTR = hexNum.length() < 4 ? ZEROS.substring(hexNum.length()) + hexNum.toUpperCase() : hexNum;


            }
                       
            }
            
            bw.close();
            
            //System.out.println(".lst file is written.");
            
            //Attempt to resplit the string again
     
           
            

            }
            catch (IOException e){
               System.out.println("Cannot write file.");
           
            }
                      
      }
      catch(FileNotFoundException error){
         System.out.println("Error. Cannot read file.");
         return;
      }
     
                 
   }
}
