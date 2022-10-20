/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3csc4102;

/**
 *
 * @author Ravi
 */
//Ravi Stimphil
//Assignment 3
//Make sure you get my name test program!

//No essay on how this program works because I barely understand hows it works.
//But it pretty much uses pointers rather than pointers and stacks. 
//Why no stacks? Because I thought it would be cool not to use them. It was 
//actually pretty dumb and a waste of time. Like, a huge waste. 
public class Stimphil_Convertor {
    public static String convertToPostfix(String zone){
        String[] endResult = convert(zone);
        int i = 0;
        if(scanOne(endResult,"(",0,endResult.length) == true){
            //System.out.println("IKUJYJ");
            //System.out.println("IYYU");
            endResult = close(endResult);
            
        }
                
                //MAKE THESE METHODS
        //System.out.println();
        endResult = reduce(endResult,i,endResult.length-1,"*","/");
        
        endResult = reduce(endResult,i,endResult.length-1,"+","-");
        
        
        
        //System.out.println(scanOne(some,"(",0,some.length));
        
        return endResult[0];
    }
    public static String evaluatePostfix(String after){
        //System.out.println(after);
        String[] subject = convert(after);
        subject = going(subject);
        String joe = subject[0];
                
        //System.out.println(subject[4]);
        
        return joe;
    }
    
    //Edit to get bigger numbers
    public static String[] convert (String array){
        //System.out.println(array);
        char charArray[] = array.toCharArray();
        
        String stringStorage[] = new String[charArray.length];
        StringBuilder store = new StringBuilder();
        int j = 0;
        for(int i = 0; i < array.length(); i++){
            if(charArray[i] != ' '){
                store.append(charArray[i]);
            }
            else{
                stringStorage[j] = store.toString();
                j++;
                store.delete(0, 32);
                stringStorage[j] = " ";
                j++;
            }
        }
        stringStorage[j] = store.toString();
        j++;
        while(j < stringStorage.length){
            stringStorage[j] = "`";
            j++;
        }
        
        if(scanOne(stringStorage,"`",0,stringStorage.length)){
            stringStorage = weightLost(stringStorage);
        }
        
        return stringStorage;
        
    }
    public static String[] reduce (String[] stringStorage, int i, int q, String oper, String ator){
        StringBuilder store = new StringBuilder();
        while((scanOne(stringStorage,oper,i,q) == true || scanOne(stringStorage,ator,i,q) == true) && i < q){
            //System.out.println(some[i]);
            
            if(isDigit(stringStorage[i]) == true && isDigit(stringStorage[i+4]) == true && (stringStorage[i+2].equals(oper) || stringStorage[i+2].equals(ator))){
                
                store.append(stringStorage[i]);
                store.append(" ");
                store.append(stringStorage[i+4]);
                store.append(" ");
                store.append(stringStorage[i+2]);
                stringStorage[i] = store.toString();
                for(int j = 1; j < 5; j++){
                    stringStorage[i + j] = "`";
                    q--;
                }
                store.delete(0,32222);
                //System.out.println(some[i]);
               stringStorage = weightLost(stringStorage);
               //System.out.println("Store: " + store);
               i--;
            }
            
            
            i++;
            //System.out.println(some[i]);
        }
        
        return stringStorage;
    }
    
    public static boolean isDigit (String test){
        boolean digitCheck = false;
        char[] check = test.toCharArray();
        if(check[0] == '0' || check[0] == '1'|| check[0] == '2'|| check[0] == '3'|| check[0] == '4'
                || check[0] == '5'|| check[0] == '6'|| check[0] == '7'|| check[0] == '8'|| check[0] == '9'){
            digitCheck = true;
        }
        return digitCheck;
    }
    
    public static String[] weightLost (String[] comsumer){
        int j = 0;
        int nudge = 0;
        while(j < comsumer.length){
            if(comsumer[j].equals("`")){
                nudge++;
            }
            j++;
        }
        String[] newStringStorage = new String[comsumer.length-nudge];
        int i = 0;
        int track = 0;
        
        while(i < comsumer.length){
            if(!comsumer[i].equals("`")){
                newStringStorage[i-track] = comsumer[i];
            }
            else{
                track = track + 1;
            }
            i++;
        }
          
        
        return newStringStorage;
    }
    public static String[] close (String[] stringStorage){
        int endPoint = 0;
        int startPoint = 0;
        
        int i = 0;
        
        while(!stringStorage[i].equals(")")){
            endPoint++;
            i++;
        }
        //System.out.println(zone[i]);
        startPoint = endPoint;
        while(!stringStorage[i].equals("(")){
            startPoint--;
            i--;
        }
        //.println("Place: " +zone[i]);
        
        startPoint++;
        
        //zone = weightLost(zone);
        
        
        //System.out.println("YOU CALLEd");
        int dudge = stringStorage.length;
        stringStorage = reduce(stringStorage,startPoint,endPoint-1,"*","/");
        endPoint = endPoint - dudge + stringStorage.length;
        stringStorage = reduce(stringStorage,startPoint,endPoint-1,"+","-");
        int nudge = endPoint - startPoint - 4;
        //.println("Nudge: " + nudge);
        //System.out.println("YUo" + zone[endPoint-8]);
        stringStorage[startPoint-1] = "`";
        stringStorage[startPoint] = "`";
        stringStorage[endPoint-nudge-2] = "`";
        stringStorage[endPoint-nudge-1] = "`";
        stringStorage = weightLost(stringStorage);
        //System.out.println(zone.length);
        //System.out.println("Length: " + zone.length);
        for(int n = 0; n < stringStorage.length; n++){
            //System.out.print(zone[n]);
        }
        //System.out.println(scanOne(zone,")",0,zone.length));
        if(scanOne(stringStorage,")",0,stringStorage.length) == true){
            //System.out.println("IKUJYJ");
            stringStorage = close(stringStorage);
            
        }
        
        return stringStorage;
    }
    public static String[] going (String[] stringStorage){
        int i = 0;
        double north = 0;
        while(!"+".equals(stringStorage[i]) && !"*".equals(stringStorage[i]) && !"-".equals(stringStorage[i]) && !"/".equals(stringStorage[i])){
            i++;
        }
        if("+".equals(stringStorage[i])){
            north = Double.parseDouble(stringStorage[i-4]) + Double.parseDouble(stringStorage[i-2]);
        }
        else if("-".equals(stringStorage[i])){
            north = Double.parseDouble(stringStorage[i-4]) - Double.parseDouble(stringStorage[i-2]);
        }
        else if("/".equals(stringStorage[i])){
            north = Double.parseDouble(stringStorage[i-4]) / Double.parseDouble(stringStorage[i-2]);
        }
        else if("*".equals(stringStorage[i])){
            north = Double.parseDouble(stringStorage[i-4]) * Double.parseDouble(stringStorage[i-2]);
        }
        
        stringStorage[i] = Double.toString(north);
        stringStorage[i-1] = "`";
        stringStorage[i-2] = "`";
        stringStorage[i-3] = "`";
        stringStorage[i-4] = "`";
        stringStorage = weightLost(stringStorage);for(int k = 0; k < stringStorage.length; k++){
            //System.out.print(test[k]);
        }
        if(stringStorage.length != 1){
            stringStorage = going(stringStorage);
        }
        
        
        //System.out.println();
        //System.out.println("Answer me this: " + test[0]);
        
        return stringStorage;
    }
    public static boolean scanOne (String[] stringStorage,String target,int start, int end){
        boolean check = false;
        //System.out.println(zone[0]);
        for(int i = start; i < end;i++){
            //System.out.println(i + ": " + zone[i]);
            
            if(stringStorage[i].equals(target)){
                
                check = true;
            }
        }
        return check;
    }
}
