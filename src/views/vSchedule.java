package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import controllers.cSchedule;
import models.mSchedule;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class vSchedule {

	public JFrame frame;
	private JTable table;
	private JButton btnQuayLai;
	private JButton btnDangXuat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vSchedule window = new vSchedule();
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
	public vSchedule(String className, int idUser, String userName) {
		initialize(className, idUser, userName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String className, int idUser, String userName) {
		frame = new JFrame("Thoi khoa bieu " + className);
		frame.setBounds(450, 250, 633, 372);
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
			renderDataTable (table, className);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vMinistry window = new vMinistry(idUser, userName);
				window.frame.setVisible(true);
			}
		});
		
		btnDangXuat = new JButton("Dang xuat");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vLogin window = new vLogin();
				window.frame.setVisible(true);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(370)
							.addComponent(btnDangXuat)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnQuayLai))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuayLai)
						.addComponent(btnDangXuat))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void renderDataTable (JTable table, String className) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("STT");
		model.addColumn("Ma mon");
		model.addColumn("Ten mon");
		model.addColumn("Phong hoc");
		
		ArrayList<mSchedule> listScheduleClassName = cSchedule.getListScheduleClassName(className);
		if (listScheduleClassName.size() > 0) {
			int index = 1;
			for (mSchedule schedule : listScheduleClassName) {
				Vector<String> listSchedule = new Vector<String>();
				listSchedule.add(String.valueOf(index));
				listSchedule.add(schedule.getSubjectCode());
				listSchedule.add(schedule.getSubjectName());
				listSchedule.add(schedule.getClassroom());
				model.addRow(listSchedule);
				index++;
			}
		}
	}
}
