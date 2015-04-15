package boundaries;

import javax.swing.JFrame;

import oval.model.Model;
import oval.view.OvalPanel;

public class Application extends JFrame {
	SelectionMenu smp;
	

	public Application() {

	}

}


Model model;
OvalPanel panel;

public Application(Model m) {
	super ("Oval Drawer");
	
	this.model = m;
	
	setSize(400, 400);
	panel = new OvalPanel(model);
	add(panel);
}

OvalPanel getPanel() { return panel; }

}