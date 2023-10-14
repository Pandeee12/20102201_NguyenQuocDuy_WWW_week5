package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import java.time.LocalDate;
import java.util.Random;
@SpringBootApplication
public class Week5Application {

    public static void main(String[] args) {
        SpringApplication.run(Week5Application.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Bean
    CommandLineRunner initData(){
        return  args -> {
            Random random = new Random();
            for(int i=1; i<705; i++){
                Address address = new Address(random.nextInt(1,704)+"","Le Loi"
                        ,"HCM",random.nextInt(70000,80000)+"",CountryCode.VN);
                addressRepository.save(address);
                Candidate candidate = new Candidate("HeheName ~ "+i,LocalDate.of(2002
                        ,random.nextInt(1,13),random.nextInt(1,29)),address
                        ,random.nextLong(1111111111L,99999999999L)+"","email_"+i+"@gmail.com");
                candidateRepository.save(candidate);
                System.out.println("Added: "+candidate);
            }
        };
    }

}
