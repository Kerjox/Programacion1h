package Ejercicio06;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Ventana {

	private JPanel panel1;
	private JMenuItem newMenuItem;
	private JTextArea text;
	private JMenuItem exitMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openMenuItem;

	public Ventana() {

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		newMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				text.setText("");
			}
		});
		openMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser openFileWindows = newFileWindow();
				File file = openFileWindows.getSelectedFile();
				try {
					text.setText(getContentFile(file));
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
	}

	@NotNull
	private String getContentFile(File file) throws IOException {

		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		String line;
		String content = "";

		while((line = b.readLine()) != null) {

			content = content.concat(line).concat("\n");
		}

		b.close();
		return content;
	}

	private JFileChooser newFileWindow() {

		JFileChooser openFileWindows = new JFileChooser();
		openFileWindows.setAcceptAllFileFilterUsed(true);
		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {

			@Override
			public boolean accept(File f) {

				if (f.isDirectory()) {

					return true;
				}else {

					return f.getName().endsWith(".txt");
				}

			};

			@Override
			public String getDescription() {

				return "Text file (*.txt)";
			}
		};

		openFileWindows.setFileFilter(filter);
		openFileWindows.showOpenDialog(null);
		return openFileWindows;
	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Window");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ventana().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
