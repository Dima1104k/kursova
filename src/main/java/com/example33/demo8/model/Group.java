package com.example33.demo8.model;

public class Group {
    private String groupCode; // унікальний код або просто назва групи
    private String schedule;  // розклад занять для групи
    // Конструктори
    public Group(String groupCode) {
        this.groupCode = groupCode;
        this.schedule = ""; // Початкове значення розкладу
    }

    public Group(String groupCode, String schedule) {
        this.groupCode = groupCode;
        this.schedule = formatSchedule(schedule);
    }
    private String formatSchedule(String rawSchedule) {
        return rawSchedule.replace(",", ",<br/>");
    }
    // Гетери та сетери
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}