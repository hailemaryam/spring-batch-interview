package et.com.hmmk.springbatch.demo.repository;

import et.com.hmmk.springbatch.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
