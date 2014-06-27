package com.bellaire.aerbot;

import java.util.Vector;

public class TeleopExecuter implements Executer {
	
	private final Vector runnables = new Vector();// no generics in Java ME

	/**
	 * Doesn't initialize anything
	 */
	public TeleopExecuter(){
		
	}
	
    /**
     * Calls init
	 * @param environment environment to initialize with
	 */
	public TeleopExecuter(Environment environment) {
		init(environment);
	}
	
	/* (non-Javadoc)
	 * @see com.bellaire.aerbot.Initializable#init(com.bellaire.aerbot.Environment)
	 */
	public void init(Environment environment) {
		// add the runnable systems to runnables
		runnables.addElement(environment.getIntakeSystem());
		runnables.addElement(environment.getShooterSystem());
		runnables.addElement(environment.getWheelSystem());
	}

	/* (non-Javadoc)
	 * @see com.bellaire.aerbot.Executer#execute()
	 */
	public void execute() {
		//run all the runnables
		for(int i = 0; i < runnables.size(); i++){
			Runnable runnable = (Runnable) runnables.elementAt(i);
			runnable.run();
		}
	}

}
