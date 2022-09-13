package et.com.hmmk.springbatch.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="PATIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "APPOINTMENT")
    private Date appointment;
    @Column(name = "GUID")
    private String guid;
}
