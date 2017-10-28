import java.util.*;
public class OPTAB extends Token ();
{
   private static class 
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
      optab.put("ADD", new OPTAB_ENTRY(Token.Value.OP0, 0x18));
      optab.put("ADDF", new OPTAB_ENTRY(Token.Value.OP0, 0x58));
      optab.put("ADDR", new OPTAB_ENTRY(Token.Value.OP0, 0x90));
      optab.put("AND", new OPTAB_ENTRY(Token.Value.OP0, 0x40));
      optab.put("CLEAR", new OPTAB_ENTRY(Token.Value.CLEAR, 0xB4));
      optab.put("COMP", new OPTAB_ENTRY(Token.Value.OP0, 0x28));
      optab.put("COMPF", new OPTAB_ENRTY(Token.Value.OP0, 0x88));
      optab.put("COMPR", new OPTAB_ENTRY(Token.Value.OP0, 0xA0));
      optab.put("DIV", new OPTAB_ENTRTY(Token.Value.OP0, 0x24));
      optab.put("DIVF", new OPTAB_ENTRY(Token.Value.OP0, 0x64));
      optab.put("DIVR", new OPTAB_ENTRY(Token.Value.OP0, 0x9C)); 
       
   }
}
