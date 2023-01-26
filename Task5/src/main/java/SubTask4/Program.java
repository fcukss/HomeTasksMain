package SubTask4;

import java.sql.*;
import java.util.Scanner;

public class Program {
    private static final SqlQueries sqlQueries = new SqlQueries();


    public static void main(String[] args) {
        ModificationDB modificationDB = new ModificationDB();
        Scanner scanner = new Scanner(System.in);

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "shop",
                "bestuser", "bestuser");


        try (Connection connection = dcm.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueries.select01);
            while (resultSet.next()) {

                System.out.printf("%d | %-10s | %-10s | %d | %.2f | %s\n",
                        resultSet.getInt("order_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("total_price"),
                        resultSet.getString("date_order"));
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------");


        try (Connection connection = dcm.getConnection()) {
            System.out.print("Введіть сумму :");
            int sum = scanner.nextInt();
            System.out.print("Введіть кількість товарів :");
            double count = scanner.nextDouble();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueries.select02);
            preparedStatement.setInt(1, sum);
            preparedStatement.setDouble(2, count);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d | %d | %.2f \n",
                        resultSet.getInt("order_id"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"));
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------");

        try (Connection connection = dcm.getConnection()) {
            System.out.print("Введіть назву товару :");

            String name = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueries.select03);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d \n",
                        resultSet.getInt("order_id"));
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println("---------------------------------------------");

        try (Connection connection = dcm.getConnection()) {
            System.out.print("Введіть назву товару :");
            String name = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQueries.select04);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.printf("%d | %-10s | %s\n",
                        resultSet.getInt("order_id"),
                        resultSet.getString("name"),
                        resultSet.getString("date_order"));
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        modificationDB.insertToTable();
        modificationDB.deleteQuantityOfProductsFromTable();

    }
}
