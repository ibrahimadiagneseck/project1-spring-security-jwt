package sn.esp.project1springsecurity.services;

import sn.esp.project1springsecurity.dto.UserDTO;
import sn.esp.project1springsecurity.utils.BaseResponseDTO;

public interface UserService {
    BaseResponseDTO registerAccount(UserDTO userDTO);
}
