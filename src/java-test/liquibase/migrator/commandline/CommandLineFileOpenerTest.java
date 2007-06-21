package liquibase.migrator.commandline;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import org.junit.Test;

import liquibase.migrator.AbstractFileOpenerTest;
import liquibase.migrator.FileOpener;

/**
 * Tests for {@link CommandLineFileOpener}
 */
public class CommandLineFileOpenerTest extends AbstractFileOpenerTest {

    /**
     * @see liquibase.migrator.AbstractFileOpenerTest#createFileOpener()
     */
    @Override
    protected FileOpener createFileOpener() {
        return new CommandLineFileOpener(Thread.currentThread().getContextClassLoader());
    }

    @Test
    public void getResourceAsStream() throws Exception {
      InputStream inputStream = fileOpener.getResourceAsStream("liquibase/migrator/ant/AntFileOpenerTest.class");
      assertNotNull(inputStream);
    }

    @Test(expected = IOException.class)
    public void getResourceAsStreamNonExistantFile() throws Exception {
      fileOpener.getResourceAsStream("non/existant/file.txt");
    }

    @Test
    public void getResources() throws Exception {
      Enumeration<URL> resources = fileOpener.getResources("liquibase/migrator/ant");
      assertNotNull(resources);
    }
}