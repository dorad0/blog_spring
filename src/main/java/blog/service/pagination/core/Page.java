package blog.service.pagination.core;

import java.util.List;

public class Page<T> {

    private int pageNumber;
    private int pages;
    private List<T> entities;
    private boolean next;
    private boolean previous;
    private int nextPage;
    private int previousPage;

    public int getNextPage() {
        if (next) //or exception NoSuchPageException
            return nextPage;
        return pageNumber;
    }

    public int getPreviousPage() {
        if (previous)
            return previousPage;
        return pageNumber;
    }

    public boolean isPrevious() {
        return previous;
    }

    public Page(int pageNumber, int pages, List<T> entities) {
        this.pageNumber = pageNumber;
        this.pages = pages;
        this.entities = entities;
        this.nextPage = pageNumber + 1;
        this.previousPage = pageNumber - 1;
        this.next = nextPage <= pages;
        this.previous = previousPage >= 1;
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
