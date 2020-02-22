import com.mangostreet.mangostreetserspring.dataobject.User;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class httpTest {
    @Test
    public void restTemplateGetTest(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            User user = restTemplate.getForObject("http://localhost:3000/users",User.class);
            System.out.println(user);
        }catch (HttpClientErrorException e){
            System.out.println("http客户端请求出错了！");
            //开发中可以使用统一异常处理，或者在业务逻辑的catch中作响应
        }
    }

    @Test
    public void restTemplateTransferFile(){
        final String filePath = "F:";
        final String fileName = "testFile.txt";
        final String url = "http://localhost:3000/users";

        RestTemplate restTemplate = new RestTemplate();

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        //设置请求体，注意是LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(filePath+"/"+fileName);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", fileSystemResource);
        form.add("filename",fileName);

        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        String s = restTemplate.postForObject(url, files, String.class);
        System.out.println(s);
    }
}
