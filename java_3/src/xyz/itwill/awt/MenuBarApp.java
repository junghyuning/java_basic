package xyz.itwill.awt;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;


public class MenuBarApp extends Frame {


	private static final long serialVersionUID = 1L;

	public MenuBarApp(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		MenuBar menuBar = new MenuBar();
//		MenuBar menuBar2 = new MenuBar();
		
		Menu file = new Menu("File");
		Menu help = new Menu("Help");
		
		menuBar.add(file);
		menuBar.add(help);
		
		MenuItem open = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_0));
		MenuItem save = new MenuItem("SAVE", new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit = new MenuItem("EXIT");

		MenuItem view = new MenuItem("Help");
		MenuItem info = new MenuItem("Information");

		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		setMenuBar(menuBar);
//		setMenuBar(menuBar2);
		
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		
		setBounds(1000, 300, 400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		MenuBarApp menuBarApp = new MenuBarApp("menubarApp");
		
	}
}
