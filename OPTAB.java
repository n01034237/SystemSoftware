import java.util.*;
public class OPTAB
{
   private static class OPTAB_ENTRY
   {
      public Token.Value val;
      //Token used as key to check each element of the OPTAB
      public int opcode;
      //opcode for the opcode valve used in the appendixed
      public OPTAB_ENTRY(Token.Value val, int opcode)
      {
         this.val = val;
         this.opcode = opcode;
         //this method used for getting the value of the opcode and the value of the token
         
      }
   }
   private static Map<String, OPTAB_ENTRY> optab;
   static 
   {
      optab = new HashMap<String, OPTAB_ENTRY>();
      //Creates new entries for the elements of the hashTable ie the OPTAB from Appendix
      optab.put("ADD", new OPTAB_ENTRY(Token.Value.OP0, 18));
      optab.put("ADDF", new OPTAB_ENTRY(Token.Value.OP0, 58));
      optab.put("ADDR", new OPTAB_ENTRY(Token.Value.OP0, 90));
      optab.put("AND", new OPTAB_ENTRY(Token.Value.OP0, 40));
      optab.put("CLEAR", new OPTAB_ENTRY(Token.Value.CLEAR, B4));
      optab.put("COMP", new OPTAB_ENTRY(Token.Value.OP0, 28));
      optab.put("COMPF", new OPTAB_ENRTY(Token.Value.OP0, 88));
      optab.put("COMPR", new OPTAB_ENTRY(Token.Value.OP0, A0));
      optab.put("DIV", new OPTAB_ENTRTY(Token.Value.OP0, 24));
      optab.put("DIVF", new OPTAB_ENTRY(Token.Value.OP0, 64));
      optab.put("DIVR", new OPTAB_ENTRY(Token.Value.OP0, 9C)); 
       
   }
}
