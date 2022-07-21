package view;

import java.awt.Color;
import model.*;
import javax.swing.JFrame;

public class view extends JFrame {
	snake snake;
	stone stone;
	myPanel mypanel;

	public view(snake snake) {
		this.snake = snake;
		mypanel = new myPanel(this.snake);
		this.setSize(800, 500);
		this.setBackground(Color.BLACK);
		this.add(mypanel);
		this.show(true);
		System.out.println("Test 1");
	}
	
	public void setSnake(snake snake) {
		this.snake = snake;
	}
	
	public snake getSnake() {
		return snake;
	}
	
	public void setStone(stone stone) {
		this.stone = stone;
		this.mypanel.setStone(stone);
	}
	
	public stone getStone() {
		return this.stone;
	}
	
	
}
