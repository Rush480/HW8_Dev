import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.goit.util.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseTest {

    private static Connection connection;

    @BeforeEach
    void init() throws SQLException {
        connection = Database.getInstance().getConnection();
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @Test
    void testGetConnection() throws SQLException {
        assert (connection != null);
        assertTrue(connection.isValid(1));
        assertFalse(connection.isClosed());
    }

}
