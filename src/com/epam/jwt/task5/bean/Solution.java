package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Solution implements Serializable {
    private int id;
    private int studentId;
    private int taskId;
    private int mark;
    private String answer;
    private String attachments;
    private boolean isAccepted;

    public Solution() {
    }

    public Solution(int id, int studentId, int taskId, int mark, String answer, String attachments, boolean isAccepted) {
        this.id = id;
        this.studentId = studentId;
        this.taskId = taskId;
        this.mark = mark;
        this.answer = answer;
        this.attachments = attachments;
        this.isAccepted = isAccepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
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

        Solution solution = (Solution) obj;

        if (id != solution.id) {
            return false;
        }
        if (studentId != solution.studentId) {
            return false;
        }
        if (taskId != solution.taskId) {
            return false;
        }
        if (mark != solution.mark) {
            return false;
        }
        if (isAccepted != solution.isAccepted) {
            return false;
        }
        if (null == answer) {
            return (answer == solution.answer);
        } else {
            if (!answer.equals(solution.answer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((id * 11) + (studentId * 31) + (taskId * 17) + (isAccepted ? 1* 19 : 0 ) + (mark * 13) +
                ((null == answer) ? 0 : (answer.hashCode() * 11) +
                        ((null == attachments) ? 0 : (attachments.hashCode() * 31))));
    }

    @Override
    public String toString() {
        return getClass().getName() + "id: " + id + ", studentId: " + studentId + ", taskId: " + taskId +
                ", mark: " + mark + ", statusId: " + ", answer: " + answer + ", attachments: " + attachments +
                ", isAccepted: " + isAccepted;
    }
}
