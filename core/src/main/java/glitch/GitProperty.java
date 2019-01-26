package glitch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
public enum GitProperty {

    APPLICATION_NAME("application.name"),
    APPLICATION_VERSION("application.version"),
    APPLICATION_DESCRIPTION("application.description"),
    APPLICATION_URL("application.url"),
    GIT_BRANCH("git.branch"),
    GIT_COMMIT_ID("git.commit.id"),
    GIT_COMMIT_ID_ABBREV ("git.commit.id.abbrev"),
    GIT_COMMIT_ID_DESCRIBE("git.commit.id.describe");

    private final String value;

    GitProperty(String value) {
        this.value = value;
    }

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = GitProperty.class.getClassLoader().getResourceAsStream("git.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException ignore) {}
    }

    public static String get(GitProperty key) {
        return properties.getProperty(key.value);
    }
}
