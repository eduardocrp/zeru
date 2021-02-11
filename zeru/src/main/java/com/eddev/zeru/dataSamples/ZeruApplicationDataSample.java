package com.eddev.zeru.dataSamples;

import java.text.ParseException;
import java.util.Arrays;

import com.eddev.zeru.models.ClassOrder;
import com.eddev.zeru.models.Family;
import com.eddev.zeru.models.Genus;
import com.eddev.zeru.models.Order;
import com.eddev.zeru.models.Phylum;
import com.eddev.zeru.models.Specie;
import com.eddev.zeru.models.User;
import com.eddev.zeru.models.enums.ProfileType;
import com.eddev.zeru.repositories.ClassOrderRepository;
import com.eddev.zeru.repositories.FamilyRepository;
import com.eddev.zeru.repositories.GenusRepository;
import com.eddev.zeru.repositories.OrderRepository;
import com.eddev.zeru.repositories.PhylumRepository;
import com.eddev.zeru.repositories.SpecieRepository;
import com.eddev.zeru.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Profile("dev")
@Configuration
public class ZeruApplicationDataSample {
    
    @Autowired
    private PhylumRepository phylumRepository;

    @Autowired
    private ClassOrderRepository classOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private GenusRepository genusRepository;

    @Autowired
    private SpecieRepository specieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passEncode;

    @Bean
    public boolean runDataSample() throws ParseException{
        
        // Insert below data samples

        Phylum phylum1 = new Phylum();
        phylum1.setDsPhylum("Tracheophyta");
        phylumRepository.save(phylum1);

        ClassOrder class1 = new ClassOrder();
        class1.setPhylum(phylum1);
        class1.setDsClassOrder("Magnoliopsida");
        classOrderRepository.save(class1);

        Order order1 = new Order();
        order1.setClassOrder(class1);
        order1.setDsOrder("Sapindales");
        orderRepository.save(order1);

        Family family1 = new Family();
        family1.setOrder(order1);
        family1.setDsFamily("Anacardiaceae");
        familyRepository.save(family1);

        Genus genus1 = new Genus();
        genus1.setFamily(family1);
        genus1.setDsGenus("Anacardium");
        genusRepository.save(genus1);

        Specie specie1 = new Specie();
        specie1.setGenus(genus1);
        specie1.setIdSibbr("369843");
        specie1.setNmCommon("Cajú");
        specie1.setNmScientific("Anacardium occidentale");
        specieRepository.save(specie1);

        User user1 = new User();
        user1.setEmail("tst@tst.com");
        user1.setPassword(passEncode.encode("tst123"));
        user1.addProfile(ProfileType.ADMIN);
        
        User user2 = new User();
        user2.setEmail("tst1@tst.com");
        user2.setPassword(passEncode.encode("tst123"));

        userRepository.saveAll(Arrays.asList(user1, user2));

        return true;

    }

}
