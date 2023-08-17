package ui.elements.table;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
@Getter
public class Row {
    protected List<Cell> cells;


    public String getValueByColumnName(String columnName) {
        return cells.stream().filter(cell ->
                cell.getTitle().equals(columnName)).findFirst().get().getValue();
    }

    public boolean isEqualsToOneCellTitle(String title) {
        return isEqualsToOneCell(cell -> cell.getTitle().equals(title));
    }

    public boolean isEqualsToOneCellValue(String value) {
        return isEqualsToOneCell(cell -> cell.getValue().equals(value));
    }

    public static Row getRowByTitle(String columnName, List<Row> rows) {
        return rows.stream().filter(row -> row.isEqualsToOneCellTitle(columnName)).findFirst().get();
    }

    public static Row getRowByCellEquals(String columnValue, List<Row> rows) {
        return rows.stream().filter(row -> row.isEqualsToOneCellValue(columnValue)).findFirst().get();
    }

    /**
     * Search row by column index and cell value
     *
     * @param index int. begin from 1 and as display in site ant not from zero
     * @param columnValue
     * @param rows
     * @return Row
     */
    public static Row getRowBy(int index, String columnValue, List<Row> rows) {
        return rows.stream().filter(row -> row.getCells().get(index - 1).getValue().equals(columnValue)).findFirst().get();
    }


    public boolean isEqualsToOneCell(Predicate<Cell> predicate) {
        return cells.stream().anyMatch(predicate);
    }
}
