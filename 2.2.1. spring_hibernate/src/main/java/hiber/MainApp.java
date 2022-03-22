package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      User ivan = new User("Ivan", "Ivanov", "ytrewq@gmail.com");
//      userService.add(ivan);
//      Car toyota = new Car("Corolla", 10);
//      toyota.setUser(ivan);
//      ivan.setCar(toyota);
//
//      User maria = new User("Maria", "Varlamova", "qsazxsw@gmail.com");
//      userService.add(maria);
//      Car nissan = new Car("Tiida", 3);
//      nissan.setUser(maria);
//      maria.setCar(nissan);
//
//      User sergio = new User("Sergio", "Ramos", "qwwerty@gmail.com");
//      userService.add(sergio);
//      Car ford = new Car("Focus", 6);
//      ford.setUser(sergio);
//      sergio.setCar(ford);
//
//      User leo = new User("Leo", "Ronaldo", "cr10@gmail.com");
//      userService.add(leo);
//      Car reno = new Car("Logan", 2);
//      reno.setUser(leo);
//      leo.setCar(reno);

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

      userService.getUserCar("Corolla", 10);

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println(user + " " + user.getCar());
//         System.out.println();
//      }

      context.close();
   }
}
