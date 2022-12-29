package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FinalTableModel extends AbstractTableModel {

    private List<Student> list;
    private final String[] columnNames = {"id", "email", "firstname", "lastname"};

    public FinalTableModel(List<Student> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getId();
            case 1:
                return student.getEmail();
            case 2:
                return student.getFirstname();
            case 3:
                return student.getLastname();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 3:
            case 2:
                return String.class;
        }
        return null;
    }
}