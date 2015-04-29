package blog.web.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

//    /**
//     * Convert a predefined exception to an HTTP Status code
//     */
//    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
//    // 409
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public void conflict() {
////        logger.error("Request raised a DataIntegrityViolationException");
//        // Nothing to do
//    }
//
//    /**
//     * Demonstrates how to take total control - setup a model, add useful
//     * information and return the "support" view name. This method explicitly
//     * creates and returns
//     *
//     * @param req       Current HTTP request.
//     * @param exception The exception thrown - always {@link SupportInfoException}.
//     * @return The model and view used by the DispatcherServlet to generate
//     * output.
//     * @throws Exception
//     */
//
//    @ExceptionHandler({CannotCreateTransactionException.class, DataAccessException.class})
//    public ModelAndView databaseError(HttpServletRequest req, Exception exception)
//            throws Exception {
//
//        // Rethrow annotated exceptions or they will be processed here instead.
//        if (AnnotationUtils.findAnnotation(exception.getClass(),
//                ResponseStatus.class) != null)
//            throw exception;
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.addObject("url", req.getRequestURL());
//        mav.addObject("timestamp", new Date().toString());
//        mav.addObject("status", 500);
//        mav.setViewName("databaseError");
//
//        return mav;
//    }
//
//    // Total control - setup a model and return the view name yourself. Or consider
//    // subclassing ExceptionHandlerExceptionResolver (see below).
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }
}
