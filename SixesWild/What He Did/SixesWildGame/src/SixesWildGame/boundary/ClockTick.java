//-- entirely new java class for timer
package SixesWildGame.boundary;

import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JFrame;

import SixesWildGame.model.Model;

public class ClockTick extends TimerTask {

	SixesWildGUI param;
	Timer timer;
	
	// note that you can pass in what you need
	public ClockTick(SixesWildGUI params, Timer theTimer) {
		this.param = params;
		this.timer = theTimer;
	}
	

	@Override
	public void run() {
		int val = Integer.valueOf(param.getTimerLabel().getText());
		if(val == 0){
			timer.cancel();
			param.reset();
		}
		if(val > 0){
			val -= 1;
			param.getTimerLabel().setText("" + val);
		}
		
	}

}