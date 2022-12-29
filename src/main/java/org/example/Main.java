package org.example;

import javax.swing.*;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        table();
        Student student1_1 = new Student("f1asd", "asda", "mdflsjhjsad@dsfklk");
        Student student1_2 = new Student("sdggd", "fghjn f", "sgms,jmsl@dsfklk");
        Student student1_3 = new Student("xcgsdsg", "fggggd", "fklsdxnmv@dsfklk");


        dao.save(student1_1);
        dao.save(student1_2);
        dao.save(student1_3);

        Student student2_1 = dao.getById(student1_1.getId());
        Student student2_2 = dao.getById(student1_2.getId());
        Student student2_3 = dao.getById(student1_3.getId());

        student1_1.setFirstname("normal");
        dao.update(student1_1);


        dao.getAllStudents().forEach(System.out::println);

        dao.delete(student1_1.getId());
    }

    private static void table() {
        JFrame frame = new JFrame();
        String[][] data = loadData();

        // Column Names
        String[] columnNames = { "id", "email", "firstname", "lastname" };

        // Initializing the JTable
        JTable table = new JTable(data, columnNames);
        table.setDefaultEditor(Object.class, null);
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
        frame.setVisible(true);    }

    private static String[][] loadData() {
        List<Student> list = dao.getAllStudents();

        String[][] data = new String[list.size()][4];
        IntStream.range(0, list.size()).forEach(i -> {
            Student student = list.get(i);
            data[i][0] = String.valueOf(student.getId());
            data[i][1] = student.getEmail();
            data[i][2] = student.getFirstname();
            data[i][3] = student.getLastname();
        });
        return data;
    }
}
