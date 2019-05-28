package com.sm.frame;

import com.sm.entity.CClass;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.AliOSSUtil;
import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddStudentFrame extends JFrame{
    private ImgPanel rootPanel;
    private JTextField idtextField;
    private JComboBox<CClass> classcomboBox;
    private JRadioButton boyradioButton;
    private JRadioButton girlradioButton;
    private JTextField nametextField;
    private JTextField addresstextField;
    private JTextField phonetextField;
    private JPanel birthdayPanel;
    private JLabel avatarLabel;
    private JButton sfAddstubutton;
    private JButton closebutton;
    private AdminMainFrame adminMainFrame;
    private int classId;
    private File file;

    public AddStudentFrame(AdminMainFrame adminMainFrame){
        this.adminMainFrame = adminMainFrame;
        setUndecorated(true);
        setSize(600,800);
        setTitle("增加学生");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        rootPanel.setFileName("wordbg2.png");


        CClass tip = new CClass();
        tip.setClassName("请选择班级");
        classcomboBox.addItem(tip);
        List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAllClass();
        for (CClass cClass:cClassList) {
            classcomboBox.addItem(cClass);
        }

        avatarLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:/QLDownload"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
                    avatarLabel.setText("");
                    avatarLabel.setIcon(icon);
                }
            }
        });
        classcomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = classcomboBox.getSelectedIndex();
                classId = classcomboBox.getItemAt(index).getId();
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(boyradioButton);
        group.add(girlradioButton);

        DatePicker datepick = getDatePicker();
        birthdayPanel.add(datepick);
        birthdayPanel.revalidate();

        sfAddstubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender = null;
                if (boyradioButton.isSelected()){
                    gender = "男";
                }
                if (girlradioButton.isSelected()){
                    gender = "女";
                }
                Student student = new Student();
                student.setId(idtextField.getText());
                student.setClassId(classId);
                student.setStudentName(nametextField.getText());
                student.setAvatar(AliOSSUtil.ossUpload(file));
                student.setGender(gender);
                student.setBirthday((Date) datepick.getValue());
                student.setAddress(addresstextField.getText());
                student.setPhone(phonetextField.getText());
                int n = ServiceFactory.getStudentServiceInstance().insertStu(student);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel,"新增成功");
                    AddStudentFrame.this.dispose();
                    List<StudentVO> studentVOList = ServiceFactory.getStudentServiceInstance().selectAll();
                    adminMainFrame.showStudentTable(studentVOList);
                }
            }
        });

        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentFrame.this.dispose();
            }
        });
    }

    public AddStudentFrame() { }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
       // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        Dimension dimension = new Dimension(200, 30);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date,DefaultFormat,font,dimension);
        // datepick.setLocation(137, 83);//设置起始位置

         //也可用setBounds()直接设置大小与位置
          //datepick.setBounds(137, 83, 177, 24);

       // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
         // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
         // datepick.setTimePanleVisible(true);
        return datepick;
    }

    public static void main(String[] args) {
        new AddStudentFrame();
    }
}
