/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3csc4102;


public class Project3CSC4102 {


    public static void main(String[] args) {
        
       
        String infixExpr1 = "( 1 + 2 ) / 4 - 5 * 6";
        String infixExpr2 = "( 4 / 2 + 2 ) + ( 5 - 4 ) * 6";
        String infixExpr3 = "14 / 7 + ( 3 - 2 )";
        
        String postfixExpr1 = Stimphil_Convertor.convertToPostfix(infixExpr1);
        String postfixExpr2 = Stimphil_Convertor.convertToPostfix(infixExpr2);
        String postfixExpr3 = Stimphil_Convertor.convertToPostfix(infixExpr3);
        
        System.out.println(infixExpr1 + " => " + postfixExpr1 + " = " + Stimphil_Convertor.evaluatePostfix(postfixExpr1));
        System.out.println(infixExpr2 + " => " + postfixExpr2 + " = " + Stimphil_Convertor.evaluatePostfix(postfixExpr2));
        System.out.println(infixExpr3 + " => " + postfixExpr3 + " = " + Stimphil_Convertor.evaluatePostfix(postfixExpr3));
        
        
    }
    
     
    
    
}

