package kr.co.sboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.sboard.dto.UserDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private String hp;
    private String role;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;


    @CreationTimestamp // NOW()
    private String regDate;

    private String leaveDate;


    public UserDTO toDTO(){
        return UserDTO.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .role(role)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .regip(regip)
                .regDate(regDate)
                .leaveDate(leaveDate)
                .build();
    }


}
