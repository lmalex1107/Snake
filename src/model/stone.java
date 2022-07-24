package model;

import java.awt.Dimension;
import java.util.Random;

public class stone {
	Random randomcreator;
	Dimension position;
	boolean stillexists;
	
	
	
	public stone() {
		this.stillexists = false;
		randomcreator = new Random();
	}
	
	public boolean ifstillexists() {
		
		return this.stillexists;
	}
	
	public Dimension getPosition() {
		return this.position;
	}
	
	public Dimension createStone() {
		if (this.stillexists == false) {
			this.position = new Dimension();
			int width =  randomcreator.nextInt(790);
			int height = randomcreator.nextInt(490);
			this.position.setSize(width, height);
			this.stillexists = true;
			System.out.println("Stone");
			System.out.println(width);
			System.out.println(height);
			System.out.println("-----");
		}
		
		return this.position;
	}
	
	public boolean hitStone(Dimension headposition) {
		boolean ishit = false;
		if (headposition.getHeight() + 10 >= this.position.getHeight() && headposition.getHeight() <= this.position.getHeight() +10) {
			if ((headposition.getWidth() + 10 >= this.position.getWidth()) && (headposition.getWidth() <= this.position.getWidth() + 10)) {
				ishit = true;
				this.stillexists = false;
			}
		}
		
		
		return ishit;
	}
	
	
	
}
