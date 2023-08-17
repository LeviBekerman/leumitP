package ui.pages.manager;

import lombok.Getter;
import ui.driver.Browser;
import ui.pages.manager.pages.sportSite.home.SportHomePage;
import ui.pages.manager.pages.w3scool.table.html.HtmlPage;

@Getter
public class PageManager {
    SportHomePage sportHomePage;
    HtmlPage htmlPage;
    public PageManager(Browser browser){
        sportHomePage = new SportHomePage(browser);
        htmlPage = new HtmlPage(browser);
    }
}
