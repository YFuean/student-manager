package com.sm.frame;

import com.sm.entity.Admin;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame{
    private ImgPanel mainPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public AdminLoginFrame(){
        mainPanel.setFileName("wordbg2.png");
        mainPanel.repaint();
        setTitle("管理员登录界面");
        setContentPane(mainPanel);
        setSize(800,800);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得输入的账号和密码，注意密码框组件的使用方法
                String account = accountField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                JOptionPane.showMessageDialog(mainPanel, resultEntity);
                //登录成功，进入主界面，并关闭登录界面
                if (resultEntity.getCode() == 0) {
                    new AdminMainFrame((Admin)resultEntity.getData());
                    AdminLoginFrame.this.dispose();
                } else if (resultEntity.getCode() == 1) {  //密码错误，清空密码框
                    passwordField.setText("");
                } else {   //账号错误，清空两个输入框
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                passwordField.setText("");
            }
        });
    }
    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
