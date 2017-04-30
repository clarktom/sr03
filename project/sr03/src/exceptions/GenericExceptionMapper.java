//package exceptions;
//
//import beans.ErrorMessage;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
///**
// * Created by tompu on 29/04/2017.
// */
//@Provider
//public class GenericExceptionMapper implements ExceptionMapper<Exception> {
//
//    @Override
//    public Response toResponse(Exception e) {
//        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500);
//        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                .entity(errorMessage)
//                .build();
//    }
//}