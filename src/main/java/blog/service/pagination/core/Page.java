package blog.service.pagination.core;

import java.util.List;

/**
 * Created by Alex on 06.02.2015.
 */
public class Page<T> {
    private int pageNumber;
    private int pages;
    private List<T> entities;
    private boolean next;
    private boolean previous;

    public boolean isPrevious() {
        return previous;
    }

    public Page(int pageNumber, int pages, List<T> entities) {
        this.pageNumber = pageNumber;
        this.pages = pages ;
        this.entities = entities;
        this.next = (pageNumber + 1) <= pages;
        this.previous = (pageNumber - 1) >= 0;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public List<T> getEntities() {
        return entities;
    }

    public int getPages() {
        return pages;
    }

    public boolean isNext() {
        return next;
    }
}
