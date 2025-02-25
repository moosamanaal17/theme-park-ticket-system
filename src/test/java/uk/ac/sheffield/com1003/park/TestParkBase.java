package uk.ac.sheffield.com1003.park;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TestParkBase {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    private PrintStream originalErr = System.err;

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


    protected ArrayList<String> getOutLines() {
        Stream<String> lines = outContent.toString().lines();
        ArrayList<String> arrayList = new ArrayList<>();
        lines.forEach(arrayList::add);
        return arrayList;
    }

    protected void resetOutLines() {
        outContent.reset();
    }

    protected ArrayList<String> getErrLines() {
        Stream<String> lines = errContent.toString().lines();
        ArrayList<String> arrayList = new ArrayList<>();
        lines.forEach(arrayList::add);
        return arrayList;
    }
}
