package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.bean.Task;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.dto.TaskSolutionsDTO;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DisplayCourseInfoCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayCourseInfoCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> students;
        List<Task> taskList;
        Course course;
        List<TaskSolutionsDTO> taskSolutionsDTOS = new ArrayList<>();

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            course = commonService.findCourse(request.getParameter(RequestParameter.COURSE_ID));
            String courseId = String.valueOf(course.getId());

            students = commonService.findStudentsBy(courseId);
            taskList = commonService.findTasks(courseId);
            if (taskList != null) {
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.get(i);
                    TaskSolutionsDTO dto = new TaskSolutionsDTO();
                    dto.setTask(task);
                    List<Solution> solutionList = commonService.findSolutions(String.valueOf(task.getId()));
                    dto.setSolutions(solutionList != null ? solutionList : new ArrayList<>());
                }
            }

            request.setAttribute(JspAttribute.STUDENTS, students);
            request.setAttribute(JspAttribute.TASKS, taskList);
            request.setAttribute(JspAttribute.COURSE, course);
            request.setAttribute(JspAttribute.TASK_SOLUTIONS, taskSolutionsDTOS);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.COURSE_INFO;
    }
}
