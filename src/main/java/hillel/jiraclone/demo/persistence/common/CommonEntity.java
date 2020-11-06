package hillel.jiraclone.demo.persistence.common;

import hillel.jiraclone.demo.persistence.util.CustomLongTimeConverter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    private Integer id;

    @Column(name = "creation_date")
    @Convert(converter = CustomLongTimeConverter.class)
    private Long creationDate;

    public Integer getId() {
        return id;
    }

    public Long getCreationDate() {
        return creationDate;
    }
}
