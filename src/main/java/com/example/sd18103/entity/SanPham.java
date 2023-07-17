package com.example.sd18103.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SanPham")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GiaBan")
    private Integer giaBan;

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
