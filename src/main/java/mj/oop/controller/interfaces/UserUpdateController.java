package mj.oop.controller.interfaces;

import mj.oop.controller.CustomerUpdateController;
import mj.oop.controller.dto.UserRequestData;
import mj.oop.controller.dto.UserResponseData;

/**
 * User에 대해 HTTP PATCH의 수정 요청을 받고, 처리결과를 응답으로 반환한다
 * <p>
 * All Known Implementing Classes:
 * @see CustomerUpdateController
 * </p>
 */
public interface UserUpdateController<T extends UserResponseData, T2 extends UserRequestData> {
    /**
     * 수정 요청에 따른 처리 결과를 UserResponseData 형태로 가공하여 반환한다
     * <p>
     *
     * @param id Request Path Parameter 전달된 User Id를 받기 위한 객체
     * @return HTTP Request를 처리한 결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    T update(Long id, T2 requestData);
}
