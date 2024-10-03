
package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement tableElement;
    private List<UIElement> rows;
    private List<UIElement> cells;
    private WebDriver driver;

    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.tableElement = new UIElement(driver, by);
    }

    public UIElement getRow(int indexRow) {
        rows = new ArrayList<>();
        for (UIElement element : tableElement.findUIElements(By.xpath("//tr[@data-testid != 'row-header']"))) {
            rows.add(element);
        }
        return rows.get(indexRow);
    }

    public UIElement getCell(int indexRow, int indexCell) {
        cells = new ArrayList<>();
        for (UIElement element: getRow(indexRow).findUIElements(By.tagName("td"))) {
            cells.add(element);
        }
        return cells.get(indexCell);
    }
}