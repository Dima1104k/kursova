package com.example33.demo8.dao;
import com.example33.demo8.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class StubUserDao implements UserDAO {
    private List<User> users;

    private GroupDAO groupDao;
    private static Integer nextId = 1; // Лічильник для генерації ID
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public Integer getNextId() {
        return nextId ;  // Збільшуємо nextId на 1 кожного разу, коли метод викликається
    }
    public StubUserDao(GroupDAO groupDao) {
        this.groupDao = groupDao;
        this.users = new ArrayList<>();
        init();
    }
    private void init() {
        try {
            LocalDate dateOfBirthDmytro = LocalDate.parse("2006-04-11", formatter);
            LocalDate dateOfBirthVadim = LocalDate.parse("2006-04-05", formatter);
            addUser(new User(1, "Дмитро", "Китченко", groupDao.getGroupByCode("IA-33"), "2", "2", "student", dateOfBirthDmytro, "Факультет інформатики та обчислюваної техніки", "денна", 1, " Інформаційні системи та технології"));
            addUser(new User(2, "Вадим", "Марченко", groupDao.getGroupByCode("IA-33"), "vadim", "word456", "student", dateOfBirthVadim, "Факультет інформатики та обчислюваної техніки", "денна", 1, " Інформаційні системи та технології"));
            addUser(new User(null, "Адміністратор", "1", "1", "dean"));
            System.out.println("Користувачі ініціалізовані: " + users.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public List<User> getUsersByType(String type) {
        return users.stream()
                .filter(user -> user.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override

    public List<User> findUsersByGroup(String groupCode) {
        return users.stream()
                .filter(user -> user.getGroup() != null && user.getGroup().getGroupCode().equalsIgnoreCase(groupCode))
                .collect(Collectors.toList());
    }

    @Override
    public User findUserByName(String firstName, String lastName) {
        return users.stream()
                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null); // повертає null, якщо користувач не знайдений
    }
    @Override
    public User getUserById(Integer id) {
        if (id == null) return null;
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElse(null);
    }



    @Override
    public void updateUser(User user) {
        User found = getUserById(user.getId());
        if (found != null) {
            found.setFirstName(user.getFirstName());
            found.setLastName(user.getLastName());
            found.setGroup(user.getGroup());
            found.setBirthDate(user.getBirthDate());
          /* found.setUsername(user.getUsername());
            found.setPassword(user.getPassword());
            found.setType(user.getType());*/
            found.setFaculty(user.getFaculty());
            found.setEducationForm(user.getEducationForm());
            found.setCourse(user.getCourse());
            found.setSpeciality(user.getSpeciality());
        }
    }


    @Override
    public void deleteUser(Integer id) {
        if (id != null) {
            users.removeIf(user -> id.equals(user.getId()));
        }
    }

    @Override
    public void addUser(User user) {
        if ("student".equals(user.getType())) {
            user.setId(nextId++);  // Встановлюємо id і збільшуємо лічильник
        } else {
            user.setId(null); // Забезпечуємо, що id для нестудентів не встановлено
        }
        users.add(user);
    }
}
