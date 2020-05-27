package com.ss.retraining.controllerTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.ss.retraining.controller.FieldsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FieldsControllerTest {
    @Autowired
    private FieldsController fieldsController;

    @Test
    public void contextLoads() throws Exception{
        assertNotNull(fieldsController);
    }
}
