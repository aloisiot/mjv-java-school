package model;

import javax.persistence.*;

@Entity
@Table(name = "tb_students_with_jpa")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", columnDefinition = "char(1)")
    private Character sex;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "heigth", scale = 3, precision = 2)
    private Double heigth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getHeigth() {
        return heigth;
    }

    public void setHeigth(Double heigth) {
        this.heigth = heigth;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
