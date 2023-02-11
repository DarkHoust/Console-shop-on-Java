import control.GadgetController;
import sql_query.DB;
import sql_query.GadgetRepo;
import sql_query.Interfaces.IGadgetRepo;

public class Main {
    public static void main(String[] args) {
        DB db = new DB(); // Создание объекта базы данных
        IGadgetRepo repo = new GadgetRepo(db); // Создание репозитория
        GadgetController controller = new GadgetController(repo);
        Application app = new Application(controller); // Создание объекта приложения
        app.start(); // Запуск приложения

    }
}