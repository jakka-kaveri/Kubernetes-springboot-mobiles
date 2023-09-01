package com.example.Mobiles.controller;

import com.example.Mobiles.dao.MobilesRepository;
import com.example.Mobiles.entity.Mobiles;
import com.example.Mobiles.exception.MobileNotFound;
import com.example.Mobiles.service.MobilesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/mobiles")
public class MobilesController {

    private final MobilesService mobileSer;
    private MobilesRepository mobileRep;
    public MobilesController(MobilesService mobileSer) {
        this.mobileSer = mobileSer;
    }

    @GetMapping()
    public List<Mobiles> getAllMobilesData() {      //localhost:8080/mobiles/list
        List<Mobiles> mobiles =mobileSer.displayAll();
        return mobiles;
    }
    @GetMapping ("/{mid}")
    public Mobiles getMobilesData(@PathVariable ("mid") int mId) throws MobileNotFound {      //localhost:8080/mobiles/list/id
        Mobiles mobile =mobileSer.getById(mId);
        if (mobile==null) {
            throw new MobileNotFound("Mobile not found with the given mobile id");
        }
        return mobile;
    }

    @PostMapping ("/")
    public void insertMobile( @RequestBody Mobiles mobile ) {

        mobileSer.insertOrUpdate(mobile);
    }
    @PutMapping ("/")
    public void updateMobile(@RequestBody Mobiles mobile ) {
        mobileSer.insertOrUpdate(mobile);
    }
    @DeleteMapping ("/{mid}")
    public String deleteMobilesData(@PathVariable ("mid")int mobileId) throws MobileNotFound {      //localhost:8080/mobiles/list/id
        Mobiles mobile =mobileSer.getById(mobileId);
        if (mobile==null) {
            throw new MobileNotFound("Mobile not found with the given  mobile id");
        }
        mobileSer.removeById(mobileId);
        return "Deleted Mobile Id = " +mobileId;
    }




        }
