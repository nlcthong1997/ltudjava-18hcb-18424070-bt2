package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import models.mStudent;
import controllers.cStudentClassSubject;
import hibernate.result;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class vStudentClassSubject {

	public JFrame frame;
	private JTable table;
	private JTextField txtMssv;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vStudentClassSubject window = new vStudentClassSubject();
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
	public vStudentClassSubject(String classSubject, int idUser, String userName) {
		initialize(classSubject, idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String classSubject, int idUser, String userName) {
		frame = new JFrame("Danh sach lop - " + classSubject);
		frame.setBounds(450, 250, 593, 462);
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Them sinh vien", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vMinistry window = new vMinistry(idUser, userName);
				window.frame.setVisible(true);
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(362)
					.addComponent(btnDangXuat)
					.addGap(18)
					.addComponent(btnQuayLai)
					.addGap(19))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuayLai)
						.addComponent(btnDangXuat))
					.addGap(70))
		);
		
		JLabel lblMssv = new JLabel("Mssv");
		
		txtMssv = new JTextField();
		txtMssv.setColumns(10);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idStudent = txtMssv.getText();
				if (idStudent.equals("")) {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					result rs = cStudentClassSubject.insertStudentOfClassSubject(idStudent, classSubject);
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						txtMssv.setText(null);
						try {
							renderDataTable(table, classSubject);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Canh bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idStudent = "";
				int row = table.getSelectedRow();
				if (row >= 0) {
					idStudent = table.getModel().getValueAt(row, 1).toString();
				}
				idStudent = txtMssv.getText();
				
				if (idStudent.equals("")) {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap hoac chon thong tin tu bang.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					result rs = cStudentClassSubject.deleteStudentOfClassSubject(idStudent, classSubject);
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						txtMssv.setText(null);
						try {
							renderDataTable(table, classSubject);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Canh bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMssv)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtMssv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnThem)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoa)
						.addComponent(btnThem)
						.addComponent(txtMssv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMssv))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		try {
			renderDataTable(table, classSubject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	private void renderDataTable (JTable table, String classSubject) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("STT");
		model.addColumn("MSSV");
		model.addColumn("Ho ten");
		model.addColumn("Gioi tinh");
		model.addColumn("CMND");
		
		cStudentClassSubject.getListStudentClassSubject(classSubject);
		ArrayList<mStudent> listStudentClassSubject = cStudentClassSubject.getListStudentClassSubject(classSubject);
		if (listStudentClassSubject.size() > 0) {
			int index = 1;
			for (mStudent student : listStudentClassSubject) {
				Vector<String> listStudents = new Vector<String>();
				listStudents.add(String.valueOf(index));
				listStudents.add(student.getIdStudent());
				listStudents.add(student.getNameStudent());
				listStudents.add(student.getSex());
				listStudents.add(student.getIdentityCard());
				model.addRow(listStudents);
				index++;
			}
		}
	}
}
