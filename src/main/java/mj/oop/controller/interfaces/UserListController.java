package mj.oop.controller.interfaces;

import mj.oop.controller.dto.UserResponseData;

import java.util.List;

/**
 * User 객체에 대한 목록 조회 요청을 받아서 처리결과를 반환한다
 * <p>
 * All Known Implementing Classes:
 * UserListController
 * </p>
 */
public interface UserListController {
    /**
     * 목록 조회 요청에 따른 처리 결과를 List<UserResponseData> 형태로 가공하여 반환한다
     * <p>
     * @return 목록 조회 요청에 대한 처리결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    List<UserResponseData> list();
}
