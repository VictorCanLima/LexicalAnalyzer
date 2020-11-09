package analyzer;

import java.util.*;

public class Analyzer {
    
    public static void manageSymbols(char curr){  // Used to print symbols
        
        System.out.println("Token text: "+ curr);
        switch(curr)
        {
            case '+':
                System.out.println("Token lexical category: ADD"); break;
            case '-':
                System.out.println("Token lexical category: SUB"); break;
            case '*':
                System.out.println("Token lexical category: MULT"); break;
            case '/':
                System.out.println("Token lexical category: DIV"); break;
            case '%':
                System.out.println("Token lexical category: MOD"); break;
        } 
    }
    
    public static void printNumber(String token){  // Use to print each operand (may be numbers or letters)
        System.out.println("Token text: "+ token);
        System.out.println("Token lexical category: OPERAND"); 
    }
  
    public static void getNumbers(char chars[]){  // main method
        int sizeToken = 0;
        String token = "";
        char curr;
        int len = chars.length;
        for(int i=0; i< len; i++){
            int type = Character.getType(chars[i]);
            curr = chars[i];
            if(type == 9 || type == 2)  // if the element in the array is a number or a letter
            {
                curr = chars[i];
                token = curr + "";
                sizeToken = 1;  
                if( i+1 < len) // used to find length of operand
                {
                    for(int j=i+1; j<len; j++){
                        int typeNext = Character.getType(chars[j]);
                        if(typeNext == 9 || typeNext == 2)
                        {
                            sizeToken++;
                            curr = chars[j];
                            token+=curr;
                            if(j + 1 == len){
                                printNumber(token);
                                i+=(sizeToken-1);
                                break;
                            }
                        }
                        else{
                            printNumber(token);
                            i+=(sizeToken-1);
                            break;
                        }
                    }
                }
                else{
                    printNumber(token);
                }
            }
            if( type == 20 || type == 24 || type == 25)  // if the element of the array is a symbol
            {
                manageSymbols(curr);
            }
        } 
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");  // used to read the whole line, as the space is the default delimeter
        System.out.print("Enter text: ");
        String line = scan.next();
        char[] chars = line.toCharArray();  // converts the line to char array
        getNumbers(chars);   // calls main method
    }
    
}
