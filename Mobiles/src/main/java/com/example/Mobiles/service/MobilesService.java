package com.example.Mobiles.service;

import com.example.Mobiles.dao.MobilesRepository;
import com.example.Mobiles.entity.Mobiles;
import com.example.Mobiles.exception.MobileNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MobilesService {

    public MobilesRepository mobileRep;

    @Autowired
    public MobilesService(MobilesRepository mobileRep) {

        this.mobileRep = mobileRep;
    }


    public List<Mobiles> displayAll(){
        List<Mobiles> mobiles= mobileRep.findAll();
        return mobiles;
    }

    public Mobiles getById(int mobileId) {
        return mobileRep.findById(mobileId).orElseThrow(() -> new RuntimeException("Sorry your Mobile with Id " + mobileId + " is not found, please enter valid mobile Id"));
    }

//    public List<Mobiles> findMobilesByName(String name) {
//        return mobileRep.findByName(name);
//    }
    @Transactional
    public void insertOrUpdate(Mobiles mobile) {
        mobileRep.save(mobile);
    }

    public Mobiles updateMobile(Mobiles mobile) throws MobileNotFound {
        Optional<Mobiles> savedMobile = mobileRep.findByName(mobile.getName());
        //already stroed record

        if(!savedMobile.isPresent()) {
            throw new MobileNotFound("mobile not found  with Name"+mobile.getName());
        }

        Mobiles m=null;
        if(savedMobile.isPresent()) {
            m=savedMobile.get();
            m.setPrice(mobile.getPrice());
            m.setName(mobile.getName());
        }
        return m;
    }


        public void removeById(int mobileId) {
        mobileRep.deleteById(mobileId);
    }





}
