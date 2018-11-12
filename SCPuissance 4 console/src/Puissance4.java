/*******************************************************************************
 * Copyright (C) 2018 ROMAINPC_LECHAT
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
import java.util.Scanner;

//Code suffisement simple pour être réalisé en 1 seule classe
//Jeu jouable dans la console


public class Puissance4 {

	public static void main(String[] args) {
		//DEBUT DU PROGRAMME
		
		Scanner scanner = new Scanner(System.in);
		
		
		//Le plateau vertical de jeu:
		//alignement requis :
		int N = 4;
		//colonnes et lignes :
		int C = 7;
		int L = 6;
		//tableau du plateau ('.' = emplacement vide  / 'X' = joueur 1  /  'O'  = joueur 2)
		char[][] plateau = new char[C][L];
		//remplissage des cases avec du vide, oui c'est paradoxal !
		for(int x = 0 ; x < C ; x++)
			for(int y = 0 ; y < L ; y++)
				plateau[x][y] = '.';
		
		
		
		
		int gagnant = 0;
		
		//boucle de jeu, s'arrête en cas de victoire de J1 ou J2 ou si le plateau est plein avec égalité
		for(int i = 1 ; i <= C*L ; i++){
			
			//affichage du plateau:
			System.out.println("Tour " + i + ", Etat du plateau :");
			
			for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
			System.out.println();
			
			for(int y = 0 ; y < L ; y++){
				System.out.print('|');
				for(int x = 0 ; x < C ; x++){
					System.out.print(" " + plateau[x][y] + " ");
				}
				System.out.print('|');
				System.out.println();
			}
			
			for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
			System.out.println();
			
			//Placements du jeton:
			System.out.println("Tour du joueur " + (i%2==1 ? 'X' : 'O') );
			System.out.println("Entrez le numéro de la colonne entre 1 et " + C + " ...");
			boolean placement = false;
			int colonne = -1;
			while(!placement){
				colonne = -1;
				String ligne = scanner.nextLine();
				//vérification que la ligne est un entier entre 1 et C:
				try{
					colonne = Integer.valueOf(ligne);
					
					if(colonne >= 1 && colonne <= C){
						if(plateau[colonne - 1][0] != '.'){
							System.out.println("Colonne pleine, réitérez");
						} else {
							placement = true;
						}
					} else {
						System.out.println("Nombre incorrect, réitérez");
					}
					
				}catch(Exception e){System.out.println("Nombre incorrect, réitérez");}
				
			}
			//placement du jeton:
			int rang = L-1;
			while(plateau[colonne - 1][rang] != '.'){
				rang--;
			}
			plateau[colonne - 1][rang] = (i%2==1 ? 'X' : 'O');
			
			
			
			//Détection de victoire:
			
			//symbole en cours:
			char symbole = (i%2==1 ? 'X' : 'O');
			//nombre alignés maximal: 
			int max = 0;
			int x; int y;
			int somme;
			
			//-->  diagonale HG-BD
			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && x >= 0 && plateau[x][y] == symbole){ y--; x--; somme++;}
			x = colonne-1; y = rang;
			while(y < L && x < C && plateau[x][y] == symbole){ y++; x++; somme++;}
			if(somme > max) max= somme;
			
			//-->  diagonale HD-BG
			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && x < C && plateau[x][y] == symbole){ y--; x++; somme++;}
			x = colonne-1; y = rang;
			while(y < L && x >= 0 && plateau[x][y] == symbole){ y++; x--; somme++;}
			if(somme > max) max= somme;
			
			//-->  verticale:
			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && plateau[x][y] == symbole){ y--; somme++;}
			y = rang;
			while(y < L && plateau[x][y] == symbole){ y++; somme++;}
			if(somme > max) max= somme;
			
			//-->  horizontale:
			x = colonne-1; y = rang; somme=-1;
			while(x >= 0 && plateau[x][y] == symbole){ x--; somme++;}
			x = colonne-1;
			while(x < C && plateau[x][y] == symbole){ x++; somme++;}
			if(somme > max) max= somme;
			
			
			if(max >= N){
				gagnant = (i%2==1 ? 1 : 2);
				i = C*L+1;
			}
			
			
			
			
			System.out.println("********************************");
		}
		
		
		//affichage des résultats:
		// si gagnant == 0 c'est que tout le plateau s'est remplis sans gagnant, il y a donc égalité
		System.out.println();
		System.out.println("*********************");
		System.out.println("****FIN DE PARTIE****");
		System.out.println("*********************");
		if(gagnant == 0)
			System.out.println("*******EGALITE*******");
		if(gagnant == 1)
			System.out.println("****VICTOIRE DE X****");
		if(gagnant == 2)
			System.out.println("****VICTOIRE DE O****");
		System.out.println("*********************");
		
		
		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();
		
		for(int y = 0 ; y < L ; y++){
			System.out.print('|');
			for(int x = 0 ; x < C ; x++){
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}
		
		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();
		
		
		
		
		
		//OUI J'AIME BEAUCOUP LES PETITES ETOILES ! ! ! !
		
		
	}

}
