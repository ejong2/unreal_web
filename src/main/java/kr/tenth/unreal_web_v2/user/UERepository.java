package kr.tenth.unreal_web_v2.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UERepository extends JpaRepository<UEUser, Long> {
    UEUser findByEmail(String email);
}