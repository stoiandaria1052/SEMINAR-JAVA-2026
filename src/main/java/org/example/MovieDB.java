package org.example;

import java.sql.*;

public class MovieDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) {
        try {
            System.out.println("H2 Console started at: http://localhost:8082");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to H2 in-memory database.\n");

                createTable(connection);

                insertMovies(connection, "Five night's at freddy's", "120");
                insertMovies(connection, "Iron Maiden: Burning Ambition", "167");
                insertMovies(connection, "Familia Heck", "20");

                System.out.println("=== ALL MOVIES AFTER INSERT ===");
                printAllMovies(connection);

                updateMovieLength(connection, 2, 195);
                System.out.println("\n=== ALL MOVIES AFTER UPDATE ===");
                printAllMovies(connection);

                deleteMovie(connection, 1);
                System.out.println("\n=== ALL MOVIES AFTER DELETE ===");
                printAllMovies(connection);

                System.out.println("\nOpen the H2 console in your browser!");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
                System.out.println("\nPress ENTER to exit...");
                System.in.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
            CREATE TABLE movies (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                length INT NOT NULL
            )
            """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'movies' created.");
        }
    }

    private static void insertMovies(Connection connection, String name, String length) throws SQLException {
        String sql = "INSERT INTO movies (name, length) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(length));

            ps.executeUpdate();
            System.out.println("Inserted: " + name);
        }
    }

    private static void printAllMovies(Connection connection) throws SQLException {
        String sql = "SELECT id, name, length FROM movies ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("length")
                );
            }
        }
    }

    private static void updateMovieLength(Connection connection, int id, int newLength) throws SQLException {
        String sql = "UPDATE movies SET length = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, newLength);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Updated movie id " + id);
        }
    }

    private static void deleteMovie(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted movie id " + id);
        }
    }
}


//ex.2
//descarcati local un server de PostgreSQL
//conectati programul Java la acea BD

