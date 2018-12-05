package it.unical.ingsw.command;

import java.util.Stack;

import it.unical.ingsw.interfaces.Command;
import it.unical.ingsw.memento.ShapeMemento;

public class RedoCommand implements Command {
	private Stack<ShapeMemento> undo;
	private Stack<ShapeMemento> redo;
	
	public RedoCommand(Stack<ShapeMemento> undo, Stack<ShapeMemento> redo) {
		this.undo = undo;
		this.redo = redo;
	}

	@Override
	public void execute() {
		if(!redo.isEmpty()) {
			undo.push(redo.pop());
		}
	}

}
