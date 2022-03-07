package com.maple.minio.core;

import com.maple.minio.core.util.MinioProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MinioTest {
    @Test
    public void testProperties(){

        System.out.println(MinioProperties.ENDPOINT);
        System.out.println(MinioProperties.ACCESS_KEY);
        System.out.println(MinioProperties.SECRET_KEY);
        System.out.println(MinioProperties.BUCKET_NAME);
    }
}
