package blog.service.pagination;

/**
 * Created by Alex on 13.03.2015.
 */
public interface Pageable<T> {

    Pagination<T> getPagination();

}
