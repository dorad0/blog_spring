package blog.service.pagination.core;

import blog.dao.GenericDAO;

import javax.transaction.Transactional;

/**
 * Created by Alex on 06.02.2015.
 */
@Transactional
public abstract class PaginationManager<T, D extends GenericDAO<T>> implements Pagination<T> {

    public static final int DEFAULT_PAGE_SIZE = 5;
    public static final int DEFAULT_FIRST_ELEMENT = 0;
    public static final int DEFAULT_FIRST_PAGE_NUMBER = 1;

    protected D dao;
    protected int pageSize = DEFAULT_PAGE_SIZE;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    protected int countPages(int items, int pageSize) {
        int pages;
//        if(pages == 0) throw new Exception();
        if (items <= pageSize) {
            pages = 1;
        } else if (items % pageSize == 0) {
            pages = items / pageSize;
        } else
            pages = items / pageSize + 1;
        return pages;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    public Page<T> getPage(int pageNumber, int pageSize) {

        int items = dao.getCount().intValue();
        int fromElement = DEFAULT_FIRST_ELEMENT;
        int pages = countPages(items, pageSize);
//        if(pageNumber <= 0 || pageNumber > pages)
//            throw new Exception();
        this.pageSize = pageSize;
                if(pageNumber <= 0 || pageNumber > pages)
                    pageNumber = DEFAULT_FIRST_ELEMENT;
        if (pageNumber > 1) {
            fromElement = (pageNumber - 1) * pageSize;
            return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize));
        }
        return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize));
    }

    public Page<T> getFirstPage() {
        return getPage(DEFAULT_FIRST_PAGE_NUMBER);
    }

    public Page<T> getPage(int pageNumber) {
        return getPage(pageNumber, pageSize);
    }
}
