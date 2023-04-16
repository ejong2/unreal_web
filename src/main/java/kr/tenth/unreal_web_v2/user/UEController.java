package kr.tenth.unreal_web_v2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UEController {

    private final UEService ueService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UEUserDto userDto) {
        ueService.joinUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UEUserDto userDto) {
        UEUserDto.LoginResult result = ueService.loginUser(userDto);

        if (result == UEUserDto.LoginResult.SUCCESS) {
            System.out.println("OKOK");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            System.out.println("NONO");
            return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
        }
    }
}
