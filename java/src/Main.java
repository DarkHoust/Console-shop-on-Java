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
        IGadgetRepo repo = new GadgetRepo(db); // Создание репозитория
        GadgetController controller = new GadgetController(repo);
        IUserRepo repo1 = new UserRepo(db);
        UserController controller1 = new UserController(repo1);
        Application app = new Application(controller); // Создание объекта приложения
        app.start(); // Запуск приложения


    }
}