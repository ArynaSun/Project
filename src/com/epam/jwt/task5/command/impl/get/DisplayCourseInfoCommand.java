package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.dto.CourseDTO;
import com.epam.jwt.task5.dto.SolutionDTO;
import com.epam.jwt.task5.dto.TaskSolutionsDTO;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class DisplayCourseInfoCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayCourseInfoCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> students;
        List<Task> taskList;
        Course course;
        List<TaskSolutionsDTO> taskSolutionsDTOS = new ArrayList<>();

        Map<String, String> map = new HashMap<>();

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            course = commonService.findCourse(request.getParameter(RequestParameter.COURSE_ID));
            String courseId = String.valueOf(course.getId());

            map.put(RequestParameter.COURSE_ID, courseId);

            students = commonService.findStudentsBy(courseId);
            taskList = commonService.findTasks(courseId);
            if (taskList != null) {
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.get(i);
                    TaskSolutionsDTO dto = new TaskSolutionsDTO();
                    dto.setTask(task);
                    List<Solution> solutionList = commonService.findSolutions(String.valueOf(task.getId()));
                    List<SolutionDTO> solutionDTOList = new ArrayList<>();
                    for (Solution solution : solutionList) {
                        SolutionDTO solutionDTO = new SolutionDTO();
                        solutionDTO.setSolution(solution);
                        solutionDTO.setStudentName(commonService.findUserById(solution.getStudentId() + "").getName());
                        solutionDTOList.add(solutionDTO);
                    }
                    dto.setSolutions(!solutionDTOList.isEmpty() ? solutionDTOList : new ArrayList<>());
                    taskSolutionsDTOS.add(dto);
                }
            }

            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourse(course);
            courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());
            courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());

            request.setAttribute(JspAttribute.STUDENTS, students);
            request.setAttribute(JspAttribute.COURSE, courseDTO);
            request.setAttribute(JspAttribute.TASK_SOLUTIONS, taskSolutionsDTOS);
            request.setAttribute(JspAttribute.COURSE_STATUSES, Arrays.asList(CourseStatus.values()));
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return new JspPage(JspPage.COURSE_INFO, map);
    }
}
