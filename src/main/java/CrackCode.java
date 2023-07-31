import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CrackCode {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://94.198.50.185:7081/api/users";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        HttpHeaders headers = response.getHeaders();
        String sessionId = headers.getFirst(HttpHeaders.SET_COOKIE);

        User user = new User();
        user.setId(3L);
        user.setName("James");
        user.setLastName("Brown");
        user.setAge(30);

        HttpHeaders postHeaders = new HttpHeaders();
        postHeaders.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> postRequestEntity = new HttpEntity<>(user, postHeaders);

        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, postRequestEntity, String.class);
        String part1 = postResponse.getBody();

        user.setName("Thomas");
        user.setLastName("Shelby");

        HttpHeaders putHeaders = new HttpHeaders();
        putHeaders.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<User> putRequestEntity = new HttpEntity<>(user, putHeaders);

        ResponseEntity<String> putResponse = restTemplate.exchange(url, HttpMethod.PUT, putRequestEntity, String.class);
        String part2 = putResponse.getBody();

        HttpHeaders deleteHeaders = new HttpHeaders();
        deleteHeaders.set(HttpHeaders.COOKIE, sessionId);
        HttpEntity<Void> deleteRequestEntity = new HttpEntity<>(deleteHeaders);

        url = "http://94.198.50.185:7081/api/users/3";
        ResponseEntity<String> deleteResponse = restTemplate.exchange(url, HttpMethod.DELETE, deleteRequestEntity, String.class);
        String part3 = deleteResponse.getBody();

        String finalCode = part1 + part2 + part3;
        System.out.println("Итоговый код: " + finalCode);

    }
}
