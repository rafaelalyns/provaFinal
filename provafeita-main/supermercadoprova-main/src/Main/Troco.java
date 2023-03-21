package Main;

import java.text.DecimalFormat;
import java.util.Scanner;



public class Troco extends Pedido{
    public static void trocoValor() {
        Scanner scan = new Scanner(System.in);
        double troco;
        double valorPago;
        double valorTotaldoPedido;
        DecimalFormat fmt = new DecimalFormat("0.00");
       
        
        System.out.println("Informe o total do pedido: ");
        valorTotaldoPedido = scan.nextDouble();
        
        System.out.println("Informe o valor pago: ");
        valorPago = scan.nextDouble();
        
       
                troco = valorPago - valorTotaldoPedido;
                
                String resultado = String.format("%.2f", troco);
                
                if (troco > 0) {
                    System.out.printf("O troco a ser dado é de: "+ resultado + " reais");
                } else { 
                    System.out.println("Não tem troco.");
                }
                int resultadoFinal;
                System.out.println("Notas: ");
                
                resultadoFinal = (int) (troco/100);
                System.out.println(resultadoFinal + " nota(s) de R$100,00.");
                troco = troco % 100;
 
                resultadoFinal = (int) (troco/50);
                System.out.println(resultadoFinal + " nota(s) de R$50,00.");
                troco = troco % 50;
                
                resultadoFinal = (int) (troco/20);
                System.out.println(resultadoFinal + " nota(s) de R$20,00.");
                troco = troco % 20;
                
                resultadoFinal = (int) (troco/10);
                System.out.println(resultadoFinal + " nota(s) de R$10,00.");
                troco = troco % 10;
                
                resultadoFinal = (int) (troco/5);
                System.out.println(resultadoFinal + " nota(s) de R$5,00.");
                troco = troco % 5;
                
                resultadoFinal = (int) (troco/2);
                System.out.println(resultadoFinal + " nota(s) de R$2,00.");
                troco = troco % 2;
                
                troco = troco*100;
                
                System.out.println("Moedas:");
                
                resultadoFinal = (int) (troco/100);
                System.out.println(resultadoFinal + " moeda(s) de R$1,00.");
                troco = troco % 100;
                
                resultadoFinal = (int) (troco/50);
                System.out.println(resultadoFinal + " moeda(s) de R$0,50.");
                troco = troco % 50;
                
                resultadoFinal = (int) (troco/25);
                System.out.println(resultadoFinal + " moeda(s) de R$0,25.");
                troco = troco % 25;
                
                resultadoFinal = (int) (troco/10);
                System.out.println(resultadoFinal + " moeda(s) de R$0,10.");
                troco= troco % 10;
                
                resultadoFinal = (int) (troco/5);
                System.out.println(resultadoFinal + " moeda(s) de R$0,05.");
                troco = troco % 5;
                
                resultadoFinal = (int) (troco/1);
                System.out.println(resultadoFinal + " moeda(s) de R$0,01.");
                troco = troco % 1;
                
                
                
                
                
                
                
                
                
            }
       
     
    
   

   
    }

    
   

