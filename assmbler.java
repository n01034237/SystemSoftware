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
      
      //need to create a 2D array to store opcode and neumonics
      
         Scanner reader = new Scanner(new File(args[0]));
         
         //program reads file
         while(reader.hasNextLine()){
         
            //if file has next line then continue to read and store into array
            String line = reader.nextLine();
         
            array.add(new String(line));
             
         }
         reader.close();
         
         BufferedWriter bw = null;
         FileWriter fw = null;
         //write a new line to the output file
         String newLine = System.getProperty("line.separator");
        
        //try to write to  output file 
         try{      
   
           //user can change output file name
           fw = new FileWriter("prog1testing.txt");
           bw = new BufferedWriter(fw);
           
           //compare string to lines of string stored in the ArrayList array
           for(String str : array){
          
          //writes contents of array into output file 
           bw.write(str + newLine);
           
            
            }
            bw.close();
        
         
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
