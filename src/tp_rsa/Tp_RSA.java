/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_rsa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MOSIKANA JACQUES
 */
public class Tp_RSA {

    /**
     * @param args the command line arguments
     */
    //Fonction Permutation
      public static int [] permut(int [] mot, int [] permut){
        int index=0;
        
        int[] tempo=new int[mot.length];
         for (int i =0; i < permut.length; i++) {
           index = permut[i];
          tempo[i] = mot[index];
          }
         mot=tempo;
         return mot;
    }
       
          public static List<int []> DiviserMot(int [] MotDiv){
        List<int []> list=new ArrayList<>();
        int taille = MotDiv.length;
       int longeurK1 = MotDiv.length/2;
      int longeurK2 = taille-longeurK1;
       int [] K1= new int[longeurK1];
       int [] K2 = new int[longeurK2];
       
      
        for (int i = 0; i < longeurK1; i++) {
            
            K1[i]=MotDiv[i];
        }
        for (int i=longeurK1 ; i < taille; i++) {
            
            K2[i-longeurK1]=MotDiv[i];
            
        }
        list.add(K1);
        list.add(K2);
        return list;
    }
        
          
          public static  int [] Et(int [] X,int [] Y){
        int[] Tempo=new int[X.length];
        for (int i = 0; i < X.length; i++) {
        Tempo[i]= (X[i]==1&&Y[i]==1)?1:0;
        }
        return Tempo;
    }
       
          
           public static  int [] Ou(int [] X,int [] Y){
        int[] Tempo=new int[X.length];
        for (int i = 0; i < X.length; i++) {
        Tempo[i]= (X[i]==1||Y[i]==1)?1:0;
        }
        return Tempo;
    } 
          
           public static  int [] Ouex(int [] X,int [] Y){
        int[] Tempo=new int[X.length];
        for (int i = 0; i < X.length; i++) {
        Tempo[i]= (X[i]==Y[i])?0:1;
        }
        return Tempo;
    }
    public static void main(String[] args) {
        // TODO code application logic here
         int [] H = {0,2,1,5,4,6,3,7};
        int [] K = new int [8];
//        Scanner val = new Scanner(System.in);
          System.out.println("ENTRER LA FONCTION 'H'");
          
//           int pas=0;
//          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 7 : ");
//          while (pas<H.length){
//           int X= val.nextInt();
//          
//           if (X>=0 && X<=7){
//           boolean seul = true;
//             for (int i = 0; i < pas; i++) {
//               if (H[i]==X){
//                   System.out.println("cette valeur existe dans H");
//                   seul =false;
//                   break;
//               }
//           }
//               if (seul) {
//                    
//           H[pas]=X;
//           pas ++;
//               } 
//           }
//           else {
//               
//                System.out.println("La valeur doit être comprise entre 0 et 7.");
//               }
           
            System.out.println("Le H est :"+Arrays.toString(H));
         
         Scanner valeurCle = new Scanner(System.in);
         
         System.out.println("ENTRER LA CLE QUI EST UNE SUITE DE 0 ET 1");
         
            for (int i = 0; i < K.length; i++) {
            int x =  valeurCle.nextInt(); 
            
            while (x!=0&& x!=1) {                
                 System.out.println("ENTRER 1 ou 0");
                x=  valeurCle.nextInt();
            }
             K[i]=x;
        }
         
          System.out.println("'K'"+Arrays.toString(K));
          
          K= permut(K, H);
          
           System.out.println("K Après permutation :"+Arrays.toString(K));
           
        int taille = K.length;
        int longeurK1 = K.length/2;
        int longeurK2 = taille-longeurK1;
        int [] K1= new int[longeurK1];
        int [] K2 = new int[longeurK2];
        
      
        
        K1=DiviserMot(K).get(0);
        K2=DiviserMot(K).get(1);
        
        System.out.println("Première clé générée : " +Arrays.toString(K1));
        System.out.println("Deuxième clé générée : " +Arrays.toString(K2)); 
        
        
        int [] tempo;
        int a=0;
        
        int[] K11=new int [K1.length];
        int [] K21= new int [K2.length];
        
        K11 = Ouex(K1, K2);
        K21 = Et(K1, K2);
        
        System.out.println("Première clé générée avec opérations logique K11: " +Arrays.toString(K11));
        System.out.println("Deuxième clé générée avec opérations logique K21: " +Arrays.toString(K21));  
        
        tempo=new int[K11.length];
         for (int i = 2; i < K11.length; i++) {
            tempo[i-2]=K11[i];
        }
         tempo[K11.length-1]=K11[1];
         tempo[K11.length-2]=K11[0];
         K11=tempo;
        
         System.out.println("Première clé applicative K1: " +Arrays.toString(K11));
         
         tempo=new int[K21.length];
        a= K21[K21.length-1]; 
          
          tempo[0]=a;
          
         for (int i = 0; i < K21.length-1; i++) { 
            tempo[i+1]=K21[i]; 
        }
        K21=tempo;        
         System.out.println("Deuxième clé applicative K2: " +Arrays.toString(K21));
         
       int [] mot = new int [8] ;
       int [] pi = new int [8];
       
       Scanner motEntre = new Scanner(System.in);
       Scanner piEntre = new Scanner(System.in);
       
 
        System.out.println("SAISISSEZ LE MOT A CRYPTER QUI EST UNE SUITE DES 1 ET DES 0: " ); 
        for (int i = 0; i < mot.length; i++) {
            int x = motEntre.nextInt(); 
 
            while (x!=0&& x!=1) {                
                 System.out.println("ENTRER 1 ou 0");
                x= motEntre.nextInt();
            }
            mot[i]=x;
        }
        
        System.out.println("Le mot à crypter :"+Arrays.toString(mot));
        
         System.out.println("ENTRER LA FONCTION DE PERMUTTATION Pi");
         int compteur=0;
         
          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 7 : ");
          while (compteur<pi.length){    
           int x= piEntre.nextInt();
           if (x>=0 && x<=7){
           boolean seul = true;
             for (int i = 0; i < compteur; i++) {
               if (pi[i]==x){
                   System.out.println("cette valeur existe dans Pi");
                   seul =false;
                   break;
               }
           }
               if (seul) {
                    
           pi[compteur]=x;
           compteur++;
               } 
           }
           else {
               
                System.out.println("La valeur doit être comprise entre 0 et 7.");
               }
       }
         System.out.println("Le pi :"+Arrays.toString(pi));
         
         
       mot= permut(mot, pi);
        System.out.println("MOT PERMUTER "+Arrays.toString(mot));
        
    
         
         int compteur2=0;
         int [] p = new int [4];
         Scanner var= new Scanner(System.in);
          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 3 : ");
          while (compteur2<p.length){
       
          
           int Y= var.nextInt();
          
           if (Y>=0 && Y<=3){
           boolean seul = true;
             for (int i = 0; i < compteur2; i++) {
               if (p[i]==Y){
                   System.out.println("cette valeur existe dans H");
                   seul =false;
                   break;
               }
           }
               if (seul) {
                    
           p[compteur2]=Y;
           compteur2 ++;
               } 
           }
           else {
               
                System.out.println("La valeur doit être comprise entre 0 et 3.");
               }
       }
         
        System.out.println("P est :"+Arrays.toString(p));
        
        int [] Go=DiviserMot(mot).get(0);
        int []Do=DiviserMot(mot).get(1);
        System.out.println("Mot de gauche Go: " +Arrays.toString(Go));
        System.out.println("Mot de droite Do: " +Arrays.toString(Do));
        
        int [] D1=Ouex(permut(Go, p), K11);
        int [] G1=Ouex(Do, Ou(Go, K11));
        
        System.out.println("Mot de gauche amélioré G1: " +Arrays.toString(G1));
        System.out.println("Mot de droite amélioré D1: " +Arrays.toString(D1));
        
        
        int [] D2 = Ouex((permut(G1, p)), K21);
        int [] G2 = Ouex(D1, Ou(G1, K21));
        System.out.println("Mot de gauche dernière amélioration G2: " +Arrays.toString(G2));
        System.out.println("Mot de droite dernière amélioration D2: " +Arrays.toString(D2));
        
        
        int [] C = new int [D2.length+G2.length];
        
        System.arraycopy(G2,0, C, 0, G2.length);
        System.arraycopy(D2,0, C, G2.length, D2.length);
        
        System.out.println("C = "+Arrays.toString(C));
        tempo=new int[pi.length];
        for (int i = 0; i < pi.length; i++) {
            int j=0;
            boolean bl=false;
            do{
                if(pi[j]==i){
                    bl=true;
                }
                else j++;
            }while(!bl);
            tempo[i]=j;
        }
        int[] pi1=tempo;
        
        
        
        tempo = new  int [p.length];
        for (int i = 0; i < p.length; i++) {
            int j=0;
            boolean bl=false;
            do{
                if(p[j]==i){
                    bl=true;
                }
                else j++;
            }while(!bl);
            tempo[i]=j;
        }
        
        int [] inverseP= tempo;
        
        System.out.println("pi1 = "+Arrays.toString(pi1));
        
        C= permut(C, pi1);
         System.out.println("Mot Crypter = "+Arrays.toString(C));
         
         
      int [] textClaire = new int [8];
      
      int [] textChiffre= C;
      
       int [] textpermuter = permut(textChiffre, pi);
       
       int [] textpermuterDroit = DiviserMot(textpermuter).get(1);
       int [] textpermuterGauche = DiviserMot(textpermuter).get(0);
       
        System.out.println("les deux parties du mot chiffré sont :"+Arrays.toString(textpermuterGauche)+" et "+Arrays.toString(textpermuterDroit));
        
        //Application Round 1 
        
        int [] Gauche1 = permut(Ouex(D2, K21), inverseP);
        int [] Droit1= Ouex(G2, Ou(Go, K1));
        
        //Application Round 2
        
        int [] dernierGauche = permut(Ouex(D1, K1), inverseP);
        int [] dernierDroit= Ouex(G1, Ou(Go, K1));
        
 
        
         System.arraycopy(dernierGauche,0, textClaire, 0, dernierGauche.length);
        System.arraycopy(dernierDroit,0, textClaire, dernierGauche.length, dernierDroit.length);
        
        textClaire=permut(textClaire, pi1);
        
        
        System.out.println("LE MESSAGE EN TEXTE CLAIRE :" +Arrays.toString(textClaire));
         
 
       }
          

    }
    
}
