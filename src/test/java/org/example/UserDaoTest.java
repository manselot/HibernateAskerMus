//package org.example;
// не работает
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//public class UserDaoTest {
//    private UserDao userDao;
//
//    @BeforeEach
//    public void setUp() {
//
//        userDao = new UserDaoImpl();
//        HibernateUtil.getSessionFactory().openSession().createSQLQuery("DELETE FROM users").executeUpdate();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        HibernateUtil.getSessionFactory().openSession().createSQLQuery("DELETE FROM users").executeUpdate();
//    }
//
//    @Test
//    public void testSaveAndGetUserById() {
//        // Arrange
//        User user = new User();
//        user.setName("asker");
//        user.setEmail("asker.com");
//        user.setAge(23);
//        user.setCreatedAt(LocalDateTime.now());
//
//        // Act
//        userDao.save(user);
//        User retrievedUser = userDao.findById(user.getId());
//
//        // Assert
//        Assertions.assertThat(retrievedUser).isNotNull();
//        Assertions.assertThat(retrievedUser.getName()).isEqualTo("asker");
//        Assertions.assertThat(retrievedUser.getEmail()).isEqualTo("asker.com");
//        Assertions.assertThat(retrievedUser.getAge()).isEqualTo(23);
//    }
//
//    @Test
//    public void testGetAllUsers() {
//        // Arrange
//        User user1 = new User();
//        user1.setName("Alice");
//        user1.setEmail("alice.com");
//        user1.setAge(25);
//        user1.setCreatedAt(LocalDateTime.now());
//
//        User user2 = new User();
//        user2.setName("Bob");
//        user2.setEmail("bo@example.com");
//        user2.setAge(35);
//        user2.setCreatedAt(LocalDateTime.now());
//
//        // Act
//        userDao.save(user1);
//        userDao.save(user2);
//        List<User> users = userDao.findAll();
//
//        // Assert
//        Assertions.assertThat(users).hasSize(2);
//        Assertions.assertThat(users).extracting(User::getName).containsExactlyInAnyOrder("Alice", "Bob");
//    }
//
//
//
//
//}
//import java.util.List;