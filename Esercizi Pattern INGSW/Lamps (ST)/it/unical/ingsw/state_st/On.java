package it.unical.ingsw.state_st;

import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.state_st.State;

public class On extends State{

    private static On instance = new On();
    Image on = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/lamp-on.png"));

    private On() {}

    public static State instance() {
        return instance;
    }
    
    public void push(Lamp l) {
    	l.setCurrent(Off.instance());
    }
    
    public Image getImage() {
    	return on;
    }

}
