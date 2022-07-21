package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.*;

public class myPanel extends JPanel{
	snake snake;
	stone stone;
	
	public myPanel (snake snake) {
		this.snake = snake;
	}
	
	public void setSnake(snake snake) {
		this.snake = snake;
	}
	
	public snake getSnake() {
		return this.snake;
	}
	
	public void setStone(stone stone) {
		this.stone = stone;
	}
	
	public stone getStone(stone stone) {
		return this.stone;
	}

	public void paintComponent (Graphics g) {
		this.setBackground(Color.BLACK);
		g.setColor(Color.GREEN);
		g.fillRect((int) this.snake.getHead().getWidth(), (int) this.snake.getHead().getHeight(), 10, 10);
		if (this.snake.getTail() != null) {
			g.setColor(Color.ORANGE);
			for (int i = 1; i < this.snake.getTail().size(); i++) {
				g.fillRect((int) this.snake.getTail().get(i).getWidth(), (int) this.snake.getTail().get(i).getHeight(), 10, 10);
			}
		}
		if (this.stone != null) {
			g.setColor(Color.RED);
			g.fillRect((int)this.stone.getPosition().getWidth(), (int) this.stone.getPosition().getHeight(), 10, 10);
		}
		
		
		
		
		
	}
	
	
}