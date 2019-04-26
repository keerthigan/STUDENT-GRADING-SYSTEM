package universityGradingsystem;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*Graph class is created to create objects, to define data type,
and to create methods to do calculations in this case to create jframe setting bounds*/
public class HorizontalHistogram {
	// declaring variables
	static String ns1 = " ";
	static String ns2 = " ";
	static String ns3 = " ";
	static String ns4 = " ";
	static String ns5 = " ";
	static int total = UniversitySystem.num;
	static double average = UniversitySystem.classAvg;

	// this method has for loops to print stars horizontally
	public static void star() {
		for (int i = 0; i < UniversitySystem.firstclass; i++) {
			ns1 += "* ";
		}
		for (int i = 0; i < UniversitySystem.secondclass; i++) {
			ns2 += "* ";
		}
		for (int i = 0; i < UniversitySystem.secondlowerclass; i++) {
			ns3 += "* ";
		}
		for (int i = 0; i < UniversitySystem.normal; i++) {
			ns4 += "* ";
		}
		for (int i = 0; i < UniversitySystem.fail; i++) {
			ns5 += "* ";
		}
		HorizontalHistogram horizontal = new HorizontalHistogram();
		horizontal.starframe();
	}

	public void starframe() {
		JLabel firstclass = new JLabel("70-100 :" + ns1);
		JLabel secondclass = new JLabel("60-69  :" + ns2);
		JLabel secondlowerclass = new JLabel("50-59  :" + ns3);
		JLabel normal = new JLabel("40-49 :" + ns4);
		JLabel fail = new JLabel("0-29 :" + ns5);
		JLabel totall = new JLabel("Total Students :" + total);
		JLabel Average = new JLabel("Class Average :" + average);

		firstclass.setVerticalAlignment(SwingConstants.TOP);
		secondclass.setVerticalAlignment(SwingConstants.TOP);
		secondlowerclass.setVerticalAlignment(SwingConstants.TOP);
		normal.setVerticalAlignment(SwingConstants.TOP);
		fail.setVerticalAlignment(SwingConstants.TOP);
		totall.setVerticalAlignment(SwingConstants.BOTTOM);
		Average.setVerticalAlignment(SwingConstants.BOTTOM);

		JFrame frame = new JFrame("HISTOGRAM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel(new GridLayout(7, 1, 8, 8));
		p.add(firstclass);
		p.add(secondclass);
		p.add(secondlowerclass);
		p.add(normal);
		p.add(fail);
		p.add(totall);
		p.add(Average);

		p.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
		frame.setContentPane(p);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
