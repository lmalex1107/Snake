package model;

import java.awt.Dimension;
import java.util.LinkedList;

public class snake {
	private LinkedList<Dimension> tail;
	private Dimension head;
	private Dimension oldhead;
	private int direction;
	
	public snake (Dimension  position) {
		this.tail= new LinkedList<Dimension>();
		this.head = position;
		this.tail.add(position);
	}
	
	public Dimension getHead() {
		return this.head;
		//return this.tail.getFirst();
	}
	
	public void setDirection (int direction) {
		this.direction = direction;
	}
	
	public void setHead(Dimension newHead) {
		this.oldhead = this.head;
		;
		;
		;
		;
		this.head = newHead;
		if (this.tail.size() > 0) {
			this.tail.getFirst().setSize(newHead);
		}
		else {
			this.tail.add(newHead);
		}
		
	}
	
	public LinkedList<Dimension> getTail() {
		return this.tail;
	}
	
	public void addNewElementToTail(int direction) {
		this.direction = direction;
		int antidirection = 0;
		Dimension last = null;
		Dimension prelast = null;
		
		if (this.tail.size() == 1) {
			//this.tail = new LinkedList<Dimension>();
			//this.tail.add(this.head);
			switch (this.direction) {
			case 2:
				antidirection = 8;
				break;
			case 8:
				antidirection = 2;
				break;
			case 4:
				antidirection = 6;
				break;
			case 6:
				antidirection = 4;
				break;
			
			}
		System.out.println("Direction: " + this.direction);
		System.out.println("Anti-Direction: " + antidirection);
		}
		
		
		else {
			last = this.tail.getLast();
			prelast = this.tail.get(this.tail.size() - 2);
			if (last.getHeight() == prelast.getHeight()){
				if (last.getWidth() < prelast.getWidth()) {
					antidirection = 4;
				}
				else {
					antidirection = 6;
				}
			}
			if (last.getWidth() == prelast.getWidth()) {
				if (last.getHeight() < prelast.getHeight()) {
					antidirection = 8;
				}
				else {
					antidirection = 2;
				}
			}
			
		}
		
		last = this.tail.getLast();
		switch (antidirection) {
		case 2:
			for (int i = 0; i < 3; i++) {
				last = this.tail.getLast();
				Dimension newelement = new Dimension ((int) last.getWidth(), (int) last.getHeight() + 10);
				this.tail.add(newelement);
			}
			break;
		case 8:
			for (int i = 0; i < 3; i++) {
				last = this.tail.getLast();
				Dimension newelement = new Dimension ((int) last.getWidth(), (int) last.getHeight() - 10);
				this.tail.add(newelement);
			}
			break;
		case 4:
			for (int i = 0; i < 3; i++) {
				last = this.tail.getLast();
				Dimension newelement = new Dimension ((int) last.getWidth() - 10, (int) last.getHeight() );
				this.tail.add(newelement);
			}
			break;
		case 6:
			for (int i = 0; i < 3; i++) {
				last = this.tail.getLast();
				Dimension newelement = new Dimension ((int) last.getWidth() + 10, (int) last.getHeight() );
				this.tail.add(newelement);
			}
			break;
		}
		
	}
	
	public void changeSnake() {		//Wofür ???
		for (int i = 0; i < this.tail.size(); i++) {
			
		}
	}
	
	public void move(Dimension position) {
		System.out.println("move-Test");
		for (int i = 0; i < this.tail.size(); i++) {
			System.out.println(this.tail.get(i).getWidth());
			System.out.println(this.tail.get(i).getHeight());
			System.out.println("---");
		}
		Dimension newposition = new Dimension ((int) position.getWidth(), (int) position.getHeight() );
		this.tail.addFirst(newposition);
		this.tail.removeLast();
	}
	
}
