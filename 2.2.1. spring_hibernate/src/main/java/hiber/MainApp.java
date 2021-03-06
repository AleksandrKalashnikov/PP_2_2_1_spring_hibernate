package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User ivan = new User("Ivan", "Ivanov", "ytrewq@gmail.com");
      User maria = new User("Maria", "Varlamova", "qsazxsw@gmail.com");
      User sergio = new User("Sergio", "Ramos", "qwwerty@gmail.com");
      User leo = new User("Leo", "Ronaldo", "cr10@gmail.com");

      Car toyota = new Car("Corolla", 10);
      Car nissan = new Car("Tiida", 3);
      Car ford = new Car("Focus", 6);
      Car reno = new Car("Logan", 2);

      userService.add(ivan.setCar(toyota).setUser(ivan));
      userService.add(maria.setCar(nissan).setUser(maria));
      userService.add(sergio.setCar(ford).setUser(sergio));
      userService.add(leo.setCar(reno).setUser(leo));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + " " + user.getCar());
         System.out.println();
      }

      System.out.println("Пользователь на Corolla " + userService.getUserCar("Corolla", 10));
      System.out.println();

      try {
         User noUser = userService.getUserCar("Lada", 2106);
      } catch (NoResultException e) {
         System.out.println("Нет пользователя с таким авто");
      }

      context.close();
   }
}
