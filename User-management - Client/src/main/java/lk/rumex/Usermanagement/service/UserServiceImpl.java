package lk.rumex.Usermanagement.service;

import lk.rumex.Usermanagement.model.UserDTO;
import lk.rumex.Usermanagement.util.ResponseUtil;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final String apiUrl = "http://localhost:8080/api/v1/user";

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseUtil getAllUsers() {

        return restTemplate.getForObject(apiUrl, ResponseUtil.class);
    }

    @Override
    public ResponseUtil getUserById(int id) {
        return restTemplate.getForObject(apiUrl + "/id", ResponseUtil.class);
    }

    @Override
    public ResponseUtil addUser(UserDTO user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(user, headers);
        return restTemplate.postForObject(apiUrl, requestEntity, ResponseUtil.class);
    }

    @Override
    public ResponseUtil updateUser(UserDTO user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<ResponseUtil> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.PUT,
                requestEntity,
                ResponseUtil.class
        );

        return responseEntity.getBody();
    }

    @Override
    public ResponseUtil deleteUser(int id) {
        restTemplate.delete(apiUrl + "/" + id);
        return new ResponseUtil("200",null);
    }
}
