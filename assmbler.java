//import libraries
import java.util.*;
import java.lang.*;
import java. io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class assmbler{

   //main method
   public static void main(String args[]) throws FileNotFoundException{
   
     //array that stores each line read from file
     ArrayList<String> array = new ArrayList<String>();
    
	 int lineCount = 0;
	 int index = 0;
    
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
      
      //System.out.println(optab.entrySet());
     
     //enumeration for optab keys
     Enumeration en = optab.keys();
     
//     while(en.hasMoreElements()){
     //prints out the optab keys
//     System.out.println(en.nextElement());
//     }
     /*//creatng a set of Strings to hold the keys// Same thing as enumeration
     Set<String> mnemonics = optab.keySet();
     for(String key:mnemonics){
     System.out.println(key);
     } */
     
      
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
            lineCount++;
             
         }
         reader.close();
         
         BufferedWriter bw = null;
         FileWriter fw = null;
         
         //write a new line to the output file
         String newLine = System.getProperty("line.separator");
         
         //attempt at COUNTER
         int counter = 0;
         int value = Integer.parseInt("0", 16);
         
        
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
           
           for(String str : array){

           //write arraylist into a seperate file
            bw.write(LOCCTR + "\t" + "   " + str + newLine);                 
           
          //increment LOCCTR by 3, need to replace with if statement and compare to OBTAB
           value += 3;
           String hexNum = Integer.toHexString(value);
         
           LOCCTR = hexNum.length() < 4 ? ZEROS.substring(hexNum.length()) + hexNum.toUpperCase() : hexNum;
                       
            }
            bw.close();
            
            //System.out.println(".lst file is written.");
     
            for(String str : array){
            String[] parts = str.split(" ");
            
            if (str.startsWith(" ") || str.startsWith("\\s") || str.startsWith("\t")){
            parts[0] = " ";

            }

            System.out.println(parts[0]);

            /*
            if(parts[0].equals(" ")){
            part1 = " ";
            if(parts[1].equals(" ")){
            part2 = " ";
            part3 = " ";
            }
            part2 = parts[1];
            part3 = parts[2];
            }
           // else if(Character.isWhitespace(str.charAt(0))){
            //part1 = " ";
            //}
            else{
            part1 = parts[0];
            part2 = parts[1];
            part3 = parts[2];

            }
            System.out.println(part1 + part2 + part3);
     */
            }

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
