package au.com.riosoftware.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name_Book")
    private String nameBook;

    @Column(name = "Author_Name")
    private String authorName;

    public Books(){

    }
}
