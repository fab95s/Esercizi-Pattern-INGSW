package it.unical.ingsw.memento;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Stack;

import javax.swing.JComponent;

import it.unical.ingsw.command.FocusCommand;
import it.unical.ingsw.command.RedoCommand;
import it.unical.ingsw.command.UndoCommand;
import it.unical.ingsw.interfaces.Command;

@SuppressWarnings("serial")
public class DrawArea extends JComponent {
	private Shape shape = new Shape();
	private Stack<ShapeMemento> undoMementos = new Stack<ShapeMemento>();
	private Stack<ShapeMemento> redoMementos = new Stack<ShapeMemento>();
	private Command undo = new UndoCommand(undoMementos, redoMementos);
	private Command redo = new RedoCommand(undoMementos, redoMementos);
	private Command focus = new FocusCommand(this);
	private boolean mouseDragging = false;
	
	public DrawArea() {
		super();
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				shape.getOld().x = e.getX();
				shape.getOld().y = e.getY();
			}
			
			public void mouseReleased(MouseEvent e) {
				mouseDragging = false;
				redoMementos.clear();
				undoMementos.push(shape.getMemento());
				
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				mouseDragging = true;
				if(shape.getType() == Shape.LINE) {
					shape.getCurrent().x = e.getX();
					shape.getCurrent().y = e.getY();
				} else {
					shape.getCurrent().x = (e.getX() - shape.getOld().x);
					shape.getCurrent().y = (e.getY() - shape.getOld().y);
				}
				repaint();
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_Z && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
					undo.execute();
					repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_Y && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
					redo.execute();
					repaint();
				}
			}
		});
		
		focus.execute();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);
		for(ShapeMemento s : undoMementos) {
			s.getState().draw(g);
		}
		if(mouseDragging) {
			shape.draw(g);
		}
	}
	
	public void setPaint(Color c) {
		shape.setColor(c);
		focus.execute();
	}
	
	public void setType(String type) {
		shape.setType(type);
		focus.execute();
	}
	
	public void undo() {
		undo.execute();
		repaint();
	}
	
	public void redo() {
		redo.execute();
		repaint();
	}
}
