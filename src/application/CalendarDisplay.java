package application;

import java.awt.Frame;
import java.awt.Panel;
import javax.swing.SwingUtilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.model.Appointment;

public class CalendarDisplay{
	
		public CalendarDisplay() {
			
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Daily Planner");
		shell.setLayout(new RowLayout());
		Composite composite = new Composite(shell, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		composite.setLayoutData(new RowData(1000, 500));
		
		Frame frame = SWT_AWT.new_Frame(composite);
		Panel panel = new Panel(new java.awt.BorderLayout());
		frame.add(panel);
		
		Calendar calendar = new Calendar();
		calendar.setTheme(ThemeType.Light);
		panel.add(calendar);
		
		Utility utility = new Utility(display, calendar);
		
		calendar.addCalendarListener(new CalendarAdapter() {
			
		});
		
		 shell.open();
		 while (!shell.isDisposed())
		 {
			 	if (!display.readAndDispatch())
			 	
			 		display.sleep();
		 }
		 display.dispose();		
}

		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			this.setVisible(true);
		}


}

class Utility
{
	private Calendar calendar;
	private Display display;
	
	public Utility(Display display, Calendar calendar)
	{
		this.display = display;
		this.calendar = calendar;
	}
	
	public void updateProgress() 
	{
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {

		    	com.mindfusion.common.DateTime firstDate = calendar.getFirstVisibleDate();
		    	com.mindfusion.common.DateTime oneWeek = firstDate.addDays(7);	
		    	
		    	Appointment app = new Appointment();
		    	app.setStartTime(firstDate);
		    	app.setEndTime(oneWeek);
		    	app.setHeaderText("");
		    	calendar.getSchedule().getItems().add(app);	
		    	 
		    }
		    });
		  }

}