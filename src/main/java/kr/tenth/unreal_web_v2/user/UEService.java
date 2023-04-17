package kr.tenth.unreal_web_v2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<UEUserDto> findAllUsers() {
        List<UEUser> users = ueRepository.findAll();
        List<UEUserDto> userDtos = users.stream().map(user -> {
            UEUserDto userDto = new UEUserDto();
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            return userDto;
        }).collect(Collectors.toList());
        return userDtos;
    }
}