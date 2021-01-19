package Ejercicio06_EditorDeTexto;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Ventana {

	private JMenuItem exitMenuItem;
	private File file;
	private JMenuItem newMenuItem;
	private JMenuItem openMenuItem;
	private JPanel panel1;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JTextArea text;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Ejercicio06_EditorDeTexto");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ventana().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

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

				file = null;
				text.setText("");
			}
		});
		openMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				openFileWindow();
			}
		});

		saveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (file != null) saveFile(); else saveAsWindow();
			}
		});
		saveAsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				saveAsWindow();
			}
		});
	}

	private void saveAsWindow() {

		JFileChooser saveAsWindows = new JFileChooser();
		saveAsWindows.setDialogTitle("Save As");
		if (saveAsWindows.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){

			file = saveAsWindows.getSelectedFile();
			String filePath = file.getAbsolutePath();
			if (! filePath.endsWith(".txt")) {
				file = new File(filePath + ".txt");
			}
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(text.getText());
				fw.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Error",
						"No se pudo guardar el archivo",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	private void openFileWindow() {

		JFileChooser openFileWindows = new JFileChooser();
		openFileWindows.setAcceptAllFileFilterUsed(true);
		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {

			@Override
			public boolean accept(File f) {

				if (f.isDirectory()) {

					return true;
				} else {

					return f.getName().endsWith(".txt");
				}

			}

			@Override
			public String getDescription() {

				return "Text file (*.txt)";
			}
		};

		openFileWindows.setFileFilter(filter);
		if (openFileWindows.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			file = openFileWindows.getSelectedFile();
			try {
				text.setText(getContentFile(file));
			} catch (IOException ioException) {

				JOptionPane.showMessageDialog(null,
						"Error",
						"No se pudo leer el contenido del archivo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void saveFile() {

		FileWriter f = null;
		try {
			f = new FileWriter(file);
		} catch (IOException ioException) {

			ioException.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error",
					"No se pudo guardar el archivo",
					JOptionPane.WARNING_MESSAGE);
		}
		assert f != null;
		PrintWriter pw = new PrintWriter(f);
		pw.println(text.getText());
		pw.close();
	}

	@NotNull
	private String getContentFile(File file) throws IOException {

		FileReader fr = null;
		try {
			fr = new FileReader(file);
		}catch (FileNotFoundException fileNotFoundException){
			fileNotFoundException.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error",
					"No se pudo obtener el contenido del archivo",
					JOptionPane.WARNING_MESSAGE);
		}
		assert fr != null;
		BufferedReader b = new BufferedReader(fr);
		String line;
		String content = "";

		while ((line = b.readLine()) != null) {

			content = content.concat(line).concat("\n");
		}

		content = content.substring(0, content.length() - 1);

		b.close();
		return content;
	}

}
