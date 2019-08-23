package views;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controllers.cStudent;
import hibernate.studentSubjectPoint;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vStudent {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vStudent window = new vStudent();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public vStudent(int idUser, String userName) {
		initialize(idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idUser, String userName) {
		frame = new JFrame("Sinh vien - " + userName);
		frame.setBounds(450, 250, 682, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// handle close window
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Ban muon thoat chuong trinh", "Thong bao!",
						JOptionPane.YES_NO_OPTION);
				if (confirm == 0) {
					frame.dispose();
				}
			}
		});
		
		JLabel lblMon = new JLabel("Mon");
		
		JComboBox comboBox = new JComboBox();
		loadComboboxSubjectName(comboBox, userName);
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxTatCaMon = new JCheckBox("Tat ca mon");
		chckbxTatCaMon.setSelected(true);
		
		// first load table
		try {
			renderDataTable(table, userName, "");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					chckbxTatCaMon.setSelected(false);
					String cbbStudentSubjectSelected = (String) comboBox.getSelectedItem();
					renderDataTable(table, userName, cbbStudentSubjectSelected);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnDangXuat = new JButton("Dang xuat");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vLogin window = new vLogin();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnDoiMatKhau = new JButton("Doi mat khau");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vChangePassword window = new vChangePassword(idUser, userName);
				window.frame.setVisible(true);
			}
		});
		
		chckbxTatCaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (chckbxTatCaMon.isSelected()) {
						renderDataTable (table, userName, "");
					} else {
						String cbbStudentSubjectSelected = (String) comboBox.getSelectedItem();
						renderDataTable(table, userName, cbbStudentSubjectSelected);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDoiMatKhau)
							.addGap(18)
							.addComponent(btnDangXuat))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(68)
								.addComponent(lblMon)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addGap(64)
								.addComponent(chckbxTatCaMon))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(38)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMon))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(chckbxTatCaMon)))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDangXuat)
						.addComponent(btnDoiMatKhau))
					.addContainerGap())
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void renderDataTable (JTable table, String idStudent, String studentSubjectSelected) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("STT");
		model.addColumn("Ma mon");
		model.addColumn("Ten mon");
		model.addColumn("Phong hoc");
		model.addColumn("Diem GK");
		model.addColumn("Diem CK");
		model.addColumn("Diem Khac");
		model.addColumn("Diem Tong");
		
		ArrayList<studentSubjectPoint> listStudentPoint = cStudent.getListStudentPoint(idStudent);
		if (listStudentPoint.size() > 0) {
			int index = 1;
			if (studentSubjectSelected.equals("") ) {
				for (studentSubjectPoint stuPoint : listStudentPoint) {
					Vector<String> list = new Vector<String>();
					list.add(String.valueOf(index));
					list.add(stuPoint.getSubjectCode());
					list.add(stuPoint.getSubjectName());
					list.add(stuPoint.getClassRoom());
					list.add(Float.toString(stuPoint.getMidPoint()));
					list.add(Float.toString(stuPoint.getEndPoint()));
					list.add(Float.toString(stuPoint.getOtherPoint()));
					list.add(Float.toString(stuPoint.getTotalPoint()));
					model.addRow(list);
					index++;
				}
			} else {
				for (studentSubjectPoint stuPoint : listStudentPoint) {
					Vector<String> list = new Vector<String>();
					if (stuPoint.getSubjectName().equals(studentSubjectSelected)) {
						list.add(String.valueOf(index));
						list.add(stuPoint.getSubjectCode());
						list.add(stuPoint.getSubjectName());
						list.add(stuPoint.getClassRoom());
						list.add(Float.toString(stuPoint.getMidPoint()));
						list.add(Float.toString(stuPoint.getEndPoint()));
						list.add(Float.toString(stuPoint.getOtherPoint()));
						list.add(Float.toString(stuPoint.getTotalPoint()));
						model.addRow(list);
						index++;
					}
				}
			}
		}
	}
	
	private void  loadComboboxSubjectName (JComboBox<String> comboBoxSubjectName, String idStudent) {
		comboBoxSubjectName.removeAllItems();
		for (studentSubjectPoint stuPoint : cStudent.getListStudentPoint(idStudent)) {
			comboBoxSubjectName.addItem(stuPoint.getSubjectName());
		}
	}
}
