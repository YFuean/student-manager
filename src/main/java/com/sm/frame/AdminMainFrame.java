package com.sm.frame;

import com.eltima.components.ui.DatePicker;
import com.sm.entity.*;
import com.sm.factory.DAOFactory;
import com.sm.factory.ServiceFactory;
import com.sm.service.DepartmentService;
import com.sm.ui.ImgPanel;
import com.sm.utils.AliOSSUtil;
import net.coobird.thumbnailator.Thumbnails;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AdminMainFrame extends JFrame{
    private ImgPanel rootPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPunishPanel;
    private JPanel topPanel;
    private JButton 新增院系Button;
    private JPanel leftPanel;
    private JTextField depNameField;
    private JButton chooseButton;
    private JButton addButton;
    private JPanel contentPanel,classContentPanel;
    private JLabel adminNameLabel;
    private JLabel timeLabel;
    private JLabel logoLabel;
    private JPanel cTopPanel;
    private JTextField classNameField;
    private JButton searchBtn;
    private JPanel treePanel;
    private JScrollPane rightSP;
    private JButton addClass;
    private JSplitPane splitPanel;
    private JScrollPane crightScrollP;
    private JScrollPane cleftScrollP;
    private Admin admin;
    private JButton deleteButton;
    private DepartmentService departmentService;
    private JPanel depPanel;
    private Department department;
    private String uploadFileUrl;
    private File file,toPic,yuanAvatar,nowAvatar;
    private DefaultMutableTreeNode school,sDepartment,sCClass;
    private JTree schoolTree;
    private JPanel mClassPanel;
    private JLabel departmentNameLabel,cclassNameLabel;
    private JList mClassList;
    private List<Department> departmentList;
    private List<CClass> cClassList;
    private JTextField depNamFile,claNamFile;
    private int departmentId = 0;
    private JComboBox<Department> decomboBox;
    private JPanel stuTopPanel;
    private ImgPanel infoPanel;
    private JComboBox<Department>  comboBox1;
    private JComboBox<CClass> comboBox2;
    private JTextField searchField;
    private JButton addStudentBtn;
    private JPanel tablePanel;
    private JLabel stuAvatarLabel;
    private JTextField stuAddressField;
    private JTextField stuPhoneField;
    private JButton upDateBtn;
    private JLabel stuNumLabel;
    private JLabel stuDepLabel;
    private JLabel stuClassLabel;
    private JLabel stuNameLabel;
    private JLabel stuGenderLabel;
    private JLabel stuBirthdayLabel;
    private JButton 初始化数据Button;
    private JScrollPane deparScrollPanel;
    private JButton rewardBtn;
    private JButton punsihBtn;
    private JPanel rpcenterPanel;
    private JPanel rewardPanel;
    private JPanel punishPanel;
    private JPanel addRewardPanel;
    private JPanel rewardListPanel;
    private JTextField ReawrdField;
    private JButton searchRewBtn;
    private JButton addRewardBtn;
    private JTextField PunishField;
    private JButton searchPunBtn;
    private JButton addPunishBtn;
    private JPanel punishListPanel;
    private JPanel addPunishPanel;
    private JComboBox<Department> addPunDepComboBox;
    private JComboBox<CClass> addPunClaComboBox;
    private JComboBox<StudentVO> addPunNamComboBox;
    private JLabel addPunIdLabel;
    private JPanel addPunDatePanel;
    private JTextField addPunField;
    private JComboBox<Department> addRewDepComboBox;
    private JComboBox<CClass> addRewClaComboBox;
    private JComboBox<StudentVO> addRewNamComboBox;
    private JTextField addRewField;
    private JLabel addRewIdLabel;
    private JPanel addRewDatePanel;
    private JScrollPane rewSP;
    private JPanel minRewardPanel;
    private int row,index;
    private CClass cClass;
    private JPanel rewPanel;
    private JTextArea rewArea;
    private Font font;
    private JButton deRewButton,upRewOKButton;
    private JLabel idLabel;

    public AdminMainFrame(Admin admin) {
        font = new Font("微软雅黑",Font.PLAIN,22);
        departmentService = ServiceFactory.getDepartmentServiceInstance();
        this.admin = admin;
        adminNameLabel.setText("管理员：" + admin.getAdminName());
        adminNameLabel.setFont(font);
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText(f.format(date));
        timeLabel.setFont(font);
        setTitle("管理员主界面");
        setContentPane(rootPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootPanel.setFileName("FreshB2.jpg");
        rootPanel.repaint();
        setVisible(true);
        //调用显示所有院系方法
        showDepartments();
        //获取centerPanel,获取的是LayoutManager,向下转型CardLayout
        CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
        CardLayout rpCardLayout = (CardLayout) rpcenterPanel.getLayout();

        DatePicker datepick1 = getDatePicker();
        addRewDatePanel.add(datepick1);
        addRewDatePanel.revalidate();

        DatePicker datepick2 = getDatePicker();
        addPunDatePanel.add(datepick2);
        addPunDatePanel.revalidate();

        院系管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card1");
                showDepartments();
            }
        });
        班级管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card2");
                showClass();
            }
        });
        新增院系Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = leftPanel.isVisible();
                if (flag == true) {
                    leftPanel.setVisible(false);
                } else {
                    leftPanel.setVisible(true);
                }
            }
        });
        学生管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card3");
                infoPanel.setFileName("wordbg4.png");
                infoPanel.repaint();

                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);

                Department tip1 = new Department();
                tip1.setDepartmentName("请选择院系");
                comboBox1.addItem(tip1);
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);

                List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
                for (Department department:departmentList) {
                    comboBox1.addItem(department);
                }

                List<CClass> classList = ServiceFactory.getCClassServiceInstance().selectAllClass();
                for (CClass cClass:classList) {
                    comboBox2.addItem(cClass);
                }

                comboBox1.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED){
                            int index = comboBox1.getSelectedIndex();
                            //排除第一项提示信息
                            if (index != 0 ){
                                departmentId = comboBox1.getItemAt(index).getId();
                                //获取院系的学生，显示在表格中
                                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().getStuByDepartmentId(departmentId);
                                showStudentTable(studentList);
                                //二级联动
                                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                                //
                                comboBox2.removeAllItems();
                                CClass tip = new CClass();
                                tip.setClassName("请选择班级");
                                comboBox2.addItem(tip);
                                for (CClass cClass:cClassList) {
                                    comboBox2.addItem(cClass);
                                }
                            }
                        }
                    }
                });
                comboBox2.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED){
                            int index = comboBox2.getSelectedIndex();
                            if (index != 0){
                                int classId = comboBox2.getItemAt(index).getId();
                                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().getStuByClassId(classId);
                                showStudentTable(studentList);
                            }
                        }
                    }
                });
            }
        });
        奖惩管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card4");
                rpCardLayout.show(rpcenterPanel,"reward");

                List<RewardVO> rewardVOList = ServiceFactory.getStudentServiceInstance().selectAllReward();
                showRewardTable(rewardVOList);
                showAddRewCombox();
            }
        });
        rewardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rpCardLayout.show(rpcenterPanel,"reward");
                List<RewardVO> rewardVOList = ServiceFactory.getStudentServiceInstance().selectAllReward();
                showRewardTable(rewardVOList);
                showAddRewCombox();
            }
        });
        punsihBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rpCardLayout.show(rpcenterPanel,"punish");
                List<PunishVO> punishVOList = ServiceFactory.getStudentServiceInstance().selectAllPunish();
                showPunishTable(punishVOList);
                showAddPunCombox();
            }
        });
        depNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depNameField.setText("");
            }
        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:/QLDownload"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    logoLabel.removeAll();
                    //选中文件,原图
                    file = fileChooser.getSelectedFile();
                    //指定缩略图大小
                    toPic=fileChooser.getSelectedFile();
                    //此处把图片压成200×200的缩略图
                    try {
                        Thumbnails.of(file).size(200,200).toFile(toPic);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    //通过文件创建icon对象
                    Icon icon = new ImageIcon(toPic.getAbsolutePath());
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //上传文件到OSS并返回外链
                uploadFileUrl = AliOSSUtil.ossUpload(file);
                //创建Department对象，并设置相应属性
                Department department = new Department();
                department.setDepartmentName(depNameField.getText().trim());
                department.setLogo(uploadFileUrl);
                //调用service实现新增功能
                int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系成功");
                    //新增成功后，将侧边栏隐藏
                    leftPanel.setVisible(false);
                    //刷新界面数据
                    showDepartments();
                    //将图片预览标签隐藏
                    logoLabel.setVisible(false);
                    //将选择图片的按钮可见
                    chooseButton.setVisible(true);
                    //清空文本框
                    depNameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系失败");
                }
            }
        });
        decomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //得到选中项的索引
                int index = decomboBox.getSelectedIndex();
                //按照索引取出项，就是一个Department对象，然后取出其id备用
                departmentId = decomboBox.getItemAt(index).getId();
            }
        });
        addClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CClass cClass = new CClass();
                cClass.setClassName(classNameField.getText());
                cClass.setDepartmentId(departmentId);
                int n = ServiceFactory.getCClassServiceInstance().addCClass(cClass);
                if (n ==1){
                    JOptionPane.showMessageDialog(rootPanel,"新增班级成功");
                    showClass();
                    classNameField.setText("");
                }else {
                    JOptionPane.showMessageDialog(rootPanel,"新增班级失败");
                }
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText().trim();
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().getStuByKeywords(keywords);
                if (studentList != null ){
                    showStudentTable(studentList);
                }
            }
        });
        初始化数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);

                comboBox1.setSelectedIndex(0);
                comboBox2.removeAllItems();
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAllClass();
                for (CClass cClass:cClassList) {
                    comboBox2.addItem(cClass);
                }
                stuAvatarLabel.setText("<html><img src='https://upload-images.jianshu.io/upload_images/14042421-11f481617b7a3fae.jpg?imageMogr2/auto-orient/'></html>");
                stuNumLabel.setText("未选择");
                stuDepLabel.setText("未选择");
                stuClassLabel.setText("未选择");
                stuNameLabel.setText("未选择");
                stuGenderLabel.setText("未选择");
                stuBirthdayLabel.setText("未选择");
                stuAddressField.setText("未选择");
                stuPhoneField.setText("未选择");
                searchField.setText("未选择");
                upDateBtn.setVisible(false);
            }
        });
        addStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentFrame(AdminMainFrame.this);
                AdminMainFrame.this.setEnabled(true);
            }
        });
        searchRewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = ReawrdField.getText().trim();
                List<RewardVO> rewardVOList = ServiceFactory.getStudentServiceInstance().selectRewByKeywords(keywords);
                if (rewardVOList !=null){
                    showRewardTable(rewardVOList);
                }
            }
        });
        searchPunBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = PunishField.getText().trim();
                List<PunishVO> punishVOList = ServiceFactory.getStudentServiceInstance().selectPunByKeywords(keywords);
                if (punishVOList !=null){
                    showPunishTable(punishVOList);
                }
            }
        });
        addRewardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RewardVO rewardVO = new RewardVO();
                rewardVO.setStudentId(addRewIdLabel.getText());
                rewardVO.setReward(addRewField.getText());
                rewardVO.setRewardDate((Date) datepick1.getValue());
                ServiceFactory.getStudentServiceInstance().inRew(rewardVO);
                rewardListPanel.revalidate();

                //初始化
                addRewDepComboBox.setSelectedIndex(0);
                addRewClaComboBox.removeAllItems();
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                addRewClaComboBox.addItem(tip2);
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAllClass();
                for (CClass cClass:cClassList) {
                    addRewClaComboBox.addItem(cClass);
                }

                addRewNamComboBox.removeAllItems();
                StudentVO tip3 = new StudentVO();
                tip3.setStudentName("请选择学生");
                addRewNamComboBox.addItem(tip3);
                List<StudentVO> studentVOList = ServiceFactory.getStudentServiceInstance().selectAll();
                for (StudentVO student:studentVOList) {
                    addRewNamComboBox.addItem(student);
                }
                addRewIdLabel.setText("未选择");
                addRewField.setText("");
            }
        });
        addPunishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PunishVO punishVO = new PunishVO();
                punishVO.setStudentId(addPunIdLabel.getText());
                punishVO.setPunish(addPunField.getText());
                punishVO.setPunishDate((Date) datepick2.getValue());
                ServiceFactory.getStudentServiceInstance().inPun(punishVO);
                punishListPanel.revalidate();//刷新
                //初始化
                addPunDepComboBox.setSelectedIndex(0);
                addPunClaComboBox.removeAllItems();
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                addPunClaComboBox.addItem(tip2);
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAllClass();
                for (CClass cClass:cClassList) {
                    addPunClaComboBox.addItem(cClass);
                }
                addPunNamComboBox.removeAllItems();
                StudentVO tip3 = new StudentVO();
                tip3.setStudentName("请选择学生");
                addPunNamComboBox.addItem(tip3);
                List<StudentVO> studentVOList = ServiceFactory.getStudentServiceInstance().selectAll();
                for (StudentVO student:studentVOList) {
                    addPunNamComboBox.addItem(student);
                }
                addPunIdLabel.setText("未选择");
                addPunField.setText("");
            }
        });
    }
    private void showPunishTable(List<PunishVO> punishVOList){
        punishListPanel.removeAll();
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名","处分","日期","id"});
        String[] ob = {"学号","院系","班级","姓名","处分","日期","id"};
        model.addRow(ob);
        for (PunishVO punishVO:punishVOList) {
            Object[] object = new Object[]{punishVO.getStudentId(),punishVO.getDepartmentName(),punishVO.getClassName(),punishVO.getStudentName(),
                    punishVO.getPunish(),punishVO.getPunishDate(),punishVO.getId()};
            model.addRow(object);
        }
        //将最后一列隐藏id
        TableColumn tc = table.getColumnModel().getColumn(6);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);

        table.setRowHeight(35);
        table.setBackground(Color.WHITE);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);

        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        punishListPanel.add(scrollPane);
        punishListPanel.revalidate();//刷新

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("删除");
        jPopupMenu.add(item);
        table.add(jPopupMenu);
        punishListPanel.add(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.getSelectedRow();
                if (e.getButton() == 3){
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) table.getValueAt(row,6);
                int choice = JOptionPane.showConfirmDialog(punishListPanel,"确定要删除吗？");
                if (choice == 0){
                    if(row != -1){
                        model.removeRow(row);
                    }
                    ServiceFactory.getStudentServiceInstance().delPunById(id);
                }
            }
        });
    }
    private void showRewardTable(List<RewardVO> rewardVOList) {
        rewardListPanel.removeAll();
        GridLayout gridLayout = new GridLayout(0, 3, 15, 15);
        rewardListPanel.setBorder(new EmptyBorder(15,10,15,10));
        rewardListPanel.setLayout(gridLayout);
        rewardListPanel.setBackground(Color.WHITE);
        for (RewardVO rewardVO : rewardVOList) {
            //给每个院系对象创建一个面板
            rewPanel = new JPanel();
            rewPanel.setLayout(null);
            rewPanel.setSize(100,200);
            rewPanel.setBackground(new Color(187,218,218));
            JLabel deLabel = new JLabel("院系："+rewardVO.getDepartmentName());
            deLabel.setBounds(10,5,400,24);
            deLabel.setFont(font);
            rewPanel.add(deLabel);
            JLabel claLabel = new JLabel("班级："+rewardVO.getClassName());
            claLabel.setBounds(10,30,400,24);
            claLabel.setFont(font);
            rewPanel.add(claLabel);
            JLabel xhLabel = new JLabel("学号：");
            xhLabel.setBounds(10,55,70,24);
            xhLabel.setFont(font);
            rewPanel.add(xhLabel);
            idLabel = new JLabel(rewardVO.getStudentId());
            idLabel.setBounds(75,55,400,24);
            idLabel.setFont(font);
            rewPanel.add(idLabel);
            JLabel naLabel = new JLabel("姓名："+rewardVO.getStudentName());
            naLabel.setBounds(10,80,400,24);
            naLabel.setFont(font);
            rewPanel.add(naLabel);
            JLabel reDateLabel = new JLabel("日期：" + rewardVO.getRewardDate());
            reDateLabel.setBounds(10,105,400,24);
            reDateLabel.setFont(font);
            rewPanel.add(reDateLabel);
            rewArea = new JTextArea(rewardVO.getReward());
            rewArea.setBounds(10,130,300,100);
            rewArea.setBackground(Color.WHITE);
            rewArea.setFont(font);
            rewArea.setLineWrap(true);
            rewArea.setWrapStyleWord(true);
            rewArea.setEditable(false);
            rewArea.setEnabled(false);
            rewPanel.add(rewArea);
            deRewButton = new JButton("删除");
            deRewButton.setBounds(330,5,100,30);
            deRewButton.setFont(font);
            rewPanel.add(deRewButton);
            upRewOKButton = new JButton("确定");
            upRewOKButton.setBounds(330,130,100,30);
            upRewOKButton.setFont(font);
            upRewOKButton.setVisible(false);
            rewPanel.add(upRewOKButton);
            rewardListPanel.add(rewPanel);
            deRewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");
                    // 判断用户是否点击
                    if (result == JOptionPane.OK_OPTION) {
                        //从流式面板移除当前这个人的布局
                        rewardListPanel.remove(rewPanel);
                        //删除这行记录
                        ServiceFactory.getStudentServiceInstance().delRewById(rewardVO.getId());
                        rewardListPanel.revalidate();
                    }
                }
            });
            rewArea.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2){
                        rewArea.setEditable(true);
                        rewArea.setEnabled(true);
                        upRewOKButton.setVisible(true);
                        upRewOKButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                rewardVO.setId(Integer.valueOf(idLabel.getText()));
                                rewardVO.setReward(rewArea.getText());
                                ServiceFactory.getStudentServiceInstance().upRew(rewardVO);
                                rewArea.setEditable(false);
                                rewArea.setEnabled(false);
                                upRewOKButton.setVisible(false);
                                rewPanel.revalidate();
                            }
                        });
                    }
                }
            });
        }
        rewardListPanel.revalidate();
    }
    public void showStudentTable(List<StudentVO> studentList) {
        tablePanel.removeAll();
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名","性别","地址","手机号","出生日期","头像"});
        for (StudentVO student:studentList) {
            Object[] object = new Object[]{student.getId(),student.getDepartmentName(),student.getClassName(),student.getStudentName(),
                student.getGender(),student.getAddress(),student.getPhone(),student.getBirthday(),student.getAvatar()};
            model.addRow(object);
        }
        //将最后一列隐藏头像
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        //获得表头
        JTableHeader header = table.getTableHeader();
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(hr);
        header.setPreferredSize(new Dimension(header.getWidth(),40));
        header.setFont(new Font("楷体",Font.PLAIN,22));
        table.setRowHeight(35);
        table.setBackground(new Color(188, 228, 239));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);

        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        tablePanel.revalidate();//刷新

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("删除");
        jPopupMenu.add(item);
        table.add(jPopupMenu);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.getSelectedRow();
                stuNumLabel.setText(table.getValueAt(row,0).toString());
                stuDepLabel.setText(table.getValueAt(row,1).toString());
                stuClassLabel.setText(table.getValueAt(row,2).toString());
                stuNameLabel.setText(table.getValueAt(row,3).toString());
                stuGenderLabel.setText(table.getValueAt(row,4).toString());
                stuAddressField.setText(table.getValueAt(row,5).toString());
                stuPhoneField.setText(table.getValueAt(row,6).toString());
                stuBirthdayLabel.setText(table.getValueAt(row,7).toString());
                stuAvatarLabel.setText("<html><img src='" + table.getValueAt(row,8).toString() + "'/></html>");

                upDateBtn.setVisible(true);
                upDateBtn.setText("编辑");
                upDateBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equals("编辑")){
                            stuAddressField.setEditable(true);
                            stuAddressField.setEnabled(true);
                            stuPhoneField.setEditable(true);
                            stuPhoneField.setEnabled(true);
                            upDateBtn.setText("保存");
                        }
                        if (e.getActionCommand().equals("保存")){
                            Student student = new Student();
                            student.setId(stuNumLabel.getText());
                            student.setAddress(stuAddressField.getText());
                            student.setPhone(stuPhoneField.getText());
                            int n = ServiceFactory.getStudentServiceInstance().updateStudent(student);
                            if (n == 1){
                                model.setValueAt(stuAddressField.getText(),row,5);
                                model.setValueAt(stuPhoneField.getText(),row,6);
                                stuAddressField.setEditable(false);
                                stuAddressField.setEnabled(false);
                                stuPhoneField.setEditable(false);
                                stuPhoneField.setEnabled(false);
                                upDateBtn.setText("编辑");
                            }
                        }
                    }
                });
                if (e.getButton() == 3){
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(row,0).toString();
                int choice = JOptionPane.showConfirmDialog(tablePanel,"确定要删除吗？");
                if (choice == 0){
                    if(row != -1){
                        model.removeRow(row);
                    }
                    ServiceFactory.getStudentServiceInstance().deleteStuById(id);
                }
            }
        });
    }
    private void showClass() {
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departmentList);
        showTree(departmentList);
        showClasses(departmentList);
    }
    private void showCombobox(List<Department> departmentList) {
        for (Department department:departmentList) {
            decomboBox.addItem(department);
        }
    }
    private void showTree(List<Department> departmentList){
        treePanel.removeAll();
        //左边JTree
        school = new DefaultMutableTreeNode("南工院");
        for (Department department:departmentList) {
            sDepartment = new DefaultMutableTreeNode(department.getDepartmentName());
            school.add(sDepartment);
            List<Map> cClassList = ServiceFactory.getCClassServiceInstance().selectClassInfo(department.getId());
            for (Map map:cClassList) {
                DefaultMutableTreeNode cSClass = new DefaultMutableTreeNode( map.get("cClass")+ "  "
                       + map.get("studentCount") + "人");
                sDepartment.add(cSClass);
            }
        }
        final JTree schoolTree = new JTree(school);
        schoolTree.setRowHeight(30);
        schoolTree.setFont(new Font("微软雅黑",Font.PLAIN,20));
        treePanel.add(schoolTree);
        treePanel.revalidate();
    }
    private void showClasses(List<Department> departmentList){
        classContentPanel.removeAll();
        //rightSP.setViewportView(classContentPanel);
        for (Department department: departmentList) {
            ImgPanel imgPanel = new ImgPanel();
            imgPanel.setFileName("border4.png");
            imgPanel.repaint();
            imgPanel.setPreferredSize(new Dimension(400,400));
            imgPanel.setLayout(null);
            JLabel nameLabel = new JLabel(department.getDepartmentName());
            nameLabel.setFont(font);
            nameLabel.setBounds(130,30,200,30);
            List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            DefaultListModel listModel = new DefaultListModel();
            for (CClass cClass:cClassList) {
                listModel.addElement(cClass);
            }
            JList<CClass> jList =  new JList<>(listModel);
            JScrollPane listScrollPane = new JScrollPane(jList);
            listScrollPane.setBounds(100,100,200,150);

            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item1 = new JMenuItem("修改");
            JMenuItem item2 = new JMenuItem("删除");
            jPopupMenu.add(item1);
            jPopupMenu.add(item2);
            jList.add(jPopupMenu);
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //选中项的下标
                    index = jList.getSelectedIndex();
                    //点击鼠标右键
                    if (e.getButton() == 3){
                        //在鼠标位置弹出菜单
                        jPopupMenu.show(jList,e.getX(),e.getY());
                        //取出选项中的数据
                        cClass = jList.getModel().getElementAt(index);
                    }
                }
            });
            //对“删除”选项监听
            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int choice = JOptionPane.showConfirmDialog(depPanel,"确定删除吗？");
                    if (choice == 0){
                        ServiceFactory.getCClassServiceInstance().deleteClassById(cClass.getId());
                        listModel.remove(index);
                        showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                    }
                }
            });

            imgPanel.add(nameLabel);
            imgPanel.add(listScrollPane);
            classContentPanel.add(imgPanel);
        }
    }
    private void showDepartments() {
        //移除原有数据
        contentPanel.removeAll();
        //从service层获取到所有院系列表
        List<Map> departmentList = ServiceFactory.getDepartmentServiceInstance().selectDepartmentInfo();
        GridLayout gridLayout = new GridLayout(0, 4, 15, 15);
        contentPanel.setLayout(gridLayout);
        for (Map map : departmentList) {
            //给每个院系对象创建一个面板
            depPanel = new JPanel();
            Department department = (Department) map.get("department");
            int classCount = (int) map.get("classCount");
            int studentCount = (int) map.get("studentCount");
            depPanel.setPreferredSize(new Dimension(200, 200));
            depPanel.setBackground(Color.WHITE);
            //将院系名称设置给面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个Label用来放置院系logo，并指定大小
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' width=200 height=200/></html>");
            logoLabel.setMaximumSize(new Dimension(200,200));
            logoLabel.setMinimumSize(new Dimension(200,200));
            JLabel infoLabel = new JLabel("班级" + classCount + "个  学生" + studentCount + "人");
            depPanel.add(infoLabel);
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            deleteButton = new JButton("删除");
            depPanel.add(deleteButton);
            //院系面板加入主体内容面板
            contentPanel.add(depPanel);
            //刷新主体内容面板
            contentPanel.revalidate();
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");
                    // 判断用户是否点击
                    if (result == JOptionPane.OK_OPTION) {
                        //从流式面板移除当前这个人的布局
                        contentPanel.remove(depPanel);
                        int id = department.getId();
                        //删除这行记录
                        departmentService.deleteDepartmentById(id);
                        contentPanel.revalidate();
                    }
                }
            });
        }
    }
    private void showAddRewCombox(){
        Department tip1 = new Department();
        tip1.setDepartmentName("请选择院系");
        addRewDepComboBox.addItem(tip1);
        CClass tip2 = new CClass();
        tip2.setClassName("请选择班级");
        addRewClaComboBox.addItem(tip2);
        StudentVO tip3 = new StudentVO();
        tip3.setStudentName("请选择学生");
        addRewNamComboBox.addItem(tip3);
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        for (Department department:departmentList) {
            addRewDepComboBox.addItem(department);
        }
        List<CClass> classList = ServiceFactory.getCClassServiceInstance().selectAllClass();
        for (CClass cClass:classList) {
            addRewClaComboBox.addItem(cClass);
        }
        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
        for (StudentVO student :studentList) {
            addRewNamComboBox.addItem(student);
        }
        addRewDepComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addRewDepComboBox.getSelectedIndex();
                    //排除第一项提示信息
                    if (index != 0 ){
                        departmentId = addRewDepComboBox.getItemAt(index).getId();
                        //二级联动
                        List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                        //
                        addRewClaComboBox.removeAllItems();
                        CClass tip = new CClass();
                        tip.setClassName("请选择班级");
                        addRewClaComboBox.addItem(tip);
                        for (CClass cClass:cClassList) {
                            addRewClaComboBox.addItem(cClass);
                        }
                    }
                }
            }
        });
        addRewClaComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addRewClaComboBox.getSelectedIndex();
                    if (index != 0){
                        int classId = addRewClaComboBox.getItemAt(index).getId();
                        //三级联动
                        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().getStuByClassId(classId);
                        //
                        addRewNamComboBox.removeAllItems();
                        StudentVO tip = new StudentVO();
                        tip.setStudentName("请选学生");
                        addRewNamComboBox.addItem(tip);
                        for (StudentVO student:studentList) {
                            addRewNamComboBox.addItem(student);
                        }
                    }
                }
            }
        });
        addRewNamComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addRewNamComboBox.getSelectedIndex();
                    if (index != 0){
                        String studentId = addRewNamComboBox.getItemAt(index).getId();
                        addRewIdLabel.setText(studentId);
                    }
                }
            }
        });
    }
    private void showAddPunCombox(){
        Department tip1 = new Department();
        tip1.setDepartmentName("请选择院系");
        addPunDepComboBox.addItem(tip1);
        CClass tip2 = new CClass();
        tip2.setClassName("请选择班级");
        addPunClaComboBox.addItem(tip2);
        StudentVO tip3 = new StudentVO();
        tip3.setStudentName("请选择学生");
        addPunNamComboBox.addItem(tip3);
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        for (Department department:departmentList) {
            addPunDepComboBox.addItem(department);
        }
        List<CClass> classList = ServiceFactory.getCClassServiceInstance().selectAllClass();
        for (CClass cClass:classList) {
            addPunClaComboBox.addItem(cClass);
        }
        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
        for (StudentVO student :studentList) {
            addPunNamComboBox.addItem(student);
        }
        addPunDepComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addPunDepComboBox.getSelectedIndex();
                    //排除第一项提示信息
                    if (index != 0 ){
                        departmentId = addPunDepComboBox.getItemAt(index).getId();
                        //二级联动
                        List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                        //
                        addPunClaComboBox.removeAllItems();
                        CClass tip = new CClass();
                        tip.setClassName("请选择班级");
                        addPunClaComboBox.addItem(tip);
                        for (CClass cClass:cClassList) {
                            addPunClaComboBox.addItem(cClass);
                        }
                    }
                }
            }
        });
        addPunClaComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addPunClaComboBox.getSelectedIndex();
                    if (index != 0){
                        int classId = addPunClaComboBox.getItemAt(index).getId();
                        //三级联动
                        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().getStuByClassId(classId);
                        //
                        addPunNamComboBox.removeAllItems();
                        StudentVO tip = new StudentVO();
                        tip.setStudentName("请选学生");
                        addPunNamComboBox.addItem(tip);
                        for (StudentVO student:studentList) {
                            addPunNamComboBox.addItem(student);
                        }
                    }
                }
            }
        });
        addPunNamComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = addPunNamComboBox.getSelectedIndex();
                    if (index != 0){
                        String studentId = addPunNamComboBox.getItemAt(index).getId();
                        addPunIdLabel.setText(studentId);
                    }
                }
            }
        });
    }
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.PLAIN, 22);
        Dimension dimension = new Dimension(180, 30);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date,DefaultFormat,font,dimension);

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
    public static void main(String[] args)throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new AdminMainFrame(DAOFactory.getAdminDAOInstance().getAdminByAccount("aaa@qq.com"));
    }
}
