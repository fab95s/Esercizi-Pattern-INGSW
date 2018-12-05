package it.unical.ingsw.state_st;

import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.state_st.State;

public class Off extends State{

    private static Off instance = new Off();
    Image off = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/lamp-off.png"));

    private Off() {}

    public static State instance() {
        return instance;
    }
    
    public void push(Lamp l) {
    	l.setCurrent(On.instance());
    }
    
    public Image getImage() {
    	return off;
    }
}