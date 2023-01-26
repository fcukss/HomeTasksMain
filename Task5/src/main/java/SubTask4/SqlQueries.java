package SubTask4;

public class SqlQueries {
    //вивести повну інформацію про замовлення
    String select01 = """
            SELECT  
                o.order_id, 
                name, 
                description, 
                quantity, 
                (quantity*price) total_price,
                ord.date_order 
            FROM 
                orders_info o 
                    JOIN  
                product AS p ON p.product_id = o.product_id 
                    JOIN 
                orders AS ord on o.order_id = ord.order_id;
            """;

    //Вивести номери замовлень, сума яких не перевищує задану, та коли-ність різних товарів дорівнює заданому.
    String select02 = """
            SELECT 
                ord.order_id, 
                SUM(quantity) count, 
                SUM(price) total 
            FROM 
                orders_info o 
                   JOIN 
                product p ON p.product_id = o.product_id 
                   JOIN 
                orders ord ON o.order_id = ord.order_id 
            GROUP BY
                order_id HAVING count = ? AND total > ?
                    """;

    //Вивести номери замовлень, що містять цей товар.
    String select03 = """
            SELECT 
                o.order_id 
            FROM 
                orders_info o 
                    JOIN 
                product p ON p.product_id = o.product_id 
            WHERE 
                name like ?;
            """;

    //Вивести номери замовлень, що не містять заданого товару та які надішли протягом поточного дня.
    String select04 = """
            SELECT
                o.order_id, name, ord.date_order
            FROM 
                orders_info o 
                    JOIN 
                product p ON p.product_id = o.product_id 
                    JOIN 
                orders ord ON o.order_id = ord.order_id 
            WHERE
                name != ? AND date_order = SYSDATE();
            """;

    //Сформувати нове замовлення, яке складається з товарів, замовлених у поточний день.
    String select05 = """
            INSERT  INTO 
                orders_info (product_id, quantity)  (
                SELECT
                    p.product_id,
                    quantity 
                FROM orders_info o 
                        JOIN 
                    product p ON p.product_id = o.product_id 
                        JOIN 
                    orders ord on o.order_id = ord.order_id 
                WHERE 
                    date_order=SYSDATE()
            );
            """;

    //Видалити всі замовлення, в яких є задана кількість товару
    String select06 = """
            DELETE FROM 
                orders_info 
            WHERE 
                quantity = ?;
            """;
}
