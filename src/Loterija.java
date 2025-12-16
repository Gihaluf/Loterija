import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;
/*
 * Izmantojot JOptionPane klases dialoglodziņus datu ievadei un izvadei, sastādīt programmu, 
 * kura pielietojot steku realizēt loterijas trīs laimīgo skaitļu izlozi. Trīs piegājienos steks 
 * tiek aizpildīts ar 10 nejaušiem skaitļiem (bumbiņām) intervālā [0;9]. Skaitļi pa vienam tiek vilkti ārā no steka 
 * un viens no skaitļiem (steka virsējais skaitlis) nejauši tiek iegaumēts un ielikts laimējušo skaitļu stekā. 
 * Programma nodrošina izlozes izdarīšanu, piefiksējot izlozes veikšanas datumu un laiku, kā arī laimīgo skaitļu 
 * apskatīšanu. Pēc laimīgo skaitļu noteikšanas, izlozi atkārtoti var veikti tikai ja pagājusi vismaz 1 minūte
 */
public class Loterija {
	static void Aizpilda() {
		Random rand = new Random();
		
	}
	public static void main(String[] args) {
		String izvele;
		Stack<Integer> bumbas = new Stack<>();
		Stack<Integer> laimigie = new Stack<>();
		
		String [] darbibas = {"Ievadīt vārdu", "Noteikt vārda garumu", "Apskatīt pēdējo burtu", "Apgriezt vārdu", "Apturēt"};
		
		do {
			izvele  = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", 
					JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null)
				break;
			switch(izvele) {
			
			case "Apskatīt pēdējo bumbu":
				if(!bumbas.isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Pēdējais burts ir: " + bumbas.peek(), 
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Steks ir tukšs!", 
							"Kļūda", JOptionPane.ERROR_MESSAGE);
				}
				break;
			
			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta!", 
						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}while(!izvele.equals("Apturēt"));
	}

}
