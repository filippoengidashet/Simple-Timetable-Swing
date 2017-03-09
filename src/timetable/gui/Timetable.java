package timetable.gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import timetable.model.Task;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import timetable.callback.TaskActionListener;
import timetable.helper.JOptionPaneHelper;
import timetable.manager.DatabaseManager;
import timetable.model.AppConstants;
import timetable.model.CellTimetable;
import timetable.model.Subject;
import timetable.render.SubjectCellEditor;
import timetable.render.SubjectDropDownCellRenderer;
import timetable.render.TaskPriorityCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pri
 */
public class Timetable extends javax.swing.JFrame implements TaskActionListener.AddTaskActionListener,
        TaskActionListener.ModifyTaskActionListener {

    private final DefaultListModel<Task> taskListModel;

    /**
     * Creates new form Timetable
     */
    public Timetable() {
        initComponents();
        this.taskListModel = new DefaultListModel<>();
        this.taskList.setModel(taskListModel);
        this.taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.taskList.setCellRenderer(new TaskPriorityCellRenderer());
        DatabaseManager.getInstance();

        refreshTasks();
        refreshTimetable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        weeklyTimetable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskList = new javax.swing.JList<>();
        addTask = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        preferenceMenu = new javax.swing.JMenu();
        resetTimetable = new javax.swing.JMenuItem();
        manageSubjects = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        weeklyTimetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null},
                {"2", null, null, null, null, null, null},
                {"3", null, null, null, null, null, null},
                {"4", null, null, null, null, null, null},
                {"5", null, null, null, null, null, null},
                {"6", null, null, null, null, null, null},
                {"7", null, null, null, null, null, null},
                {"8", null, null, null, null, null, null},
                {"9", null, null, null, null, null, null},
                {"10", null, null, null, null, null, null}
            },
            new String [] {
                "Lesson number", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            }
        ));
        jScrollPane1.setViewportView(weeklyTimetable);

        taskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taskList);

        addTask.setText("Add task");
        addTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetable/assets/close_icon.png"))); // NOI18N
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenu);

        jMenuBar1.add(fileMenu);

        preferenceMenu.setText("Preferences");

        resetTimetable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        resetTimetable.setText("Reset Timetable");
        resetTimetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTimetableActionPerformed(evt);
            }
        });
        preferenceMenu.add(resetTimetable);

        manageSubjects.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        manageSubjects.setText("Manage Subjects");
        manageSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSubjectsActionPerformed(evt);
            }
        });
        preferenceMenu.add(manageSubjects);

        jMenuBar1.add(preferenceMenu);

        helpMenu.setText("Help");

        aboutMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetable/assets/info_icon.png"))); // NOI18N
        aboutMenu.setText("About");
        helpMenu.add(aboutMenu);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addTask)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addTask)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskActionPerformed
        // TODO add your handling code here:
        AddTask addTaskWindow = new AddTask(this, true);
        addTaskWindow.setTaskActionListener(this);
        addTaskWindow.setLocationRelativeTo(this);
        addTaskWindow.setTitle("Add Task");
        addTaskWindow.setVisible(true);
    }//GEN-LAST:event_addTaskActionPerformed

    private void taskListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskListMouseClicked
        if (evt.getClickCount() == 2) {
            int index = taskList.locationToIndex(evt.getPoint());
            Task selectedTask = taskListModel.get(index);
            ModifyTask modifyTaskWindow = new ModifyTask(this, true);
            modifyTaskWindow.setTaskActionListener(this);
            modifyTaskWindow.setSelectedTask(selectedTask);
            modifyTaskWindow.setLocationRelativeTo(this);
            modifyTaskWindow.setTitle(AppConstants.TITLE_MODIFY_TASK);
            modifyTaskWindow.setVisible(true);
        }
    }//GEN-LAST:event_taskListMouseClicked

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    private void manageSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSubjectsActionPerformed
        AddSubject subjectWindow = new AddSubject(this, true);
        subjectWindow.setActionListener(new AddSubject.OnSubjectActionListener() {
            @Override
            public void refresh() {
                refreshTimetable();
            }
        });
        subjectWindow.setTitle(AppConstants.TITLE_MANAGE_SUBJECTS);
        subjectWindow.setLocationRelativeTo(this);
        subjectWindow.setVisible(true);
    }//GEN-LAST:event_manageSubjectsActionPerformed

    private void resetTimetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTimetableActionPerformed
        int confirm = JOptionPaneHelper.showConfirmationMessage(this, "You want to reset the timetable?", "Confirm");
        if (confirm == 0) {
            DatabaseManager.getInstance().emptyTimetables();
            refreshTimetable();
        }
    }//GEN-LAST:event_resetTimetableActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JButton addTask;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem manageSubjects;
    private javax.swing.JMenu preferenceMenu;
    private javax.swing.JMenuItem resetTimetable;
    private javax.swing.JList<Task> taskList;
    private javax.swing.JTable weeklyTimetable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onTaskAdded(Task task) {
        DatabaseManager.getInstance().saveTask(task);
        refreshTasks();
    }

    @Override
    public void onTaskUpdated(Task task) {
        DatabaseManager.getInstance().updateTask(task);
        refreshTasks();
    }

    @Override
    public void onTaskDeleted(int taskId) {
        DatabaseManager.getInstance().removeTask(taskId);
        refreshTasks();
    }

    private void refreshTasks() {
        List<Task> allTasks = DatabaseManager.getInstance().getAllTasks();
        this.taskListModel.clear();
        for (int i = 0; i < allTasks.size(); i++) {
            this.taskListModel.addElement(allTasks.get(i));
        }
    }

    private void refreshTimetable() {

        DefaultTableModel dm = (DefaultTableModel) weeklyTimetable.getModel();
        dm.fireTableDataChanged();

        JComboBox<Subject> subjectsComboBox = new JComboBox<>();
        Map<Integer, Subject> map = new HashMap();

        List<Subject> allSubjects = DatabaseManager.getInstance().getAllSubjects();
        if (allSubjects != null) {
            for (int i = 0; i < allSubjects.size(); i++) {
                Subject subjectItem = allSubjects.get(i);
                subjectsComboBox.addItem(subjectItem);
                map.put(subjectItem.getSubjectID(), subjectItem);
            }
        }

        subjectsComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedRow = weeklyTimetable.getSelectedRow();
                    int selectedColumn = weeklyTimetable.getSelectedColumn();

                    Subject selectedSubject = (Subject) e.getItem();

                    System.out.println(selectedSubject.getName() + " selected " + " :: " + selectedSubject.getSubjectID() + " " + selectedColumn + " :: " + selectedRow);
                    DatabaseManager.getInstance().saveCellTimeTable(selectedSubject, selectedColumn, selectedRow);
                }
            }
        });

        for (int columnIndex = 1; columnIndex <= 6; columnIndex++) {
            TableColumn tableColumn = this.weeklyTimetable.getColumnModel().getColumn(columnIndex);
            tableColumn.setCellEditor(new SubjectCellEditor(subjectsComboBox));
            tableColumn.setCellRenderer(new SubjectDropDownCellRenderer());
        }

        List<CellTimetable> allTimetables = DatabaseManager.getInstance().getAllTimetables();
        for (int k = 0; k < allTimetables.size(); k++) {
            CellTimetable cellTimetable = allTimetables.get(k);
            weeklyTimetable.getModel().setValueAt(map.get(cellTimetable.getSubjectID()), cellTimetable.getCellRow(), cellTimetable.getCellColumn());
        }
    }
}