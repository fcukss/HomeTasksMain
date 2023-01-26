package SubTask4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ModificationDB {
    private static final SqlQueries sqlQueries = new SqlQueries();

    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "shop",
            "bestuser", "bestuser");

    void insertToTable(){
        try (Connection connection = dcm.getConnection()) {
            Statement statement = connection.createStatement();

         int rows = statement.executeUpdate(sqlQueries.select05);
                System.out.printf("rows added %d",rows);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    void deleteQuantityOfProductsFromTable (){
        try (Connection connection = dcm.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть кількість :");
            int count = scanner.nextInt();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueries.select06);
            preparedStatement.setInt(1, count);

            if(preparedStatement.execute())
                System.out.println("Delete done");;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
