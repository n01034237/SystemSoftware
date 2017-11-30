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
   
   ArrayList<String> locationArray = new ArrayList<String>();
   ArrayList<String> locOperand = new ArrayList<String>();
   
   ArrayList<String> nixbpe  = new ArrayList<String>();
     
      //Creates new entries for the elements of the hashTable ie the OPTAB from Appendix
      Hashtable<String, Integer> optabb = new Hashtable<String, Integer>();
      optabb.put("ADD", new Integer (0x18));
      optabb.put("ADDF", new Integer(0x58));
      optabb.put("AND", new Integer(0x40));
      optabb.put("COMP", new Integer(0x28));
      optabb.put("COMPF", new Integer(0x88));
      optabb.put("DIV", new Integer(0x24));
      optabb.put("DIVF", new Integer(0x64));
      optabb.put("J", new Integer(0x3C));
      optabb.put("JEQ", new Integer(0x30));
      optabb.put("JLT", new Integer(0x38));
      optabb.put("JSUB", new Integer(0x48));
	   optabb.put("LDA", new Integer(0x00));
      optabb.put("LDB", new Integer(0x68));
      optabb.put("LDCH", new Integer(0x50));
      optabb.put("LDF", new Integer(0x70));
      optabb.put("LDL", new Integer(0x08));
      optabb.put("LDS", new Integer(0x6C));
      optabb.put("LDT", new Integer(0x74));
      optabb.put("LDX", new Integer(0x04));
	   optabb.put("MUL", new Integer(0x20));
      optabb.put("OR", new Integer(0x44));
      optabb.put("RD", new Integer(0xD8));
      optabb.put("RSUB", new Integer(0x4C));
	   optabb.put("STA", new Integer(0x0C));
      optabb.put("STB", new Integer(0x78));
      optabb.put("STCH", new Integer(0x54));
      optabb.put("STF", new Integer(0x80));
      optabb.put("STI", new Integer(0xD4));
      optabb.put("STL", new Integer(0x14));
      optabb.put("STS", new Integer(0x7C));
      optabb.put("STSW", new Integer(0xE8));
      optabb.put("STT", new Integer(0x84));
      optabb.put("STX", new Integer(0x10));
      optabb.put("SUB", new Integer(0x1C));
      optabb.put("SUBF", new Integer(0x5C));
      optabb.put("TD", new Integer(0xE0));
      optabb.put("TIX", new Integer(0x2C));
      optabb.put("WD", new Integer(0xDC));
   
      optabb.put("ADDR", new Integer(0x90));
      optabb.put("CLEAR", new Integer(0xB4));
      optabb.put("COMPR", new Integer(0xA0));
      optabb.put("DIVR", new Integer(0x9C));
      optabb.put("RMO", new Integer(0xAC));
      optabb.put("SHIFTL", new Integer(0xA4));
      optabb.put("SHIFTER", new Integer(0xA8));
      optabb.put("SUBR", new Integer(0x94));
      optabb.put("TIXR", new Integer(0xB8));  


try{

 Hashtable<String, String> symtab = new Hashtable<String, String>();
 ArrayList<String> row = new ArrayList<String>();
 ArrayList<String> thirdArray = new ArrayList<String>();
 ArrayList<String> fourthArray = new ArrayList<String>();
 String OPCODE3 = "000000";
 String OPCODE4 = "00000000";

 

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
         String[] local = new String[row.size()];
            
            for(String arrange : row){
            String[] rowPart = arrange.split("\\s");
            String part1,part2, part3, part4;
            
            //System.out.println(arrange.trim().split("\\s").length);
            
            if(arrange.trim().split("\\s").length == 4){
            part1 = rowPart[0];
            part2 = rowPart[1];
            part3 = rowPart[2];
            part4 = rowPart[3];
            
            thirdArray.add(part3);
            fourthArray.add(part4);
            
            if(!(part2.isEmpty()))
            {
               symtab.put(new String(part2), new String(part1));
            }
            
                  //enumeration for nixbpe
                  Enumeration compareNix = symtab.keys();    
                     while (compareNix.hasMoreElements()) {
                     String nixKey = (String) compareNix.nextElement();
                     String nixHex = symtab.get(nixKey);


                  }


         }

       }             
     
     
         //System.out.println("LOCCTR" + " \t\t" + "Program" + "\t\t\t" + "Opcode");
         //System.out.println();
     
         for(int g = 2; g < row.size(); g++){
         //for(String compare:thirdArray){
         
         String compare = rO[g];
         String compare1, compare2, compare3, compare4;
         String[] cPart = compare.trim().split("\\s");
                     Enumeration en = optabb.keys();
                     while (en.hasMoreElements()) {
                     String header = (String) en.nextElement();
                     int hexVar = optabb.get(header);
                     String hexa = Integer.toHexString(hexVar).toUpperCase(); 
                     
                     Enumeration location = symtab.keys();    
                     while (location.hasMoreElements()) {
                     String locKey = (String) location.nextElement();
                     String locHex = symtab.get(locKey);
                     
                     
           

            if(compare.trim().split("\\s").length >= 4  && compare.trim().split("\\s").length < 6){
            compare1 = cPart[0];
            compare2 = cPart[1];
            compare3 = cPart[2];
            compare4 = cPart[3];
            
                    if(compare3.equals(header)){

                     OPCODE3 = hexa;
                     local[g] = OPCODE3;
          
                     if(OPCODE3.length() < 2){
                     OPCODE3 = "0" + OPCODE3;
                     
                     }
                     
                     if(compare4.equals(locKey)){
                     OPCODE3 = OPCODE3 + locHex;
                     System.out.println(header + " " + OPCODE3);
                     }
                     
                      //@-indirect addressing
                     if(compare4.contains("@") && compare4.contains(locKey)){
                       
                        
                        OPCODE3 = OPCODE3 + locHex;
                        System.out.println(header + " " + OPCODE3);
                       // nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                        
                        }
                          
                        
                     //#-immediate addressing
                     if(compare4.contains("#") && compare4.contains(locKey)){
                       
                        OPCODE3 = OPCODE3 + locHex;
                        System.out.println(header + " " + OPCODE3);
                        //nixbpe.add(compare1 + " " + compare3 + " " + compare4 + " " + OPCODE3);
                        
                        }
                     

                       
            }
            //FORMAT4
            else if(compare3.contains("+")){
             OPCODE4 = hexa;
             local[g] = OPCODE4;
          
             if(OPCODE4.length() < 2){
               OPCODE4 = "0" + OPCODE4;
                     
             }
             
             String nextElem = compare3.substring(compare3.lastIndexOf("+") + 1);
             if(nextElem.equals(header) && compare4.contains(locKey)){
             
            
             OPCODE4 = OPCODE4 + locHex;
             
              System.out.println("+" + header + " " + OPCODE4);
              //nixbpe.add(compare1 + " " + compare3 + " " + compare4 + " " + OPCODE4);
            


             }


                                     
            }
                     
       
             
                  }
                  }
                              
            if(compare.contains("RSUB")){
            
            compare3 = "RSUB";

                    if(compare3.equals(header)){

                     OPCODE3 = hexa;
                     local[g] = OPCODE3;
                     if(OPCODE3.length() < 2){
                     OPCODE3 = "0" + OPCODE3;
                     
                     }
                     OPCODE3 = OPCODE3 + "0000";
                     System.out.println(header + " " + OPCODE3);
                     
                     }  
            
            }
            if(compare.trim().split("\\s").length >= 4  && compare.trim().split("\\s").length < 6){
            compare1 = cPart[0];
            compare2 = cPart[1];
            compare3 = cPart[2];
            compare4 = cPart[3];
            
               //FORMAT4 + immediate addressing >:D         
             if(compare3.equals("+" + header) && compare4.contains("#")){
             
             String compN = compare4.substring(compare4.lastIndexOf("#") + 1);
            
             int compIn = Integer.parseInt(compN);

             String adder = Integer.toHexString(compIn);
           
              OPCODE4 = OPCODE4 + "00" + adder;
              System.out.println("+" + header + " " + OPCODE4);
              //nixbpe.add( compare1 + " " +compare3 + " " + compare4 + " " + OPCODE4);
                        
              }
              //comparing a label with a register ie BUFFER,X
                     if(compare3.equals(header)){

                     OPCODE3 = hexa;
                     local[g] = OPCODE3;
            
                    //compare operand, x
                     if(compare4.contains(compare2)){
                     
                      OPCODE3 = OPCODE3 + "000";
                      if(compare4.contains(",X")){
                      OPCODE3 = OPCODE3 + "1";
                      System.out.println(header + " " + OPCODE3);
                      //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                                           
                     }
                     
                     //next character after # to implement opcode based on given number operand
                         if(compare4.contains("#") && (compare4.contains("0") || compare4.contains("1") || compare4.contains("2") ||
                                 compare4.contains("3") || compare4.contains("4") || compare4.contains("5") || compare4.contains("6") ||
                                 compare4.contains("7") || compare4.contains("8") || compare4.contains("9"))){
                                 
                           String number = (compare4.substring(compare4.lastIndexOf("#") + 1));
                           
                           int numberOfOp = Integer.parseInt(number);
                           String Op = Integer.toHexString(numberOfOp);
                           OPCODE3 = OPCODE3 + Op;
                           if(OPCODE3.length() < 6){
                           OPCODE3 = "0" + OPCODE3;
                           
                           }
                           System.out.println(header + " " + OPCODE3);
                           //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                           
                         
                           }
                       
                 

                        }

            
 
                     
       
             
                  }
            //FORMAT 2 with registers
            if(compare.trim().split("\\s").length >= 4  && compare.trim().split("\\s").length < 6){
            compare1 = cPart[0];
            compare2 = cPart[1];
            compare3 = cPart[2];
            compare4 = cPart[3];
            
                    if(compare3.equals(header)){

                     OPCODE3 = hexa;
                     local[g] = OPCODE3;
                     
                   
                     
                     if(compare4.contains("A,")){
                 
                     OPCODE3 = OPCODE3 + "0";
                 
                     if(compare4.contains(",X")){
                      OPCODE3 = OPCODE3 + "1";
                      System.out.println(header + " " + OPCODE3);
                      //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                     }
                     else if(compare4.contains(",S")){
                      OPCODE3 = OPCODE3 + "4";
                      System.out.println(header + " " + OPCODE3);
                      //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                     }
                     else if(compare4.contains(",T")){
                     OPCODE3 = OPCODE3 + "5";
                     System.out.println(header + " " + OPCODE3);
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                     }
                    
                     }
                     else if(compare4.equals("A")){
                     OPCODE3 = OPCODE3 + "0";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }

                   
                     if(compare4.contains("X,")){
                      OPCODE3 = OPCODE3 + "1";
                 
                      if(compare4.contains(",A"))
                      {
                          OPCODE3 = OPCODE3 + "0";
                          System.out.println(header + " " + OPCODE3);
                          //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if(compare4.contains(",S")){
                       OPCODE3 = OPCODE3 + "4";
                       System.out.println(header + " " + OPCODE3);
                       //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if( compare4.contains(",T")){
                     OPCODE3 = OPCODE3 + "5";
                     System.out.println(header + " " + OPCODE3);
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }

                     
                     }
                     else if(compare4.equals("X")){
              
                     OPCODE3 = OPCODE3 + "1";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }
                     
                     if(compare4.equals("B")){
                    
                     OPCODE3 = OPCODE3 + "3";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     
               
                     }
                     if(compare4.equals("L")){
                   
                     OPCODE3 = OPCODE3 + "2";
                     System.out.println(header + " " + OPCODE3 + "0");
                    //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     
               
                     }
                    
                     if(compare4.contains("S,")){
                     OPCODE3 = OPCODE3 + "4";
            
                       if(compare4.contains(",A"))
                      {
                          OPCODE3 = OPCODE3 + "0";
                          System.out.println(header + " " + OPCODE3);
                          //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if(compare4.contains(",X")){
                      OPCODE3 = OPCODE3 + "1";
                      System.out.println(header + " " + OPCODE3);
                      //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if( compare4.contains(",T")){
                     OPCODE3 = OPCODE3 + "5";
                     System.out.println(header + " " + OPCODE3);
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                     
                     }
                     else if(compare4.equals("S")){
                     OPCODE3 = OPCODE3 + "4";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");

                     }
                     
                    
                     if(compare4.contains("T,")){
                     OPCODE3 = OPCODE3 + "5";
                   
                       if(compare4.contains(",A"))
                      {
                          OPCODE3 = OPCODE3 + "0";
                          System.out.println(header + " " + OPCODE3);
                          //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if(compare4.contains(",X")){
                      OPCODE3 = OPCODE3 + "1";
                      System.out.println(header + " " + OPCODE3);
                      //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }
                      else if(compare4.contains(",S")){
                       OPCODE3 = OPCODE3 + "4";
                       System.out.println(header + " " + OPCODE3);
                       //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                      }

                     
                     }
                     else if(compare4.equals("T")){
                 
                     OPCODE3 = OPCODE3 + "5";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }
                     
                     if(compare4.equals("F")){
                   
                     OPCODE3 = OPCODE3 + "6";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }
                     if(compare4.equals("PC")){
                   
                     OPCODE3 = OPCODE3 + "8";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }
                     if(compare4.equals("SW")){
                     OPCODE3 = OPCODE3 + "9";
                     System.out.println(header + " " + OPCODE3 + "0");
                     //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3 + "0");
                     }
 
                       
            }

                              
            }
            
                
               

         }
          //implement opcode for BYTE
            if(compare.trim().split("\\s").length >= 4  && compare.trim().split("\\s").length < 6){
            compare1 = cPart[0];
            compare2 = cPart[1];
            compare3 = cPart[2];
            compare4 = cPart[3];
            
                    if(compare3.equals("BYTE")){
                    //hex integer value
                    if(compare4.contains("X'")){ 
                         String nextState = compare4.substring(compare4.lastIndexOf("X'") + 2, compare4.lastIndexOf("'"));
                         OPCODE3 = nextState;
                         System.out.println( compare3 + " " + OPCODE3);
                         //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + OPCODE3);
                         }
                         //character value
                         if(compare4.contains("C'")){
                         String nextOption = compare4.substring(compare4.lastIndexOf("C'") + 2, compare4.lastIndexOf("'"));
                         ArrayList<Character> bytes = new ArrayList<Character>();
                         for(char b : nextOption.toCharArray()){
                         bytes.add(b);
                         }
                         
                         //nixbpe
                         ArrayList<String> integ = new ArrayList<String>();
                         for(char chara : bytes ){
                         int ascii = (int) chara;
                         String asciiHex = Integer.toHexString(chara).toUpperCase();
                         integ.add(asciiHex);
                        
                         }
                         String[] stringCat = integ.toArray(new String[integ.size()]);
                         
                         StringBuilder strBuilder = new StringBuilder();
                         for (int y = 0; y < stringCat.length; y++) {
                          strBuilder.append(stringCat[y]);
                         }
                         String oneWord = strBuilder.toString();
                         System.out.println(compare3 + " " + oneWord);
                         //nixbpe.add(compare1 + " " +compare3 + " " + compare4 + " " + oneWord);
                   
                        // System.out.print(compare3 + " " );

                         //int binaryHolder = Integer.parseInt(oneWord, 16);
                
                         //String binary = Integer.toBinaryString(binaryHolder);
                         //if(binary.length() < 24){
                         //binary = "0" + binary;
                         //System.out.println(binary);
                        // }
             
                         }

                    
                    }
                    }

         
     
           }  
                  
         

         

      }
      catch(FileNotFoundException er){
         System.out.println("Error. Cannot read file.");
         return;
      }
     
                 
   }
}
