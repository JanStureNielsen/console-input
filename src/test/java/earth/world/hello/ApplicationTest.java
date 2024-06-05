package earth.world.hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import earth.console.input.Application;

public class ApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void helloWorld() throws IOException {
        Application.main(new String[] {});

        assertThat(outContent.toString()).isEqualTo("Hello, World!\n");
    }

    @Test
    void helloAbbyBobby() throws IOException {
        Application.main(new String[] {"Abby", "Bobby"});

        assertThat(outContent.toString()).isEqualTo("Hello, Abby, Bobby!\n");
    }

}
