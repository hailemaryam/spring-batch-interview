package et.com.hmmk.springbatch.demo.config;

import et.com.hmmk.springbatch.demo.entity.Patient;
import org.springframework.batch.item.ItemProcessor;

import java.time.Instant;
import java.util.Date;

public class CustomProcessor implements ItemProcessor<Patient, Patient> {

    @Override
    public Patient process(Patient patient) throws Exception{
//        if(patient.getAppointment().after(Date.from(Instant.now()))){
//            return null;
//        } else {
//            return patient;
//        }
        return patient;
    }
}
