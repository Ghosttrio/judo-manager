//package com.ghosttrio.judomanager.user.user.user.domain;
//
//import com.judomanager.domain.common.BaseEntity;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Entity(name = "tb_user")
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class User extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private Long id;
//
//    private String nickname;
//
//    @Enumerated(EnumType.STRING)
//    private UserRole role;
//
//    private Long dojoId; // 본인이 속한 도장 id
//
//    private String email; // 카카오 로그인 메일
//
//    private LocalDateTime lastLoginDate;
//
//    private UserState state;
//
//    public void withDrawUser() {
//        this.state = UserState.DELETED;
//        this.nickname = "탈퇴유저";
//        this.email = null;
//        this.dojoId = null;
//    }
//
//    public static User init(String email) {
//        return new User(
//                null,
//                "이름",
//                UserRole.MEMBER,
//                null,
//                email,
//                LocalDateTime.now(),
//                UserState.ACTIVATE);
//    }
//
//    public void setNickname(String nickname){
//        this.nickname = nickname;
//    }
//
//    public void setDojo(Long dojoId){
//        this.dojoId = dojoId;
//    }
//
//    public void updateLoginDate(){
//        this.lastLoginDate = LocalDateTime.now();
//    }
//}
