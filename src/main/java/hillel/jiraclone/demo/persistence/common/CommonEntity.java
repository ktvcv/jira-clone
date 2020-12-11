package hillel.jiraclone.demo.persistence.common;

import hillel.jiraclone.demo.persistence.util.CustomLongTimeConverter;

import javax.persistence.*;

@MappedSuperclass
public abstract class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    private Integer id;

    @Column(name = "creation_date", updatable = false)
    @Convert(converter = CustomLongTimeConverter.class)
    private Long creationDate;

    public Integer getId() {
        return id;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public boolean isNew(){
        return this.id == null;
    }
}
