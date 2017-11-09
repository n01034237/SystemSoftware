import java.util.*;

public class SYMTAB
{
   private Hashtable<String, Integer> LOCCTR;
   //THE hashtable
   
   //constructor for the hash object
      public SYMTAB ()
      {
         LOCCTR = new Hashtable<String,Integer>();
      } 
      //inserting the hash object
      public void putVal(String label, int LocationCounter)
      {
         LOCCTR.put(label,LocationCounter);
      }
      //get funtion for the LOCCTR
      public int getLOCCTR(String label)
      {
         Integer LCCT=LOCCTR.get(label);
         if(LCCT==null) return -1;
         else return LCCT;
        
      }
     //method to print the value
     public String toString()
     {
      StringBuilder hashTab=new StringBuilder();
      //Enumeration key=LOCCTR.key();
      while(key.hasMoreElements());
      {
         String k=(String)key.nextElement();
         hashTab.append(k+"\t"+LOCCTR.get(k)+"\n");
      }
      return hashTab.toSting();
     }
     
}  