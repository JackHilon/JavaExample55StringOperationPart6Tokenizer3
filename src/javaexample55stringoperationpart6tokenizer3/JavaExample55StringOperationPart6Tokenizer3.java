
package javaexample55stringoperationpart6tokenizer3;

import java.util.Locale;
import java.util.Scanner;


public class JavaExample55StringOperationPart6Tokenizer3 {

    
    public static void main(String[] args) {
        
        String a="10 11 100 101 8 9";
        
        Scanner tokenizer=new Scanner(a);
        int temp;
        tokenizer.useRadix(2); // change the base of the number system
                               // useful for converting from 2-base to 10-base (in our example)
        while (tokenizer.hasNextInt()) {            
            temp=tokenizer.nextInt();
            System.out.println(temp+" ..... "+temp*temp);
        }
        
        tokenizer.reset(); // reset the tokenizer and return to the basic installing confg.
        
        // =====================================================================
        // =====================================================================
        // ==== Locale are used when we chose to use point instead of comma in entering doubles
        // =====================================================================
        
        Scanner input = new Scanner(System.in);
        DoubleTokenizeWithoutLocale(input);
        
        System.out.println();
        System.out.println();
        
        DoubleTokenizeWithLocaleUS(input);
        
        
        
        
        
        
    }// end main()
    
    
    private static void DoubleTokenizeWithoutLocale(Scanner input)
    {
        System.out.println("-------------------------------------------------");
        System.out.print("Enter a string of doubles (use points!): ");
        String line = input.nextLine();
        String nLine=ChangePointToComma(line);
        System.out.println("Your string of doubles (with commas!): "+nLine);
        
        Scanner tokenizer=new Scanner(line);
        
        double num;
        while (tokenizer.hasNextDouble()) {            
            num=tokenizer.nextDouble();
            System.out.println("("+num+")");
        }
        System.out.println("-------------------------------------------------");
        
        tokenizer=new Scanner(nLine);
        
        while (tokenizer.hasNextDouble()) {            
            num=tokenizer.nextDouble();
            System.out.println("("+num+")");
        }
        System.out.println("-------------------------------------------------");
    }
    
    // =========================================================================
    
    private static void DoubleTokenizeWithLocaleUS(Scanner input)
    {
        System.out.println("*************************************************");
        System.out.print("Enter a string of doubles (use points!): ");
        String line = input.nextLine();
        String nLine=ChangePointToComma(line);
        System.out.println("Your string of doubles (with commas!): "+nLine);
        
        Scanner tokenizer=new Scanner(line);
        tokenizer.useLocale(Locale.US);
        
        double num;
        while (tokenizer.hasNextDouble()) {            
            num=tokenizer.nextDouble();
            System.out.println("("+num+")");
        }
        System.out.println("*************************************************");
        
        tokenizer=new Scanner(nLine);
        tokenizer.useLocale(Locale.US);
        
        while (tokenizer.hasNextDouble()) {            
            num=tokenizer.nextDouble();
            System.out.println("("+num+")");
        }
        System.out.println("*************************************************");
    }
    
    private static String ChangePointToComma(String str)
    {
        char[] a= str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if(a[i]=='.')
                a[i]=',';
        }
        String b=new String(a);
        return b;
    }
    
}
