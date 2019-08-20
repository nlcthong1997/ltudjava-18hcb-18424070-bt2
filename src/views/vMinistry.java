package views;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controllers.cMinistry;
import hibernate.result;

public class vMinistry {

	public JFrame frame;
	private JTextField txtTuNgay;
	private JTextField txtTuThang;
	private JTextField txtTuNam;
	private JTextField txtDenNgay;
	private JTextField txtDenThang;
	private JTextField txtDenNam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vMinistry window = new vMinistry();
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
	public vMinistry(int idUser, String userName) {
		initialize(idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idUser, String userName) {
		frame = new JFrame("Giao vu - " + userName);
		//frame.setSize(685, 485);
		frame.setBounds(450, 250, 686, 485);
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
		
		
		JComboBox cbbLop = new JComboBox();
		JComboBox cbbLopTheoMon = new JComboBox();
		//load combobox
		loadComboboxFollowClassName(cbbLop);
		loadComboboxFollowSubject(cbbLopTheoMon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lop theo mon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lop", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Import", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Phuc khao", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnDoiMatKhau = new JButton("Doi mat khau");
		
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
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
							.addComponent(btnDoiMatKhau, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
							.addGap(36)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDangXuat)
						.addComponent(btnDoiMatKhau))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		
		JLabel lblDen = new JLabel("Den");
		
		txtDenNgay = new JTextField();
		txtDenNgay.setColumns(10);
		
		JLabel label_3 = new JLabel("/");
		label_3.setFont(new Font("Dialog", Font.BOLD, 17));
		
		txtDenThang = new JTextField();
		txtDenThang.setColumns(10);
		
		JLabel label_4 = new JLabel("/");
		label_4.setFont(new Font("Dialog", Font.BOLD, 17));
		
		txtDenNam = new JTextField();
		txtDenNam.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(lblDen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDenNgay, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDenThang, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDenNam, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDen)
						.addComponent(txtDenNgay, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(txtDenThang, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDenNam, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JButton btnTaoPhucKhao = new JButton("Tao");
		
		JButton btnDanhSachPhuc = new JButton("Danh sach phuc khao");
		
		JLabel label_2 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_2)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnDanhSachPhuc)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnTaoPhucKhao, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
					.addGap(70))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTaoPhucKhao))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDanhSachPhuc)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblTu = new JLabel("Tu");
		
		txtTuNgay = new JTextField();
		txtTuNgay.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		
		txtTuThang = new JTextField();
		txtTuThang.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Dialog", Font.BOLD, 17));
		
		txtTuNam = new JTextField();
		txtTuNam.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(lblTu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTuNgay, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTuThang, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTuNam, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTu)
						.addComponent(txtTuNgay, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(txtTuThang, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTuNam, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(gl_panel_3);
		
		JButton btnDanhSachLop = new JButton("Danh sach lop");
		btnDanhSachLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result rs = cMinistry.importCSV("dslop");
				if (rs.isStatus()) {
					JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				//load combobox
				loadComboboxFollowClassName(cbbLop);
				loadComboboxFollowSubject(cbbLopTheoMon);
			}
		});
		
		JButton btnImpThoiKhoaBieu = new JButton("Thoi khoa bieu");
		btnImpThoiKhoaBieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result rs = cMinistry.importCSV("tkb");
				if (rs.isStatus()) {
					JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				//load combobox
				loadComboboxFollowClassName(cbbLop);
				loadComboboxFollowSubject(cbbLopTheoMon);
			}
		});
		
		JButton btnImpBangDiem = new JButton("Bang diem");
		btnImpBangDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result rs = cMinistry.importCSV("bangdiem");
				if (rs.isStatus()) {
					JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnImpBangDiem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(btnDanhSachLop, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(btnImpThoiKhoaBieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(btnDanhSachLop)
					.addGap(18)
					.addComponent(btnImpThoiKhoaBieu)
					.addGap(18)
					.addComponent(btnImpBangDiem)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnDanhSach_1 = new JButton("Danh sach");
		btnDanhSach_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbbLopTheoMon.getSelectedItem() != null) {
					String cbbClassNameSelected = (String) cbbLop.getSelectedItem();
					frame.dispose();
					vStudentClassName window = new vStudentClassName(cbbClassNameSelected, idUser,  userName);
					window.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDanhSach_1.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnLichBieu = new JButton("Lich bieu");
		btnLichBieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbbLopTheoMon.getSelectedItem() != null) {
					String cbbClassNameSelected = (String) cbbLop.getSelectedItem();
					frame.dispose();
					vSchedule window = new vSchedule(cbbClassNameSelected, idUser,  userName);
					window.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLichBieu.setFont(new Font("Dialog", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbbLop, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnDanhSach_1)
					.addGap(18)
					.addComponent(btnLichBieu, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(cbbLop, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDanhSach_1)
						.addComponent(btnLichBieu))
					.addGap(21))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnDanhSach = new JButton("Danh sach");
		btnDanhSach.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbbLopTheoMon.getSelectedItem() != null) {
					String cbbClassSubjectSelected = (String) cbbLopTheoMon.getSelectedItem();
					frame.dispose();
					vStudentClassSubject window = new vStudentClassSubject(cbbClassSubjectSelected, idUser, userName);
					window.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnBangDiem = new JButton("Bang diem");
		btnBangDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbbLopTheoMon.getSelectedItem() != null) {
					String cbbClassSubjectSelected = (String) cbbLopTheoMon.getSelectedItem();
					frame.dispose();
					vPoint window = new vPoint(cbbClassSubjectSelected, idUser, userName);
					window.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBangDiem.setFont(new Font("Dialog", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbbLopTheoMon, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnDanhSach)
					.addGap(18)
					.addComponent(btnBangDiem, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbLopTheoMon, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDanhSach)
						.addComponent(btnBangDiem))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void loadComboboxFollowSubject(JComboBox<String> comboBoxClassSubject) {
		comboBoxClassSubject.removeAllItems();
		for (String cLass : cMinistry.getListClassSubjects()) {
			comboBoxClassSubject.addItem(cLass);
		}
	}
	
	private void loadComboboxFollowClassName(JComboBox<String> comboBoxClassName) {
		comboBoxClassName.removeAllItems();
		for (String cLass : cMinistry.getListClassName()) {
			comboBoxClassName.addItem(cLass);
		}
	}
}
