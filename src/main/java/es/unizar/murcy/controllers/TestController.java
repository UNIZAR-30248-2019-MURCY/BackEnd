package es.unizar.murcy.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity helloWorld() {
        logger.info("hello world");

        return ResponseEntity.status(HttpStatus.OK).body("Hello world");
    }
}