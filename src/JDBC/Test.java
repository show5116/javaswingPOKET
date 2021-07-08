package JDBC;

import java.awt.EventQueue;

public class Test {
	public static void main(String args[])
    {
		//User user = new User();
		//user.SignUp();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwing frame = new TestSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
