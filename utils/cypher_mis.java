import java.sql.*;
import java.sql.DriverManager;
 
class DatabaseMGR 
{
 
    private static final String url = "jdbc:mysql://localhost/cypher_mis?useSSL=false"; 
    private static final String user = "root";
    private static final String password = "DamienBro";
    
    public static void main(String args[]) 
    {
        int hello;
        boolean goodbye;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection sqlcon = DriverManager.getConnection(url, user, password);

            //createTeam(sqlcon, "dylandd");
            
            System.err.println(getTeamName(sqlcon, getTeamId(sqlcon, "dylandd")));


        } catch (Exception e) {
            e.printStackTrace();
        }


        
    }

    /*
        Team Manager
        Input: (String name)
        Output: team_id
    */
    public static int createTeam(Connection sqlcon, String teamName)
    {
        Statement stmt = null;
        String query = "INSERT INTO team(name) VALUES " + "('" + teamName + "');";
        int teamId = -1;
        //ResultSet result;
        try
        {
            stmt = sqlcon.createStatement();
            teamId = stmt.executeUpdate(query);
            //teamId = getTeamId(sqlcon, teamName);
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }
        return teamId;
    }

    public static boolean deleteTeam(Connection sqlcon, String teamName)
    {
        Statement stmt = null;
        String query = "DELETE FROM team WHERE name = '" + teamName + "';";
        boolean deleted = false;

        try
        {
            stmt = sqlcon.createStatement();
            deleted = stmt.executeUpdate(query);
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }

        return deleted;
    }

    public static boolean deleteTeam(Connection sqlcon, int teamId)
    {
        Statement stmt = null;
        String query = "DELETE FROM team WHERE id = '" + teamId + "';";
        boolean deleted = false;
        try
        {
            stmt = sqlcon.createStatement();
            deleted = stmt.executeUpdate(query);
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }
        return deleted;
    }

    public static int getTeamId(Connection sqlcon, String teamName)
    {
        int teamId = -1;
        Statement stmt = null;
        String query = "SELECT id FROM team WHERE name ='" + teamName + "';";
        try
        {
            stmt = sqlcon.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            teamId = result.getInt("id");
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }

        return teamId;
    }

    public static String getTeamName(Connection sqlcon, int teamId)
    {
        String teamName = null;
        Statement stmt = null;
        String query = "SELECT name FROM team WHERE id = " + teamId + ";";
        try
        {
            stmt = sqlcon.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            teamName = result.getString("name");
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }

        return teamName;
    }









    /* 
        Problem Manager
    */
    public static int createProblem(String problemName, byte[] problemDescription, byte[] problemTestCode)
    {
        Statement nameStmt = null;
        PreparedStatement descStmt = null;
        PreparedStatement testStmt = null;
        String nameQuery = "INSERT INTO problem(name) VALUES " + "('" + problemName + "');";
        String descQuery = "UPDATE "
        int problemId = -1;
        try
        {
            stmt = sqlcon.createStatement();
            teamId = nameStmt.executeUpdate(nameQuery);

            
            
        }
        catch (SQLException e)
        {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        } 
    }
}