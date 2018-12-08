package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private int courseId;
    private String name;
    private String attachments;
    private String assignmentDate;
    private String deadline;

    public Task() {
    }

    public Task(int id, int courseId, String name, String attachments, String assignmentDate, String deadline) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.attachments = attachments;
        this.assignmentDate = assignmentDate;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Task task = (Task) obj;
        if (id != task.id) {
            return false;
        }
        if (courseId != task.courseId) {
            return false;
        }
        if (null == name) {
            return (name == task.name);
        } else {
            if (!name.equals(task.name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((id * 31) + (courseId * 11) + ((name == null) ? 0 : name.hashCode()) * 11) +
                +((attachments == null) ? 0 : (attachments.hashCode()) * 13) +
                ((assignmentDate == null) ? 0 : (assignmentDate.hashCode()) * 17)
                + ((deadline == null) ? 0 : (deadline.hashCode()) * 31);
    }

    @Override
    public String toString() {
        return getClass().getName() + "id: " + id + ", courseId: " + courseId + ", name: "
                + name +  ", attachments: " + attachments + ", assignmentDate: "
                + assignmentDate + ", deadline: " + deadline;
    }
}
