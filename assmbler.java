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
      
      if (args.length <= 0){
      
         System.out.println("File not found.");
         return;
      }
      
      try{
      
      //need to create a 2D array to store opcode and neumonics?
      
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
           bw.write("Location" + "     "  + "Program" + "                  " + "Opcode" + newLine);
           bw.write("-------     --------------            --------" + newLine);
           
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
