package views;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controllers.cStudentClassName;
import hibernate.result;
import models.mStudent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vStudentClassName {

	public JFrame frame;
	private JTable table;
	private JTextField textMssv;
	private JTextField textHoten;
	private JTextField textCmnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vStudentClassName window = new vStudentClassName();
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
	public vStudentClassName(String className, int idUser, String userName) {
		initialize(className, idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String className, int idUser, String userName) {
		frame = new JFrame(className);
		frame.setBounds(450, 250, 698, 515);
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
		table = new JTable();
		try {
			renderDataTable(table, className);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Them sinh vien", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnDangXuat = new JButton("Dang xuat");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vLogin window = new vLogin();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vMinistry window = new vMinistry(idUser, userName);
				window.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addComponent(btnDangXuat)
					.addGap(18)
					.addComponent(btnQuayLai)
					.addGap(29))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDangXuat)
						.addComponent(btnQuayLai))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblMssv = new JLabel("Mssv:");
		
		textMssv = new JTextField();
		textMssv.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Ho ten:");
		
		textHoten = new JTextField();
		textHoten.setColumns(10);
		
		JLabel lblCmnd = new JLabel("Cmnd:");
		
		textCmnd = new JTextField();
		textCmnd.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gioi tinh:");
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nu");
		buttonGroup.add(rdbtnNu);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idStudent = textMssv.getText();
				String nameStudent = textHoten.getText();
				String identityCard = textCmnd.getText();
				String sex = "";
				if (rdbtnNam.isSelected()) {
					sex = "Nam";
				} else if (rdbtnNu.isSelected()) {
					sex = "Nu";
				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (nameStudent.equals("") || idStudent.equals("") || identityCard.equals("")) {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String [] info = { idStudent, nameStudent, identityCard, sex, className };
					result rs = cStudentClassName.addStudent(info);
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						try {
							renderDataTable(table, className);
						} catch (IOException e) {
							e.printStackTrace();
						}
						textMssv.setText("");
						textHoten.setText("");
						textCmnd.setText("");
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
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblGioiTinh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNam)
							.addGap(18)
							.addComponent(rdbtnNu))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMssv)
								.addComponent(lblHoTen)
								.addComponent(lblCmnd))
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnThem, Alignment.TRAILING)
								.addComponent(textMssv, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addComponent(textHoten)
								.addComponent(textCmnd))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMssv)
						.addComponent(textMssv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoTen)
						.addComponent(textHoten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCmnd)
						.addComponent(textCmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGioiTinh)
						.addComponent(rdbtnNam)
						.addComponent(rdbtnNu))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnThem)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void renderDataTable (JTable table, String className) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("STT");
		model.addColumn("MSSV");
		model.addColumn("Ho ten");
		model.addColumn("Gioi tinh");
		model.addColumn("Cmnd");
		
		ArrayList<mStudent> listStudentClassName = cStudentClassName.getListStudentClassName(className);
		if (listStudentClassName.size() > 0) {	
			int index = 1;
			for (mStudent student : listStudentClassName) {
				Vector<String> listStudent = new Vector<String>();
				listStudent.add(String.valueOf(index));
				listStudent.add(student.getIdStudent());
				listStudent.add(student.getNameStudent());
				listStudent.add(student.getSex());
				listStudent.add(student.getIdentityCard());
				model.addRow(listStudent);
				index++;
			}
		}
	}
}
