package kr.tenth.unreal_web_v2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UEService {

    private final UERepository ueRepository;

    public UEUser joinUser(UEUserDto userDto) {
        UEUser user = new UEUser();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return ueRepository.save(user);
    }

    public UEUserDto.LoginResult loginUser(UEUserDto userDto) {
        UEUser user = ueRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            return UEUserDto.LoginResult.INVALID_EMAIL;
        }
        return userDto.getPassword().equals(user.getPassword()) ? UEUserDto.LoginResult.SUCCESS : UEUserDto.LoginResult.INVALID_PASSWORD;
    }
}