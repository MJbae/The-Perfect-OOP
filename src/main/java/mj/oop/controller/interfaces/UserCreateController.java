package mj.oop.controller.interfaces;


import mj.oop.controller.CustomerCreateController;
import mj.oop.controller.dto.*;

/**
 * User에 연관된 HTTP POST 요청을 받고, 처리결과를 응답으로 반환한다
 * <p>
 * All Known Implementing Classes:
 * @see CustomerCreateController
 * </p>
 */
public interface UserCreateController<T extends UserResponseData, T2 extends UserRequestData> {
    /**
     * POST 요청에 따른 처리 결과를 UserResponseData 형태로 가공하여 반환한다
     * <p>
     *
     * @param requestData Request Body로 전달된 JSON 객체를 직렬화하여 받기 위한 객체
     * @return HTTP Request를 처리한 결과를 JSON 객체로 역직렬화하기 위한 객체
     * </p>
     */
    T create(T2 requestData);
}
