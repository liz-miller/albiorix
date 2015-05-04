//-- entirely new java class for timer
package SixesWildGame.boundary;

import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JFrame;

import SixesWildGame.model.Lightning;
import SixesWildGame.boundary.*;


/**
* ClockTick - This is the Boundary class which counts clock ticks for use in the lightning level type
* @author Sean
*/
public class ClockTick extends TimerTask {

	Lightning param;
	Timer timer;
	SixesWildGUI gui;
	
	/**
	 * Constructor for ClockTick
	 * @param params info from lightning class
	 * @param theTimer timer info
	 * @param gui gui info
	 */
	// note that you can pass in what you need
	public ClockTick(Lightning params, Timer theTimer, SixesWildGUI gui) {
		this.param = params;
		this.timer = theTimer;
		this.gui = gui;
	}
	
   /**
    * run() runs the clock tick command
    */
	@Override
	public void run() {
		int val = Integer.valueOf(param.getTime());
		if(val == 0){
			timer.cancel();
			//-- new lightning when timer expires (change to a victory screen later)
		}
		if(val > 0){
			val -= 1;
			param.setTime(val);
			gui.updateStatViews();
			
		}
		
	}

}