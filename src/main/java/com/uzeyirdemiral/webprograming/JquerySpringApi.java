package com.uzeyirdemiral.webprograming;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("api/jquery")
@CrossOrigin //(origins = "http://localhost:8080")



public class JquerySpringApi {

    private final IJqueryService iJqueryService;



    //http://localhost:8080/api/jquery/post
    @PostMapping(value = "/post",consumes={"application/json"})
    public ResponseEntity<JqueryDto> createRegister(@Valid @RequestBody(required = true) JqueryDto jqueryDto) { //@RequestBody(required = false)
        System.out.println(jqueryDto);
        iJqueryService.createRegister(jqueryDto);
        return ResponseEntity.ok(jqueryDto);
    }


    // http://localhost:8080/api/jquery/get
    @GetMapping(value = "/get")
    public ResponseEntity<List<JqueryDto>>  getAllRegisters() {
        return ResponseEntity.ok(iJqueryService.getAllRegisters());
    }
}
