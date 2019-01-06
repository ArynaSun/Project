package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.bean.RequestStatus;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.AdminService;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddingStudentToCourseCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(AddingStudentToCourseCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        AdminService adminService = ServiceHelper.getAdminService();

        String studentId = request.getParameter(RequestParameter.STUDENT_ID);
        String courseId = request.getParameter(RequestParameter.COURSE_ID);
        String requestId = request.getParameter(RequestParameter.REQUEST_ID);

        JspPage jspPage;

        try {
            adminService.addStudentToCourse(studentId,courseId );
            adminService.changeRequestStatus(requestId, String.valueOf(RequestStatus.IS_ACCEPTED.getId()));
            jspPage = new JspPage(JspPage.ADMIN_PAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));

        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            jspPage = JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            jspPage = new JspPage(JspPage.ADMIN_PAGE, e.getMessage());
        }

        return jspPage;
    }
}
