package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controllers.cUser;
import hibernate.result;

public class vLogin {

	private JFrame frame;
	private JTextField taikhoanField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin window = new vLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDangNhap = new JLabel("Dang nhap");
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblTaiKhoan = new JLabel("Tai khoan");
		
		taikhoanField = new JTextField();
		taikhoanField.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mat khau");
		
		passwordField = new JPasswordField();
		
		JButton btnDangNhap = new JButton("Dang nhap");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = taikhoanField.getText();
				String password = passwordField.getText();
				result rs = cUser.login(username, password);
				if (rs.isStatus()) {
					if (rs.getTypeUser().equals("gv")) {
						frame.dispose();
						vMinistry window = new vMinistry(rs.getIdUser(), rs.getUserName());
						window.frame.setVisible(true);
					} else {
						frame.dispose();
						vStudent window = new vStudent(rs.getIdUser(), rs.getUserName());
						window.frame.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(frame, rs.getMessage());
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDangNhap)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblMatKhau)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTaiKhoan)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(55)
										.addComponent(lblDangNhap))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(passwordField, Alignment.TRAILING)
											.addComponent(taikhoanField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblDangNhap)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaiKhoan)
						.addComponent(taikhoanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatKhau)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDangNhap)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
