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
package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Case extends ImageView{
	
	private static Image rouge = new Image("JRP4.png");
	private static Image jaune = new Image("JJP4.png");
	
	
	//vide = 0 ; rouge = 1 ; jaune = 2;
	private int statut;
	
	public Case(){
		this.statut = 0;
	}
	
	public void set(int j){
		this.setImage(j == 1 ? rouge : jaune);
		this.statut = j;
	}
	
	
	public int getStatut(){
		return statut;
	}
	
}
