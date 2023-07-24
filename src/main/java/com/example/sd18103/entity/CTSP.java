package com.example.sd18103.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ChiTietSP")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CTSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    private Integer id;

    @Column(name = "NamBH")
    private Integer namBh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Integer giaNhap;

    @Column(name = "GiaBan")
    private Integer giaBan;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;


    @Override
    public String toString() {
        return "CTSP{" +
                "id=" + id +
                ", namBh=" + namBh +
                ", moTa='" + moTa + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                ", sanPhamID=" + sanPham.getId() +
                '}';
    }
}
