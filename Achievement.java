import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Achievement extends JDialog {
	public Achievement() {
		initComponents();
		readData();
	}

	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		topPanel = new javax.swing.JPanel();
		earnedTomotoesLabel = new javax.swing.JLabel();
		tomatoIcon = new javax.swing.JLabel();
		achievementListPanel = new javax.swing.JPanel();

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane2.setViewportView(jTextArea2);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 0, 20));

		earnedTomotoesLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
		earnedTomotoesLabel.setText("You've earned 0");
		earnedTomotoesLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 10, 1));
		topPanel.add(earnedTomotoesLabel);

		tomatoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tomatoIcon.setText("🍅");
		tomatoIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		topPanel.add(tomatoIcon);

		getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);

		achievementListPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 10, 20));
		achievementListPanel.setLayout(new java.awt.GridBagLayout());
		getContentPane().add(achievementListPanel, java.awt.BorderLayout.CENTER);

		pack();
	}


	int readData() {
		FileInputStream fileObject;
		java.awt.GridBagConstraints gridBagConstraints;
		int count = 0;
		int noTomatoes = 0;

		try {
			fileObject = new FileInputStream("achievement.txt");

			Scanner x = new Scanner(fileObject);

			while (x.hasNext()) {
				String text = x.nextLine();	// Get the raw text

				// Handle raw text to get the number of tomatoes earned on each tasks
				String lineContent[] = text.split("-");
				lineContent = lineContent[1].trim().split(" ");
				// Add the the total number of tomatoes
				noTomatoes += Integer.parseInt(lineContent[0]);

				achievedTask = new AchievedTask(text);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = count++;
				gridBagConstraints.weighty = 0.1;
				achievementListPanel.add(achievedTask, gridBagConstraints);
				achievementListPanel.setPreferredSize(new java.awt.Dimension(300, 40 * count));
				pack();
			}

			earnedTomotoesLabel.setText("You have earned " + noTomatoes);
		} catch (FileNotFoundException ex) {
			System.out.println("Error");
		}	
		return noTomatoes;
	}

	AchievedTask achievedTask;
	// Variables declaration
	private javax.swing.JPanel achievementListPanel;
	private javax.swing.JLabel earnedTomotoesLabel;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JLabel tomatoIcon;
	private javax.swing.JPanel topPanel;
	// End of variables declaration

	private class AchievedTask extends JLabel {

		public AchievedTask(String text) {
			super();

			setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			setText(text);
			setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
		}
	}
}
