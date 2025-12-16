import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Loterija {
	static Random rand = new Random();
	static void Aizpilda(Stack<Integer> bumbas) {
		bumbas.clear();
		for(int i = 0; i < 10; i++) {
			bumbas.push(rand.nextInt(10));
		}
	}
	public static void main(String[] args) {
		String izvele;
		Stack<Integer> bumbas = new Stack<>();
		Stack<Integer> laimigie = new Stack<>();
		LocalDateTime pLaiks;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String FormatL = null;
		String [] darbibas = {"Veikt izlozi", "Apskatīt laimīgos skaitļus","Apturēt"};
		Long PLaiks = null;
		
		do {
			izvele  = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", 
					JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null)
				break;
			
			switch(izvele) {
			case "Veikt izlozi":
				
				if(!laimigie.isEmpty()) {
					
					Long ALaiks = System.currentTimeMillis();
					Long starpiba = ALaiks - PLaiks;
					System.out.println(starpiba);
					if(starpiba  < 60000) {
						JOptionPane.showMessageDialog(null, "Izlozi var veikt pēc 1 minūtes no pēdējās izlozes!", 
								"Kļūda", JOptionPane.ERROR_MESSAGE);
						break;
					}else {
						PLaiks = System.currentTimeMillis();
						laimigie.clear();
					}
				}
				if(laimigie.isEmpty()) {
				PLaiks = System.currentTimeMillis();
				for(int j=0; j<3; j++) {
					pLaiks = LocalDateTime.now();
					FormatL = pLaiks.format(myFormatObj);
					Aizpilda(bumbas);
					for(int i = 0; i < rand.nextInt(10); i++) {
						bumbas.pop();
					}
					laimigie.push(bumbas.pop());
					}
				
				}
				break;
			case "Apskatīt laimīgos skaitļus":
				if(!laimigie.isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Izloze veikta: "+FormatL+
							"\nLaimigie skaitļi: " + laimigie, 
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
