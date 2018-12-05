package it.unical.ingsw.command;

import it.unical.ingsw.interfaces.Command;
import it.unical.ingsw.memento.DrawArea;

public class FocusCommand implements Command {
	private DrawArea area;
	
	public FocusCommand(DrawArea area) {
		this.area = area;
	}

	@Override
	public void execute() {
		area.setFocusable(true);
		area.setRequestFocusEnabled(true);
		area.requestFocus();
	}

}
