package service;

import com.starkend.elastictest.ElastictestApplication;
import com.starkend.elastictest.service.UtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastictestApplication.class)
public class UtilServiceTest {

    @Autowired
    UtilService utilService;

    @Test
    public void whenUtilServiceIsCreatedWithDependencies_thenSucceed() {
        assertNotNull(utilService);
    }
}
