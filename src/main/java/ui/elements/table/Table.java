package ui.elements.table;

import enums.ui.locators.LocatorsStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.driver.Browser;
import ui.elements.BaseElement;
import ui.elements.ElementList;
import ui.elements.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static enums.ui.locators.LocatorsStrategy.TAG_NAME;
import static enums.ui.locators.LocatorsStrategy.XPATH;
import static java.util.stream.Collectors.toList;
import static ui.elements.table.Row.*;

public class Table extends BaseElement {
    String CELL_XPATH = "//child::tr[{ROW_NUM}]/td[{CELL_NUM}]";
    public List<Row> rows = new ArrayList<>();

    public Table(Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(browser, locatorsStrategy, selector);
    }

    public Table(BaseElement fatherElement, Browser browser, LocatorsStrategy locatorsStrategy, String selector) {
        super(fatherElement, browser, locatorsStrategy, selector);
    }

    public Table(Browser browser, Supplier<WebElement> webElementSupplier) {
        super(browser, webElementSupplier);
    }

    public String getTableCelText(int searchColumn, String searchText, int returnColumnText) {
        initRows();
        if (searchText != null || searchText.length() > 0) {
            return getRowBy(searchColumn, searchText, rows).getCells().get(returnColumnText - 1).getValue();
        } else {
            throw new RuntimeException("searchText parameter  Can't by empty or null");
        }
    }

    public String getTableCelText(String searchColumn, String searchText, int returnColumnText) {
        initRows();
        if (searchText != null || searchText.length() > 0) {
            return getRowByTitle(searchColumn, rows).getCells().get(returnColumnText - 1).getValue();
        } else {
            throw new RuntimeException("searchText parameter Can't by empty or null");
        }
    }

    public String getTableCelTextByXpath(int searchColumn, String searchText, int returnColumnText) {
        initRows();
        if (searchText != null || searchText.length() > 0) {
            String cellXpath = "";
            Row row = getRowBy(searchColumn, searchText, rows);
            cellXpath = getCellXpath(getRowIndex(row), returnColumnText);
            Label cellLabel = new Label(this, browser, XPATH, cellXpath);
            return cellLabel.getText();
        } else {
            throw new RuntimeException("searchText parameter  Can't by empty or null");
        }
    }

    public List<String> getAllColumnValuesByIndex(int columnIndex) {
        return rows.stream().map(row -> row.cells.get(columnIndex).getValue()).collect(toList());
    }

    public List<String> getAllColumnValuesByName(String columnName) {
        return rows.stream().map(row -> row.getValueByColumnName(columnName)).collect(toList());
    }

    public List<String> getTitles() {
        return rows.get(0).getCells().stream().map(Cell::getTitle).collect(toList());
    }

    public int getRowIndex(Row row) {
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            if (rows.get(rowIndex).getCells().containsAll(row.getCells())) {
                return rowIndex + 2;
            }
        }
        throw new RuntimeException("No fount match row");
    }

    public void initRows() {
        if (rows.size() == 0) {
            addAllRows();
        }
    }

    public void addAllRows() {
        List<String> titles = new ArrayList<>();

        ElementList<Label> rowsElement = new ElementList<>(this, browser, TAG_NAME, "tr", Label.class);
        for (int rowIndex = 0; rowIndex < rowsElement.getAll().size(); rowIndex++) {
            if (rowIndex == 0) {
                titles.addAll(getCellValues(rowsElement.getAll().get(0), true));
            } else {
                List<Cell> cells = new ArrayList<>();
                List<String> celleValues = getCellValues(rowsElement.getAll().get(rowIndex), false);
                for (int cellIndex = 0; cellIndex < titles.size(); cellIndex++) {
                    cells.add(new Cell(titles.get(cellIndex), celleValues.get(cellIndex)));
                }
                rows.add(new Row(cells));
            }
        }
        ;
    }

    private List<String> getCellValues(BaseElement element, boolean isTitles) {
        String tagName = isTitles ? "th" : "td";
        List<String> celleValues = new ArrayList<>(element.getElement().findElements(By.tagName(tagName)).stream().map(title -> title.getText()).collect(toList()));
        return celleValues;
    }

    private String getCellXpath(int rowIndex, int cellIndex) {
        return CELL_XPATH.replace("{ROW_NUM}", Integer.toString(rowIndex)).replace("{CELL_NUM}", Integer.toString(cellIndex));
    }
}
