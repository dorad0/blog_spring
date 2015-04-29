package blog.aspect;

import blog.dao.exception.DaoException;
import blog.service.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public aspect ExceptionTranslationAspect {

    @Around("execution(* blog.dao..*(..)) &&" +
            "@annotation(blog.annotation.ExceptionTranslation)")
    public Object translateHibernateExceptionToDaoException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    @Around("execution(* blog.service..*(..)) &&" +
            "@annotation(blog.annotation.ExceptionTranslation)")
    public Object translateDaoExceptionToServiceException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
