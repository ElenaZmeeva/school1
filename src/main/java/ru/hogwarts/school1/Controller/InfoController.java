package ru.hogwarts.school1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school1.Service.InfoService;

@RestController
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService){
        this.infoService= infoService;
    }

    @GetMapping("/getPort")
    public Integer getServerPort(){
        return infoService.getServerPort();
    }
}
