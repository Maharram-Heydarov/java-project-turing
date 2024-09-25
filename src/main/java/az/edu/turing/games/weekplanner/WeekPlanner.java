package az.edu.turing.games.weekplanner;

import java.util.Optional;

public class WeekPlanner {
    private Day[] schedule;

    public WeekPlanner() {
        schedule = new Day[7];
        schedule[0] = new Day("Sunday", "go to the GYM");
        schedule[1] = new Day("Monday", "go to the course");
        schedule[2] = new Day("Tuesday", "read book");
        schedule[3] = new Day("Wednesday", "hang out with friends");
        schedule[4] = new Day("Thursday", "relax and visit");
        schedule[5] = new Day("Friday", "prepare task");
        schedule[6] = new Day("Saturday", "attend a conference");
    }

    public Optional<Day> findDay(String dayName) {
        for (Day day : schedule) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                return Optional.of(day);
            }
        }
        return Optional.empty();
    }

    public void changeTask(String dayName, String newTask) {
        Optional<Day> optionalDay = findDay(dayName);
        optionalDay.ifPresent(day -> day.setTask(newTask));
    }

    public Day[] getSchedule() {
        return schedule;
    }
}
