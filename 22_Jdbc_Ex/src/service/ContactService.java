package service;

import java.util.List;
import java.util.Map;

import dto.ContactDto;

//사용자가 입력한 값이 DB까지 전달되는 순서
//ContactMain -> ContactController -> ContactService -> ContactDao -> DB

public interface ContactService {
  int insert(Map<String, Object> map);
  int update(Map<String, Object> map);
  int delete(Map<String, Object> map);
  List<ContactDto> selectList();
  ContactDto selectContactByNo(Map<String, Object> map);
  

}
