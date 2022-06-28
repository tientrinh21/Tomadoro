import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Pomodoro extends JDialog {

	public Pomodoro(String task) {
		this.isDone = false;
		this.earnedTomatoes = 0;
		this.task = task;
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		mainPanel = new javax.swing.JPanel();
		timerBtn = new javax.swing.JButton();
		timerPanel = new javax.swing.JPanel();
		timerLabel = new javax.swing.JLabel();
		timerBar = new javax.swing.JProgressBar();
		doneBtn = new javax.swing.JButton();
		settingPanel = new javax.swing.JPanel();
		intervalLabel = new javax.swing.JLabel();
		intervalCombo = new javax.swing.JComboBox<>();
		breakLabell = new javax.swing.JLabel();
		breakCombo = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(task);

		mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
		java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
		jPanel2Layout.columnWidths = new int[] {0, 5, 0};
		jPanel2Layout.rowHeights = new int[] {0, 5, 0};
		mainPanel.setLayout(jPanel2Layout);

		timerBtn.setText(" ▶ ");
		timerBtn.setActionCommand("Start");
		timerBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				timerBtnActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.ipady = 10;
		mainPanel.add(timerBtn, gridBagConstraints);

		timerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 20, 10));
		java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
		jPanel4Layout.columnWidths = new int[] {0};
		jPanel4Layout.rowHeights = new int[] {0, 5, 0};
		timerPanel.setLayout(jPanel4Layout);

		timerLabel.setFont(new java.awt.Font("Segoe UI", 0, 36));
		timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		timerLabel.setText("20 : 00");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		timerPanel.add(timerLabel, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weighty = 0.1;
		timerPanel.add(timerBar, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		mainPanel.add(timerPanel, gridBagConstraints);

		doneBtn.setText(" ✔ ");
		doneBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneBtnActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipady = 10;
		mainPanel.add(doneBtn, gridBagConstraints);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		settingPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));

		intervalLabel.setText("Interval:");
		settingPanel.add(intervalLabel);

		intervalCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "10", "15", "20", "25", "30", "35", "40" }));
		intervalCombo.setSelectedIndex(3);
		intervalCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				intervalComboActionPerformed(evt);
			}
		});
		settingPanel.add(intervalCombo);

		breakLabell.setText("Breaks:");
		breakLabell.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
		settingPanel.add(breakLabell);

		breakCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "5", "10", "15" }));
		breakCombo.setSelectedIndex(1);
		breakCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				breakComboActionPerformed(evt);
			}
		});
		settingPanel.add(breakCombo);

		getContentPane().add(settingPanel, java.awt.BorderLayout.SOUTH);

		pack();
	}

	private void timerBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (timerBtn.getText().equals(" ▶ ")) {
			CountInterval timer = new CountInterval();
			thread = new Thread(timer);
			thread.start();

			timerBtn.setText(" ⏹ ");
			doneBtn.setEnabled(false);
		} else if (timerBtn.getText().equals(" 😴 ")) {
			CountBreak timer = new CountBreak();
			thread = new Thread(timer);
			thread.start();

			timerBtn.setText(" ⏹ ");
			doneBtn.setEnabled(false);
		} else if (timerBtn.getText().equals(" ⏹ ")) {
			timerBtn.setText(" ▶ ");
			doneBtn.setEnabled(true);

			thread.stop();
			intervalComboActionPerformed(evt);
		}
	}

	private void intervalComboActionPerformed(java.awt.event.ActionEvent evt) {
		if (timerBtn.getText().equals(" ▶ ")) {
			timerLabel.setText(intervalCombo.getSelectedItem() + " : 00");
			timerLabel.setText(String.format("%02d : 00", Integer.parseInt((String) intervalCombo.getSelectedItem())));
		}
	}

	private void breakComboActionPerformed(java.awt.event.ActionEvent evt) {
		if (timerBtn.getText().equals(" 😴 ")) {
			timerLabel.setText(breakCombo.getSelectedItem() + " : 00");
			timerLabel.setText(String.format("%02d : 00", Integer.parseInt((String) breakCombo.getSelectedItem())));
		}
	}

	private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (earnedTomatoes > 0) {
			isDone = true;

			try {
				FileOutputStream fileObject = new FileOutputStream("achievement.txt", true); // without appending
																																										 // Write to achivement file the finished task
				try ( PrintWriter pw = new PrintWriter(fileObject)) {
					pw.println(task + " - " + earnedTomatoes + "  🍅");
				}
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(getRootPane(), "File not found", "Warning", JOptionPane.ERROR_MESSAGE);
			}		
		}

		dispose();
	}



	private Thread thread;
	private final String task;
	protected int earnedTomatoes;
	protected boolean isDone;
	// Variables declaration
	private javax.swing.JComboBox<String> breakCombo;
	private javax.swing.JLabel breakLabell;
	private javax.swing.JButton doneBtn;
	private javax.swing.JComboBox<String> intervalCombo;
	private javax.swing.JLabel intervalLabel;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel settingPanel;
	private javax.swing.JProgressBar timerBar;
	private javax.swing.JButton timerBtn;
	private javax.swing.JLabel timerLabel;
	private javax.swing.JPanel timerPanel;
	// End of variables declaration

	private class CountInterval implements Runnable {

		@Override
		public void run() {
			int totalTimeInSeconds = Integer.parseInt((String) intervalCombo.getSelectedItem()) * 60;
			timerLabel.setText(String.format("%02d : %02d", (totalTimeInSeconds / 60), (totalTimeInSeconds % 60)));
			timerBar.setValue(0);

			for (int i = totalTimeInSeconds - 1; i >= 0; i--) {
				try {
					Thread.sleep(1000);
					timerLabel.setText(String.format("%02d : %02d", (i / 60), (i % 60)));
					timerBar.setValue((totalTimeInSeconds - i) * 100 / totalTimeInSeconds);
				} catch (InterruptedException ex) {
				}
			}

			earnedTomatoes++;
			timerBtn.setText(" 😴 ");
			doneBtn.setEnabled(true);
		}
	}

	private class CountBreak implements Runnable {

		@Override
		public void run() {
			int totalTimeInSeconds = Integer.parseInt((String) breakCombo.getSelectedItem()) * 60;
			timerLabel.setText(String.format("%02d : %02d", (totalTimeInSeconds / 60), (totalTimeInSeconds % 60)));
			timerBar.setValue(0);

			for (int i = totalTimeInSeconds - 1; i >= 0; i--) {
				try {
					Thread.sleep(1000);
					timerLabel.setText(String.format("%02d : %02d", (i / 60), (i % 60)));
					timerBar.setValue((totalTimeInSeconds - i) * 100 / totalTimeInSeconds);
				} catch (InterruptedException ex) {
				}
			}

			timerBtn.setText(" ▶ ");
			doneBtn.setEnabled(true);
		}
	}
}
