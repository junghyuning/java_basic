package xyz.itwill.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Year;

import javax.swing.JFrame;

public class PaintApp extends JFrame{

	private static final long serialVersionUID = 1L;

	private int x, y;
	
	public PaintApp(String title) {
		// TODO Auto-generated constructor stub\
		super(title);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				//paint 수동으로 호출하는 메서드.
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800,200,300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint() method calling");
		super.paint(g);
		
		g.drawString("["+x+","+y+"]",x,y);
		
//		g.setColor(Color.red);
//		g.drawRect(20, 40, 50, 50);
//		g.fillRect(20, 100, 100, 50);
//		
//		g.setColor(Color.green);
//		g.drawOval(125,175,50, 50);
//		g.fillOval(100,250,200, 50);
//		
//		g.setColor(Color.blue);
//		g.drawLine(100,320,20,320);
//		g.drawString("홍길동",100,350);
		
	}
}
