package agriculture.B_Controller.ExceptionHandle;

import agriculture.B_Controller.Exception.UserCreationFailureException;
import jdk.Exported;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Created by redrock on 15/12/22.
 */
@ControllerAdvice
public class UserExceptionHandlingControllerAdvice {
    protected Logger logger;

    public UserExceptionHandlingControllerAdvice(){
        logger= LoggerFactory.getLogger(getClass());
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){
        logger.error("Request raised a DataIntegrityVoilationException");
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String databaseError(Exception exception){
        logger.error("request raised "+ exception.getClass().getSimpleName());
        return "database error";
    }

    @ExceptionHandler(UserCreationFailureException.class)
    public String creationFailure(){
        return "creation failure, please try again";
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public String creationConflict(){
        return "username has already existed, please try another one!";
    }
}
