package control;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.*;
import view.*;

public class control implements KeyListener {
	snake snake;
	view view;
	Dimension position;
	stone stone;
	boolean escape;
	int direction;
	
	
	public control() {
		this.escape = false;
		
		
		this.position = new Dimension();
		this.position.setSize(50, 80);
		this.snake = new snake(this.position);
		//this.snake.setHead(position);
		
		this.stone = new stone();
		this.stone.createStone();
		
		this.view = new view(this.snake);
		this.view.addKeyListener(this);
		this.view.setStone(stone);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT:
			this.position.setSize((int) this.position.getWidth() + 5, (int) this.position.getHeight());
			this.direction = 6;
			break;
		case KeyEvent.VK_LEFT:
			this.position.setSize((int) this.position.getWidth() - 5, (int) this.position.getHeight());
			this.direction = 4;
			break;
		case KeyEvent.VK_UP:
			this.position.setSize((int) this.position.getWidth(), (int) this.position.getHeight() - 5);
			this.direction = 8;
			break;
		case KeyEvent.VK_DOWN:
			this.position.setSize((int) this.position.getWidth(), (int) this.position.getHeight() + 5);
			this.direction = 2;
			break;
		}
		//this.snake.setHead(this.position);
		this.snake.move(this.position);
		if (this.stone.hitStone(this.snake.getHead())==true){
			//System.out.println("Hit");
			this.stone.createStone();
			this.snake.addNewElementToTail(this.direction);
		}
		view.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String args[]) {
		control mycontrol = new control();
	}

}
