package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cUser;
import hibernate.result;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vChangePassword {

	public JFrame frame;
	private JPasswordField txtMkHienTai;
	private JPasswordField txtMkMoi;
	private JPasswordField txtXacNhanMk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vChangePassword window = new vChangePassword();
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
	public vChangePassword(int idUser, String userName) {
		initialize(idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idUser, String userName) {
		frame = new JFrame("Tai khoan: " + userName);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMatKhauHien = new JLabel("Doi mat khau");
		lblMatKhauHien.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblMatKhauHien_1 = new JLabel("Mat khau hien tai");
		
		JLabel lblMatKhauMoi = new JLabel("Mat khau moi");
		
		txtMkHienTai = new JPasswordField();
		
		txtMkMoi = new JPasswordField();
		
		JLabel lblXacNhanMat = new JLabel("Xac nhan mat khau");
		
		txtXacNhanMk = new JPasswordField();
		
		JButton btnDoiMatKhau = new JButton("Doi mat khau");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwordCurrent = txtMkHienTai.getText();
				String passwordNew = txtMkMoi.getText();
				String passwordConfirm = txtXacNhanMk.getText();
				if (passwordNew.equals(passwordConfirm)) {
					result rs = cUser.changePassword(idUser, passwordNew, passwordCurrent);
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						txtMkHienTai.setText("");
						txtMkMoi.setText("");
						txtXacNhanMk.setText("");
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Canh bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Mat khau xac nhan khong dung", "Canh bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = cUser.getTypeUser(idUser);
				if (type.equals("sv")) {
					frame.dispose();
					vStudent window = new vStudent(idUser, userName);
					window.frame.setVisible(true);
				} else {
					frame.dispose();
					vMinistry window = new vMinistry(idUser, userName);
					window.frame.setVisible(true);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(lblMatKhauHien))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatKhauHien_1)
								.addComponent(lblMatKhauMoi)
								.addComponent(lblXacNhanMat))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtMkMoi)
									.addComponent(txtMkHienTai, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnDoiMatKhau)
									.addComponent(txtXacNhanMk, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(316, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblMatKhauHien)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatKhauHien_1)
						.addComponent(txtMkHienTai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatKhauMoi)
						.addComponent(txtMkMoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXacNhanMat)
						.addComponent(txtXacNhanMk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDoiMatKhau)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
