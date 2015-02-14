package blog.service.pagination.core;

/**
 * Created by Alex on 06.02.2015.
 */
public interface Pagination<T> {
    Page<T> getPage(int pageNumber, int pageSize);
    Page<T> getPage(int pageNumber);
}
