import control.GadgetController;
import control.UserController;
import sql_query.DB;
import sql_query.GadgetRepo;
import sql_query.interfaces.IGadgetRepo;
import user_info.UserRepo;
import user_info.interfaces.IUserRepo;

public class Main {
    public static void main(String[] args) {
        DB db = new DB(); // Создание объекта базы данных
        IGadgetRepo gadgetRepo = new GadgetRepo(db); // Создание репозитория
        IUserRepo userRepo = new UserRepo(db);
        GadgetController gadgetController = new GadgetController(gadgetRepo);
        UserController userController = new UserController(userRepo);
        IUserRepo repo1 = new UserRepo(db);
        UserController controller1 = new UserController(repo1);
        Application app = new Application(gadgetController,userController); // Создание объекта приложения
        app.start(); // Запуск приложениe
    }
}