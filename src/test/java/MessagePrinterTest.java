import org.junit.Test;

public class MessagePrinterTest {

    String message = "This is Java 8 tutorial first example.";

    @Test
    public void shouldConvertToList(){
        MessagePrinter printer = new MessagePrinter();
        printer.splitWith(message, MessagePrinter.SPACE)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void shouldDisplayLongWords(){
        MessagePrinter printer = new MessagePrinter();
        printer.showLongWords(message);
    }

}
