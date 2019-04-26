package main.java;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

public class DueCalculator {
    List<String> weekDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    public DueCalculator() {
    }

    public String calculateDueDate(String reportedTime, int turnaround) {


        String[] report = reportedTime.split(" ");
        String reportDay = report[0];
        String submitTime = report[1];
        if (turnaround % 8 == 0) {
            return calculateDay(reportDay, turnaround) + " " + submitTime;
        } else {
            int hoursWithoutDays = turnaround % 8;
            int dueHour;
            int dayIndex = weekDays.indexOf(reportDay) + round(turnaround / 8);
            if (Character.toString(submitTime.charAt(1)).equals(":")) {
                dueHour = Integer.parseInt(Character.toString(submitTime.charAt(0))) + hoursWithoutDays;
            } else {
                dueHour = Integer.parseInt(Character.toString(submitTime.charAt(0)) + Character.toString(submitTime.charAt(1))) + hoursWithoutDays;
            }

            String amOrPm = submitTime.substring(submitTime.length() - 2);
            String dueHourFormatted = Integer.toString(dueHour);
            if (dueHour > 12) {

                dueHourFormatted = Integer.toString(dueHour - 12);
                amOrPm = "PM";


            }
            int findDelimiter = 1;
            if (Character.toString(submitTime.charAt(2)).equals(":")) {
                findDelimiter = 2;
            }
            if (amOrPm.equals("PM") && Integer.parseInt(dueHourFormatted) > 5){
                dueHourFormatted = Integer.toString((Integer.parseInt(dueHourFormatted) - 5) + 9);
                amOrPm = "AM";
                if (dayIndex == weekDays.size() - 1){
                    dayIndex = 0;
                }else {
                    dayIndex += 1;
                }

            }
            if (!submitTime.substring(submitTime.length() - 4, submitTime.length() - 2).equals("00") && dueHourFormatted.equals("5")){
                dueHourFormatted = "9";
                if (dayIndex == weekDays.size() - 1){
                    dayIndex = 0;
                }else {
                    dayIndex += 1;
                }
                amOrPm = "AM";
            }
            return weekDays.get(dayIndex) + " " + dueHourFormatted + submitTime.substring(findDelimiter, submitTime.length() - 2) + amOrPm;
        }
    }

    public String calculateDay(String reportDay, int turnaround) {
        if (weekDays.indexOf(reportDay) + (turnaround / 8) < weekDays.size()) {
            return weekDays.get(weekDays.indexOf(reportDay) + turnaround / 8);
        } else {
            int dayIndex = (turnaround / 8) % 5;
            if (weekDays.indexOf(reportDay) + dayIndex > weekDays.size()) {
                return weekDays.get(5 - (weekDays.indexOf(reportDay) + dayIndex));
            } else {
                return weekDays.get(weekDays.indexOf(reportDay) + dayIndex);
            }
        }
    }
}
