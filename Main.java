import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {

	public Main() {
		achievement = new Achievement();
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		topPanel = new javax.swing.JPanel();
		pomodoro = new javax.swing.JPanel();
		achievementBtn = new javax.swing.JButton();
		banner = new javax.swing.JPanel();
		iconLabel = new javax.swing.JLabel();
		bannerLabel = new javax.swing.JLabel();
		music = new javax.swing.JPanel();
		songBtn = new javax.swing.JButton();
		muteBtn = new javax.swing.JButton();
		mainPanel = new javax.swing.JPanel();
		taskPanel = new javax.swing.JPanel();
		insertPanel = new javax.swing.JPanel();
		insertTextField = new javax.swing.JTextField();
		addBtn = new javax.swing.JButton();
		taskListPanel = new javax.swing.JPanel();
		achievementPanel = new javax.swing.JPanel();
		pomodoroPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("🍅   Tomadoro");

		topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 10, 0));
		topPanel.setLayout(new java.awt.GridBagLayout());

		achievementBtn.setText("🍅 :   " + achievement.readData());
		achievementBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				achievementBtnActionPerformed(evt);
			}
		});
		pomodoro.add(achievementBtn);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.weightx = 0.15;
		topPanel.add(pomodoro, gridBagConstraints);

		banner.setLayout(new javax.swing.BoxLayout(banner, javax.swing.BoxLayout.LINE_AXIS));

		iconLabel.setText(" 🚀  ");
		banner.add(iconLabel);

		bannerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
		bannerLabel.setText("Tasks");
		banner.add(bannerLabel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.weightx = 0.8;
		topPanel.add(banner, gridBagConstraints);

		songBtn.setText(" 🎧 ");
		songBtn.setHideActionText(true);
		songBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		songBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				songBtnActionPerformed(evt);
			}
		});
		music.add(songBtn);

		muteBtn.setText("🔇");
		muteBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				muteBtnActionPerformed(evt);
			}
		});
		music.add(muteBtn);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.weightx = 0.1;
		topPanel.add(music, gridBagConstraints);

		getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);

		mainPanel.setLayout(new java.awt.CardLayout());

		taskPanel.setLayout(new java.awt.BorderLayout());

		insertPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 10, 30));
		java.awt.GridBagLayout insertPanelLayout = new java.awt.GridBagLayout();
		insertPanelLayout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
		insertPanelLayout.rowHeights = new int[] { 0 };
		insertPanel.setLayout(insertPanelLayout);

		insertTextField.setForeground(java.awt.Color.lightGray);
		insertTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		insertTextField.setText("Insert Task");
		insertTextField.setPreferredSize(new java.awt.Dimension(200, 22));
		insertTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				insertTextFieldFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				insertTextFieldFocusLost(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.ipady = 10;
		insertPanel.add(insertTextField, gridBagConstraints);

		addBtn.setText(" ➕ ");
		addBtn.setToolTipText("");
		addBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addBtnActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		insertPanel.add(addBtn, gridBagConstraints);

		taskPanel.add(insertPanel, java.awt.BorderLayout.NORTH);

		taskListPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 20, 30));
		taskListPanel.setLayout(new java.awt.GridBagLayout());
		taskPanel.add(taskListPanel, java.awt.BorderLayout.CENTER);

		mainPanel.add(taskPanel, "card2");

		javax.swing.GroupLayout achievementPanelLayout = new javax.swing.GroupLayout(achievementPanel);
		achievementPanel.setLayout(achievementPanelLayout);
		achievementPanelLayout.setHorizontalGroup(
				achievementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 565, Short.MAX_VALUE));
		achievementPanelLayout.setVerticalGroup(
				achievementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 390, Short.MAX_VALUE));

		mainPanel.add(achievementPanel, "card4");

		javax.swing.GroupLayout pomodoroPanelLayout = new javax.swing.GroupLayout(pomodoroPanel);
		pomodoroPanel.setLayout(pomodoroPanelLayout);
		pomodoroPanelLayout.setHorizontalGroup(
				pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 565, Short.MAX_VALUE));
		pomodoroPanelLayout.setVerticalGroup(
				pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 390, Short.MAX_VALUE));

		mainPanel.add(pomodoroPanel, "card3");

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		pack();
	}

	private void muteBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (muteBtn.getText().equals("🔊")) {
			muteBtn.setText("🔇");
			song.mute();
		} else {
			muteBtn.setText("🔊");
			song.unmute();
		}
	}

	private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();

		String taskName = insertTextField.getText();
		if (taskName.equals("Insert Task")) {
			return;
		}
		if (taskName.length() > 20) {
			JOptionPane.showMessageDialog(mainPanel.getParent(), "Task should be less than 20 characters", "Task",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (noNewTask - noDoneTask - noRemovedTask >= 5) {
			JOptionPane.showMessageDialog(mainPanel.getParent(), "Too many tasks undone, let's start doing it ^^",
					"Task", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		Task task = new Task(taskName);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = ++noNewTask;

		taskListPanel.add(task, gridBagConstraints);
		validate();

	}

	private void insertTextFieldFocusLost(java.awt.event.FocusEvent evt) {
		if (insertTextField.getText().isEmpty()) {
			insertTextField.setForeground(Color.LIGHT_GRAY);
			insertTextField.setText("Insert Task");
		}
	}

	private void insertTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		insertTextField.setText("");
		insertTextField.setForeground(Color.WHITE);
	}

	private void achievementBtnActionPerformed(java.awt.event.ActionEvent evt) {
		achievement = new Achievement();
		achievement.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		achievement.setLocationRelativeTo(mainPanel.getParent());
		achievement.setVisible(true);
	}

	private void songBtnActionPerformed(java.awt.event.ActionEvent evt) {
		String[] choices = { "Hope You Are Okay", "The Time We Spent", "comfy vibes" };
		String input = (String) JOptionPane.showInputDialog(mainPanel.getParent(),
				"Listen to lofi will make you more focus",
				"Music", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

		input += ".wav"; // Add the extension file name

		try {
			if (song != null) {
				song.stop();
			}
			song = new Music(input);
			muteBtn.setText("🔊");
		} catch (NullPointerException ex) {
			if (song != null) {
				song.stop(); // In case the user press cancel, it will stop the song
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String args[]) {
		FlatDraculaIJTheme.setup();

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new Main().setVisible(true);
		});
	}

	Music song;
	Pomodoro timer;
	Achievement achievement;
	private int noNewTask = 0;
	private int noDoneTask = 0;
	private int noRemovedTask = 0;
	// Variables declaration
	private javax.swing.JButton achievementBtn;
	private javax.swing.JPanel achievementPanel;
	private javax.swing.JButton addBtn;
	private javax.swing.JPanel banner;
	private javax.swing.JLabel bannerLabel;
	private javax.swing.JLabel iconLabel;
	private javax.swing.JPanel insertPanel;
	private javax.swing.JTextField insertTextField;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel music;
	private javax.swing.JButton muteBtn;
	private javax.swing.JPanel pomodoro;
	private javax.swing.JPanel pomodoroPanel;
	private javax.swing.JButton songBtn;
	private javax.swing.JPanel taskListPanel;
	private javax.swing.JPanel taskPanel;
	private javax.swing.JPanel topPanel;
	// End of variables declaration

	// Create task
	class Task extends JPanel {

		Task current;

		javax.swing.JTextField taskLabel = new javax.swing.JTextField();
		javax.swing.JButton startBtn = new javax.swing.JButton();
		javax.swing.JButton removeBtn = new javax.swing.JButton();
		javax.swing.JButton editBtn = new javax.swing.JButton();

		Task(String task) {
			super();
			java.awt.GridBagConstraints gridBagConstraints;

			setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
			setLayout(new java.awt.GridBagLayout());

			taskLabel.setEditable(false);
			taskLabel.setText(task);
			taskLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			taskLabel.setPreferredSize(new java.awt.Dimension(200, 22));
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.ipadx = 20;
			gridBagConstraints.ipady = 10;
			add(taskLabel, gridBagConstraints);

			startBtn.setText(" 🍅 ");
			startBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
				startBtnActionPerformed(evt);
			});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
			add(startBtn, gridBagConstraints);

			removeBtn.setText(" ❌ ");
			removeBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
				removeBtnActionPerformed(evt);
			});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
			add(removeBtn, gridBagConstraints);

			editBtn.setText(" ✎ ");
			editBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
				editBtnActionPerformed(evt);
			});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 3;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
			add(editBtn, gridBagConstraints);
		}

		private void startBtnActionPerformed(ActionEvent evt) {
			timer = new Pomodoro(taskLabel.getText());
			timer.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			timer.setLocationRelativeTo(mainPanel.getParent());
			timer.setModal(true);
			timer.setVisible(true);

			if (timer.isDone) {
				noDoneTask++;
				setVisible(false);
				getParent().remove(this);
			}

			achievementBtn.setText("🍅 :   " + achievement.readData());
			revalidate();
		}

		private void removeBtnActionPerformed(ActionEvent evt) {
			noRemovedTask++;
			setVisible(false);
			getParent().remove(this);
			revalidate();
		}

		private void editBtnActionPerformed(ActionEvent evt) {
			if (!taskLabel.isEditable()) {
				editBtn.setText(" ✔ ");
				taskLabel.setEditable(true);
				taskLabel.requestFocus();
			} else {
				editBtn.setText(" ✎ ");
				taskLabel.setEditable(false);
			}
		}
	}
}
