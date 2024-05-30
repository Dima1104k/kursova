package com.example33.demo8.dao;
import com.example33.demo8.model.Group;
import java.util.ArrayList;
import java.util.List;
public class StubGroupDao implements GroupDAO {
    private List<Group> groups ;

    public StubGroupDao() {
        this.groups = new ArrayList<>(); // Ініціалізація з деякими початковими даними

        this.groups.add(new Group("IA-33",
                "Понеділок: Фізика. Частина 2. Загальна фізика ІІ (08:30 - 10:05), Практичний курс іноземної мови. Частина 1. Foreign Language. Part I (10:25 - 12:00), Основи здорового способу життя (12:20 - 13:55)," +
                        "Вівторок: Фізика. Частина 2. Загальна фізика ІІ (08:30 - 10:05), Спеціальні розділи математики. Частина 2. Чисельні (10:25 - 12:00), Вища математика. Частина 2.(12:20 - 13:55)," +
                        "Середа: Українська мова за професійним спрямуванням (08:30 - 10:05), Програмування. Частина 2. Структури даних та алгоритми (10:25 - 12:00), Фізика. Частина 2. Загальна фізика ІІ (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50)," +
                        "Четвер: Спеціальні розділи математики. Частина 2. Чисельні (10:25 - 12:00), Програмування. Частина 2. Структури даних та алгоритми (12:20 - 13:55), Вища математика. Частина 2. (14:15 - 15:50)," +
                        "П’ятниця: Теорія алгоритмів (08:30 - 10:05), Фізика. Частина 2. Загальна фізика ІІ (10:25 - 12:00), Спеціальні розділи математики. Частина 2. Чисельні (12:20 - 13:55), Вища математика. Частина 2. Диференціальні та (14:15 - 15:50)."
        ));


        this.groups.add(new Group("IA-34",
                "Понеділок: Практичний курс іноземної мови. Частина 1. Foreign Language. Part I (08:30 - 10:05), Фізика. Частина 2. Загальна фізика (10:25 - 12:00)," +
                        "Вівторок: Основи здорового способу життя (8:30 - 10:05), Спеціальні розділи математики. Частина 2. Чисельні (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55)," +
                        "Середа: Українська мова за професійним спрямуванням (08:30 - 10:05), Програмування. Частина 2. Структури даних та алгоритми (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50), Теорія алгоритмів (16:10 - 17:45)," +
                        "Четвер: Програмування. Частина 2. Структури даних та алгоритми (08:30 - 10:05), Спеціальні розділи математики. Частина 2.(10:25 - 12:00), Українська мова за професійним спрямуванням (12:20 - 13:55), Вища математика. Частина 2. (14:15 - 16:10)," +
                        "П’ятниця:  Вища математика. Частина 2. Диференціальні та (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50)."
        ));

        this.groups.add(new Group("IA-31",
                "Понеділок: Практичний курс іноземної мови. Частина 1. Foreign Language. Part I (08:30 - 10:05), Фізика. Частина 2. Загальна фізика (10:25 - 12:00)," +
                        "Вівторок: Спеціальні розділи математики. Частина 2. Чисельні (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55)," +
                        "Середа: Українська мова за професійним спрямуванням (08:30 - 10:05), Програмування. Частина 2. Структури даних та алгоритми (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50), Теорія алгоритмів (16:10 - 17:45)," +
                        "Четвер: Програмування. Частина 2. Структури даних та алгоритми (08:30 - 10:05), Спеціальні розділи математики. Частина 2. (10:25 - 12:00), Українська мова за професійним спрямуванням (12:20 - 13:55), Вища математика. Частина 2.(14:15 - 16:10)," +
                        "П’ятниця: Основи здорового способу життя (10:25 - 12:00), Вища математика. Частина 2. (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50)."
        ));


        this.groups.add(new Group("IA-32", "Понеділок: Практичний курс іноземної мови. Частина 1. Foreign Language. Part I (08:30 - 10:05), Фізика. Частина 2. Загальна фізика (10:25 - 12:00)," +
                "Вівторок: Спеціальні розділи математики. Частина 2. Чисельні (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55)," +
                "Середа: Українська мова за професійним спрямуванням (08:30 - 10:05), Програмування. Частина 2. Структури даних та алгоритми (10:25 - 12:00), Фізика. Частина 2. Загальна фізика II (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50), Теорія алгоритмів (16:10 - 17:45)," +
                "Четвер: Програмування. Частина 2. Структури даних та алгоритми (08:30 - 10:05), Спеціальні розділи математики. Частина 2. (10:25 - 12:00), Українська мова за професійним спрямуванням (12:20 - 13:55), Вища математика. Частина 2. Диференціальні та інтегральні рівняння (14:15 - 16:10)," +
                "П’ятниця: Основи здорового способу життя (10:25 - 12:00), Вища математика. Частина 2. (12:20 - 13:55), Теорія алгоритмів (14:15 - 15:50)."
        ));
    }
    @Override
    public void addGroup(Group group) {
        if (!groupExists(group.getGroupCode())) {
            groups.add(group);
        }
    }
    @Override
    public void removeGroup(String groupName) {
        groups.removeIf(group -> groupName.equals(group.getGroupCode()));
    }
    @Override
    public Group getGroupByCode(String code) {
        return groups.stream()
                .filter(g -> g.getGroupCode().equals(code))
                .findFirst()
                .orElse(null);
    }
    @Override
    public void updateGroup(String oldCode, String newCode, String newSchedule ) {
        for (Group group : groups) {
            if (group.getGroupCode().equalsIgnoreCase(oldCode)) { // Змінено з .equals() на .equalsIgnoreCase()
                group.setGroupCode(newCode.toUpperCase()); // Нормалізація до верхнього регістру
                group.setSchedule(newSchedule);
            }
        }
    }

    @Override
    public boolean groupExists(String groupName) {
        String normalizedGroupName = groupName.toUpperCase(); // Перетворення на верхній регістр
        return groups.stream()
                .anyMatch(group -> group.getGroupCode().toUpperCase().equals(normalizedGroupName));
    }
    @Override
    public List<Group> getAllGroups() {
        return new ArrayList<>(groups); // Забезпечуємо незмінність списку
    }


}