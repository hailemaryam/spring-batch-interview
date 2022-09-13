package et.com.hmmk.springbatch.demo.config;

import et.com.hmmk.springbatch.demo.entity.Patient;
import et.com.hmmk.springbatch.demo.repository.PatientRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerWriter implements ItemWriter<Patient> {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void write(List<? extends Patient> list) throws Exception {
        System.out.println("Thread Name : -"+Thread.currentThread().getName());
        patientRepository.saveAll(list);
    }

}
