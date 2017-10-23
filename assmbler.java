import java.util.*;
import java.lang.*;
import java. io.*;

public class assmbler{

   public static void main(String args[]) throws FileNotFoundException{
   
     // ArrayList<Program> progArray = new ArrayList<Program>();
      
      if (args.length <= 0){
      
         System.out.println("File not found.");
         return;
      }
      
      try{
      
      //need to create a 2D array to store opcode and neumonics
      
         Scanner reader = new Scanner(new File(args[0]));
         
         //program reads file
         while(reader.hasNextLine()){
         
            String line = reader.nextLine();
            System.out.println(line);
            //line.add(reader.nextLine());
            
            /*
            if(line.equals("START")){
            
               String opcode/numonuic = reader.nextLine();
               progArray.add(new Program(opcode))  
            }
            */
         }
         reader.close();
      }
      catch(FileNotFoundException error){
         System.out.println("Error. Cannot read file.");
         return;
      }
      
      //System.out.println(progArray);
      
   }
}

/*Program class
class Program implements Comparable<Program>{

public Program(){
}
}*/

/*public Class WriteFile{

   private String path;
   private boolean append_to_file = false;
   
   public WriteFile(String file_path){
         
      path = file_path;   
   }
   public void writeToFile(String textLine){
   
      FileWriter write = new FileWriter(path, append_to_file);
   }
}*/