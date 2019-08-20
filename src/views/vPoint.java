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

import controllers.cPoint;
import hibernate.result;
import models.mPoint;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(450, 250, 750, 492);
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
		
		JLabel lblPhantramdau = new JLabel("New label");
		
		JLabel lblSoluongdau = new JLabel("New label");
		
		JLabel lblPhantramrot = new JLabel("New label");
		
		JLabel lblSoluongrot = new JLabel("New label");
		
		table = new JTable();
		try {
			renderDataTable(table, classSubject);
			loadPercent(classSubject, lblPhantramdau, lblSoluongdau, lblPhantramrot, lblSoluongrot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					String idStudent = table.getModel().getValueAt(row, 1).toString();
		        	String diemGK = txtDiemGK.getText();
		        	String diemCK = txtDiemCK.getText();
		        	String diemKhac = txtDiemKhac.getText();
		        	String diemTong = txtDiemtong.getText();
		        	String [] infoEdit = { idStudent, diemGK, diemCK, diemKhac, diemTong, classSubject };
		        	result rs = cPoint.updatePointStudent(infoEdit);
		        	if (rs.isStatus()) {
		        		JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
		        		try {
							renderDataTable(table, classSubject);
							loadPercent(classSubject, lblPhantramdau, lblSoluongdau, lblPhantramrot, lblSoluongrot);
							lblMssv.setText("MSSV");
				        	txtDiemGK.setText("");
				        	txtDiemCK.setText("");
				        	txtDiemKhac.setText("");
				        	txtDiemtong.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
		        	} else {
		        		JOptionPane.showMessageDialog(frame, rs.getMessage(), "Canh bao",
								JOptionPane.INFORMATION_MESSAGE);
		        	}
				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua chon sinh vien can sua.", "Canh bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMssv)
								.addGap(88))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(lblDiemKhac)
								.addGap(83)
								.addComponent(txtDiemKhac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDiemGK)
									.addComponent(lblDiemCk))
								.addGap(92)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtDiemCK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDiemGK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(lblDiemTong)
								.addGap(83)
								.addComponent(txtDiemtong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(10)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnSua)
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
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	String idStudent = table.getModel().getValueAt(row, 1).toString();
		        	String diemGK = table.getModel().getValueAt(row, 3).toString();
		        	String diemCK = table.getModel().getValueAt(row, 4).toString();
		        	String diemKhac = table.getModel().getValueAt(row, 5).toString();
		        	String diemTong = table.getModel().getValueAt(row, 6).toString();
		        	lblMssv.setText(idStudent);
		        	txtDiemGK.setText(diemGK);
		        	txtDiemCK.setText(diemCK);
		        	txtDiemKhac.setText(diemKhac);
		        	txtDiemtong.setText(diemTong);
		        }
		    }
		});
		
	}
	
	private void renderDataTable (JTable table, String classSubject) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("STT");
		model.addColumn("MSSV");
		model.addColumn("Ho ten");
		model.addColumn("Diem GK");
		model.addColumn("Diem CK");
		model.addColumn("Diem Khac");
		model.addColumn("Diem Tong");
		model.addColumn("Trang thai");
		
		ArrayList<mPoint> listStudentClassSubjectPoint = cPoint.getListStudentClassSubjectPoint(classSubject);
		if (listStudentClassSubjectPoint.size() > 0) {
			int index = 1;
			for (mPoint point : listStudentClassSubjectPoint) {
				Vector<String> listPoint = new Vector<String>();
				listPoint.add(String.valueOf(index));
				listPoint.add(point.getIdStudent());
				listPoint.add(point.getNameStudent());
				listPoint.add(String.valueOf(point.getMidPoint()));
				listPoint.add(String.valueOf(point.getEndPoint()));
				listPoint.add(String.valueOf(point.getOtherPoint()));
				listPoint.add(String.valueOf(point.getTotalPoint()));
				if (point.getTotalPoint() >= 5) {
					listPoint.add("");
				} else {
					listPoint.add("         X");
				}
				model.addRow(listPoint);
				index++;
			}
		}
	}
	
	private void loadPercent (String classSubject, JLabel lblPhantramdau, JLabel lblSoluongdau, JLabel lblPhantramrot, JLabel lblSoluongrot) {
		ArrayList<Long> listResult = cPoint.loadQuantityAndPercentPoint(classSubject);

		lblSoluongdau.setText("So luong dau: " + Long.toString(listResult.get(0)) + " sv");
		lblSoluongrot.setText("So luong rot: " + Long.toString(listResult.get(1)) + " sv");
		lblPhantramdau.setText("Ti le dau: " + Long.toString(listResult.get(2)) + "%");
		lblPhantramrot.setText("Ti le rot: " + Long.toString(listResult.get(3)) + "%");
	}

}
