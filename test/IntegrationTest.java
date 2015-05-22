import org.junit.Test;
import play.mvc.Result;
import play.test.FakeRequest;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
//        running(fakeApplication(), () -> {
//            Map<String, String> parameters = new HashMap<>();
//            parameters.put("fbToken", "random");
//            parameters.put("gpToken", "random");
//            FakeRequest fakeRequest = fakeRequest(GET, "/update/individual").withFormUrlEncodedBody(parameters);
//
//            System.out.println(fakeRequest);
//            Result result = route(fakeRequest);
//            System.out.println(status(result));
//            assertThat(status(result) == OK);
//            assertThat(status(result) != OK);
//        }
//        );
    }

}
