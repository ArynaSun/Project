package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.AdminService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleRequestCommand implements CourseCommand {//todo
    private static Logger logger = LogManager.getLogger(HandleRequestCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        AdminService adminService = ServiceHelper.getAdminService();

        String requestId = request.getParameter(RequestParameter.REQUEST_ID);
        String statusId = request.getParameter(RequestParameter.REQUEST_STATUS_ID);

        try {
            adminService.changeRequestStatus(requestId, statusId);
            request.setAttribute(JspAttribute.SUCCESS_MESSAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e);
        }

        return JspPage.TEACHER_PAGE;
    }
}
