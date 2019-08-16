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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controllers.cStudentClassSubject;
import models.mStudent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class vPoint {

	public JFrame frame;
	private JTable table;
	private JTextField txtDiemGK;
	private JTextField txtDiemCK;
	private JTextField txtDiemKhac;
	private JTextField txtDiemtong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vPoint window = new vPoint();
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
	public vPoint(String classSubject, int idUser, String userName) {
		initialize(classSubject, idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String classSubject, int idUser, String userName) {
		frame = new JFrame("Bang diem lop - " + classSubject);
		frame.setBounds(450, 250, 612, 492);
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
		panel.setBorder(new TitledBorder(null, "Thong so thong ke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chinh sua diem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnDangXuat = new JButton("Dang xuat");
		
		JButton btnQuayLai = new JButton("Quay lai");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnDangXuat)
									.addGap(18)
									.addComponent(btnQuayLai)
									.addGap(8))))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(425, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuayLai)
						.addComponent(btnDangXuat))
					.addContainerGap())
		);
		
		JLabel lblMssv = new JLabel("MSSV");
		
		JLabel lblDiemGK = new JLabel("Diem GK:");
		
		txtDiemGK = new JTextField();
		txtDiemGK.setColumns(10);
		
		JLabel lblDiemCk = new JLabel("Diem CK:");
		
		txtDiemCK = new JTextField();
		txtDiemCK.setColumns(10);
		
		JLabel lblDiemKhac = new JLabel("Diem khac:");
		
		txtDiemKhac = new JTextField();
		txtDiemKhac.setColumns(10);
		
		JLabel lblDiemTong = new JLabel("Diem tong:");
		
		txtDiemtong = new JTextField();
		txtDiemtong.setColumns(10);
		
		JButton btnSua = new JButton("Sua");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblMssv)
							.addGap(88))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDiemKhac)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(txtDiemKhac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDiemGK)
								.addComponent(lblDiemCk))
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtDiemCK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiemGK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSua)
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
									.addComponent(lblDiemTong)
									.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
									.addComponent(txtDiemtong, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMssv)
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiemGK)
						.addComponent(txtDiemGK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblDiemCk))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDiemCK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiemKhac)
						.addComponent(txtDiemKhac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiemTong)
						.addComponent(txtDiemtong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSua)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblPhantramdau = new JLabel("New label");
		
		JLabel lblSoluongdau = new JLabel("New label");
		
		JLabel lblPhantramrot = new JLabel("New label");
		
		JLabel lblSoluongrot = new JLabel("New label");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhantramdau)
						.addComponent(lblPhantramrot))
					.addGap(67)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSoluongdau)
						.addComponent(lblSoluongrot))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhantramdau)
						.addComponent(lblSoluongdau))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhantramrot)
						.addComponent(lblSoluongrot))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
