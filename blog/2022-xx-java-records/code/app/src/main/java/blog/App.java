
package blog;

import static java.lang.System.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;

public class App {

    ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        out.println(new blog.records.Customer(UUID.randomUUID(), ""));

        var customer = new blog.jackson.Customer();
    }
}
