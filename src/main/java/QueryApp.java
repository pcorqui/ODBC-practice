import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryApp {

    public static void main(String[] args) {

        try{
            //the resultset object
            ResultSet resultSet;


            //para java 8 no es necesario cargar el metodo forName
            //Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","user","admin");

            //The statement Object has methods can be used for for the purpose of querying
            /*
            * The executeQuery(): for execute a simple select
            * the executeUpdate(): for INSERT, UPDATE and DELETE statement
            * the execute(): execute un SQL statement that may return multiple results
             */
            Statement statement = conexion.createStatement();
            resultSet = statement.executeQuery("select * from platillos");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Error " + e);

        }
    }
}
